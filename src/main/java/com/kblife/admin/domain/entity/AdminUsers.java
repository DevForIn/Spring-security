package com.kblife.admin.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "admin_users")
public class AdminUsers {

    @Id
    @Column
    private String id;

    @Column
    private String password;

    @Column
    private String username;

    @Builder
    public AdminUsers(String id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }
}
