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

    public List<Borrowed> queryBorrowsOfUser(String user_id);
    public List<Borrowed> queryOneBorrowed(String user_id, String book_id);

    public List<Borrowed> queryAllBorrows();
    public boolean BorrowBook(Borrowed borr);

    public boolean BorrowAgain(Borrowed borr);

    public boolean BorrowReturn(Borrowed borr);

    List<Borrowed> queryBorrowedsOfUser(String strUserId);
    List<Borrowed> queryBorrowedsOfBook(String strBookId);
}
