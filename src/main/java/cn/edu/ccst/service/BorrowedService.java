package cn.edu.ccst.service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/09/15:21
 * @Description:
 */

import cn.edu.ccst.model.Borrowed;

import java.util.List;

/**
 * 封装用户管理业务逻辑.
 *
 * @author
 */
public interface BorrowedService {


    /**
     * 查询用户的借阅信息.
     *
     * @param userId 用户编号
     * @return List
     */
    public List<Borrowed> queryBorrowsOfUser(String userId);

    /**
     * 查询图书的借阅信息.
     *
     * @param bookId 图书编号
     * @return List
     */
    public List<Borrowed> queryBorrowsOfBook(String bookId);

    /**
     * 根据用户id 和 图书id查找一条借阅信息.
     *
     * @param userId 用户编号
     * @param bookId 图书编号
     * @return List
     */
    public List<Borrowed> queryOneBorrowed(String userId, String bookId);

    /**
     * 查找所有借阅信息.
     *
     * @return List
     */
    public List<Borrowed> queryAllBorrows();

    /**
     * 借阅图书.
     *
     * @param borr 借阅信息
     * @return boolean true 成功 false 失败
     */
    public boolean BorrowBook(Borrowed borr);

    /**
     * 续借图书.
     *
     * @param borr 借阅信息 用户编号和图书编号必须，其他字段为修改后的值
     * @return boolean true 成功 false 失败
     */
    public boolean BorrowAgain(Borrowed borr);

    /**
     * 归还图书.
     *
     * @param borr 借阅信息 用户编号和图书编号必须
     * @return boolean true 成功 false 失败
     */
    public boolean BorrowReturn(Borrowed borr);

    public List<Borrowed> queryAllBorroweds();

    public List<Borrowed> queryBorrowedsOfBook(String strBookId);
}

