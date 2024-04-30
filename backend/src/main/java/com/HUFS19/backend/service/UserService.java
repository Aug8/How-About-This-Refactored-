package com.HUFS19.backend.service;

import com.HUFS19.backend.dto.user.JoinDto;
import com.HUFS19.backend.error.CustumException;
import com.HUFS19.backend.error.ErrorCode;
import com.HUFS19.backend.repository.user.User;
import com.HUFS19.backend.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository=userRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }

    public boolean checkIdDuplication(String id){
        return userRepository.findById(id).isPresent();
    }

    public boolean joinProcess(JoinDto joinDto){
        String id = joinDto.getId();
        String pw = joinDto.getPw();

        if (checkIdDuplication(id)){
            throw new CustumException(ErrorCode.USER_ID_CONFLICT);
        }
//
//        User newUser = new User(id, bCryptPasswordEncoder.encode(pw));
////        User.builder().id(id).password(bCryptPasswordEncoder.encode(pw)).build();
//        userRepository.save(newUser);

        return false;
    }
}
