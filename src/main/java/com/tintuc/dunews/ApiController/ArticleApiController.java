package com.tintuc.dunews.ApiController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tintuc.dunews.Config.ContextPath;
import com.tintuc.dunews.Entity.Article;
import com.tintuc.dunews.Entity.Category;
import com.tintuc.dunews.Service.IArticleService;
import com.tintuc.dunews.Utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = {"/api/article"})
public class ArticleApiController {
    @Autowired
    final IArticleService service;
    public ArticleApiController(IArticleService service, FileUploadUtil uploadUtil) {
        this.service=service;
    }
    @GetMapping(value = {"/get"})
    public ResponseEntity<?> getArticlesCategorykey(@RequestParam(required=true,defaultValue="0") Integer page,@RequestParam(required=true,defaultValue="10") Integer pageSize,@RequestParam String key){
        Pageable pageable = PageRequest.of(page, pageSize);
        List<Article> Articles=service.GetAllArticleCategory(pageable,key);
        return ResponseEntity.ok(Articles);
    }
    @GetMapping(value = {"/getkey"})
    public ResponseEntity<?> getArticlesArticle(@RequestParam(required=true,defaultValue="0") Integer page,@RequestParam(required=true,defaultValue="10") Integer pageSize,@RequestParam String key){
        Pageable pageable = PageRequest.of(page, pageSize);
        List<Article> Articles=service.GetAllArticleArticle(pageable,key);
        return ResponseEntity.ok(Articles);
    }
    @GetMapping(value = {"/gets"})
    public ResponseEntity<?> getArticlesCategorykey(@RequestParam(required=true,defaultValue="0") Integer page,@RequestParam(required=true,defaultValue="10") Integer pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        List<Article> Articles=service.GetAllArticlePage(pageable);
        return ResponseEntity.ok(Articles);
    }
    @GetMapping
    public ResponseEntity<?> getArticles(){
        List<Article> Articles=service.GetAllArticle();
        return ResponseEntity.ok(Articles);
    }
    @PostMapping(value = {"/add"})
    public ResponseEntity<?>AddArticle(@RequestParam(value = "file", required = false) MultipartFile file, @RequestParam(value = "model",required = false) String model) throws IOException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();
        Article article = mapper.readValue(model, Article.class);

        FileUploadUtil  fileUploadUtil  =new FileUploadUtil();
        fileUploadUtil.saveFile(ContextPath.resourcePath+"articles",file.getOriginalFilename(),file);

        String pathFile = "/articles/"+file.getOriginalFilename();

        article.setUrlToImage(pathFile);

        Article articleResponse = service.AddArticle(article);
        return ResponseEntity.ok(articleResponse);
    }
    @PutMapping(value = {"/update"})
    public ResponseEntity<?>UpdateArticle(@RequestParam(value = "file", required = false) MultipartFile file, @RequestParam(value = "model",required = false) String model) throws IOException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();
        Article article = mapper.readValue(model, Article.class);

        FileUploadUtil  fileUploadUtil  =new FileUploadUtil();
        fileUploadUtil.saveFile(ContextPath.resourcePath+"articles",file.getOriginalFilename(),file);


        String pathFile = "/articles/"+file.getOriginalFilename();

        article.setUrlToImage(pathFile);

        service.UpdateArticle(article);
        return ResponseEntity.ok("Update Success!!!");
    }
    @DeleteMapping (value = {"/delete"})
    public ResponseEntity<?>DeleteArticle(@RequestParam Long id){
        service.DeleteArticle(id);
        return ResponseEntity.ok("Delete Success!!!");
    }
}

