package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.MyusersMapper;
import com.bjpowernode.pojo.Myusers;
import com.bjpowernode.pojo.MyusersExample;
import com.bjpowernode.service.MyusersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MyusersServiceImpl")
public class MyusersServiceImpl implements MyusersService {

    //业务逻辑层一定有数据访问层的对象
    @Autowired
    MyusersMapper myusersMapper;

    @Override
    public List<Myusers> getAll() {
        return myusersMapper.selectByExample(new MyusersExample());
    }

    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        //查询操作
        MyusersExample example = new MyusersExample();
        //逆序
        example.setOrderByClause("uid desc");
        //取集合
        List<Myusers> list = myusersMapper.selectByExample(example);
        //将查到的集合封装
        PageInfo<Myusers> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


}
