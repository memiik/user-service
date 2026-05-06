package com.memm.user.model;

import com.memm.user.model.key.FollowerKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("followers_by_user")
public class FollowersByUser {

    @PrimaryKey
    private FollowerKey followerKey;

    public FollowersByUser() {
    }

    public FollowersByUser(FollowerKey followerKey) {
        this.followerKey = followerKey;
    }

    public FollowerKey getFollowerKey() {
        return followerKey;
    }

    public void setFollowerKey(FollowerKey followerKey) {
        this.followerKey = followerKey;
    }
}
