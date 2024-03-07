package com.sparta.hh99_spring_lv3.model.dto;

import com.sparta.hh99_spring_lv3.model.enumtype.DepartmentEnum;
import com.sparta.hh99_spring_lv3.model.enumtype.StaffRoleEnum;
import lombok.Getter;

@Getter
public class SignupRequestDto {
    private String email;
    private String password;
    private DepartmentEnum department;
    private StaffRoleEnum role;
}
