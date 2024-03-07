package com.sparta.hh99_spring_lv3.controller;

import com.sparta.hh99_spring_lv3.model.dto.*;
import com.sparta.hh99_spring_lv3.model.enumtype.StaffRoleEnum;
import com.sparta.hh99_spring_lv3.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @Secured({StaffRoleEnum.Authority.MANAGER, StaffRoleEnum.Authority.STAFF})
    @PostMapping("/register")
    public ResponseEntity<TeacherRegisterResponseDto> registerTeacher(@RequestBody TeacherRegisterRequestDto teacherRegisterRequestDto) {
        try {
            TeacherRegisterResponseDto teacherRegisterResponseDto = teacherService.registerTeacher(teacherRegisterRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(teacherRegisterResponseDto);
        } catch (Exception e) {
            TeacherRegisterResponseDto teacherRegisterResponseDto = new TeacherRegisterResponseDto("강사등록 실패: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(teacherRegisterResponseDto);
        }
    }

    @Secured({StaffRoleEnum.Authority.MANAGER})
    @PutMapping("/modify/{teacherId}")
    public ResponseEntity<TeacherModifyResponseDto> modifyTeacher(@PathVariable Long teacherId, @RequestBody TeacherModifyRequestDto teacherModifyRequestDto) {
        try {
            TeacherModifyResponseDto teacherModifyResponseDto = teacherService.modifyTeacher(teacherId, teacherModifyRequestDto);
            return ResponseEntity.status(HttpStatus.OK).body(teacherModifyResponseDto);
        } catch (Exception e) {
            TeacherModifyResponseDto teacherModifyResponseDto = new TeacherModifyResponseDto("강사수정 실패: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(teacherModifyResponseDto);
        }
    }

    @Secured({StaffRoleEnum.Authority.MANAGER, StaffRoleEnum.Authority.STAFF})
    @GetMapping("/get/{teacherId}")
    public ResponseEntity<TeacherGetResponseDto> getTeacher(@PathVariable Long teacherId) {
        try {
            TeacherGetResponseDto teacherGetResponseDto = teacherService.getTeacher(teacherId);
            return ResponseEntity.status(HttpStatus.OK).body(teacherGetResponseDto);
        } catch (Exception e) {
            TeacherGetResponseDto teacherGetResponseDto = new TeacherGetResponseDto("강사조회 실패: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(teacherGetResponseDto);
        }
    }
}
