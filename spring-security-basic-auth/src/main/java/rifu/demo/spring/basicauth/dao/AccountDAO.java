package rifu.demo.spring.basicauth.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rifu.demo.spring.basicauth.entity.Account;

public interface AccountDAO extends CrudRepository<Account, Long> {

}
