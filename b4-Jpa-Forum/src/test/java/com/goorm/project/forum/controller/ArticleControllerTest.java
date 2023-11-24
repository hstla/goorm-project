package com.goorm.project.forum.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goorm.project.forum.BasicTestConfig;
import com.goorm.project.forum.domain.Entity.Article;
import com.goorm.project.forum.domain.request.ArticleDeleteRequest;
import com.goorm.project.forum.domain.request.ArticlePostRequest;
import com.goorm.project.forum.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

class ArticleControllerTest extends BasicTestConfig {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void writeArticleTest() throws Exception {
        ArticlePostRequest articlePostRequest = new ArticlePostRequest("title", "content");


        mockMvc.perform(
                post("/api/article")
                    .content(objectMapper.writeValueAsString(articlePostRequest))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.title").value("title"))
            .andExpect(jsonPath("$.body").value("content"));
    }

    @Test
    void searchArticleListTest() throws Exception {
        Article firstArticle = articleRepository.save(
            Article.create(new ArticlePostRequest("title1", "content1")));
        articleRepository.save(Article.create(new ArticlePostRequest("title2", "content2")));
        articleRepository.save(Article.create(new ArticlePostRequest("title3", "content3")));
        Long articleNo = firstArticle.getArticleNo();

        mockMvc.perform(
                get("/api/articles")
                    .queryParam("pageSize", "5")
                    .queryParam("lastArticleNo", String.valueOf(articleNo))
            ).andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void searchArticle() throws Exception {
        Article findArticle = articleRepository.save(
            Article.create(new ArticlePostRequest("title1", "content1")));

        mockMvc.perform(
                get("/api/article")
                    .queryParam("articleNo", String.valueOf(findArticle.getArticleNo()))
            ).andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.title").value("title1"))
            .andExpect(jsonPath("$.body").value("content1"));
    }

    @Test
    void deleteArticle() throws Exception {
        Article findArticle = articleRepository.save(
            Article.create(new ArticlePostRequest("title1", "content1")));

        ArticleDeleteRequest deleteArticle = new ArticleDeleteRequest(findArticle.getArticleNo());

        mockMvc.perform(
            delete("/api/article")
                .content(objectMapper.writeValueAsString(deleteArticle))
                .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("OK"));
    }
}