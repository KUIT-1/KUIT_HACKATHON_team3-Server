package kuit.server.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Table
public class Selected_Option {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    //Foriegn Key
    @OneToOne
    @JoinColumn(name = "option_item_id")
    private Option_item optionItem;

    @ManyToOne
    @JoinColumn(name = "selected_menu_id")
    private Selected_Menu selectedMenu;


    private String status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
