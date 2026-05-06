package com.memm.user.model.key;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.Objects;
import java.util.UUID;

@PrimaryKeyClass
public class FollowerKey {

    @PrimaryKeyColumn(name = "followee_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID followeeId;

    @PrimaryKeyColumn(name = "follower_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private UUID followerId;

    public FollowerKey() {
    }

    public FollowerKey(UUID followeeId, UUID followerId) {
        this.followeeId = followeeId;
        this.followerId = followerId;
    }

    public UUID getFolloweeId() {
        return followeeId;
    }

    public void setFolloweeId(UUID followeeId) {
        this.followeeId = followeeId;
    }

    public UUID getFollowerId() {
        return followerId;
    }

    public void setFollowerId(UUID followerId) {
        this.followerId = followerId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FollowerKey that = (FollowerKey) o;
        return Objects.equals(followeeId, that.followeeId) && Objects.equals(followerId, that.followerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followeeId, followerId);
    }
}
