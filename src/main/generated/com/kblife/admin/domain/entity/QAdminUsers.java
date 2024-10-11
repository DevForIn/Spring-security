package com.kblife.admin.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdminUsers is a Querydsl query type for AdminUsers
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdminUsers extends EntityPathBase<AdminUsers> {

    private static final long serialVersionUID = -1856029721L;

    public static final QAdminUsers adminUsers = new QAdminUsers("adminUsers");

    public final StringPath id = createString("id");

    public final StringPath password = createString("password");

    public final StringPath username = createString("username");

    public QAdminUsers(String variable) {
        super(AdminUsers.class, forVariable(variable));
    }

    public QAdminUsers(Path<? extends AdminUsers> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminUsers(PathMetadata metadata) {
        super(AdminUsers.class, metadata);
    }

}

