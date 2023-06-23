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
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    //이름
    @Column(nullable = false, columnDefinition = "VARCHAR(20) CHARACTER SET UTF8")
    private String name;

    //가격
    @Column(nullable = false)
    private int price;

    //메뉴 주문 수
    @Column(nullable = false)
    private Long ordered_count;

    // 설명

    @Column(columnDefinition = "TEXT CHARACTER SET UTF8")
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
    @JoinColumn(name = "detail_cate_id")
    private Detail_Category detailCategory;

}
