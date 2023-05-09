package uz.nt.mediumclone.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.nt.mediumclone.controller.ArticleResources;
import uz.nt.mediumclone.dto.ArticlesDto;
import uz.nt.mediumclone.repository.ArticleRepository;
import uz.nt.mediumclone.service.ArticleServices;

@Service
@RequiredArgsConstructor
public class ArticleServicesImpl implements ArticleServices {

    private final ArticleRepository articleRepository;

    @Override
    public ResponseEntity<ArticlesDto> addArticle(ArticlesDto articlesDto) {
        articleRepository.findById(articlesDto.getId());
        return null;
    }

    @Override
    public ResponseEntity<ArticlesDto> deleteArticleById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<ArticlesDto> getArticleById(Integer id) {

        return null;
    }

    @Override
    public ResponseEntity<ArticlesDto> getAllArticles() {
        return null;
    }

    @Override
    public ResponseEntity<ArticlesDto> editArticle(ArticlesDto articlesDto) {
        return null;
    }
}
