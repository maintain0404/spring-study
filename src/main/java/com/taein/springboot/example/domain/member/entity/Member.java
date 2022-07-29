package com.taein.springboot.example.domain.member.entity;

import com.taein.springboot.example.domain.member.enums.Grade;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Member {
    private Long id;
    private String name;
    private Grade grade;

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}
