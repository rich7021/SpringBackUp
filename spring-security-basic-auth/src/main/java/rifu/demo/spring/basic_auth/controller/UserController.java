package rifu.demo.spring.basic_auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* @RestController cannot assign URI path, it's necessary to define with @RequestMapping */
@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getMessage() {
        return "Hello World";
    }
}
