package com.tintuc.dunews.Service.imp;
import com.tintuc.dunews.Entity.Article;
import com.tintuc.dunews.Repository.IArticleRepository;
import com.tintuc.dunews.Service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    IArticleRepository repository;

    @Override
    public Article AddArticle(Article Article) {
        try{
            repository.save(Article);
        }catch (Exception ex){
            throw ex;
        }
        return Article;
    }
    @Override
    public void UpdateArticle(Article Article){
        try{
            repository
                    .findById(Article.getId()) // returns Optional<User>
                    .ifPresent(Article1 -> {
                        Article1.setCreateDate(Article.getCreateDate());
                        Article1.setUpdateDate(Article.getUpdateDate());
                        Article1.setIdCreateUser(Article.getIdCreateUser());
                        Article1.setName(Article.getName());
                        Article1.setArticleKey(Article.getArticleKey());
                        Article1.setAuthor(Article.getAuthor());
                        Article1.setTitle(Article.getTitle());
                        Article1.setDescription(Article.getDescription());
                        Article1.setUrl(Article.getUrl());
                        Article1.setUrlToImage(Article.getUrlToImage());
                        Article1.setPublishedAt(Article.getPublishedAt());
                        Article1.setContent(Article.getContent());
                        Article1.setCategoryKey(Article.getCategoryKey());
                        repository.save(Article1);
                    });

        } catch (Exception ex){
            throw ex;
        }
    }
    @Override
    public void DeleteArticle(Long id) {
        try{
            // repository.deleteById(id);
            boolean isExits =repository.findById(id).isPresent();
            if(isExits){
                repository.deleteById(id);
            }else {
                // throw new Exception("Article not exits!!!");
            }
        }
        catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public List<Article> GetArticleByKey(String key) {
        List<Article> Articles = repository.findByKey(key);
        return Articles;
    }


    @Override
    public List<Article> GetAllArticleCategory(Pageable pageable,String CategoryKey) {
        Page<Article> pagingArticle= repository.findByCategoryKeyContaining(CategoryKey,pageable);
        List<Article> Articles1= pagingArticle.getContent();
        return Articles1;
    }

    @Override
    public List<Article> GetAllArticle() {
        List<Article> Articles = repository.findAll();
        return Articles;
    }

    @Override
    public List<Article> GetAllArticleArticle(Pageable pageable, String ArticleKey) {
        Page<Article> pagingArticle= repository.findByArticleKeyContaining(ArticleKey,pageable);
        List<Article> Articles1= pagingArticle.getContent();
        return Articles1;
    }


    @Override
    public List<Article> GetAllArticlePage(Pageable pageable) {
        Page<Article> pagingArticle= repository.findAll(pageable);
        List<Article> Articles1= pagingArticle.getContent();
        return Articles1;
    }


}

