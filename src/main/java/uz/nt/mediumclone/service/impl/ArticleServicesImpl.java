package uz.nt.mediumclone.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.nt.mediumclone.dto.ArticlesDto;
import uz.nt.mediumclone.exeption.DatabaseException;
import uz.nt.mediumclone.model.Article;
import uz.nt.mediumclone.model.Tag;
import uz.nt.mediumclone.repository.ArticleRepository;
import uz.nt.mediumclone.repository.TagsRepository;
import uz.nt.mediumclone.service.ArticleServices;
import uz.nt.mediumclone.service.mapper.ArticleMapper;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ArticleServicesImpl implements ArticleServices {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleMapper articleMapper;

    private final TagsRepository tagsRepository;

    @Override
    public ResponseEntity<ArticlesDto> addArticle(ArticlesDto articlesDto) {
        List<Tag> tagList = identifyNewTagsAndSaveThem(articlesDto.getTags());
        Article article = articleMapper.toEntity(articlesDto);
        article.setTags(tagList);
        try {
            return ResponseEntity
                    .ok()
                    .body(
                            articleMapper.toDto(
                                    articleRepository.save(article)));
        } catch (Exception e) {
            throw new DatabaseException("Error while saving article to database: " + e.getMessage());
        }

    }

    private List<Tag> identifyNewTagsAndSaveThem(List<String> listOfTags) {


        List<String> existingTags = StreamSupport.stream(tagsRepository.findAll().spliterator(), false)
                .map(Tag::getName)
                .toList();


        List<Tag> tags = new ArrayList<>( existingTags.stream().map(tag -> Tag.builder().name(tag).build()).toList());

        listOfTags.stream()
                .filter(tag -> !existingTags.contains(tag))
                .map(tag -> Tag.builder().name(tag).build())
                .forEach(tag -> {
                    try {
                        tags.add(tag);
                        tagsRepository.save(tag);
                    } catch (Exception e) {
                        throw new DatabaseException("Error while saving new tags: " + e.getMessage());
                    }
                });
        return tags;
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
        if (articlesDto.getId() == null) {
            return ResponseEntity.ofNullable(articlesDto);
        }

        Optional<Article> articleOptional = articleRepository.findById(articlesDto.getId());

        if (articleOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Article article = articleOptional.get();

        if (articlesDto.getTitle() != null) {
            article.setTitle(articlesDto.getTitle());
        }
        if (articlesDto.getAbout() != null) {
            article.setAbout(articlesDto.getAbout());
        }
        if (articlesDto.getBody() != null) {
            article.setBody(articlesDto.getBody());
        }
//        if (articlesDto.getTags()!=null){
//            List<Tag> list = new ArrayList<>();
//            articlesDto.getTags().stream().map(s -> list.add(new Tag(s)))
//            article.setTags();
//        }
        if (articlesDto.getUpdatedAt() != null) {
            article.setUpdatedAt(LocalDateTime.now());
        }
        articleRepository.save(article);
        return ResponseEntity.accepted().body(articleMapper.toDto(article));
    }
}
