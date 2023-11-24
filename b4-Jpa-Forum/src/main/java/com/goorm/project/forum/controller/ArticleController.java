package com.goorm.project.forum.controller;

import com.goorm.project.forum.domain.request.ArticleDeleteRequest;
import com.goorm.project.forum.domain.request.ArticlePostRequest;
import com.goorm.project.forum.domain.response.ArticleListResponse;
import com.goorm.project.forum.domain.response.ArticleResponse;
import com.goorm.project.forum.service.ArticleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ArticleController {

    private final ArticleService articleService;

    // 게시글 등록
    @PostMapping("article")
    public ArticleResponse writeArticle(
        @RequestBody ArticlePostRequest articlePostRequest
    ) {
        return articleService.writeArticle(articlePostRequest);
    }

    // 게시글 목록 조회(커서 페이징)
    @GetMapping("articles")
    public List<ArticleListResponse> searchArticleList(
        @RequestParam("pageSize") int pageSize,
        @RequestParam("lastArticleNo") Long lastArticleNo
    ) {
        return articleService.searchArticleList(pageSize, lastArticleNo);
    }

    // 게시글 단건 조회 (게시글 + 댓글)
    @GetMapping("article")
    public ArticleResponse searchArticle(
        @RequestParam("articleNo") Long articleNo
    ){
        return articleService.searchArticle(articleNo);
    }

    // 게시글 삭제
    @DeleteMapping("article")
    public String deleteArticle(
        @RequestBody ArticleDeleteRequest articleDeleteRequest
    ) {
        return articleService.deleteArticle(articleDeleteRequest);
    }

}
