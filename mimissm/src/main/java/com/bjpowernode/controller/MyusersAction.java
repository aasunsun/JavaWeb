package com.bjpowernode.controller;

import com.bjpowernode.pojo.Myusers;
import com.bjpowernode.service.MyusersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/myusers")
public class MyusersAction {
    public static final int PAGE_SIZE = 5;

    //在所有的界面层，一定会有业务逻辑层的对象
    @Autowired
    MyusersService myusersService;

    //显示所有用户不分页
    @RequestMapping("/getAll")
    public String getAll(HttpServletRequest request) {
        List<Myusers> list = myusersService.getAll();
        request.setAttribute("list",list);
        return "myusers";
    }


    //分页显示
    @RequestMapping("/split")
    public String split(HttpServletRequest request) {
        //得到第一页的数据
        PageInfo info = myusersService.splitPage(1,PAGE_SIZE);
        request.setAttribute("info",info);
        return "myusers";
    }


    //ajax分页翻页
    @ResponseBody
    @RequestMapping("/ajaxSplit")
    public void ajaxSplit(int page, HttpSession session) {
        //取得当前page参数的页面的数据
        PageInfo info = myusersService.splitPage(page,PAGE_SIZE);
        session.setAttribute("info",info);
    }
}
