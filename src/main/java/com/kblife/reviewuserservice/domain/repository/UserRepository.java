package com.kblife.reviewuserservice.domain.repository;

import com.kblife.reviewuserservice.domain.entity.AdminUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AdminUsers, String>, UserRepositoryCustom {

}
