package com.goorm.project.forum.domain.response;

import com.goorm.project.forum.domain.Entity.Article;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleListResponse {
    private Long articleNo;
    private String title;

    // 정적 팩토리 메서드
    public static ArticleListResponse from(Article article) {
        return new ArticleListResponse(
            article.getArticleNo(),
            article.getTitle()
        );
    }
}
