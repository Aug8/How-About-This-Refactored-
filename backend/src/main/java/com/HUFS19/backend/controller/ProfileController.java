package com.HUFS19.backend.controller;

import com.HUFS19.backend.common.dto.ApiResponseDto;
import com.HUFS19.backend.common.util.ResponseUtils;
import com.HUFS19.backend.dto.auth.LoginStatusDto;
import com.HUFS19.backend.dto.profile.ProfileDetailDto;
import com.HUFS19.backend.dto.profile.ProfileDto;
import com.HUFS19.backend.dto.profile.ProfileSummaryDto;
import com.HUFS19.backend.dto.profile.UserSnsDto;
import com.HUFS19.backend.service.ProfileService;
import com.HUFS19.backend.service.UserSnsService;
import com.HUFS19.backend.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/profileAPI")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;
    private final AuthService authService;
    private final UserSnsService userSnsService;

    @GetMapping("/{userId}")
    public ApiResponseDto<ProfileDetailDto> getProfileDetail(@PathVariable("userId")String userId){
        LoginStatusDto loginStatusDto = authService.checkLoginStatus(userId);
        List<UserSnsDto> userSnsDtoList = userSnsService.findUserSnsList(userId);
        ProfileDto profileDto = profileService.findUserInfo(userId);

        return ResponseUtils.ok(new ProfileDetailDto(profileDto, userSnsDtoList, loginStatusDto));
    }

    @GetMapping("/nav")
    public ApiResponseDto<ProfileSummaryDto> getProfileSummary(Principal principal){
        if(principal==null){
            return ResponseUtils.ok(new ProfileSummaryDto(new ProfileDto(), new LoginStatusDto(false)));
        }
        String loginUserId = principal.getName();
        ProfileDto profileDto = profileService.findUserInfo(loginUserId);
        return ResponseUtils.ok(new ProfileSummaryDto(profileDto, new LoginStatusDto(true, loginUserId)));
    }

}
