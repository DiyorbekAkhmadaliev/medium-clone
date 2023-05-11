package uz.nt.mediumclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.nt.mediumclone.dto.ArticlesDto;
import uz.nt.mediumclone.service.ArticleServices;

@RestController
@RequestMapping("article")
public class ArticleResources {

    @Autowired
    private ArticleServices articleServices;

    @PostMapping
    public ResponseEntity<?> addArticle(@RequestBody ArticlesDto articlesDto) {
        return articleServices.addArticle(articlesDto);
    }

    @PatchMapping
    public ResponseEntity<?> editArticle(@RequestBody ArticlesDto articlesDto){
        return articleServices.editArticle(articlesDto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteArticleById(@PathVariable Integer id) {
        return articleServices.deleteArticleById(id);
    }

    @GetMapping("by-id/{id}")
    public ResponseEntity<?> getArticleById(@PathVariable Integer id) {
        return articleServices.getArticleById(id);
    }

    @GetMapping
    public ResponseEntity<?> getAllArticles() {
        return articleServices.getAllArticles();
    }

    @PostMapping("/{articleId}/like")
    public ResponseEntity<?> addLikes(@PathVariable Integer articleId){
        return articleServices.addLike(articleId);
    }

    @DeleteMapping("/{articleId}/like")
    public ResponseEntity<?> deleteLikes(@PathVariable Integer articleId){
        return articleServices.deleteLike(articleId);
    }
}
