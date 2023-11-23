package com.goorm.project.forum.controller;

import com.goorm.project.forum.domain.request.CommentDeleteRequest;
import com.goorm.project.forum.domain.request.CommentPostRequest;
import com.goorm.project.forum.domain.response.ArticleResponse;
import com.goorm.project.forum.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    // 댓글 등록
    @PostMapping("/comment")
    public ArticleResponse writeComment(
        @RequestBody CommentPostRequest commentPostRequest
    ) {
        return commentService.writeComment(commentPostRequest);
    }

    @DeleteMapping("/comment")
    public String deleteComment(
        @RequestBody CommentDeleteRequest commentPostRequest
    ) {
        return commentService.deleteComment(commentPostRequest);
    }
}