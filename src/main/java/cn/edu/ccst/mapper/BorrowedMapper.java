package cn.edu.ccst.mapper;

import cn.edu.ccst.model.Borrowed;
import cn.edu.ccst.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/04/10:55
 * @Description:
 */
public interface BorrowedMapper {
    /*
    **
    * @Description: 根据用户编号查找借阅记录
    * 从表Borrow中按user_id查找记录
    * 把数据封装进borrow对象
    * @Param: [user]
    * @return: java.util.List<cn.edu.ccst.model.Borrowed>
    * @Author: LuoXinYu
    * @Date: 2024/3/4
    */
    public List<Borrowed> queryBorrowsByUser(String id);
}
