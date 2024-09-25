package kr.jeongin.springbasic.controller;

import kr.jeongin.springbasic.controller.dto.TokenDto;
import kr.jeongin.springbasic.controller.dto.UserJoinInfoDto;
import kr.jeongin.springbasic.service.user.UserService;
import lombok.RequiredArgsConstructor;
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

        boolean isJoinComplate = userService.joinUser(userJoinInfoDto);

        return ResponseEntity.ok().body(isJoinComplate);
    }
}
