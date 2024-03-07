package com.sparta.hh99_spring_lv3.controller;

import com.sparta.hh99_spring_lv3.model.dto.*;
import com.sparta.hh99_spring_lv3.model.enumtype.CategoryEnum;
import com.sparta.hh99_spring_lv3.model.enumtype.StaffRoleEnum;
import com.sparta.hh99_spring_lv3.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/lectures")
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    @Secured({StaffRoleEnum.Authority.MANAGER, StaffRoleEnum.Authority.STAFF})
    @PostMapping("/register")
    public ResponseEntity<LectureRegisterResponseDto> registerLecture(@RequestBody LectureRegisterRequestDto lectureRegisterRequestDto) {
        try {
            LectureRegisterResponseDto lectureRegisterResponseDto = lectureService.registerLecture(lectureRegisterRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(lectureRegisterResponseDto);
        } catch (Exception e) {
            LectureRegisterResponseDto lectureRegisterResponseDto = new LectureRegisterResponseDto("강의등록 실패: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(lectureRegisterResponseDto);
        }
    }

    @Secured({StaffRoleEnum.Authority.MANAGER})
    @PutMapping("/modify/{lectureId}")
    public ResponseEntity<LectureModifyResponseDto> modifyLecture(@PathVariable Long lectureId, @RequestBody LectureModifyRequestDto lectureModifyRequestDto) {
        try {
            LectureModifyResponseDto lectureModifyResponseDto = lectureService.modifyLecture(lectureId, lectureModifyRequestDto);
            return ResponseEntity.status(HttpStatus.OK).body(lectureModifyResponseDto);
        } catch (Exception e) {
            LectureModifyResponseDto lectureModifyResponseDto = new LectureModifyResponseDto("강의수정 실패: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(lectureModifyResponseDto);
        }
    }

    @Secured({StaffRoleEnum.Authority.MANAGER, StaffRoleEnum.Authority.STAFF})
    @GetMapping("/get/lectureId/{lectureId}")
    public ResponseEntity<LectureGetResponseDto> getLectureByLectureId(@PathVariable Long lectureId) {
        try {
            LectureGetResponseDto lectureGetResponseDto = lectureService.getLectureByLectureId(lectureId);
            return ResponseEntity.status(HttpStatus.OK).body(lectureGetResponseDto);
        } catch (Exception e) {
            LectureGetResponseDto lectureGetResponseDto = new LectureGetResponseDto("강의번호로 강의조회 실패: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(lectureGetResponseDto);
        }
    }

    @Secured({StaffRoleEnum.Authority.MANAGER, StaffRoleEnum.Authority.STAFF})
    @GetMapping("/get/teacherId/{teacherId}")
    public ResponseEntity<List<LectureGetResponseDto>> getLectureByTeacherId(@PathVariable Long teacherId) {
        try {
            List<LectureGetResponseDto> lectureGetResponseDtoList = lectureService.getLectureByTeacherId(teacherId);
            return ResponseEntity.status(HttpStatus.OK).body(lectureGetResponseDtoList);
        } catch (Exception e) {
            List<LectureGetResponseDto> lectureGetResponseDtoList = Collections.singletonList(new LectureGetResponseDto("강사번호로 강의조회 실패: " + e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(lectureGetResponseDtoList);
        }
    }

    @Secured({StaffRoleEnum.Authority.MANAGER, StaffRoleEnum.Authority.STAFF})
    @GetMapping("/get/category/{category}")
    public ResponseEntity<List<LectureGetResponseDto>> getLectureByCategory(@PathVariable CategoryEnum category) {
        try {
            List<LectureGetResponseDto> lectureGetResponseDtoList = lectureService.getLectureByCategory(category);
            return ResponseEntity.status(HttpStatus.OK).body(lectureGetResponseDtoList);
        } catch (Exception e) {
            List<LectureGetResponseDto> lectureGetResponseDtoList = Collections.singletonList(new LectureGetResponseDto("카테고리로 강의조회 실패: " + e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(lectureGetResponseDtoList);
        }
    }
}
