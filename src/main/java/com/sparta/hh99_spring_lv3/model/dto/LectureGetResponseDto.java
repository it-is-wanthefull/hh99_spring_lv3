package com.sparta.hh99_spring_lv3.model.dto;

import com.sparta.hh99_spring_lv3.model.entity.Lecture;
import com.sparta.hh99_spring_lv3.model.enumtype.CategoryEnum;
import lombok.Getter;

@Getter
public class LectureGetResponseDto {
    private Long lectureId;
    private String lectureName;
    private int price;
    private String introduce;
    private CategoryEnum category;
    private Long teacherId;

    public LectureGetResponseDto(Lecture lecture) {
        this.lectureId = lecture.getLectureId();
        this.lectureName = lecture.getLectureName();
        this.price = lecture.getPrice();
        this.introduce = lecture.getIntroduce();
        this.category = lecture.getCategory();
        this.teacherId = lecture.getTeacherId();
    }

    public LectureGetResponseDto(String errorMessage) {
        this.lectureName = errorMessage;
    }
}
