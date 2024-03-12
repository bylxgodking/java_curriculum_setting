package cn.edu.ccst.mapper;

import cn.edu.ccst.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/04/10:55
 * @Description:
 */
public interface UserMapper {
    public User queryUserById(String id);
    public boolean addUser(User user);

    public boolean delUser(User user);

    public boolean resetUserPass(User user);

    public boolean modUserPassword(User user);
    public User queryUserByName(String name);

    boolean addUser1(User user);

   List<User> getAllIdCount();
}
