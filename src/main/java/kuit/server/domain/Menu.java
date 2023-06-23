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
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    //가격
    @Column(nullable = false)
    private int price;

    //메뉴 주문 수
    @Column(nullable = false)
    private Long ordered_count;

    // 설명

    private String description;


    private String status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    //Foreign Key
    @ManyToOne
    @JoinColumn(name = "detail_category_id")
    private Detail_Category detailCategory;

}
