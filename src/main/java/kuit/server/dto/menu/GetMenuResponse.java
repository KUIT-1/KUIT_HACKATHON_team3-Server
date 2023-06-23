package kuit.server.dto.menu;

import lombok.*;

@Getter
@Setter
public class GetMenuResponse {
    private long id;
    private String name;
    private int price;
    private long ordered_count;
    private String description;
    private long detail_cate_id;

    public GetMenuResponse(long id, String name, int price, String description, long detailCateId) {
    }

    public GetMenuResponse() {

    }
}
