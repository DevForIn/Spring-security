package kr.jeongin.springbasic.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class TokenDto {

    private final String token;

    private final String tokenId;

    private final Date expitreDate;

    private final boolean validateToken;

    @Builder
    public TokenDto(String token, String tokenId, Date expitreDate, boolean validateToken) {
        this.token = token;
        this.tokenId = tokenId;
        this.expitreDate = expitreDate;
        this.validateToken = validateToken;
    }
}
