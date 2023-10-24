package com.example.response.repository;

import com.example.response.domain.Student;
import java.util.List;

public interface StudentRepository {
    public void add(Student student);
    public List<Student> getAll();
    public List<Student> getGrade(int grade);
    public void clear();
}
