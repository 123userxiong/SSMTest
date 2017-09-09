package org.lanqiao.dao;

import org.lanqiao.bean.Classes;
import org.lanqiao.bean.Student;

import java.util.List;

/**
 * Created by Administrator on 2017/9/4.
 */
public interface IClassDao {

    /**
     * 查询所有的班级信息，包含班级老师信息
     * @return
     */
    List<Classes> getAllClassInfo();

    /**
     * 根据班级id，查询班级所有学生的信息
     * @param id
     * @return
     */
    List<Student> getClassInfoById(int id);
}
