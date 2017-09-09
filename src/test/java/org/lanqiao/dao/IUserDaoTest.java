package org.lanqiao.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lanqiao.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/9/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class IUserDaoTest {

    @Autowired
    IUserDao userDao;
    @Test
    public void updateByCondition() throws Exception {
        User user=new User();
        user.setId(2);
        user.setName("xmy");
        userDao.updateByCondition(user);
    }
    @Test
    public void getUserIn() throws Exception {
        List<Integer> list=new ArrayList<Integer>();
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        userDao.getUserIn(list);
    }

}