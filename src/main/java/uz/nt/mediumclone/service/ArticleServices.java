package uz.nt.mediumclone.service;

import org.springframework.http.ResponseEntity;
import uz.nt.mediumclone.dto.ArticlesDto;

public interface ArticleServices {

    ResponseEntity<?> addArticle(ArticlesDto articlesDto);
    ResponseEntity<?> deleteArticleById(Integer id);
    ResponseEntity<?> getArticleById(Integer id);
    ResponseEntity<?> getAllArticles();
    ResponseEntity<?> editArticle(ArticlesDto articlesDto);

    ResponseEntity<?> addLike(Integer articleId);

    ResponseEntity<?> deleteLike(Integer articleId);
}
