package com.sparta.hh99_spring_lv3.service;

import com.sparta.hh99_spring_lv3.springsecurity.jwt.JwtUtil;
import com.sparta.hh99_spring_lv3.model.dto.LoginRequestDto;
import com.sparta.hh99_spring_lv3.model.dto.SignupRequestDto;
import com.sparta.hh99_spring_lv3.model.entity.Staff;
import com.sparta.hh99_spring_lv3.model.enumtype.DepartmentEnum;
import com.sparta.hh99_spring_lv3.model.enumtype.StaffRoleEnum;
import com.sparta.hh99_spring_lv3.repository.StaffRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StaffService {
    private final StaffRepository staffRepository;
    private final JwtUtil jwtUtil;

    @Transactional
    public void signupStaff(SignupRequestDto signupRequestDto) {
        Staff staff = new Staff(signupRequestDto);
        Optional<Staff> optionalStaff = staffRepository.findByEmail(staff.getEmail());

        if(optionalStaff.isPresent()) {
            throw new RuntimeException("이미 가입되어있는 이메일입니다.");
        } else if(staff.getDepartment() == DepartmentEnum.MARKETING
                && staff.getRole() == StaffRoleEnum.MANAGER) {
            throw new RuntimeException("마케팅 부서에서는 매니저로 등록할 수 없습니다.");
        } else {
            staffRepository.save(staff);
        }
    }

    @Transactional
    public void loginStaff(LoginRequestDto loginRequestDto, HttpServletResponse res) {
        Staff staff = new Staff(loginRequestDto);
        Optional<Staff> optionalStaff = staffRepository.findByEmail(staff.getEmail());

        if(optionalStaff.isEmpty()) {
            throw new RuntimeException("가입되어있지 않은 이메일입니다.");
        } else if(!optionalStaff.get().getPassword().equals(staff.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        } else {
            String token = jwtUtil.createToken(staff.getEmail(), staff.getRole());
            jwtUtil.addJwtToCookie(token, res);
        }
    }
}
