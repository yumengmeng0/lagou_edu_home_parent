import org.example.domain.Menu;
import org.example.mapper.MenuMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class MenuTest {

    @Autowired
    private MenuMapper mapper;

    @Test
    public void findSubMenuByPid() {
        List<Menu> menuList = mapper.findSubMenuByPid(25);
        for (Menu menu : menuList) {
            System.out.println(menu);
        }
    }


}
