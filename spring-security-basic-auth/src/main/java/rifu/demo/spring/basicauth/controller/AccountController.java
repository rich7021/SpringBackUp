package rifu.demo.spring.basicauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rifu.demo.spring.basicauth.entity.Account;
import rifu.demo.spring.basicauth.service.AccountService;

import java.util.List;

/* @RestController cannot assign URI path, it's necessary to define with @RequestMapping */
@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAllUsers() {
        return accountService.findAll();
    }
}
