package kr.jeongin.springbasic.domain.repository;

import kr.jeongin.springbasic.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    Optional<Object> findByUsername(String username);

}
