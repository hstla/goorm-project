package com.example.response.repository;

import com.example.response.domain.Student;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    Set<Student> set = new HashSet<>();

    @Override
    public void add(Student student) {
        set.add(student);
    }

    @Override
    public List<Student> getAll() {
        return set.stream()
            .sorted()
            .collect(Collectors.toList());
    }
    @Override
    public List<Student> getGrade(int grade) {
        return set.stream()
            .filter(student -> student.getGrade() == grade)
            .collect(Collectors.toList());
    }
    @Override
    public void clear() {
        set.clear();
    }

}
