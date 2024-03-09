package cn.edu.ccst.service.impl;

import cn.edu.ccst.model.Book;
import cn.edu.ccst.model.Borrowed;
import cn.edu.ccst.service.BookService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/09/16:21
 * @Description:
 */
public class BorrowServiceImpl implements BookService {
    @Override
    public Book queryBookById(String id) {
        return null;
    }

    @Override
    public boolean addBook(Book book) {
        return false;
    }

    @Override
    public boolean modBook(Book book) {
        return false;
    }

    @Override
    public boolean delBook(Book book) {
        return false;
    }

    @Override
    public List<Book> queryAllBooksByWhere(Book where) {
        return null;
    }

    @Override
    public boolean BorrowBook(Borrowed borrowed) {
        return false;
    }

    @Override
    public boolean BorrowReturn(Borrowed borrowed) {
        return false;
    }

    public List<Borrowed> queryBorrowsOfBook(String bookId) {
        return null;
    }

    public List<Borrowed> queryOneBorrowed(String userId, String bookId) {
        return null;
    }

    public boolean BorrowAgain(Borrowed borr) {
        return false;
    }

    public List<Borrowed> queryAllBorroweds() {
        return null;
    }

    public List<Borrowed> queryBorrowedsOfUser(String strUserId) {
        return null;
    }

    public List<Borrowed> queryBorrowedsOfBook(String strBookId) {
        return null;
    }
}
