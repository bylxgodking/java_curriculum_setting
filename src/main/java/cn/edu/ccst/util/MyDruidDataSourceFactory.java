package cn.edu.ccst.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/04/9:53
 * @Description:
 */
public class MyDruidDataSourceFactory extends PooledDataSourceFactory{
    public MyDruidDataSourceFactory()
    {
        this.dataSource= new DruidDataSource();
    }
}
