import org.example.mapper.ResourceCategoryMapper;
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
public class ResourceCategoryMapperTest {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    /**
     *
     */
    @Test
    public void test1() {
        List<Integer> list = resourceCategoryMapper.findAllResourceIdByCategoryByCategoryId(1);
        System.out.println(list);
    }

}
