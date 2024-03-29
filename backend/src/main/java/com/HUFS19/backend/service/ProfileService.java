package com.HUFS19.backend.service;

import com.HUFS19.backend.dto.profile.ProfileDto;
import com.HUFS19.backend.error.CustumException;
import com.HUFS19.backend.error.ErrorCode;
import com.HUFS19.backend.repository.userInfo.UserInfoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ProfileService {
    private final UserInfoRepository userInfoRepository;

    public ProfileDto findUserInfo(String userId){
        return userInfoRepository.findByUserId(userId).orElseThrow(()-> new CustumException(ErrorCode.MISSING_PROFILE));
    }
}
