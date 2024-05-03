package com.HUFS19.backend.service.auth;

import com.HUFS19.backend.common.util.AuthCheckUtils;
import com.HUFS19.backend.common.util.ResponseUtils;
import com.HUFS19.backend.dto.auth.LoginStatusDto;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthService {
    public LoginStatusDto checkLoginStatus(String userId){
        String foundUserId = AuthCheckUtils.getLoginUserId();
        if (foundUserId.equals(userId)){
            return new LoginStatusDto(true, userId);
        }
        return new LoginStatusDto(false);
    }
}
