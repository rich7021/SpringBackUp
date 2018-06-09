package rifu.demo.spring.basicauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifu.demo.spring.basicauth.dao.AccountDAO;
import rifu.demo.spring.basicauth.entity.Account;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;

    public List<Account> findAll() {
        return (List<Account>) accountDAO.findAll();
    }

}
