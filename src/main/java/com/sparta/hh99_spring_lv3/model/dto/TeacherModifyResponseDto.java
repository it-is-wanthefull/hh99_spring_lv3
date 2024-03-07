package com.sparta.hh99_spring_lv3.model.dto;

import com.sparta.hh99_spring_lv3.model.entity.Teacher;
import lombok.Getter;

@Getter
public class TeacherModifyResponseDto {
    private Long teacherId;
    private String career;
    private String company;
    private String phoneNum;
    private String introduce;

    public TeacherModifyResponseDto(Teacher teacher) {
        this.teacherId = teacher.getTeacherId();
        this.career = teacher.getCareer();
        this.company = teacher.getCompany();
        this.phoneNum = teacher.getPhoneNum();
        this.introduce = teacher.getIntroduce();
    }

    public TeacherModifyResponseDto(String errorMessage) {
        this.career = errorMessage;
    }
}
