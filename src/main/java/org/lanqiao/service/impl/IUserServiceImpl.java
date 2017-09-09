package org.lanqiao.service.impl;

import org.lanqiao.service.IUserService;
import org.lanqiao.bean.User;
import org.lanqiao.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/8/30.
 */

    @Service //告诉spring 这是一个service  同时把这个类注册到spring
public class IUserServiceImpl implements IUserService {
    //创建Logger对象
    Logger logger= Logger.getLogger("IUserServiceImpl.class");


    @Autowired//让spring 注入一个dao  autowired 会根据类型去匹配对应的对象
    private IUserDao userDao;

    public List<User> getAllUser() {
        logger.info("进入了getAllUser方法");
        return userDao.getAllUser();
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public int addUser(User user) {
        return  userDao.addUser(user);
    }

    public int updateUserById(User user) {

        return userDao.updateUserById(user);
    }

    public int delUserById(int id) {
        return userDao.delUserById(id);
    }

    public List<User> getByCondition(User user) {
        return userDao.getByCondition(user);
    }

    public List<User> findByCondition(User user) {
        return userDao.findByCondition(user);
    }
}
