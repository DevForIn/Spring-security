package com.kblife.reviewuserservice.service.authorization.impl;

import com.kblife.reviewuserservice.controller.dto.CustomUserDetails;
import com.kblife.reviewuserservice.domain.entity.AdminUsers;
import com.kblife.reviewuserservice.domain.repository.UserRepository;
import com.kblife.reviewuserservice.service.authorization.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService, CustomUserDetailsService {

    @Autowired
    private UserRepository userRepository;  // DB에서 사용자 정보를 가져올 리포지토리

    @Override
    public CustomUserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        // DB에서 사용자 이름으로 사용자 검색
        AdminUsers adminUsers = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));

        // 기타 필드 설정
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));

        return new CustomUserDetails(adminUsers.getId(), adminUsers.getUsername(), adminUsers.getPassword(), authorities);  // 사용자 정보를 UserDetails 객체로 반환
    }
}

