package com.HUFS19.backend.common.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class AuthCheckUtils {
    public static String getLoginUserId(){
        if (!AuthCheckUtils.getLoginStatus()){
            return "";
        }
        Optional<Authentication> authentication = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
        UserDetails userDetails = (UserDetails) authentication.get().getPrincipal();
        return userDetails.getUsername();
    }

    public static boolean getLoginStatus(){
        Optional<Authentication> authentication = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
        return authentication.isPresent();
    }
}
