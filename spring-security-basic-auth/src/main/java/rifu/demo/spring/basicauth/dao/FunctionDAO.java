package rifu.demo.spring.basicauth.dao;

import org.springframework.data.repository.CrudRepository;
import rifu.demo.spring.basicauth.entity.Function;

public interface FunctionDAO extends CrudRepository<Function, Long> {
}
