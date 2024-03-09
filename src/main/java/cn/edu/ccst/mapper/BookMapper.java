package cn.edu.ccst.mapper;

import cn.edu.ccst.model.Book;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/04/9:47
 * @Description:
 */
public interface BookMapper {
    public Book queryBookById(String id);
    public boolean addBook(Book book);
    public boolean modBook(Book book);
    public boolean delBook(Book book);
    public List<Book> queryAllBooksByWhere(Book where);
}
