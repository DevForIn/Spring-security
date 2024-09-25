package kr.jeongin.springbasic.domain.entity;

import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column
    private String id;

    @Column
    private String password;

    @Column
    private String username;

    @Builder
    public Users(String id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }
}
