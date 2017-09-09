package org.lanqiao.controller;

import org.lanqiao.service.IUserService;
import org.lanqiao.bean.RtnObj;
import org.lanqiao.bean.User;
import org.lanqiao.bean.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/2.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    //自定义对象类型
    @RequestMapping("/reg.do")
    @ResponseBody
    public  String register(User user){
        System.out.println(user);
        return "register";
    }

    //基本数据类型
    @RequestMapping("/baseType.do")
    @ResponseBody //该注解指的是将内容或对象作为 HTTP 响应正文返回
    public String baseType(Integer id){
        return  id+"";
    }

    //自定义混合对象
    @RequestMapping("/myFixObj.do")
    @ResponseBody
    public String myFixObj(RtnObj rtn){
        return rtn.toString();
    }

    //list绑定
    @RequestMapping("/myList.do")
    @ResponseBody
    public String myList(UserList userList){

        return userList.toString();
    }

    //查询所有用户
    @RequestMapping(value="/allUser.do",method = RequestMethod.GET)
    @ResponseBody
   public List<User> all(User user){
        List<User> list=userService.getAllUser();

        return list;
   }

   //根据ID查询用户
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
   @ResponseBody
    public User getUserById(@PathVariable  int id){
      return userService.getUserById(id);
    }

    //添加一个用户
    @RequestMapping(value="",method = RequestMethod.POST)
    @ResponseBody
    public int addUser(@RequestBody  User user){
        return userService.addUser(user);
    }

    //根据ID删除某个用户
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public int delUserById(@PathVariable  Integer id){
        return userService.delUserById(id);
    }

    //更新用户信息
    @RequestMapping(value="",method = RequestMethod.PUT)
    @ResponseBody
    public int updateUserById(@RequestBody User user){
        return userService.updateUserById(user);
    }

   @RequestMapping("/condition.do")
   public ModelAndView getByCondition(User user){
       System.out.println(111);
       List<User> list=userService.getByCondition(user);
       Map map=new HashMap();
       map.put("userList",list);
       return new ModelAndView("showStu",map);
   }

   @RequestMapping("/con.do")
    public ModelAndView findByCondition(User user){
     List<User> userList=userService.findByCondition(user);
     ModelAndView modelAndView=new ModelAndView("showStu");
     modelAndView.addObject("userList",userList);
     return modelAndView;
    }

}
