package kr.jeongin.springbasic.service.authorization;

import kr.jeongin.springbasic.domain.entity.Users;
import kr.jeongin.springbasic.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;  // DB에서 사용자 정보를 가져올 리포지토리

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        // DB에서 사용자 이름으로 사용자 검색
        Users users = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + id));

        return new org.springframework.security.core.userdetails.User(users.getId(), users.getPassword(),
                new ArrayList<>());  // 사용자 정보를 UserDetails 객체로 반환
    }
}