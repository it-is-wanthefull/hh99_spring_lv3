package com.sparta.hh99_spring_lv3.repository;

import com.sparta.hh99_spring_lv3.model.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Optional<Staff> findByEmail(String email);
}
