package com.bjpowernode.service;

import com.bjpowernode.pojo.Myusers;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MyusersService {
    //显示所有用户(不分页)
    List<Myusers> getAll();

    //分页显示
    PageInfo splitPage(int pageNum,int pageSize);
}
