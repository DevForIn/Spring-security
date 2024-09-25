package kr.jeongin.springbasic.controller.dto;

import lombok.Data;

@Data
public class UserJoinInfoDto {
    private String id;
    private String password;
    private String username;
}
