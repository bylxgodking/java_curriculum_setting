package cn.edu.ccst.service.impl;

import cn.edu.ccst.mapper.BookMapper;
import cn.edu.ccst.mapper.UserMapper;
import cn.edu.ccst.model.Book;
import cn.edu.ccst.model.Borrowed;
import cn.edu.ccst.model.User;
import cn.edu.ccst.service.BookService;
import cn.edu.ccst.util.MybatisUtil;
import cn.edu.ccst.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

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
        SqlSession sqlSession = MybatisUtil.init();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book =bookMapper.queryBookById(id);
        return book;
    }

    @Override
    public boolean addBook(Book book) {
        SqlSession sqlSession = MybatisUtil.init();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        boolean addedBook =bookMapper.addBook(book);
        sqlSession.commit();
        return addedBook;
    }

    @Override
    public boolean modBook(Book book) {
        SqlSession sqlSession = MybatisUtil.init();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        boolean addedBook =bookMapper.modBook(book);
        sqlSession.commit();
        return addedBook;
    }

    @Override
    public boolean delBook(Book book) {
        SqlSession sqlSession = MybatisUtil.init();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        boolean addedBook =bookMapper.delBook(book);
        sqlSession.commit();
        return addedBook;
    }

    @Override
    public List<Book> queryAllBooksByWhere(Book where) {
            return new BookServiceImpl().queryBooks();
    }

    @Override
    public boolean BorrowBook(Borrowed borrowed) {
        return false;
    }

    @Override
    public boolean BorrowReturn(Borrowed borrowed) {
        return false;
    }

    @Override
    public List<Book> queryBooks() {
        SqlSession sqlSession = MybatisUtil.init();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        List<Book> bookList = bookMapper.queryBooks();
        return bookList;
    }

    @Override
    public List<Book> queryBookByWhere(String where) {
        return null;
    }
}
