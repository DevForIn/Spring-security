package com.kblife.reviewuserservice.service.authorization;

import com.kblife.reviewuserservice.controller.dto.CustomUserDetails;

public interface CustomUserDetailsService {
    CustomUserDetails loadUserByUsername(String id);
}
