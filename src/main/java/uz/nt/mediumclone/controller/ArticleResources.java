package uz.nt.mediumclone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.nt.mediumclone.dto.ArticlesDto;
import uz.nt.mediumclone.service.ArticleServices;

@RestController
@RequestMapping("article")
public class ArticleResources {

    @Autowired
    private ArticleServices articleServices;

    @PostMapping
    public ResponseEntity<?> addArticle(@RequestBody ArticlesDto articlesDto){
        System.out.println(articlesDto.getTitle());
        return articleServices.addArticle(articlesDto);
    }

}
