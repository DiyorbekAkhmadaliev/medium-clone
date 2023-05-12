package uz.nt.mediumclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.nt.mediumclone.dto.ArticlesDto;
import uz.nt.mediumclone.dto.CommentsDto;
import uz.nt.mediumclone.service.ArticleServices;
import uz.nt.mediumclone.service.CommentsServices;

@RestController
@RequestMapping("articles")
public class ArticleResources {

    @Autowired
    private ArticleServices articleServices;

    @Autowired
    private CommentsServices commentsServices;

    @PostMapping
    public ResponseEntity<ArticlesDto> addArticle(@RequestBody ArticlesDto articlesDto) {
        return articleServices.addArticle(articlesDto);
    }

    @PatchMapping
    public ResponseEntity<ArticlesDto> editArticle(@RequestBody ArticlesDto articlesDto){
        return articleServices.editArticle(articlesDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticleById(@PathVariable Integer id) {
        return articleServices.deleteArticleById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getArticleById(@PathVariable Integer id) {
        return articleServices.getArticleById(id);
    }

    @GetMapping
    public ResponseEntity<?> getAllArticles() {
        return articleServices.getAllArticles();
    }

    @PostMapping("/{article_id}/comment")
    public ResponseEntity<CommentsDto> addComment(@PathVariable Integer article_id, @RequestBody CommentsDto commentsDto){
        return commentsServices.addComment(commentsDto);
    }

    @GetMapping("/{article_id}/{comment_id}")
    public ResponseEntity<?> getCommentByArticleId(@PathVariable Integer id){
        return commentsServices.getCommentsByArticleId(id);
    }
}
