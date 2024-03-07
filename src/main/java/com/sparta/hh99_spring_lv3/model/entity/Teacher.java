package com.sparta.hh99_spring_lv3.model.entity;

import com.sparta.hh99_spring_lv3.model.dto.TeacherModifyRequestDto;
import com.sparta.hh99_spring_lv3.model.dto.TeacherRegisterRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;

    @Column(nullable = false)
    private String teacherName;

    @Column(nullable = false)
    private String career;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String phoneNum;

    @Column(nullable = false)
    private String introduce;

    public Teacher(TeacherRegisterRequestDto teacherRegisterRequestDto) {
        this.teacherName = teacherRegisterRequestDto.getTeacherName();
        this.career = teacherRegisterRequestDto.getCareer();
        this.company = teacherRegisterRequestDto.getCompany();
        this.phoneNum = teacherRegisterRequestDto.getPhoneNum();
        this.introduce = teacherRegisterRequestDto.getIntroduce();
    }

    public void update(TeacherModifyRequestDto teacherModifyRequestDto) {
        this.career = teacherModifyRequestDto.getCareer();
        this.company = teacherModifyRequestDto.getCompany();
        this.phoneNum = teacherModifyRequestDto.getPhoneNum();
        this.introduce = teacherModifyRequestDto.getIntroduce();
    }
}