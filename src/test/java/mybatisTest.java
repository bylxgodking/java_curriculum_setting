import cn.edu.ccst.mapper.BookMapper;
import cn.edu.ccst.mapper.BorrowedMapper;
import cn.edu.ccst.model.Book;
import cn.edu.ccst.model.Borrowed;
import org.apache.ibatis.io.Resources;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/04/9:29
 * @Description:
 */
public class mybatisTest {
    SqlSession sqlSession=null;

    public void init() throws IOException {
        String source="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(source);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void initmybatis()
    {
        try {
            String source = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(source);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("mybatis≥ı ºªØ“Ï≥£!!!!");
        }
    }

    @Test
    public void TestMybatis()
    {
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = bookMapper.queryBookById("1");
        System.out.println(book);
    }

}
