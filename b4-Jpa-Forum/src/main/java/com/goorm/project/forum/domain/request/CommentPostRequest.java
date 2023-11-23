package com.goorm.project.forum.domain.request;

import lombok.Getter;

@Getter
public class CommentPostRequest {
    private Long articleNo;
    private String commentBody;
}
