package kr.jeongin.springbasic.controller;

import kr.jeongin.springbasic.controller.dto.TokenDto;
import kr.jeongin.springbasic.controller.dto.UserJoinInfoDto;
import kr.jeongin.springbasic.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
