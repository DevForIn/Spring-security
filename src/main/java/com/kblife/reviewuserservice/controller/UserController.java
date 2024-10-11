package com.kblife.reviewuserservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @GetMapping()
    public ResponseEntity<?> testApi(){
        return ResponseEntity.status(HttpStatus.OK).body("Just Test API");
    }
}
