package kuit.server.Controller;


import kuit.server.common.response.BaseResponse;
import kuit.server.dto.menu.GetDetailCategoryResponse;
import kuit.server.dto.menu.GetMenuResponse;
import kuit.server.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/menus")
public class MenuController {
    private final MenuService menuService;
//    @GetMapping("/{menu_category_id}")
//    public BaseResponse<List<GetDetailCategoryResponse>> getAllByMenuCategoryId(
//            @PathVariable("menu_category_id") Long menu_category_id){
//        log.info("[MenuController.getAllByMenuCategoryId]");
//        return new BaseResponse<>(menuService.getAllByMenuCategoryId(menu_category_id));
//    }
//
//    @GetMapping("/{menu_category_id}/{detail_cate_id}")
//    public BaseResponse<List<GetMenuResponse>> getAllByMenuCategoryId(
//            @PathVariable("menu_category_id") Long menu_category_id,
//            @PathVariable("detail_cate_id") Long detail_cate_id){
//        log.info("[MenuController.getAllByMenuCategoryId]");
//        return new BaseResponse<>(menuService.getAllByDetailCategoryId(menu_category_id, detail_cate_id));
//    }


        @GetMapping("/{menu_category_id}")
        public Map getAllByMenuCategoryId(
            @PathVariable("menu_category_id") Long menu_category_id){
            log.info("[MenuController.getAllByMenuCategoryId]");

            Map ret = new HashMap<String, Object>();

            ret.put("code", 1000);
            ret.put("status", 200);
            ret.put("message", "요청에 성공하였습니다.");
            ret.put("result", "콜드 브루 Cold Brew");
            return ret;
    }

}
