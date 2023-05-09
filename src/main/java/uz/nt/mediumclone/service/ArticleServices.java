package uz.nt.mediumclone.service;

import org.springframework.http.ResponseEntity;
import uz.nt.mediumclone.dto.ArticlesDto;

public interface ArticleServices {

    ResponseEntity<ArticlesDto> addArticle(ArticlesDto articlesDto);
    ResponseEntity<ArticlesDto> deleteArticleById(Integer id);
    ResponseEntity<ArticlesDto> getArticleById(Integer id);
    ResponseEntity<ArticlesDto> getAllArticles();
    ResponseEntity<ArticlesDto> editArticle(ArticlesDto articlesDto);
}
