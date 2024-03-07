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
    Book findBookById(String id);
    List<Book> findAllBook();
}
