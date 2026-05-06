package com.memm.user.model;

import com.memm.user.model.key.FollowingKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("following_by_user")
public class FollowingByUser {

    @PrimaryKey
    private FollowingKey key;

    public FollowingByUser() {
    }

    public FollowingByUser(FollowingKey key) {
        this.key = key;
    }

    public FollowingKey getKey() {
        return key;
    }

    public void setKey(FollowingKey key) {
        this.key = key;
    }
}
