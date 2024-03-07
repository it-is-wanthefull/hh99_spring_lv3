package com.sparta.hh99_spring_lv3.service;

import com.sparta.hh99_spring_lv3.model.dto.*;
import com.sparta.hh99_spring_lv3.model.entity.Teacher;
import com.sparta.hh99_spring_lv3.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherRegisterResponseDto registerTeacher(TeacherRegisterRequestDto teacherRegisterRequestDto) {
        Teacher teacher = new Teacher(teacherRegisterRequestDto);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return new TeacherRegisterResponseDto(savedTeacher);
    }

    public TeacherModifyResponseDto modifyTeacher(Long teacherId, TeacherModifyRequestDto teacherModifyRequestDto) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);

        if(optionalTeacher.isEmpty()) {
            throw new RuntimeException("존재하지 않는 강사번호입니다.");
        } else {
            Teacher teacher = optionalTeacher.get();
            teacher.update(teacherModifyRequestDto);
            Teacher savedTeacher = teacherRepository.save(teacher);
            return new TeacherModifyResponseDto(savedTeacher);
        }
    }

    public TeacherGetResponseDto getTeacher(Long teacherId) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);

        if(optionalTeacher.isEmpty()) {
            throw new RuntimeException("존재하지않는 강사번호입니다.");
        } else {
            return new TeacherGetResponseDto(optionalTeacher.get());
        }
    }
}
