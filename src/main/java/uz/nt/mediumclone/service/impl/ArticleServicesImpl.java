package uz.nt.mediumclone.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.nt.mediumclone.controller.ArticleResources;
import uz.nt.mediumclone.dto.ArticlesDto;
import uz.nt.mediumclone.dto.TagDto;
import uz.nt.mediumclone.model.Article;
import uz.nt.mediumclone.repository.ArticleRepository;
import uz.nt.mediumclone.service.ArticleServices;
import uz.nt.mediumclone.service.mapper.ArticleMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServicesImpl implements ArticleServices {
    @Autowired
    private  ArticleRepository articleRepository;

    @Autowired
    private  ArticleMapper articleMapper;

    @Override
    public ResponseEntity<?> addArticle(ArticlesDto articlesDto) {
//        Optional<Article> optional = articleRepository.findById(articlesDto.getId());
//
//        if (optional.isPresent()){
//            return ResponseEntity
//                    .ok()
//                    .body("Article already exists!");
//        }

        try {
            return ResponseEntity
                    .ok()
                    .body(articleMapper.toDto(articleRepository.save(articleMapper.toEntity(articlesDto))));
        } catch (Exception e) {
            return ResponseEntity
                    .status(500).body(null);
        }
    }

    @Override
    public ResponseEntity<?> deleteArticleById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> getArticleById(Integer id) {

        return null;
    }

    @Override
    public ResponseEntity<?> getAllArticles() {
        return null;
    }

    @Override
    public ResponseEntity<?> editArticle(ArticlesDto articlesDto) {
        return null;
    }
}
