package kr.jeongin.springbasic.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.jeongin.springbasic.service.CustomUserDetailsService;
import kr.jeongin.springbasic.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@Slf4j
//요청당 한 번 실행되는 필터로, Spring Security에서 제공하는 기본 필터 클래스
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    // JWT 유틸리티 클래스 주입
    @Autowired
    private JwtUtil jwtUtil;

    // 사용자 정보 불러오는 서비스
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        // 요청 헤더에서 Authorization 헤더 추출
        final String authorizationHeader = request.getHeader("Authorization");

        String userId = null;
        String jwt = null;

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            // "Bearer " 이후의 토큰 값 추출
            jwt = authorizationHeader.substring(7);

            // JWT에서 사용자 아이디 추출
            userId = jwtUtil.extractUserid(jwt);
        }

        if(userId != null && SecurityContextHolder.getContext().getAuthentication() == null){
            // 사용자 이름으로 UserDetails 로드
            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(userId);
            
            // token 유효성 확인
            if(jwtUtil.validateToken(jwt,userDetails)){
                // 인증 객체 생성
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                // 요청에 대한 추가 세부 정보 설정
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // 인증 객체를 SecurityContext에 설정
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        // 요청을 다음 필터로 전달
        chain.doFilter(request,response);
    }

}
