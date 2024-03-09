package cn.edu.ccst.service.impl;

import cn.edu.ccst.mapper.BorrowedMapper;
import cn.edu.ccst.mapper.UserMapper;
import cn.edu.ccst.model.Book;
import cn.edu.ccst.model.Borrowed;
import cn.edu.ccst.model.User;
import cn.edu.ccst.service.BookService;
import cn.edu.ccst.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

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
        SqlSession sqlSession = MybatisUtil.init();
        BorrowedMapper mapper = sqlSession.getMapper(BorrowedMapper.class);
        boolean target = mapper.BorrowBook(borrowed);
        return target;
    }

    @Override
    public boolean BorrowReturn(Borrowed borrowed) {
        SqlSession sqlSession = MybatisUtil.init();
        BorrowedMapper mapper = sqlSession.getMapper(BorrowedMapper.class);
        boolean target = mapper.BorrowReturn(borrowed);
        return target;
    }

    public List<Borrowed> queryBorrowsOfBook(String bookId) {
        SqlSession sqlSession = MybatisUtil.init();
        BorrowedMapper mapper = sqlSession.getMapper(BorrowedMapper.class);
        List<Borrowed> borroweds = mapper.queryBorrowsOfUser(bookId);
        return borroweds;
    }

    public List<Borrowed> queryOneBorrowed(String userId, String bookId) {
        SqlSession sqlSession = MybatisUtil.init();
        BorrowedMapper mapper = sqlSession.getMapper(BorrowedMapper.class);
        List<Borrowed> borroweds = mapper.queryOneBorrowed(userId,bookId);
        return borroweds;
    }

    public boolean BorrowAgain(Borrowed borr) {
        SqlSession sqlSession = MybatisUtil.init();
        BorrowedMapper mapper = sqlSession.getMapper(BorrowedMapper.class);
        boolean target = mapper.BorrowAgain(borr);
        return target;
    }

    public List<Borrowed> queryAllBorroweds() {
        SqlSession sqlSession = MybatisUtil.init();
        BorrowedMapper mapper = sqlSession.getMapper(BorrowedMapper.class);
        List<Borrowed> borroweds = mapper.queryAllBorrows();
        return borroweds;
    }

    public List<Borrowed> queryBorrowedsOfUser(String strUserId) {
        SqlSession sqlSession = MybatisUtil.init();
        BorrowedMapper mapper = sqlSession.getMapper(BorrowedMapper.class);
        List<Borrowed> borroweds = mapper.queryBorrowedsOfUser(strUserId);
        return borroweds;
    }

    public List<Borrowed> queryBorrowedsOfBook(String strBookId) {
        SqlSession sqlSession = MybatisUtil.init();
        BorrowedMapper mapper = sqlSession.getMapper(BorrowedMapper.class);
        List<Borrowed> borroweds = mapper.queryBorrowedsOfBook(strBookId);
        return borroweds;
    }
}
