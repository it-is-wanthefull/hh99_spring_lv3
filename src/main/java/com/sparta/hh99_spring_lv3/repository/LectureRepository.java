package com.sparta.hh99_spring_lv3.repository;

import com.sparta.hh99_spring_lv3.model.entity.Lecture;
import com.sparta.hh99_spring_lv3.model.enumtype.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    Optional<List<Lecture>> findAllByTeacherIdOrderByCreatedAtDesc(Long teacherId);
    Optional<List<Lecture>> findAllByCategoryOrderByCreatedAtDesc(CategoryEnum category);
}
