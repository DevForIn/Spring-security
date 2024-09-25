package kr.jeongin.springbasic.service.user;

import kr.jeongin.springbasic.controller.dto.UserJoinInfoDto;
import kr.jeongin.springbasic.domain.entity.Users;
import kr.jeongin.springbasic.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public boolean joinUser(UserJoinInfoDto userJoinInfoDto) {
        if(!userRepository.findById(userJoinInfoDto.getId()).isEmpty()){
            log.error("this ID is used...");
            return false;
        }

        String encodedPassword = passwordEncoder.encode(userJoinInfoDto.getPassword());

        Users user = new Users();

        user.setId(userJoinInfoDto.getId());
        user.setUsername(userJoinInfoDto.getUsername());
        user.setPassword(encodedPassword);

        user =  userRepository.save(user);

        return user != null;
    }
}
