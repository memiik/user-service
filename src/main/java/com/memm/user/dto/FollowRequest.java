package com.memm.user.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record FollowRequest(
        @NotNull UUID followerId,
        @NotNull UUID followeeId) {
}
