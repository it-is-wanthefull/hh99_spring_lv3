package com.sparta.hh99_spring_lv3.service;

import com.sparta.hh99_spring_lv3.model.dto.*;
import com.sparta.hh99_spring_lv3.model.entity.Lecture;
import com.sparta.hh99_spring_lv3.model.enumtype.CategoryEnum;
import com.sparta.hh99_spring_lv3.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;

    public LectureRegisterResponseDto registerLecture(LectureRegisterRequestDto lectureRegisterRequestDto) {
        Lecture lecture = new Lecture(lectureRegisterRequestDto);
        Lecture savedLecture = lectureRepository.save(lecture);
        return new LectureRegisterResponseDto(savedLecture);
    }

    public LectureModifyResponseDto modifyLecture(Long lectureId, LectureModifyRequestDto lectureModifyRequestDto) {
        Optional<Lecture> optionalLecture = lectureRepository.findById(lectureId);

        if(optionalLecture.isEmpty()) {
            throw new RuntimeException("존재하지 않는 강의번호입니다.");
        } else {
            Lecture lecture = optionalLecture.get();
            lecture.update(lectureModifyRequestDto);
            Lecture savedLecture = lectureRepository.save(lecture);
            return new LectureModifyResponseDto(savedLecture);
        }
    }

    public LectureGetResponseDto getLectureByLectureId(Long lectureId) {
        Optional<Lecture> optionalLecture = lectureRepository.findById(lectureId);

        if(optionalLecture.isEmpty()) {
            throw new RuntimeException("해당 강의번호로 검색된 결과가 존재하지 않습니다.");
        } else {
            return new LectureGetResponseDto(optionalLecture.get());
        }
    }

    public List<LectureGetResponseDto> getLectureByTeacherId(Long teacherId) {
        Optional<List<Lecture>> optionalLectureList = lectureRepository.findAllByTeacherIdOrderByCreatedAtDesc(teacherId);

        if(optionalLectureList.isEmpty()) {
            throw new RuntimeException("해당 강사번호로 검색된 결과가 존재하지 않습니다.");
        } else {
            return optionalLectureList.get().stream().map(LectureGetResponseDto::new).toList();
        }
    }

    public List<LectureGetResponseDto> getLectureByCategory(CategoryEnum category) {
        Optional<List<Lecture>> optionalLectureList = lectureRepository.findAllByCategoryOrderByCreatedAtDesc(category);

        if(optionalLectureList.isEmpty()) {
            throw new RuntimeException("해당 카테고리로 검색된 결과가 존재하지 않습니다.");
        } else {
            return optionalLectureList.get().stream().map(LectureGetResponseDto::new).toList();
        }
    }
}
