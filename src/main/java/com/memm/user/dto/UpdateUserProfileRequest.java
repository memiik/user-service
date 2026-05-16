package com.memm.user.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateUserProfileRequest(
        @NotBlank String displayName,
        String bio) {
}
