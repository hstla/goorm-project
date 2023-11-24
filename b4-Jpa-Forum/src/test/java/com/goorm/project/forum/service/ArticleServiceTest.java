package com.goorm.project.forum.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.goorm.project.forum.BasicTestConfig;
import com.goorm.project.forum.domain.Entity.Article;
import com.goorm.project.forum.domain.request.ArticleDeleteRequest;
import com.goorm.project.forum.domain.request.ArticlePostRequest;
import com.goorm.project.forum.domain.response.ArticleListResponse;
import com.goorm.project.forum.domain.response.ArticleResponse;
import com.goorm.project.forum.repository.ArticleRepository;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class ArticleServiceTest extends BasicTestConfig {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRepository articleRepository;

    @DisplayName("게시글을 작성한다.")
    @Test
    public void writeArticleTest() {
        // given
        ArticlePostRequest request = new ArticlePostRequest("Test Title", "Test Body");

        // when
        ArticleResponse response = articleService.writeArticle(request);

        // then
        assertThat(response.getTitle()).isEqualTo(request.getTitle());
        assertThat(response.getBody()).isEqualTo(request.getBody());
    }

    @DisplayName("게시글 목록을 조회한다.")
    @Test
    public void searchArticleListTest() {
        // given
        articleService.writeArticle(new ArticlePostRequest("Test Title1", "Test Body1"));
        articleService.writeArticle(new ArticlePostRequest("Test Title2", "Test Body2"));
        articleService.writeArticle(new ArticlePostRequest("Test Title3", "Test Body3"));
        articleService.writeArticle(new ArticlePostRequest("Test Title4", "Test Body4"));
        int pageSize = 2;
        Long lastArticleNo = 1L;

        // when
        List<ArticleListResponse> response = articleService.searchArticleList(pageSize,
            lastArticleNo);

        // then
        assertThat(response).isNotNull();
        assertThat(response.size()).isEqualTo(pageSize);
    }

    @Test
    @DisplayName("게시글을 조회한다.")
    public void searchArticleTest() {
        // given
          Article article = Article.create(new ArticlePostRequest("Test Title", "Test Body"));
          article.addComment("Test Comment");
        articleRepository.save(article);

        // when
        ArticleResponse response = articleService.searchArticle(article.getArticleNo());

        // then
        assertThat(response).isNotNull();
        assertThat(response.getTitle()).isEqualTo(article.getTitle());
        assertThat(response.getBody()).isEqualTo(article.getBody());
        assertThat(response.getComments()).hasSize(1);
        assertThat(response.getComments().get(0).getBody()).isEqualTo("Test Comment");
    }

    @Test
    @DisplayName("게시글을 삭제한다.")
    public void deleteArticleTest() {
        // given
        Article article = Article.create(new ArticlePostRequest("Test Title", "Test Body"));
        articleRepository.save(article);
        ArticleDeleteRequest request = new ArticleDeleteRequest(article.getArticleNo());

        // when
        String result = articleService.deleteArticle(request);

        // then
        assertThat(result).isEqualTo("OK");
        assertThat(articleRepository.findById(article.getArticleNo())).isEmpty();
    }
}