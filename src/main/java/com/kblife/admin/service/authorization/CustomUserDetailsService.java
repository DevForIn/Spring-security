package com.kblife.admin.service.authorization;

import com.kblife.admin.controller.dto.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUserDetailsService {
    CustomUserDetails loadUserByUsername(String id);
}
