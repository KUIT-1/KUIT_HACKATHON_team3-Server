package kuit.server.domain;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;


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

    @Column(nullable = false, columnDefinition = "VARCHAR(20) CHARACTER SET UTF8")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "Timestamp")
    private Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "Timestamp")
    private Date updated_at;

}
