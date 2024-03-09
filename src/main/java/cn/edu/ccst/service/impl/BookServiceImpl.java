package cn.edu.ccst.service.impl;

import cn.edu.ccst.model.Book;
import cn.edu.ccst.model.Borrowed;
import cn.edu.ccst.service.BookService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/09/16:00
 * @Description:
 */
public class BookServiceImpl implements BookService {
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
}
