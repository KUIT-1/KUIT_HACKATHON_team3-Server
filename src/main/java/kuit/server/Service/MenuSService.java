package kuit.server.Service;

import kuit.server.domain.Menu;
import kuit.server.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class MenuSService {


    @Autowired
    private MenuRepository menuRepository;


    public List<Menu> findByContainName(String name) {
        log.info("[MenuService.findByContainName]");
        List<Menu> menus = menuRepository.findByNameContains(name);
        if(menus.equals(null)) menus = new ArrayList();
        return menus;
    }
}
