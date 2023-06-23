package kuit.server.domain;


import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
@Table
public class Option_item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    //옵션 아이템 명
    @Column(nullable = false)
    private String name;

    //옵션 아이템 추가 가격
    @Column(nullable = false)
    private int add_price;

    //옵션 아이템 설명
    private String description;

    //옵션 아이템 수량
    @Column(nullable = false)
    private int count;

    //서브 옵션명
    @Column(nullable = false)
    private String sub_option_name;

    //기본 옵션 여부
    @Column(nullable = false)
    private boolean is_default;

    //기본 제공 수량
    @Column(nullable = false)
    private int default_count;

    //Foriegn Key
    //옵션 id

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Option option;




}
