package com.sparta.hh99_spring_lv3.model.entity;

import com.sparta.hh99_spring_lv3.model.dto.LoginRequestDto;
import com.sparta.hh99_spring_lv3.model.dto.SignupRequestDto;
import com.sparta.hh99_spring_lv3.model.enumtype.DepartmentEnum;
import com.sparta.hh99_spring_lv3.model.enumtype.StaffRoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;

    @Email
    @Column(nullable = false)
    private String email;

    @Pattern(regexp = "^[A-Za-z\\d@$!%*?&]{8,15}$")
    @Column(nullable = false)
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private DepartmentEnum department;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private StaffRoleEnum role;

    public Staff(SignupRequestDto signupRequestDto) {
        this.email = signupRequestDto.getEmail();
        this.password = signupRequestDto.getPassword();
        this.department = signupRequestDto. getDepartment();
        this.role = signupRequestDto.getRole();
    }

    public Staff(LoginRequestDto loginRequestDto) {
        this.email = loginRequestDto.getEmail();
        this.password = loginRequestDto.getPassword();
    }
}