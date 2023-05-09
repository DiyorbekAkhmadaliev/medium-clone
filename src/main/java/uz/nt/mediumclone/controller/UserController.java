package uz.nt.mediumclone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.nt.mediumclone.dto.UserDto;

@RestController
@RequestMapping("/user")
public class UserController {


    @PostMapping("/add-user")
    private ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
//        return ;
    }


}
