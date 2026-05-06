package com.memm.user.model;

import com.memm.user.model.key.FollowerKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("followers_by_user")
public class FollowersByUser {

    @PrimaryKey
    private FollowerKey key;

    public FollowersByUser() {
    }

    public FollowersByUser(FollowerKey followerKey) {
        this.key = followerKey;
    }

    public FollowerKey getKey() {
        return key;
    }

    public void setKey(FollowerKey key) {
        this.key = key;
    }
}
