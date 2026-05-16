package com.memm.user.dto;

import com.memm.user.model.FollowersByUser;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public record FollowersResponse(
        UUID userId,
        List<UUID> followerIds) {

    public static FollowersResponse from(UUID userId, Collection<FollowersByUser> followers) {
        return new FollowersResponse(
                userId,
                followers.stream()
                        .map(follower -> follower.getKey().getFollowerId())
                        .toList());
    }
}
