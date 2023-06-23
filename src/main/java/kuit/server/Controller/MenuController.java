package kuit.server.Controller;


import kuit.server.common.response.BaseResponse;
import kuit.server.dto.menu.GetDetailCategoryResponse;
import kuit.server.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/menus")
public class MenuController {
    private final MenuService menuService;
    @GetMapping("/{menu_category_id}")
    public BaseResponse<List<GetDetailCategoryResponse>> getAllByMenuCategoryId(
            @PathVariable("menu_category_id") Long menu_category_id){
        log.info("[MenuController.getAllByMenuCategoryId]");
        return new BaseResponse<>(menuService.getAllByMenuCategoryId(menu_category_id));
    }

}
