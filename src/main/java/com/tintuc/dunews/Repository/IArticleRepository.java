package com.tintuc.dunews.Repository;

import com.tintuc.dunews.Entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IArticleRepository extends JpaRepository<Article,Long> {
    @Query(value="select a from Article a where a.categoryKey=?1 order by a.id")
    Page<Article> findByCategoryKeyContaining(String categoryKey, Pageable pageable);
    @Query("select a from Article a where a.categoryKey like %?1%")
    List<Article> findAllByKey(String key);
    @Query("select a from Article a where a.articleKey =?1")
    List<Article> findByKey(String key);
    @Query(value="select a from Article a where a.articleKey like %?1% order by a.id")
    Page<Article> findByArticleKeyContaining(String articleKey, Pageable pageable);
    //List<Article> getArticleByCategoryKey(@PathVariable("categoryKey") String categoryKey);
    //
    //@Query(value = "SELECT * FROM Article WHERE categoryKey = ?1 ORDER BY ?#{#pageable}", countQuery = "SELECT count(*) FROM Article WHERE categoryKey= ?1",       nativeQuery = true)

}
