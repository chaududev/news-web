package com.tintuc.dunews.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Article")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article extends AbstractEntity {
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private String title;
    @Lob
    private String description;
    @Column
    private String url;
    @Column
    private String urlToImage;
    @Column(name="publishedAt")
    private Date publishedAt;
    @Lob
    private String content;
    @Column(name="categoryKey")
    private String categoryKey;
    @Column(name="articleKey")
    private String articleKey;
}
