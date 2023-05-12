package uz.nt.mediumclone.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import uz.nt.mediumclone.dto.ArticlesDto;
import uz.nt.mediumclone.model.Article;


@Mapper(componentModel = "spring")
public abstract class ArticleMapper implements CommonMapper<ArticlesDto, Article> {
    @Mapping(target = "likes", ignore = true)
    @Mapping(target = "tags", ignore = true)
    public abstract Article toEntity(ArticlesDto articlesDto);

//    @Mapping(target = "tags", expression = "java(article.getTags().stream().map(t->t.getName()).toList())")
//    @Mapping(target = "likes", expression = "java(article.getLikes().size())")
    public abstract ArticlesDto toDto(Article article);

}
