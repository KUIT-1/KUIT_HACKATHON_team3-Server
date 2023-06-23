package kuit.server.Controller;


import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import kuit.server.Service.MenuSService;
import kuit.server.domain.Menu;
import kuit.server.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuSController {

    private final MenuSService menuSService;

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Menu>> menuSearch(@PathVariable("name") String name) {
        log.info("[MenuController.search]");

        return new ResponseEntity<>(menuSService.findByContainName(name), new HttpHeaders(),HttpStatus.OK);
    }
    /*@PostMapping("/orders/success")
    public ResponseEntity<String> menuOrder(HttpServletResponse response) {
        log.info("[MenuController.order]");

        //return new ResponseEntity<>(menuSService);
    }*/


}
