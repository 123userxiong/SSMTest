package org.lanqiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/1.
 */
@Controller  //告诉spring,这个类是一个controller
@RequestMapping("/test")   //请求地址
public class HelloController {

    @RequestMapping("/hello.do")
    public String hello(){
        System.out.println(111);
        return "hello";
    }

    @RequestMapping("/test.do")
    public  String test1(){
        System.out.println("进行一些业务处理");
        return "redirect:/test/hello.do";
    }

    @RequestMapping("/test2.do")
    public String test2(){
        return "redirect:/hello.jsp";
    }
    @RequestMapping("/forwardTest1.do")
    public String forwardTest1(){
        return "forward:/hello.jsp";
    }

    @RequestMapping("/forwardTest2.do")
    public ModelAndView forwardTest2(){
        Map map=new HashMap();
        map.put("name","xmy");
        return new ModelAndView("forward:/hello.jsp",map);
    }
}
