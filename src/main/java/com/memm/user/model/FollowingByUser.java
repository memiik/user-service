package com.memm.user.model;

import com.memm.user.model.key.FollowingKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("following_by_user")
public class FollowingByUser {

    @PrimaryKey
    private FollowingKey followingKey;

    public FollowingByUser() {
    }

    public FollowingByUser(FollowingKey followingKey) {
        this.followingKey = followingKey;
    }

    public FollowingKey getFollowingKey() {
        return followingKey;
    }

    public void setFollowingKey(FollowingKey followingKey) {
        this.followingKey = followingKey;
    }
}
