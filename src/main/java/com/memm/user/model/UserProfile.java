package com.memm.user.model;

import org.springframework.data.cassandra.core.mapping.Table;

@Table("users_by_id")
public class UserProfile extends BaseModel {

    private String username;
    private String displayName;
    private String bio;

    public UserProfile() {
    }

    public UserProfile(String username, String displayName, String bio) {
        this.username = username;
        this.displayName = displayName;
        this.bio = bio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
