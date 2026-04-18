package com.example.repoService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Social-focused view: just the user and their friends
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFriendsResponse {
    private Long userId;
    private String fullName;
    private String profilePictureUrl;
    private List<UserSummaryResponse> friends;
    private int friendCount;
}
