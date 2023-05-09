package uz.nt.mediumclone.service.mapper;

import org.mapstruct.Mapper;
import uz.nt.mediumclone.dto.ArticlesDto;
import uz.nt.mediumclone.model.Article;

@Mapper(componentModel = "spring")
public interface ArticleMapper extends CommonMapper<ArticlesDto, Article> {
}
