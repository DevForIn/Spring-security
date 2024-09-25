package kr.jeongin.springbasic.domain.repository;

import kr.jeongin.springbasic.controller.dto.UserJoinInfoDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepositoryCustom {

    @Override
    public boolean joinUser(UserJoinInfoDto userJoinInfoDto) {
        return false;
    }
}
