package com.goorm.project.forum.service;

import com.goorm.project.forum.domain.DeleteStatus;
import com.goorm.project.forum.domain.Entity.Article;
import com.goorm.project.forum.domain.request.ArticleDeleteRequest;
import com.goorm.project.forum.domain.request.ArticlePostRequest;
import com.goorm.project.forum.domain.response.ArticleListResponse;
import com.goorm.project.forum.domain.response.ArticleResponse;
import com.goorm.project.forum.repository.ArticleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ArticleService {

    private final ArticleRepository articleRepository;
    @Transactional
    public ArticleResponse writeArticle(ArticlePostRequest articleRequest) {
        Article article = Article.create(articleRequest);
        return ArticleResponse.from(articleRepository.save(article));
    }

    public List<ArticleListResponse> searchArticleList(int pageSize, Long lastArticleNo) {
        Page<Article> articles = articleRepository.findArticlesAfterLastArticleNo(
            DeleteStatus.ACTIVE, lastArticleNo, Pageable.ofSize(pageSize));
        log.info("서비스단");
        return articles.stream()
            .map(ArticleListResponse::from)
            .toList();
    }


    public ArticleResponse searchArticle(Long articleNo) {
        return articleRepository.findArticleWithCommentsByArticleNo(articleNo)
            .map(ArticleResponse::from)
            .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다"));
    }

    @Transactional
    public String deleteArticle(ArticleDeleteRequest articleDeleteRequest) {
        Article article = articleRepository.findById(articleDeleteRequest.getArticleNo())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다"));

        articleRepository.delete(article);
        return "OK";
    }
}
