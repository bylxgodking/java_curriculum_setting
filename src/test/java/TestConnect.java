import cn.edu.ccst.util.DBUtil;
import cn.edu.ccst.util.MybatisUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/28/11:44
 * @Description:
 */
public class TestConnect {
    @Test
    public void TestDataSourceConnect() throws ClassNotFoundException, SQLException {
        // 1 加载驱动
        // ps: 利用反射技术,将驱动类加载到JVM
        Class.forName("com.mysql.jdbc.Driver");

        // 2 通过驱动管理对象获得连接对象
        /**
         * 参数1 url: 数据库连接的地址
         *    协议://ip:端口/库名
         * 参数2 username: 数据库用户名
         * 参数3 password: 数据库密码
         */
        String url = "jdbc:mysql://rm-bp1v2a9hi7077100k8o.mysql.rds.aliyuncs.com:3306/libsys?useSSL=false";
        String username = "Lyt_0223";
        String password = "lyttsl0223!";
        Connection conn = DriverManager.getConnection(url,username,password);

        // 3 通过连接对象,创建执行sql语句的对象
        Statement statement = conn.createStatement();

        // 4 通过执行语句对象,执行sql,获得结果
        String sql = "insert into tb_user (id,name,password,type) values ('999','asdsadsa','123456','2')";
        // 执行查询,是executeQuery()
        // 执行增删改,是executeUpdate(),返回受影响的行数
        int num = statement.executeUpdate(sql);

        if (num > 0) {
            System.out.println("插入成功!!" );
        }

        // 5 关流
        statement.close();
        conn.close();
    }
}
