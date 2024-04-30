package com.HUFS19.backend.controller;

import com.HUFS19.backend.repository.userInfo.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userAPI")
public class UserInfoController {
    @Autowired
    UserInfoRepository userInfoRepository;

}
