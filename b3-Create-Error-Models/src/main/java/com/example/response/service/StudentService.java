package com.example.response.service;

import com.example.response.domain.Student;
import com.example.response.repository.StudentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student addStudent(String name, int grade) {
        Student student = Student.builder().name(name).grade(grade).build();
        studentRepository.add(student);
        return student;
    }

    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    public List<Student> getGradeStudent(int grade) {
        return studentRepository.getGrade(grade);
    }
}
