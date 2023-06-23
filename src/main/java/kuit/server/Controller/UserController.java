package kuit.server.Controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        return new ResponseEntity<>("구현 안했습니다", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return new ResponseEntity<>("구현 안했습니다", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("")
    public ResponseEntity<String> signin() {
        return new ResponseEntity<>("구현 안했습니다", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
