package cn.edu.ccst.mapper;

import cn.edu.ccst.model.Book;
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

    public List<Borrowed> queryBorrowsOfUser(String userId);
    public List<Borrowed> queryOneBorrowed(String userId, String bookId);

    public List<Borrowed> queryAllBorrows();
    public boolean BorrowBook(Borrowed borr);

    public boolean BorrowAgain(Borrowed borr);

    public boolean BorrowReturn(Borrowed borr);

    List<Borrowed> queryBorrowedsOfUser(String strUserId);
    List<Borrowed> queryBorrowedsOfBook(String strBookId);
    public List<Book> queryAllBooksByWhere(Book where);
    public List<Borrowed> queryBorrowedsByUser2Book(User user, Book book);
}
