package com.example.demo_01.service;

import com.example.demo_01.DTO.UserDto;
import com.example.demo_01.entity.User;
import com.example.demo_01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    private UserRepository userRepository;

    // 회원가입 메서드
    public Integer userJoin(UserDto.RequestUserDto dto) {
        // 비밀번호 암호화
        dto.encryptPassword(passwordEncoder.encode(dto.getPassword()));

        User user = dto.toEntity();
        userRepository.save(user);
        //log.info("DB에 회원 저장 성공");

        return user.getUser_idx();
    }
}