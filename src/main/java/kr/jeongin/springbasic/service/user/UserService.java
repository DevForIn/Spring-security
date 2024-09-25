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

    public void joinUser(UserJoinInfoDto userJoinInfoDto) {

        validateDuplicateUserId(userJoinInfoDto.getId());

        String encodedPassword = passwordEncoder.encode(userJoinInfoDto.getPassword());

        Users user = Users.builder()
                .id(userJoinInfoDto.getId())
                .username(userJoinInfoDto.getUsername())
                .password(encodedPassword)
                .build();

        userRepository.save(user);
    }

    // 중복 ID 검증 로직 분리
    private void validateDuplicateUserId(String id) {
        if (userRepository.findById(id).isPresent()) {
            log.error("This ID is already in use: {}", id);
            throw new IllegalStateException("ID is already in use.");
        }
    }
}
