package rifu.demo.spring.basicauth.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rifu.demo.spring.basicauth.entity.Function;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FunctionDAOTest {
    @Autowired
    private FunctionDAO functionDAO;

    @Test
    public void testFindAll() {
        List<Function> functionList = (List<Function>) functionDAO.findAll();
        System.out.println();
    }
}
