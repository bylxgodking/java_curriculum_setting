package cn.edu.ccst.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/10/0:48
 * @Description:
 */

/*
**
* @Description: 获取sqlSession
* @Param:
* @return:
* @Author: LuoXinYu
* @Date: 2024/3/10
*/
public class MybatisUtil {
    public static SqlSession init()
    {
        try {
            String source = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(source);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            return sqlSession;
        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("mybatis初始化异常!!!!");
        }
        return null;
    }
}
