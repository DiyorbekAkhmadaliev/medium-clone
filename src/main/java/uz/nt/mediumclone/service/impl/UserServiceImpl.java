package uz.nt.mediumclone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.nt.mediumclone.dto.UserDto;
import uz.nt.mediumclone.model.UserEntity;
import uz.nt.mediumclone.repository.UserRepository;
import uz.nt.mediumclone.service.UserService;
import uz.nt.mediumclone.service.mapper.UserMapper;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
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

    public ResponseEntity<?> updateUser(UserDto userDto){
        if(userDto.getId() == null)
            return ResponseEntity.status(404).body("User id not found");
        else{
            UserEntity userEntity = new UserEntity();
            userEntity.setId(userDto.getId());
            if(userDto.getUsername() != null) userEntity.setUsername(userDto.getUsername());
            if(userDto.getPassword() != null) userEntity.setPassword(userDto.getPassword());
            if(userDto.getEmail() != null) userEntity.setEmail(userDto.getEmail());
            if(userDto.getBio() != null) userEntity.setBio(userDto.getBio());
            try{
                return ResponseEntity.ok(userRepository.save(userEntity));
            }catch (Exception e){
                return ResponseEntity.status(400).body(e.getMessage());
            }
        }
    }

    public ResponseEntity<?> deleteUser(Integer id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return ResponseEntity.ok().body("User id deleted");
        }
        return ResponseEntity.status(404).body("User is not found");
    }


}
