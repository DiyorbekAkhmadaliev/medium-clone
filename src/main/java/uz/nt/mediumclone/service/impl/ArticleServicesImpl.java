package uz.nt.mediumclone.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.nt.mediumclone.dto.ArticlesDto;
import uz.nt.mediumclone.model.Article;
import uz.nt.mediumclone.repository.ArticleRepository;
import uz.nt.mediumclone.service.ArticleServices;
import uz.nt.mediumclone.service.mapper.ArticleMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServicesImpl implements ArticleServices {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ResponseEntity<?> addArticle(ArticlesDto articlesDto) {
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
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Article> articleOptional = articleRepository.findById(id);

        if (articleOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        articleRepository.deleteById(id);

        return ResponseEntity.status(200).build();
    }

    @Override
    public ResponseEntity<?> getArticleById(Integer id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Article> articleOptional = articleRepository.findById(id);

        if (articleOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(200).body(articleMapper.toDto(articleOptional.get()));
    }

    @Override
    public ResponseEntity<?> getAllArticles() {
        List<Article> articleOptional = articleRepository.findAll();
        return ResponseEntity.status(200).body(articleOptional.stream().map(articleMapper::toDto).toList());
    }

    @Override
    public ResponseEntity<?> editArticle(ArticlesDto articlesDto) {
        if (articlesDto.getId() == null){
            return ResponseEntity.ofNullable(articlesDto);
        }

        Optional<Article> articleOptional = articleRepository.findById(articlesDto.getId());

        if (articleOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Article article = articleOptional.get();

        if (articlesDto.getTitle()!=null){
            article.setTitle(articlesDto.getTitle());
        }
        if (articlesDto.getAbout()!=null){
            article.setAbout(articlesDto.getAbout());
        }
        if (articlesDto.getBody()!=null){
            article.setBody(articlesDto.getBody());
        }
        if (articlesDto.getTags()!=null){
            article.setTags(articlesDto.getTags());
        }
        if (articlesDto.getUpdatedAt()!=null){
            article.setUpdatedAt(LocalDateTime.now());
        }
        articleRepository.save(article);
        return ResponseEntity.accepted().body(articleMapper.toDto(article));
    }
}
