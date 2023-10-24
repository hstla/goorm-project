package com.example.response.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Student implements Comparable<Student> {

    private String name;
    private int grade;

    @Override
    public int compareTo(Student o) {
        return this.grade - o.grade;
    }
}
