package com.sparta.hh99_spring_lv3.model.entity;

import com.sparta.hh99_spring_lv3.model.dto.LectureModifyRequestDto;
import com.sparta.hh99_spring_lv3.model.dto.LectureRegisterRequestDto;
import com.sparta.hh99_spring_lv3.model.enumtype.CategoryEnum;
import com.sparta.hh99_spring_lv3.model.timestamp.LectureTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lectures")
public class Lecture extends LectureTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureId;

    @Column(nullable = false)
    private String lectureName;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String introduce;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private CategoryEnum category;

    @Column(nullable = false)
    private Long teacherId;

    public Lecture(LectureRegisterRequestDto lectureRegisterRequestDto) {
        this.lectureName = lectureRegisterRequestDto.getLectureName();
        this.price = lectureRegisterRequestDto.getPrice();
        this.introduce = lectureRegisterRequestDto.getIntroduce();
        this.category = lectureRegisterRequestDto.getCategory();
        this.teacherId = lectureRegisterRequestDto.getTeacherId();
    }

    public void update(LectureModifyRequestDto lectureModifyRequestDto) {
        this.lectureName = lectureModifyRequestDto.getLectureName();
        this.price = lectureModifyRequestDto.getPrice();
        this.introduce = lectureModifyRequestDto.getIntroduce();
        this.category = lectureModifyRequestDto.getCategory();
    }
}