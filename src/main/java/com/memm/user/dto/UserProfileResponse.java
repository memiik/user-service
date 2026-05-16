package com.memm.user.dto;

import com.memm.user.model.UserProfile;

import java.time.Instant;
import java.util.UUID;

public record UserProfileResponse(
        UUID id,
        String username,
        String displayName,
        String bio,
        Instant createdAt,
        Instant updatedAt) {

    public static UserProfileResponse from(UserProfile profile) {
        return new UserProfileResponse(
                profile.getId(),
                profile.getUsername(),
                profile.getDisplayName(),
                profile.getBio(),
                profile.getCreatedAt(),
                profile.getUpdatedAt());
    }
}
