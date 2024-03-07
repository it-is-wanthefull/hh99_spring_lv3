package com.sparta.hh99_spring_lv3.model.dto;

import com.sparta.hh99_spring_lv3.model.enumtype.CategoryEnum;
import lombok.Getter;

@Getter
public class LectureModifyRequestDto {
    private String lectureName;
    private int price;
    private String introduce;
    private CategoryEnum category;
}
