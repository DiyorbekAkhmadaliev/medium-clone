package uz.nt.mediumclone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.nt.mediumclone.dto.FollowDto;
import uz.nt.mediumclone.dto.UserDto;
import uz.nt.mediumclone.model.Follows;
import uz.nt.mediumclone.model.User;
import uz.nt.mediumclone.repository.FollowsRepository;
import uz.nt.mediumclone.repository.UserRepository;
import uz.nt.mediumclone.service.UserService;
import uz.nt.mediumclone.service.mapper.FollowMapper;
import uz.nt.mediumclone.service.mapper.UserMapper;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private FollowsRepository followsRepository;


    public ResponseEntity<UserDto> addUser(UserDto userDto){
            return new ResponseEntity<>(userMapper.toDto(userRepository.save(userMapper.toEntity(userDto))), HttpStatus.CREATED);
    }

    public ResponseEntity<UserDto> getUser(Integer id){
        Optional<User> userEntity = userRepository.findFirstById(id);
        return new ResponseEntity<>(userEntity.map((m)-> userMapper.toDto(m)).orElseThrow(),HttpStatus.OK);
    }

    public ResponseEntity<UserDto> updateUser(UserDto userDto){
            User userEntity = new User();
            userEntity.setId(userDto.getId());
            if(userDto.getUsername() != null) userEntity.setUsername(userDto.getUsername());
            if(userDto.getPassword() != null) userEntity.setPassword(userDto.getPassword());
            if(userDto.getEmail() != null) userEntity.setEmail(userDto.getEmail());
            if(userDto.getBio() != null) userEntity.setBio(userDto.getBio());
            return new ResponseEntity<>(userMapper.toDto(userRepository.save(userEntity)),HttpStatus.OK);
    }



    @Override
    public ResponseEntity<FollowDto> followUser(Integer follower, Integer following) {
        User followerEntity = User.builder().id(follower).build();
        User followingEntity = User.builder().id(following).build();


            return new ResponseEntity<>(followMapper.toDto(followsRepository.save(Follows.builder()
                    .follower(followerEntity)
                    .following(followingEntity)
                    .build())),HttpStatus.OK);

    }




}
