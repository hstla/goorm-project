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

    public Student addStudent(Student student) {
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
