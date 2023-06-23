package kuit.server.service;

import kuit.server.dao.MenuDao;
import kuit.server.dto.menu.GetDetailCategoryResponse;
import kuit.server.dto.menu.GetMenuResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuDao menuDao;

    public List<GetDetailCategoryResponse> getAllByMenuCategoryId(Long menu_category_id) {
        log.info("[MenuService.getAllByMenuCategoryId]");
        return menuDao.getAllByMenuCategoryId(menu_category_id);
    }

    public List<GetMenuResponse> getAllByDetailCategoryId(Long detail_cate_id) {
        log.info("[MenuService.getAllByDetailCategoryId]");
        return menuDao.getAllByDetailCategoryId(detail_cate_id);
    }

//    public GetMenuResponse findMenuById(Long menu_id) {
//        log.info("[MenuService.getAllByMenuId]");
//        return menuDao.findMenuById(menu_id);
//    }
}
