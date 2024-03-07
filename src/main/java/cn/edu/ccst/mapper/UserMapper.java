package cn.edu.ccst.mapper;

import cn.edu.ccst.model.User;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/04/10:55
 * @Description:
 */
public interface UserMapper {
    public User findUserById(String id);

}
