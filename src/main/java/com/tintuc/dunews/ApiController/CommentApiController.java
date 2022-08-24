package com.tintuc.dunews.ApiController;

import com.tintuc.dunews.Entity.Comment;
import com.tintuc.dunews.Service.ICommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController

@RequestMapping(value = {"/api/comment"})
public class CommentApiController {

    @Autowired
    ICommentService service;
    @GetMapping
    public ResponseEntity<?> getComments(){
        List<Comment> Comments=service.GetAllComment();
        return ResponseEntity.ok(Comments);
    }
    @GetMapping(value = {"/get"})
    public ResponseEntity<?> getCommentsArticlekey(@RequestParam(required=true,defaultValue="0") Integer page,@RequestParam(required=true,defaultValue="10") Integer pageSize,@RequestParam String key){
        Pageable pageable = PageRequest.of(page, pageSize);
        List<Comment> Comments=service.GetAllCommentArticle(pageable,key);
        return ResponseEntity.ok(Comments);
    }

    @PostMapping(value = {"/add"})
    public ResponseEntity<?>AddComment(@RequestBody Comment Comment){
        service.AddComment(Comment);
        return ResponseEntity.ok("Add Success!!!");
    }
    @PutMapping(value = {"/update"})
    public ResponseEntity<?>UpdateComment(@RequestBody Comment Comment){
        service.UpdateComment(Comment);
        return ResponseEntity.ok("Update Success!!!");
    }
    @DeleteMapping (value = {"/delete"})
    public ResponseEntity<?>DeleteComment(@RequestParam Long id){
        service.DeleteComment(id);
        return ResponseEntity.ok("Delete Success!!!");
    }
}

