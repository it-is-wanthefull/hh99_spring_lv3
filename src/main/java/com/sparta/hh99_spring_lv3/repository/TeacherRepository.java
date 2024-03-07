package com.sparta.hh99_spring_lv3.repository;

import com.sparta.hh99_spring_lv3.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
