package com.example.response.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.example.response.domain.Student;
import com.example.response.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


//@WebMvcTest(controllers = StudentController.class)
@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @AfterEach
    void tearDown() {
        studentRepository.clear();
    }

    // 쿼리 파라미터로 요청하기 첫번째 방법
    @DisplayName("student를 생성한다")
    @Test
    void add1() throws Exception {
        // given
        Student student = Student.builder()
            .name("hello")
            .grade(5)
            .build();

        // when then
        mockMvc.perform(
                get("/student")  // 요청은 이렇게 보내면된다.
                    .queryParam("name", student.getName())
                    .queryParam("grade", String.valueOf(student.getGrade()))
            )
            .andDo(print())    // request, response을 모두 출력
            .andExpect(status().isOk());  // 검증 부분
    }

    // 쿼리 파라미터로 요청하기 두번째 방법
    @DisplayName("student를 MultiValueMap으로 생성한다.")
    @Test
    void add2() throws Exception {
        // given
        Student student = Student.builder()
            .name("hello")
            .grade(5)
            .build();

        MultiValueMap<String, String> map = new LinkedMultiValueMap() {};

        map.add("name", student.getName());
        map.add("grade", String.valueOf(student.getGrade()));

        // when then
        mockMvc.perform(
                get("/student")
                    .queryParams(map))

            .andDo(print())   // 프린트 해!

            .andExpect(status().isOk())

            .andExpect(jsonPath("$.status.code").value(2000))
            .andExpect(jsonPath("$.status.message").value("OK"))
            .andExpect(jsonPath("$.results").isArray())
            .andExpect(jsonPath("$.results.length()").value(1))       // 배열의 크기
            .andExpect(jsonPath("$.results[0].name").value("hello"))  // 배열 접근 방법
            .andExpect(jsonPath("$.results[0].grade").value(5))
            .andExpect(jsonPath("$.metadata.resultCount").value(1));

    }

    @DisplayName("바디로 학생 정보를 받는다.")
    @Test
    void addPost() throws Exception {
        // given
        Student student = Student.builder()
            .name("hello")
            .grade(5)
            .build();

        // when then
        mockMvc.perform(
            post("/studentBody")
                .content(objectMapper.writeValueAsString(student))
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andDo(print());
    }

    @DisplayName("add 메서드의 에러를 발생시켜 확인한다.")
    @Test
    void addException() throws Exception {
        // given
        Student student = Student.builder()
            .name("hello")
            .grade(6)
            .build();

        // when then
        mockMvc.perform(
                post("/studentBody")
                    .content(objectMapper.writeValueAsString(student))
                    .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status.code").value(5000))
            .andExpect(jsonPath("$.status.message").value("grade는 6 이상을 입력할 수 없습니다."));
    }

    @DisplayName("path variable로 요청하는 방법")
    @Test
    void addGetGrade() throws Exception {
        // given
        Student student1 = Student.builder()
            .name("hello1")
            .grade(1)
            .build();
        Student student2 = Student.builder()
            .name("hello2")
            .grade(2)
            .build();
        Student student3 = Student.builder()
            .name("hello3")
            .grade(1)
            .build();
        studentRepository.add(student1);
        studentRepository.add(student2);
        studentRepository.add(student3);

        // when then
        mockMvc.perform(
                get("/student/{grade}",1)

            ).andDo(print())
            .andExpect(status().isOk())
        ;
    }


    @DisplayName("getAll 메서드로 모든 학생을 조회한다.")
    @Test
    void getAll() throws Exception {
        // given
        Student student1 = Student.builder()
            .name("hello1")
            .grade(1)
            .build();

        Student student2 = Student.builder()
            .name("hello2")
            .grade(2)
            .build();

        studentRepository.add(student1);
        studentRepository.add(student2);

        // when then
        mockMvc.perform(get("/students"))
            .andDo(print())
            .andExpect(jsonPath("$.results.length()").value(2))
            .andExpect(jsonPath("$.results[0].grade").value(1))
            .andExpect(jsonPath("$.results[1].grade").value(2))
        ;
    }
}
