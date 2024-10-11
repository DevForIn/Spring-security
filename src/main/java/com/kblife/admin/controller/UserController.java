package com.kblife.admin.controller;

import com.kblife.admin.controller.dto.UserJoinInfoDto;
import com.kblife.admin.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<?> joinUser(@RequestBody UserJoinInfoDto userJoinInfoDto){
        try {
            userService.joinUser(userJoinInfoDto);

            return ResponseEntity.ok().body("User registration successful.");

        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while registering the user.");
        }
    }

    @GetMapping()
    public ResponseEntity<?> testApi(){
        userService.test();
        return ResponseEntity.status(HttpStatus.OK).body("Just Test API");
    }
}
