package com.memm.user.dto;

import com.memm.user.model.FollowingByUser;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public record FollowingResponse(
        UUID userId,
        List<UUID> followeeIds) {

    public static FollowingResponse from(UUID userId, Collection<FollowingByUser> following) {
        return new FollowingResponse(
                userId,
                following.stream()
                        .map(followedUser -> followedUser.getKey().getFolloweeId())
                        .toList());
    }
}
