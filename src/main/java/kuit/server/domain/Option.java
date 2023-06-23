package kuit.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "option")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    // 옵션명
    @Column(name = "name", nullable = false)
    private String name;

    // 옵션 설명
    @Column(name = "description")
    private String description;

    // 퍼스널 옵션 여부
    @Column(name = "is_personal_option", columnDefinition = "TINYINT")
    private boolean personalOption;

    // Foreign Key
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    // ...
}
