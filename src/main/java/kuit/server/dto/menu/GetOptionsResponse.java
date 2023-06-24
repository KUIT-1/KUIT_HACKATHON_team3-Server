package kuit.server.dto.menu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class GetOptionsResponse {
    private Long id;
    private String name;
    private Boolean is_personal_option;
    private List<OptionsItem> options_item;
    private Long menu_id;
}
