package uz.nt.mediumclone.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import uz.nt.mediumclone.dto.ArticlesDto;
import uz.nt.mediumclone.model.Article;

@Mapper(componentModel = "spring")
public abstract class ArticleMapper implements CommonMapper<ArticlesDto, Article> {

    @Autowired
    protected TagMapper tagMapper;

    @Mapping(target = "tags", expression = "java(articlesDto.getTags().stream().map(m-> tagMapper.toEntity(m)).toList())")
    public abstract Article toEntity(ArticlesDto articlesDto);
}
