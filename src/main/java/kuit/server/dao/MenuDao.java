package kuit.server.dao;


import kuit.server.dto.menu.GetDetailCategoryResponse;
import kuit.server.dto.menu.GetMenuResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
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

//    public GetMenuResponse findMenuById(Long menuId) {
//        log.info("[MenuDao.findMenuById]");
//        String sql = "select * from Menu where id=:menu_id";
//        Map<String, Object> param = Map.of("menu_id", menuId);
//
//        return jdbcTemplate.queryForObject(sql,
//                menuId,
//                (rs, rowNum) -> {
//                        GetMenuResponse getMenuResponse = new GetMenuResponse();
//                        getMenuResponse.setId(rs.getLong("id"));
//                        getMenuResponse.setPrice(rs.getInt("price"));
//                        getMenuResponse.setDescription(rs.getString("description"));
//                        getMenuResponse.setDetail_cate_id(rs.getLong("detailCateId"));
//                        return getMenuResponse;
//                    });
//    }
}

