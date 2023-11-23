package com.goorm.project.forum.domain.response;

import com.goorm.project.forum.domain.DeleteStatus;
import com.goorm.project.forum.domain.Entity.Article;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleResponse {
    private Long articledNo;
    private String title;
    private String body;
    private DeleteStatus deleteStatus;
    private List<CommentResponse> comments;

    // 정적 팩토리 메서드
    public static ArticleResponse from(Article article) {
        return new ArticleResponse(
            article.getArticleNo(),
            article.getTitle(),
            article.getBody(),
            article.getDeleteStatus(),
            article.getComments().stream().map(CommentResponse::from).collect(Collectors.toList())
        );
    }
}
