package com.HUFS19.backend.dto.profile;

import com.HUFS19.backend.dto.auth.LoginStatusDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProfileSummaryDto {
    ProfileDto profile;
    LoginStatusDto loginStatus;
}
