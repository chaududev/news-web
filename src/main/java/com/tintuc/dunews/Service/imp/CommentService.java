package com.tintuc.dunews.Service.imp;
import com.tintuc.dunews.Entity.Comment;
import com.tintuc.dunews.Repository.ICommentRepository;
import com.tintuc.dunews.Service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    ICommentRepository repository;

    @Override
    public void AddComment(Comment comment) {
        try{
            repository.save(comment);
        }catch (Exception ex){
            throw ex;
        }
    }
    @Override
    public void UpdateComment(Comment Comment){
        try{
            repository
                    .findById(Comment.getId()) // returns Optional<User>
                    .ifPresent(Comment1 -> {
                        Comment1.setCreateDate(Comment.getCreateDate());
                        Comment1.setUpdateDate(Comment.getUpdateDate());
                        Comment1.setIdCreateUser(Comment.getIdCreateUser());
                        Comment1.setArticleKey(Comment.getArticleKey());
                        Comment1.setEmail(Comment.getEmail());
                        Comment1.setComment(Comment.getComment());
                        repository.save(Comment1);
                    });

        } catch (Exception ex){
            throw ex;
        }
    }
    @Override
    public void DeleteComment(Long id) {
        try{
            // repository.deleteById(id);
            boolean isExits =repository.findById(id).isPresent();
            if(isExits){
                repository.deleteById(id);
            }else {
                // throw new Exception("Comment not exits!!!");
            }
        }
        catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public List<Comment> GetAllComment() {
        List<Comment> Comments = repository.findAll();
        return Comments;
    }

    @Override
    public List<Comment> GetAllCommentArticle(Pageable pageable, String ArticleKey) {
        Page<Comment> pagingComment= repository.findByArticleKeyContaining(ArticleKey,pageable);
        List<Comment> Comments1= pagingComment.getContent();
        return Comments1;
    }
}

