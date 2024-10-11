package com.kblife.reviewuserservice.domain.repository;

import com.kblife.reviewuserservice.domain.entity.AdminUsers;
import com.kblife.reviewuserservice.domain.entity.QAdminUsers;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public void test() {
        QAdminUsers qAdminUsers = QAdminUsers.adminUsers;
        AdminUsers adminUsers;
        adminUsers = jpaQueryFactory.select(qAdminUsers)
                .from(qAdminUsers)
                .where(qAdminUsers.id.eq("cognet"))
                .fetchOne();

        log.info(adminUsers.getId());
        log.info(adminUsers.getUsername());

    }
}
