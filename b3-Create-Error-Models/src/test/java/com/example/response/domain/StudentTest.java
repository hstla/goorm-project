package com.example.response.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class StudentTest {

    @DisplayName("student builder 패턴이 동작하는 지 확인한다.")
    @Test
    void test() {
        // given
        Student student1 = Student.builder()
            .name("studen1")
            .grade(12)
            .build();

        // when then
        log.info("student1 name = {}, grade = {}", student1.getName(), student1.getGrade());
    }
}