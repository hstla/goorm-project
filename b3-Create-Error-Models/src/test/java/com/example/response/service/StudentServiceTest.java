package com.example.response.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.response.domain.Student;
import com.example.response.repository.StudentRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @AfterEach
    void tearDown() {
        studentRepository.clear();
    }

    @DisplayName("학생 저장과 성적순으로 조회되는지 확인한다.")
    @Test
    void addStudent() {
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
        studentService.addStudent(student1);
        studentService.addStudent(student2);
        List<Student> result = studentService.getAll();

        // then
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getGrade()).isEqualTo(1);
        assertThat(result.get(1).getGrade()).isEqualTo(2);
    }

    @DisplayName("grade 1을 확인한다.")
    @Test
    void getGradeStudent() {
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
        studentService.addStudent(student1);
        studentService.addStudent(student2);
        List<Student> result = studentService.getGradeStudent(1);

        // then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getGrade()).isEqualTo(1);
    }
}