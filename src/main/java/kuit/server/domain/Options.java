package kuit.server.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "options")
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "options_id", nullable = false)
    private Long id;

    // 옵션명
    @Column(nullable = false, columnDefinition = "VARCHAR(100) CHARACTER SET UTF8")

    private String name;

    // 옵션 설명
    @Column(nullable = false, columnDefinition = "TEXT CHARACTER SET UTF8")

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
