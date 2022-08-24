package com.tintuc.dunews.Repository;

import com.tintuc.dunews.Entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICommentRepository extends JpaRepository<Comment,Long> {
    @Query(value="select a from Comment a where a.articleKey=?1 order by a.id")
    Page<Comment> findByArticleKeyContaining(String articleKey, Pageable pageable);
}
