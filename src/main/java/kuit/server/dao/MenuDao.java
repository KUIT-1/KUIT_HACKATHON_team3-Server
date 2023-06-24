package kuit.server.dao;


import kuit.server.dto.menu.GetDetailCategoryResponse;
import kuit.server.dto.menu.GetMenuResponse;
import kuit.server.dto.menu.GetOptionsResponse;
import kuit.server.dto.menu.OptionsItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class MenuDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public MenuDao(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    // 큰 카테고리 선택 -> 세부 카테고리 목록 조회
    // ex : 음료 카테고리 선택
    public List<GetDetailCategoryResponse> getAllByMenuCategoryId(long MenuCategoryId) {
        log.info("[MenuDao.getAllByMenuCategoryId]");

        String sql = "select id, name, description from Detail_Category where menu_category_id=:menu_category_id"; // and status='active'
        Map<String, Object> param = Map.of("menu_category_id", MenuCategoryId);
        return jdbcTemplate.query(sql, param,
                (rs, rowNum)-> new GetDetailCategoryResponse(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description")
                ));
    }

    public List<GetMenuResponse> getAllByDetailCategoryId(Long DetailCateId) {
        log.info("[MenuDao.getAllByDetailCategoryId]");
        String sql = "select id, name, price, description, detail_cate_id from Menu where detail_cate_id=:detail_cate_id"; // and status='active'
        Map<String, Object> param = Map.of("detail_cate_id", DetailCateId);

        return jdbcTemplate.query(sql, param,
                (rs, rowNum)-> new GetMenuResponse(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getLong("detail_cate_id")
                ));
    }

    public GetMenuResponse findMenuById(Long menuId) {
        log.info("[MenuDao.findMenuById]");
        String sql = "select * from Menu where id=:menu_id";
        Map<String, Object> param = Map.of("menu_id", menuId);

        List<GetMenuResponse> results = jdbcTemplate.query(sql, param,
                (rs, rowNum) -> {
                    GetMenuResponse menu = new GetMenuResponse();
                    menu.setId(rs.getLong("id"));
                    menu.setName(rs.getString("name"));
                    menu.setPrice(rs.getInt("price"));
                    menu.setDescription(rs.getString("description"));
                    menu.setDetail_cate_id(rs.getLong("detail_cate_id"));
                    return menu;
                });
        return results.get(0);

    }

    public GetOptionsResponse findOptionsByMenuId(Long menu_id) {
        log.info("[MenuDao.findOptionsByMenuId]");
        String sql = "select * from Options where menu_id=:menu_id";
        String sql_option = "select * from Option_item left outer join Options on Options.id=Option_item.options_id left outer join Menu on Menu.id=:menu_id";

        Map<String, Object> param = Map.of("menu_id", menu_id);
        List<OptionsItem> option_items = jdbcTemplate.query(sql_option, param,
                (rs, rowNum) -> {
                    OptionsItem optionsItems = new OptionsItem();
                    optionsItems.setId(rs.getLong("id"));
                    optionsItems.setName(rs.getString("name"));
                    optionsItems.setAdd_price(rs.getInt("add_price"));
                    optionsItems.setDescription(rs.getString("description"));
                    optionsItems.setOption_id(rs.getLong("detail_cate_id"));
                    return optionsItems;
                });

        List<GetOptionsResponse> results = jdbcTemplate.query(sql, param,
                (rs, rowNum) -> {
                    GetOptionsResponse options = new GetOptionsResponse();
                    options.setId(rs.getLong("id"));
                    options.setName(rs.getString("name"));
                    options.setIs_personal_option(rs.getBoolean("is_personal_option"));
                    options.setOptions_item(option_items);
                    options.setMenu_id(rs.getLong("menu_id"));
                    return options;
                });

        return results.get(0);
    }
}

