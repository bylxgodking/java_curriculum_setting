package cn.edu.ccst.service;
import cn.edu.ccst.mapper.UserMapper;
import cn.edu.ccst.model.User;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/09/15:23
 * @Description:
 */

public interface UserService {

    public User queryUserById(String id);

    public boolean addUser(User user);

    public boolean modUserPassword(User user);

    public boolean delUser(User user);

    public boolean resetUserPass(User user);

    /**
     * 退出系统.
     */
    public void exitSys();
}

