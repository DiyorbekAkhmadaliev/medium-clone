package uz.nt.mediumclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.nt.mediumclone.dto.ArticlesDto;
import uz.nt.mediumclone.dto.CommentsDto;
import uz.nt.mediumclone.exeption.NotAllowedException;
import uz.nt.mediumclone.service.ArticleServices;
import uz.nt.mediumclone.service.CommentsServices;

@RestController
@RequestMapping("articles")
public class ArticleResources {

    @Autowired
    private ArticleServices articleServices;


    @PostMapping
    public ResponseEntity<ArticlesDto> addArticle(@RequestBody ArticlesDto articlesDto) {
        return articleServices.addArticle(articlesDto);
    }

    @PatchMapping
    public ResponseEntity<ArticlesDto> editArticle(@RequestBody ArticlesDto articlesDto) throws NotAllowedException {
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

    @PostMapping("/{articleId}/like")
    public ResponseEntity<?> addLike(@PathVariable Integer articleId) {
        return articleServices.addLike(articleId);
    }

    @DeleteMapping("/{articleId}/like")
    public ResponseEntity<?> deleteLike(@PathVariable Integer articleId) {
        return articleServices.deleteLike(articleId);
    }
}
