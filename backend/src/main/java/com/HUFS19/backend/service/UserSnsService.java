package com.HUFS19.backend.service;

import com.HUFS19.backend.dto.profile.UserSnsDto;
import com.HUFS19.backend.repository.userSns.UserSnsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserSnsService {

    private final UserSnsRepository userSnsRepository;

    public List<UserSnsDto> findUserSnsList(String userId){
        return userSnsRepository.findByUserId(userId);
    }
}
