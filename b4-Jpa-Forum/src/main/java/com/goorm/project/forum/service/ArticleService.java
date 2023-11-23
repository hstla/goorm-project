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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    @Transactional
    public ArticleResponse writeArticle(ArticlePostRequest articleRequest) {
        Article article = Article.create(articleRequest);
        return ArticleResponse.from(articleRepository.save(article));
    }

    public List<ArticleListResponse> searchArticleList(int page, int pageSize) {
        return articleRepository.findAllByDeleteStatus(
                DeleteStatus.ACTIVE,
                PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "articleNo"))
            ).map(ArticleListResponse::from)
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
