package com.kblife.admin.domain.repository;

import com.kblife.admin.domain.entity.AdminUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AdminUsers, String>, UserRepositoryCustom {

}
