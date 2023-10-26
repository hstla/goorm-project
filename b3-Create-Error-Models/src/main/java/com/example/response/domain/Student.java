package com.example.response.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student implements Comparable<Student> {

    private String name;
    private int grade;


    @Override
    public int compareTo(Student o) {
        return this.grade - o.grade;
    }

}
