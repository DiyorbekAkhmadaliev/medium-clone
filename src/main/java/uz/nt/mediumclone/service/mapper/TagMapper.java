package uz.nt.mediumclone.service.mapper;

import org.mapstruct.Mapper;
import uz.nt.mediumclone.dto.TagDto;
import uz.nt.mediumclone.model.Tag;

@Mapper(componentModel = "spring")
public interface TagMapper extends CommonMapper<TagDto, Tag> {
}
