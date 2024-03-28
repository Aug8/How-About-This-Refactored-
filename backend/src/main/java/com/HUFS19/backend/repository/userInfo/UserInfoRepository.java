package com.HUFS19.backend.repository.userInfo;

import com.HUFS19.backend.dto.profile.ProfileDto;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository {
    String save(UserInfo userInfo);
    Optional<ProfileDto> findByUserId(String userId);
}
