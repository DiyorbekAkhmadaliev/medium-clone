package uz.nt.mediumclone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.nt.mediumclone.dto.UserDto;
import uz.nt.mediumclone.model.UserEntity;
import uz.nt.mediumclone.repository.UserRepository;
import uz.nt.mediumclone.service.mapper.UserMapper;

import java.util.Optional;

@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


    public ResponseEntity<?> addUser(UserDto userDto){
        try{
            return ResponseEntity.status(201).body(userMapper.toDto(userRepository.save(userMapper.toEntity(userDto))));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity<?> getUser(Integer id){
        Optional<UserEntity> userEntity = userRepository.findFirstById(id);
        if(userEntity.isPresent()) return ResponseEntity.ok(userMapper.toDto(userEntity.get()));
        return ResponseEntity.status(400).body("User is not found");
    }

//    public ResponseEntity<?> patchUser(UserDto userDto){
//
//    }


}
