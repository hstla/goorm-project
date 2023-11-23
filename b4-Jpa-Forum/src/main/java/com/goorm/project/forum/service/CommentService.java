package com.goorm.project.forum.service;

import com.goorm.project.forum.domain.Entity.Article;
import com.goorm.project.forum.domain.Entity.Comment;
import com.goorm.project.forum.domain.request.CommentDeleteRequest;
import com.goorm.project.forum.domain.request.CommentPostRequest;
import com.goorm.project.forum.domain.response.ArticleResponse;
import com.goorm.project.forum.repository.ArticleRepository;
import com.goorm.project.forum.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    @Transactional
    public ArticleResponse writeComment(CommentPostRequest request) {
        Article article = articleRepository.findArticleWithCommentsByArticleNo(request.getArticleNo())
            .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다"));

        article.addComment(request.getCommentBody());
        articleRepository.save(article);
        return ArticleResponse.from(article);
    }

    @Transactional
    public String deleteComment(CommentDeleteRequest request) {
        Comment findComment = commentRepository.findById(request.getCommentNo())
            .orElseThrow(() -> new RuntimeException("존재하지 않는 댓글입니다"));

        commentRepository.delete(findComment);
        return "OK";
    }
}
