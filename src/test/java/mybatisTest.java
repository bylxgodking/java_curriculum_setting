import cn.edu.ccst.mapper.BookMapper;
import cn.edu.ccst.mapper.BorrowedMapper;
import cn.edu.ccst.model.Book;
import cn.edu.ccst.model.Borrowed;
import org.apache.ibatis.io.Resources;
import org.junit.Before;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import cn.edu.ccst.swing.Button;

import javax.swing.*;
import javax.xml.soap.Text;

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
            System.out.println("mybatis初始化异常!!!!");
        }
    }

    @Test
    public void TestMybatis()
    {
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = bookMapper.queryBookById("1");
        System.out.println(book);
    }


    @Test
    public void showButton() throws InterruptedException {
        // 创建 Frame
        Frame frame = new Frame();
        frame.setSize(500, 500);
        frame.setBackground(new Color(0xBE16BE));

        // 创建并显示 Frame
        SwingUtilities.invokeLater(() -> {
            frame.setVisible(true);
        });

        // 在另一个线程中添加按钮并休眠
        Thread buttonThread = new Thread(() -> {
            try {
                // 等待 Frame 被创建并显示
                Thread.sleep(1000);

                // 创建按钮并添加到 Frame
                SwingUtilities.invokeLater(() -> {
                    Button customButton = new Button();
                    customButton.setSize(10,10);
                    customButton.setText("Click Me");
                    frame.add(customButton);
                    frame.revalidate(); // 重新验证 Frame，确保按钮能够显示
                });

                // 休眠一段时间以保持窗口打开状态
                Thread.sleep(5000); // 休眠 5 秒钟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        buttonThread.start();
        buttonThread.join(); // 等待按钮线程完成
    }

}
