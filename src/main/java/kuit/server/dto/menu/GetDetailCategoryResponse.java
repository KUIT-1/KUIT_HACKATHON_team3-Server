package kuit.server.dto.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetDetailCategoryResponse {
    private long menu_category_id;
    private String name;
    private String description;
}
