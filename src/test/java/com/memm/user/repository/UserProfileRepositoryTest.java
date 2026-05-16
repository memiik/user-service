package com.memm.user.repository;

import com.datastax.oss.driver.api.core.CqlSession;
import com.memm.user.model.FollowersByUser;
import com.memm.user.model.FollowingByUser;
import com.memm.user.model.UserProfile;
import com.memm.user.model.key.FollowerKey;
import com.memm.user.model.key.FollowingKey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserProfileRepositoryTest extends CassandraRepositoryIntegrationTest {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private FollowersByUserRepository followersByUserRepository;

    @Autowired
    private FollowingByUserRepository followingByUserRepository;

    @Autowired
    private CqlSession cqlSession;

    @BeforeEach
    void cleanTables() {
        followersByUserRepository.deleteAll();
        followingByUserRepository.deleteAll();
        userProfileRepository.deleteAll();
    }

    @Test
    void createsMappedTablesInTestKeyspace() {
        Set<String> tableNames = cqlSession.execute(
                        "SELECT table_name FROM system_schema.tables WHERE keyspace_name = 'user_service_test'")
                .all()
                .stream()
                .map(row -> row.getString("table_name"))
                .collect(java.util.stream.Collectors.toSet());

        assertThat(tableNames)
                .contains("users_by_id", "followers_by_user", "following_by_user");
    }

    @Test
    void savesFindsUpdatesAndDeletesUserProfile() {
        UUID userId = UUID.randomUUID();
        Instant createdAt = Instant.parse("2026-05-16T12:00:00Z");

        UserProfile profile = new UserProfile("Ari", "Ari A.", "A base-game Duplicant");
        profile.setId(userId);
        profile.setCreatedAt(createdAt);
        profile.setUpdatedAt(createdAt);

        userProfileRepository.save(profile);

        UserProfile savedProfile = userProfileRepository.findById(userId).orElseThrow();
        assertThat(savedProfile.getId()).isEqualTo(userId);
        assertThat(savedProfile.getUsername()).isEqualTo("Ari");
        assertThat(savedProfile.getDisplayName()).isEqualTo("Ari A.");
        assertThat(savedProfile.getBio()).isEqualTo("A base-game Duplicant");
        assertThat(savedProfile.getCreatedAt()).isEqualTo(createdAt);

        savedProfile.setDisplayName("Ari Updated");
        savedProfile.setBio("Updated bio");
        savedProfile.setUpdatedAt(Instant.parse("2026-05-16T13:00:00Z"));
        userProfileRepository.save(savedProfile);

        assertThat(userProfileRepository.findById(userId))
                .hasValueSatisfying(updatedProfile -> {
                    assertThat(updatedProfile.getDisplayName()).isEqualTo("Ari Updated");
                    assertThat(updatedProfile.getBio()).isEqualTo("Updated bio");
                });

        userProfileRepository.deleteById(userId);

        assertThat(userProfileRepository.findById(userId)).isEmpty();
    }

    @Test
    void savesAndDeletesFollowRelationshipFromBothLookupTables() {
        UUID followerId = UUID.randomUUID();
        UUID followeeId = UUID.randomUUID();
        FollowingKey followingKey = new FollowingKey(followerId, followeeId);
        FollowerKey followerKey = new FollowerKey(followeeId, followerId);

        followingByUserRepository.save(new FollowingByUser(followingKey));
        followersByUserRepository.save(new FollowersByUser(followerKey));

        assertThat(followingByUserRepository.findById(followingKey))
                .hasValueSatisfying(following -> assertThat(following.getKey()).isEqualTo(followingKey));
        assertThat(followersByUserRepository.findById(followerKey))
                .hasValueSatisfying(follower -> assertThat(follower.getKey()).isEqualTo(followerKey));

        followingByUserRepository.deleteById(followingKey);
        followersByUserRepository.deleteById(followerKey);

        assertThat(followingByUserRepository.findById(followingKey)).isEmpty();
        assertThat(followersByUserRepository.findById(followerKey)).isEmpty();
    }
}
