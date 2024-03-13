import cn.edu.ccst.service.UserService;
import cn.edu.ccst.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/28/13:46
 * @Description:
 */
public class testAspect {
    @Test
    public void testAspect() {
        String path = "applicationContext.xml";

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);

        UserServiceImpl userService = context.getBean("userServiceImpl", UserServiceImpl.class);
        userService.getAllIdCount();

        System.out.println("-----------------" );

    }
}
