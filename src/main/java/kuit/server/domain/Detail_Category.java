package kuit.server.domain;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Getter
@Table
@NoArgsConstructor
public class Detail_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    // 세부 카테고리 명
    @Column(nullable = false, columnDefinition = "VARCHAR(20) CHARACTER SET UTF8")
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT CHARACTER SET UTF8")
    private String description;


    @Column(nullable = false, columnDefinition = "VARCHAR(20) CHARACTER SET UTF8")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "Timestamp")
    private Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "Timestamp")
    private Date updated_at;

    //Foreign Key
    @ManyToOne
    @JoinColumn(name = "menu_category_id")
    private Menu_Category menuCategory;

    @Builder
    public Detail_Category(String name, String description, String status, Date created_at, Date updated_at, Menu_Category menuCategory) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.menuCategory = menuCategory;
    }
}
