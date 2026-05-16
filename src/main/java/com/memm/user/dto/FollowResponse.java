package com.memm.user.dto;

import com.memm.user.model.FollowersByUser;
import com.memm.user.model.FollowingByUser;

import java.util.UUID;

public record FollowResponse(
        UUID followerId,
        UUID followeeId) {

    public static FollowResponse from(FollowingByUser followingByUser) {
        return new FollowResponse(
                followingByUser.getKey().getFollowerId(),
                followingByUser.getKey().getFolloweeId());
    }

    public static FollowResponse from(FollowersByUser followersByUser) {
        return new FollowResponse(
                followersByUser.getKey().getFollowerId(),
                followersByUser.getKey().getFolloweeId());
    }
}
