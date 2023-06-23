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
    private Long option_item_id;

    private Long selected_menu_id;


    private String status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
