package com.example.response.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class StudentTest {

    @DisplayName("student builder 패턴이 동작하는 지 확인한다.")
    @Test
    void test() {
        // given when
        Student student1 = Student.builder()
            .grade(0)
            .name("student1")
            .build();

        // then
        assertThat(student1.getName()).isEqualTo("student1");
        assertThat(student1.getGrade()).isEqualTo(0);
    }

    @DisplayName("student builder 패턴의 디폴트 값을 확인한다.")
    @Test
    void test1() {
        // given when
        Student student1 = Student.builder()
//            .name("student2")
//            .grade(12)
            .build();

        // then
        assertThat(student1.getName()).isEqualTo(null);
        assertThat(student1.getGrade()).isEqualTo(0);
    }
}