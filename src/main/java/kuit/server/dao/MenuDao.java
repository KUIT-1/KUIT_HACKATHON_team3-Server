package kuit.server.dao;


import kuit.server.dto.menu.GetDetailCategoryResponse;
import kuit.server.dto.menu.GetMenuResponse;
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

        String sql = "select menu_category_id, name, description from Detail_Category where menu_category_id=:menu_category_id"; // and status='active'
        Map<String, Object> param = Map.of("menu_category_id", MenuCategoryId);
        return jdbcTemplate.query(sql, param,
                (rs, rowNum)-> new GetDetailCategoryResponse(
                   rs.getLong("menu_category_id"),
                   rs.getString("name"),
                   rs.getString("description")
                ));
    }

//    public List<GetMenuResponse> getAllByDetailCategoryId(Long MenuCategoryId, Long DetailCateId) {
//        log.info("[MenuDao.getAllByDetailCategoryId]");
//        String sql = "select name, price, description, detail_cate_id from Menu where menu_category_id=:menu_category_id and detail_cate_id=:detail_cate_id"; // and status='active'
//        Map<String, Object> param = Map.of("menu_category_id", MenuCategoryId, "detail_cate_id", DetailCateId);
//
//        return jdbcTemplate.query(sql, param,
//                (rs, rowNum)-> new GetMenuResponse(
//                        rs.getString("name"),
//                        rs.getInt("price"),
//                        rs.getString("description"),
//                        rs.getLong("detail_cate_id")
//                ));
//    }
}
