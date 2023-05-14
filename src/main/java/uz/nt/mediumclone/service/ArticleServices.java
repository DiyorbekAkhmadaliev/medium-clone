package uz.nt.mediumclone.service;

import org.springframework.http.ResponseEntity;
import uz.nt.mediumclone.dto.ArticlesDto;
import uz.nt.mediumclone.exeption.NotAllowedException;

import java.util.List;

public interface ArticleServices {

    ResponseEntity<ArticlesDto> addArticle(ArticlesDto articlesDto);
    ResponseEntity<Void> deleteArticleById(Integer id);
    ResponseEntity<ArticlesDto> getArticleById(Integer id);
    ResponseEntity<List<ArticlesDto>> getAllArticles();
    ResponseEntity<ArticlesDto> editArticle(ArticlesDto articlesDto) throws NotAllowedException;
    ResponseEntity<ArticlesDto> addLike(Integer articleId);
    ResponseEntity<ArticlesDto> deleteLike(Integer articleId);
}
