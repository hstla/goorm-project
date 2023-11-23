package com.goorm.project.forum.repository;

import com.goorm.project.forum.domain.DeleteStatus;
import com.goorm.project.forum.domain.Entity.Article;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Page<Article> findAllByDeleteStatus(DeleteStatus deleteStatus, PageRequest articleNo);

    @Query("SELECT a FROM Article a LEFT JOIN FETCH a.comments c WHERE a.articleNo = :articleNo")
    Optional<Article> findArticleWithCommentsByArticleNo(@Param("articleNo") Long articleNo);
}
