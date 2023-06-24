package kuit.server.dto.menu;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class OptionsItem {
    private Long id;
    private String name;
    private int add_price;
    private String description;
    private int default_count;
    private Long option_id;
}
