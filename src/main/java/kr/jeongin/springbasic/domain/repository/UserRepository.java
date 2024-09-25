package kr.jeongin.springbasic.domain.repository;

import kr.jeongin.springbasic.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, String>, UserRepositoryCustom {

}
