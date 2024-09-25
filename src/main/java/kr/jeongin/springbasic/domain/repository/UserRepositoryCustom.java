package kr.jeongin.springbasic.domain.repository;

import kr.jeongin.springbasic.controller.dto.UserJoinInfoDto;

public interface UserRepositoryCustom {
    boolean joinUser(UserJoinInfoDto userJoinInfoDto);
}
