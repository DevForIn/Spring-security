package com.kblife.admin.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class TokenDto {

    private final String token;

    private final String id;

    private final String username;

    private final Date expitreDate;

    private final boolean validateToken;

    @Builder
    public TokenDto(String token, String id, String username, Date expitreDate, boolean validateToken) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.expitreDate = expitreDate;
        this.validateToken = validateToken;
    }
}
