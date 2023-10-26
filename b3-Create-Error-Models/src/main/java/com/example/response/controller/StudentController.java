package com.example.response.controller;

import com.example.response.domain.Student;
import com.example.response.exception.CustomException;
import com.example.response.exception.ErrorCode;
import com.example.response.exception.InputRestriction;
import com.example.response.form.ApiResponse;
import com.example.response.service.StudentService;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/student")
    public ApiResponse add(
        @RequestParam("name") String name,
        @RequestParam("grade") int grade
    ) {
        if (grade >= 6) {
            throw new CustomException(ErrorCode.BAD_REQUEST, "grade는 6 이상을 입력할 수 없습니다.",
                new InputRestriction(6));
        }
        log.info("student name: {}, grade: {}",name, grade);
        return makeResponse(studentService.addStudent(name, grade));
    }

    @PostMapping("/studentBody")
    public ApiResponse addpost(
        @RequestBody Student student
    ) {
        if (student.getGrade() >= 6) {
            throw new CustomException(ErrorCode.BAD_REQUEST, "grade는 6 이상을 입력할 수 없습니다.",
                new InputRestriction(6));
        }
        return makeResponse(studentService.addStudent(student.getName(), student.getGrade()));
    }

    @GetMapping("/students")
    public ApiResponse addAll() {
        return makeResponse(studentService.getAll());
    }

    @GetMapping("/student/{grade}")
    public ApiResponse addGetGrade(
        @PathVariable int grade
    ) {
        return makeResponse(studentService.getGradeStudent(grade));
    }

    public <T> ApiResponse<T> makeResponse(List<T> result) {
        return new ApiResponse<>(result);
    }

    public <T> ApiResponse<T> makeResponse(T result) {
        return makeResponse(Collections.singletonList(result));
    }
}
