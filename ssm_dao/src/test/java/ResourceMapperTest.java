import org.example.domain.Resource;
import org.example.mapper.ResourceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * @author
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class ResourceMapperTest {

    @Autowired
    private ResourceMapper resourceMapper;

    @Test
    public void deleteRoleContextResource(){
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(992);
        ids.add(999);
        resourceMapper.deleteRoleContextResource(ids);
    }

    @Test
    public void findResourceById(){
        Resource resourceById = resourceMapper.findResourceById(1);
        System.out.println(resourceById);
    }
}
