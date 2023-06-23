package kuit.server.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Table
@NoArgsConstructor
public class Menu_Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    //카테고리명
    @Column(nullable = false, columnDefinition = "VARCHAR(20) CHARACTER SET UTF8")

    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(20) CHARACTER SET UTF8")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "Timestamp")
    private Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "Timestamp")
    private Date updated_at;


    @Builder
    public Menu_Category(String name, String status, Date created_at, Date updated_at) {
        this.name = name;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
