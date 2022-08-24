package com.tintuc.dunews.Service;

import com.tintuc.dunews.Entity.Article;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IArticleService {
    Article AddArticle(Article Article);
    void UpdateArticle(Article Article);
    void DeleteArticle(Long id);
    List<Article> GetArticleByKey(String key);
    List<Article> GetAllArticleCategory(Pageable pageable, String CategoryKey);
    List<Article> GetAllArticle();
    List<Article> GetAllArticleArticle(Pageable pageable, String ArticleKey);
    List<Article> GetAllArticlePage(Pageable pageable);

}

