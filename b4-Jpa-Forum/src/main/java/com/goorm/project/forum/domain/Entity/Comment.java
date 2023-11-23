package com.goorm.project.forum.domain.Entity;

import com.goorm.project.forum.domain.DeleteStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE comment SET DELETE_STATUS = 'DELETE' WHERE comment_no = ?")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @Column(length = 1000)
    private String body;

    @Enumerated(EnumType.STRING)
    private DeleteStatus deleteStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTICLE_NO")
    private Article article;

    public Comment(String body, DeleteStatus deleteStatus, Article article) {
        this.body = body;
        this.deleteStatus = deleteStatus;
        this.article = article;
    }

    public static Comment create(String body, Article article) {
        return new Comment(body, DeleteStatus.ACTIVE, article);
    }
}
