package uz.nt.mediumclone.service;
import org.springframework.http.ResponseEntity;
import uz.nt.mediumclone.dto.UserDto;

public interface UserService {

    ResponseEntity<?> addUser(UserDto userDto);

    ResponseEntity<?> getUser(Integer id);

    ResponseEntity<?> updateUser(UserDto userDto);

    ResponseEntity<?> deleteUser(Integer id);

    ResponseEntity<?> followUser(Integer follower, Integer following);
}

