package kuit.server.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Getter
@Table
public class Selected_Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    //메뉴 수량
    @Column(nullable = false)
    private int menu_count;


    @Column(nullable = false, columnDefinition = "VARCHAR(20) CHARACTER SET UTF8")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "Timestamp")
    private Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "Timestamp")
    private Date updated_at;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;
}
