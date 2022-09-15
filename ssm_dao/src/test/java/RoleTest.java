import org.example.domain.Role;
import org.example.mapper.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class RoleTest {

    @Autowired
    private RoleMapper mapper;

    @Test
    public void updateRole() {
        Role role = new Role();
        role.setId(1);
        role.setName("超级管理员test");
//        role.setUpdatedBy("ADMIN1");
        role.setDescription("后台管理员，初始拥有权限管理功能1");
        role.setUpdatedTime(new Date());

        mapper.updateRole(role);
    }


}
