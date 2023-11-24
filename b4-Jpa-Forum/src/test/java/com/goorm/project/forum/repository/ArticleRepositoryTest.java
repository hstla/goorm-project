package com.goorm.project.forum.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.goorm.project.forum.BasicTestConfig;
import com.goorm.project.forum.domain.DeleteStatus;
import com.goorm.project.forum.domain.Entity.Article;
import com.goorm.project.forum.domain.request.ArticlePostRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

class ArticleRepositoryTest extends BasicTestConfig {
    @Autowired
    private ArticleRepository articleRepository;

    @DisplayName("cursor 기반 페이징으로 게시글을 조회한다.")
    @Test
    public void testFindTopByDeleteStatusAndArticleNoLessThanOrderByArticleNoDesc() {
        // Given
        Article article1 = Article.create(new ArticlePostRequest("Title1", "Body1"));
        Article article2 = Article.create(new ArticlePostRequest("Title2", "Body2"));
        Article article3 = Article.create(new ArticlePostRequest("Title3", "Body3"));
        articleRepository.save(article1);
        articleRepository.save(article2);
        articleRepository.save(article3);

        // When
        Page<Article> articles = articleRepository.findArticlesAfterLastArticleNo(
            DeleteStatus.ACTIVE, 0L, Pageable.ofSize(2));

        // Then
        assertThat(articles).hasSize(2);
    }

    @DisplayName("게시글 번호로 게시글과 댓글을 함께 조회한다")
    @Test
    void findArticleWithCommentsByArticleNo() {
        // given
        Article article1 = Article.create(new ArticlePostRequest("Title1", "Body1"));
        Article article = articleRepository.save(article1);
        Long findNo = article.getArticleNo();

        // when
        Article findArticle = articleRepository.findArticleWithCommentsByArticleNo(findNo).get();

        // then
        assertThat(findArticle.getArticleNo()).isEqualTo(findNo);
    }
}