package kr.jeongin.springbasic.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class Users {

    @Id
    @Column
    private String id;

    @Column
    private String password;

    @Column
    private String username;

}
