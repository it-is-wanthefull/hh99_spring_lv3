package com.sparta.hh99_spring_lv3.controller;

import com.sparta.hh99_spring_lv3.model.dto.LoginRequestDto;
import com.sparta.hh99_spring_lv3.model.dto.SignupRequestDto;
import com.sparta.hh99_spring_lv3.service.StaffService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @PostMapping("/signup")
    public ResponseEntity<String> signupStaff(@RequestBody SignupRequestDto signupRequestDto) {
        try {
            staffService.signupStaff(signupRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원가입 실패: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginStaff(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse res) {
        try {
            staffService.loginStaff(loginRequestDto, res);
            return ResponseEntity.status(HttpStatus.OK).body("로그인 성공!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("로그인 실패: " + e.getMessage());
        }
    }
}