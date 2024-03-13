package cn.edu.ccst.util;

import cn.edu.ccst.model.User;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.Properties;
import java.sql.*;
import java.lang.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/02/05/16:29
 * @Description:
 */
public class DBUtil {
    // 创建Properties类对象,专用于操作properties文件
    private static final Properties properties = new Properties();

    //声明Druid连接池对象
    //数据连接，一般称作数据源 daraSource
    private static DruidDataSource dataSource;

    /**
     * 加载驱动的目的是为了在JVM中有sql运行的环境
     * 该环境有一份就行了,不用重复加载
     * ------------------------------------
     * static 静态代码块
     * 1) 保证内存中只有一份
     * 2) 保证随着类加载而加载,即该代码块会执行
     */
    static {

        // 通过反射的技术获得字节码文件
        // 再通过字节码文件将配置文件读取成输入流
        InputStream inputStream = DBUtil.class.getResourceAsStream("/db.properties");
        try {
            // 再通过流获得其中数据
            properties.load(inputStream);
            // 从properties对象取值
            //Class.forName(properties.getProperty("driverClass"));

            //不需要由我们加载驱动
            //由Durid加载驱动
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.out.println("加载驱动异常!!");
            e.printStackTrace();
        }
    }

    /**
     * 一般会将关于JDBC配置信息,抽取出来,形成一个配置文件,方便维护
     * 文件类型是properties文件,该文件类似map,键值对类型
     * 名字 jdbc.properties
     * 位置 src/jdbc.properties
     * 内容
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            //conn = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username") ,properties.getProperty("password") );
            //不需要由我们获得连接
            //使用Durid获得连接
            conn = dataSource.getConnection();
        } catch (Exception e) {
            System.out.println("获得连接出异常!!!");
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 关闭所有流
     */
    public static void closeAll(Connection conn, Statement s) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (s != null) {
            try {
                s.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void closeAll(Connection conn, Statement s, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (s != null) {
            try {
                s.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 封装查询方法,返回一个对象
     * 参数1 执行查询的SQL,预处理的,条件用?占位
     * 参数2 结果要封装的类
     * 参数3 给?赋值,不定长参数,是数组
     * 1,admin,123456
     */

    public static <T> T selectOne(String sql ,Class<T> t ,Object... args)
    {
        //获得连接对象
        Connection conn = DBUtil.getConnection();
        T target=null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        //通过连接对象获取预处理语句对象
        try
        {
            ps = conn.prepareStatement(sql);
            for(int i = 0; args!=null&&i<args.length;i++)
            {
                //查询什么从输入的args中取得
                ps.setObject(i+1,args[i]);
            }
            //执行sql,获得执行完sql的结果
            rs = ps.executeQuery();
            //接下来开始封装数据
            if(rs.next())
            {
                //new 一个对象，target
                target = t.newInstance();

                //获得所有属性
                Field[] fields = t.getDeclaredFields();
                for(int i = 0;i<fields.length;i++)
                {
                    //拿出属性对象
                    Field field = fields[i];
                    //field.getName()得到属性的名字   rs.getObject得到属性的值
                    Object value = rs.getObject(field.getName());

                    // 破解私有
                    field.setAccessible(true);

                    //使用属性对象赋值
                    field.set(target,value);
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("sql语句异常!!!");
        }

            return target;
    }
}
