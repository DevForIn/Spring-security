package kr.jeongin.springbasic.controller;

import kr.jeongin.springbasic.controller.dto.TokenDto;
import kr.jeongin.springbasic.controller.dto.UserInfoDto;
import kr.jeongin.springbasic.service.CustomUserDetailsService;
import kr.jeongin.springbasic.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@Slf4j
public class UserController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> createToken(@RequestBody UserInfoDto userInfoDto) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userInfoDto.getUsername(), userInfoDto.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Invalid username or password");
        }

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(userInfoDto.getUsername());

        // JWT 토큰 생성
        String token = jwtUtil.generateToken(userDetails);

        // 헤더에 토큰 추가
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", token);

        // 응답 생성 (헤더에 토큰 포함, 바디에 메시지 포함 가능)
        return ResponseEntity.ok()
                .headers(headers)
                .body(new TokenDto(token)); // 바디에 TokenDto 반환
    }

    @GetMapping()
    public String test(){
        return "T E S T";
    }
}

