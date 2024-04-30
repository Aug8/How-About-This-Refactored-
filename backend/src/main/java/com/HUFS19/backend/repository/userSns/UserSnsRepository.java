package com.HUFS19.backend.repository.userSns;

import com.HUFS19.backend.dto.profile.UserSnsDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSnsRepository {
    List<UserSnsDto> findByUserId(String userId);
}
