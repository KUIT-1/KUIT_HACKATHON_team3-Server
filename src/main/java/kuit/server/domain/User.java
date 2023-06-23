package kuit.server.domain;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String user_id;
    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String email;
    @Column(nullable = false)
    private String nickname;
    @Column(nullable = false)
    private String phone_number;

    private String status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
