package cn.edu.ccst.service.impl;

import cn.edu.ccst.mapper.UserMapper;
import cn.edu.ccst.model.User;
import cn.edu.ccst.service.UserService;
import cn.edu.ccst.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/09/15:28
 * @Description:
 */
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    /**
    **
    * @Description: 根据id查用户
    * @Param: [id]
    * @return: cn.edu.ccst.model.User
    * @Author: LuoXinYu
    * @Date: 2024/3/9
    */
    @Override
    public User queryUserById(String id) {
        SqlSession sqlSession = MybatisUtil.init();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User target = userMapper.queryUserById(id);
        return target;
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
        SqlSession sqlSession = MybatisUtil.init();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        boolean target = userMapper.addUser(user);
        sqlSession.commit();
        return target;
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
        SqlSession sqlSession = MybatisUtil.init();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        boolean user1 = userMapper.modUserPassword(user);
        sqlSession.commit();
        return user1;
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

    @Override
    public User queryUserByName(String UserId) {
        SqlSession sqlSession = MybatisUtil.init();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.queryUserByName(UserId);
        sqlSession.commit();
        return user1;
    }


    @Override
    public String getAllIdCount() {
        SqlSession sqlSession = MybatisUtil.init();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> allIdCount = userMapper.getAllIdCount();
        int count = allIdCount.size();

        sqlSession.commit();
        return String.valueOf(count);
    }
}
