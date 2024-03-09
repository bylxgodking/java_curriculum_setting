package cn.edu.ccst.service.impl;

import cn.edu.ccst.mapper.UserMapper;
import cn.edu.ccst.model.User;
import cn.edu.ccst.service.UserService;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/09/15:28
 * @Description:
 */
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;



    /*
    **
    * @Description: 根据id查用户
    * @Param: [id]
    * @return: cn.edu.ccst.model.User
    * @Author: LuoXinYu
    * @Date: 2024/3/9
    */
    @Override
    public User queryUserById(String id) {
        return null;
    }






    /*
    **
    * @Description: 添加用户
    * @Param: [user]
    * @return: boolean
    * @Author: LuoXinYu
    * @Date: 2024/3/9
    */
    @Override
    public boolean addUser(User user) {
        return false;
    }






    /*
    **
    * @Description: 修改用户密码
    * @Param: [user]
    * @return: boolean
    * @Author: LuoXinYu
    * @Date: 2024/3/9
    */
    @Override
    public boolean modUserPassword(User user) {
        return false;
    }




    /*
    **
    * @Description: 删除用户
    * @Param: [user]
    * @return: boolean
    * @Author: LuoXinYu
    * @Date: 2024/3/9
    */
    @Override
    public boolean delUser(User user) {
        return false;
    }



    /*
    **
    * @Description: 重置指定用户密码
    * @Param: [user]
    * @return: boolean
    * @Author: LuoXinYu
    * @Date: 2024/3/9
    */
    @Override
    public boolean resetUserPass(User user) {
        return false;
    }

    @Override
    public void exitSys() {
        System.exit(0);
    }
}
