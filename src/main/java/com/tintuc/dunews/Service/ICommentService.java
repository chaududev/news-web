package com.tintuc.dunews.Service;


import com.tintuc.dunews.Entity.Comment;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ICommentService {
    void AddComment(Comment comment);
    void UpdateComment(Comment Comment);
    void DeleteComment(Long id);
    List<Comment> GetAllComment();
    List<Comment> GetAllCommentArticle(Pageable pageable, String ArticleKey);



}
