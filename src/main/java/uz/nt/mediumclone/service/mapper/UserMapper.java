package uz.nt.mediumclone.service.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.nt.mediumclone.dto.UserDto;
import uz.nt.mediumclone.model.UserEntity;


@Mapper(componentModel = "spring")
public interface UserMapper extends CommonMapper<UserDto, UserEntity> {
}
