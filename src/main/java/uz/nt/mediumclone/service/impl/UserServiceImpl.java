package uz.nt.mediumclone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.nt.mediumclone.dto.UserDto;
import uz.nt.mediumclone.model.Follows;
import uz.nt.mediumclone.model.User;
import uz.nt.mediumclone.repository.FollowsRepository;
import uz.nt.mediumclone.repository.UserRepository;
import uz.nt.mediumclone.service.UserService;
import uz.nt.mediumclone.service.mapper.UserMapper;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FollowsRepository followsRepository;


    public ResponseEntity<?> addUser(UserDto userDto){
        try{
            return ResponseEntity.status(201).body(userMapper.toDto(userRepository.save(userMapper.toEntity(userDto))));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity<?> getUser(Integer id){
        Optional<User> userEntity = userRepository.findFirstById(id);
        if(userEntity.isPresent()) return ResponseEntity.ok(userMapper.toDto(userEntity.get()));
        return ResponseEntity.status(400).body("User is not found");
    }

    public ResponseEntity<?> updateUser(UserDto userDto){
        if(userDto.getId() == null)
            return ResponseEntity.status(404).body("User id not found");
        else{
            User userEntity = new User();
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



    @Override
    public ResponseEntity<?> followUser(Integer follower, Integer following) {
        User followerEntity = User.builder().id(follower).build();
        User followingEntity = User.builder().id(following).build();

        try {
            return ResponseEntity.ok().body(followsRepository.save(Follows.builder()
                    .follower(followerEntity)
                    .following(followingEntity)
                    .build()));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }


}
