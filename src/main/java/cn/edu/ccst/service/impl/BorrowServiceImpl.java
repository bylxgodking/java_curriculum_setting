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
    public boolean BorrowBook(Borrowed borr) {
        SqlSession sqlSession = MybatisUtil.init();
        BorrowedMapper mapper = sqlSession.getMapper(BorrowedMapper.class);
        boolean target = mapper.BorrowBook(borr);
        sqlSession.commit();
        return target;
    }

    @Override
    public boolean BorrowReturn(Borrowed borrowed) {
        SqlSession sqlSession = MybatisUtil.init();
        BorrowedMapper mapper = sqlSession.getMapper(BorrowedMapper.class);
        boolean target = mapper.BorrowReturn(borrowed);
        sqlSession.commit();
        return target;
    }

    @Override
    public List<Book> queryBooks() {
        return null;
    }

    @Override
    public List<Book> queryBookByWhere(String where) {
        return null;
    }

    public List<Borrowed> queryBorrowsOfBook(String bookId) {
        SqlSession sqlSession = MybatisUtil.init();
        BorrowedMapper mapper = sqlSession.getMapper(BorrowedMapper.class);
        List<Borrowed> borroweds = mapper.queryBorrowsOfUser(bookId);
        return borroweds;
    }

    /*
    **
    * @Description: 用于判断读者是否借阅该书
    * @Param: [userId, bookId]
    * @return: java.util.List<cn.edu.ccst.model.Borrowed>
    * @Author: LuoXinYu
    * @Date: 2024/3/12
    */
    public List<Borrowed> queryOneBorrowed(String userId, String bookId) {
        SqlSession sqlSession = MybatisUtil.init();
        BorrowedMapper mapper = sqlSession.getMapper(BorrowedMapper.class);
        List<Borrowed> borroweds = mapper.queryOneBorrowed(userId,bookId);
        for(Borrowed b:borroweds)
        {
            System.out.println(b);
        }
        return borroweds;
    }

    public boolean BorrowAgain(Borrowed borr) {
        SqlSession sqlSession = MybatisUtil.init();
        BorrowedMapper mapper = sqlSession.getMapper(BorrowedMapper.class);
        boolean target = mapper.BorrowAgain(borr);
        sqlSession.commit();
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
