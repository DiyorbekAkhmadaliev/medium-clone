package uz.nt.mediumclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.nt.mediumclone.dto.UserDto;
import uz.nt.mediumclone.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<UserDto> addUser(UserDto userDto){
//        userRepository.save()
        return null;
    }
}
