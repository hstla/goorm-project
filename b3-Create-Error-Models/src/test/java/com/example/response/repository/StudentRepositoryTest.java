package com.example.response.repository;


import static org.assertj.core.api.Assertions.assertThat;

import com.example.response.domain.Student;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private  StudentRepository studentRepository;

    @AfterEach
    void tearDown() {
        studentRepository.clear();
    }

    @DisplayName("학생이 잘 들어가는 지 확인한다.")
    @Test
    void addGetAll() {
        // given
        Student student1 = Student.builder()
            .name("hello1")
            .grade(1)
            .build();

        Student student2 = Student.builder()
            .name("hello1")
            .grade(2)
            .build();

        // when
        studentRepository.add(student1);
        studentRepository.add(student2);
        List<Student> result = studentRepository.getAll();

        // then
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getName()).isEqualTo("hello1");
        assertThat(result.get(0).getGrade()).isEqualTo(1);
        assertThat(result.get(1).getGrade()).isEqualTo(2);
    }


    @DisplayName("해당 성적 학생만 나오는 지 확인한다.")
    @Test
    void test() {
        // given
        Student student1 = Student.builder()
            .name("hello1")
            .grade(1)
            .build();

        Student student2 = Student.builder()
            .name("hello2")
            .grade(2)
            .build();

        // when
        studentRepository.add(student1);
        studentRepository.add(student2);
        List<Student> result = studentRepository.getGrade(2);

        // then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getGrade()).isEqualTo(2);
    }
}