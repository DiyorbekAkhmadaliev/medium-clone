package uz.nt.mediumclone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.nt.mediumclone.dto.ArticlesDto;
import uz.nt.mediumclone.service.ArticleServices;

@RestController
@RequestMapping("article")
@RequiredArgsConstructor
public class ArticleResources {

    private final ArticleServices articleServices;

    @PostMapping
    public ResponseEntity<ArticlesDto> addArticle(@RequestBody ArticlesDto articlesDto){
        return articleServices.addArticle(articlesDto);
    }

}
