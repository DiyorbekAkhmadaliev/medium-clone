package uz.nt.mediumclone.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.nt.mediumclone.dto.FollowDto;
import uz.nt.mediumclone.dto.UserDto;
import uz.nt.mediumclone.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;




    @PostMapping("/sign-up")
    private ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto){

        return userService.addUser(userDto);
    }

    @GetMapping({"/get-user/{id}"}) ResponseEntity<UserDto> getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }
    @PatchMapping ResponseEntity<?> updateUser(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }


    @PostMapping("follow/{follower}/{following}")
    public ResponseEntity<FollowDto> followUser(@PathVariable Integer follower, @PathVariable Integer following){
        return userService.followUser(follower, following);
    }



}
