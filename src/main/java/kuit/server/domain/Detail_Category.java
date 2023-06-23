package kuit.server.domain;


import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;


@Entity
@Getter
@Table
public class Detail_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    // 세부 카테고리 명
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private String status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
