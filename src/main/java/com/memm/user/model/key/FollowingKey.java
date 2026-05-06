package com.memm.user.model.key;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.Objects;
import java.util.UUID;

@PrimaryKeyClass
public class FollowingKey {

    @PrimaryKeyColumn(name = "follower_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID followerId;

    @PrimaryKeyColumn(name = "followee_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private UUID followeeId;

    public FollowingKey() {
    }

    public FollowingKey(UUID followerId, UUID followeeId) {
        this.followerId = followerId;
        this.followeeId = followeeId;
    }

    public UUID getFollowerId() {
        return followerId;
    }

    public void setFollowerId(UUID followerId) {
        this.followerId = followerId;
    }

    public UUID getFolloweeId() {
        return followeeId;
    }

    public void setFolloweeId(UUID followeeId) {
        this.followeeId = followeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FollowingKey that = (FollowingKey) o;
        return Objects.equals(followerId, that.followerId) && Objects.equals(followeeId, that.followeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followerId, followeeId);
    }
}
