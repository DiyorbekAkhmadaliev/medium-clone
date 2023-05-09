package uz.nt.mediumclone.service.mapper;

import org.springframework.stereotype.Component;
import uz.nt.mediumclone.dto.UserDto;
import uz.nt.mediumclone.model.UserEntity;


@Component
public interface UserMapper extends CommonMapper<UserDto, UserEntity> {
}
