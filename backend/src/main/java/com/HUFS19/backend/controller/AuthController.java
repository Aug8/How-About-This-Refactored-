package com.HUFS19.backend.controller;

import com.HUFS19.backend.common.dto.ApiResponseDto;
import com.HUFS19.backend.common.util.ResponseUtils;
import com.HUFS19.backend.dto.auth.LoginStatusDto;
import com.HUFS19.backend.dto.user.JoinDto;
import com.HUFS19.backend.repository.user.User;
import com.HUFS19.backend.service.UserService;
import com.HUFS19.backend.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

import java.security.Principal;
import java.util.Objects;

@RestController
@RequestMapping("/authAPI")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/join")

    public ApiResponseDto<String> join(JoinDto joinDto) {
        userService.joinProcess(joinDto);
        return ResponseUtils.ok("join success");
    }

    @PostMapping("/login")
    public ApiResponseDto login(JoinDto joinDto) {
        return ResponseUtils.ok("Developing");
    }

    @GetMapping("/checkLogin/{userId}")
    public ApiResponseDto<LoginStatusDto> getLoginStatus(@PathVariable("userId") String userId) {
        return ResponseUtils.ok(authService.checkLoginStatus(userId));
    }
}

