package cn.edu.ccst.service;

import cn.edu.ccst.model.Book;
import cn.edu.ccst.model.Borrowed;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/09/15:18
 * @Description:封装图书管理业务逻辑.
 */
public interface BookService {

    /**
    **
    * @Description: 图书编号
    * @Param: [id]
    * @return: cn.edu.ccst.model.Book
    * @Author: LuoXinYu
    * @Date: 2024/3/9
    */
    public Book queryBookById(String id);


    /**
    **
    * @Description: 添加一个图书
    * @Param: [book]   图书信息
    * @return: boolean    true 成功 false 失败
    * @Author: LuoXinYu
    * @Date: 2024/3/9
    */
    public boolean addBook(Book book);

    /**
    **
    * @Description: 修改图书信息
    * @Param: [book]   图书信息 图书编号必须，其他字段为修改后的值
    * @return: boolean   true 成功 false 失败
    * @Author: LuoXinYu
    * @Date: 2024/3/9
    */
    public boolean modBook(Book book);

    /**
    **
    * @Description: 删除指定图书
    * @Param: [book]  图书信息 图书编号必须
    * @return: boolean  true 成功 false 失败
    * @Author: LuoXinYu
    * @Date: 2024/3/9
    */
    public boolean delBook(Book book);


    /*
    **
    * @Description: 按条件查询所有图书
    * @Param: [where]  <p>四种条件：图书编号、名称、作者、出版社<br>
    * @return: java.util.List<cn.edu.ccst.model.Book>
    * @Author: LuoXinYu
    * @Date: 2024/3/9
    */
    public List<Book> queryAllBooksByWhere(Book where);

    boolean BorrowBook(Borrowed borrowed);

    boolean BorrowReturn(Borrowed borrowed);

    List<Book> queryBooks();
    List<Book> queryBookByWhere(String where);

}

