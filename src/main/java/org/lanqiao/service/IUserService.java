package org.lanqiao.service;

import org.lanqiao.bean.User;

import java.util.List;

/**
 * Created by Administrator on 2017/8/30.
 */
public interface IUserService {

    /**
     * 查询所有用户
     * @return
     */
    List<User> getAllUser();

    /**
     *根据id查询某一个用户
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     * 添加一个用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUserById(User user);

    /**
     *根据ID删除某个用户
     * @param id
     * @return
     */
    int delUserById(int id);

    /**
     * 根据条件查询
     * @param user
     * @return
     */
    List<User> getByCondition(User user);
    /**
     * 根据条件查询
     * @param user
     * @return
     */
    List<User> findByCondition(User user);
}
