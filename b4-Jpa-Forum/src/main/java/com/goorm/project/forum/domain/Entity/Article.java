package com.goorm.project.forum.domain.Entity;

import com.goorm.project.forum.domain.DeleteStatus;
import com.goorm.project.forum.domain.request.ArticlePostRequest;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE article SET DELETE_STATUS = 'DELETE' WHERE article_no = ?")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleNo;
    private String title;

    @Column(length = 1000)
    private String body;

    @Enumerated(EnumType.STRING)
    private DeleteStatus deleteStatus;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @Where(clause = "DELETE_STATUS = 'ACTIVE'")
    private List<Comment> comments = new ArrayList<>();

    public Article(String title, String body, DeleteStatus deleteStatus) {
        this.title = title;
        this.body = body;
        this.deleteStatus = deleteStatus;
    }

    public static Article create(ArticlePostRequest articleRequest) {
        return new Article(articleRequest.getTitle(), articleRequest.getBody(), DeleteStatus.ACTIVE);
    }

    public Article addComment(String commentBody) {
        Comment comment =  Comment.create(commentBody, this);
        this.getComments().add(comment);
        return this;
    }
}
