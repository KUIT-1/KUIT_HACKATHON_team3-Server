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


    @Column(nullable = false, columnDefinition = "VARCHAR(20) CHARACTER SET UTF8")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "Timestamp")
    private Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "Timestamp")
    private Date updated_at;


}
