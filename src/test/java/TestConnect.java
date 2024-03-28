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
        // 1 ��������
        // ps: ���÷��似��,����������ص�JVM
        Class.forName("com.mysql.jdbc.Driver");

        // 2 ͨ������������������Ӷ���
        /**
         * ����1 url: ���ݿ����ӵĵ�ַ
         *    Э��://ip:�˿�/����
         * ����2 username: ���ݿ��û���
         * ����3 password: ���ݿ�����
         */
        String url = "jdbc:mysql://rm-bp1v2a9hi7077100k8o.mysql.rds.aliyuncs.com:3306/libsys?useSSL=false";
        String username = "Lyt_0223";
        String password = "lyttsl0223!";
        Connection conn = DriverManager.getConnection(url,username,password);

        // 3 ͨ�����Ӷ���,����ִ��sql���Ķ���
        Statement statement = conn.createStatement();

        // 4 ͨ��ִ��������,ִ��sql,��ý��
        String sql = "insert into tb_user (id,name,password,type) values ('999','asdsadsa','123456','2')";
        // ִ�в�ѯ,��executeQuery()
        // ִ����ɾ��,��executeUpdate(),������Ӱ�������
        int num = statement.executeUpdate(sql);

        if (num > 0) {
            System.out.println("����ɹ�!!" );
        }

        // 5 ����
        statement.close();
        conn.close();
    }
}
