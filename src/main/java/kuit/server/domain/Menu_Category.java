package kuit.server.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table
public class Menu_Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    //카테고리명
    @Column(nullable = false, columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")

    private String name;

    private String status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
