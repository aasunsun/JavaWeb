package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.AdminMapper;
import com.bjpowernode.pojo.Admin;
import com.bjpowernode.pojo.AdminExample;
import com.bjpowernode.service.AdminService;
import com.bjpowernode.unils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    //在业务逻辑层中，一定有数据访问的对象
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {

        //根据传入的用户名到数据库中查询相应的用户对象
        //创建AdminExample的对象，用来封装条件
        //追加条件
        AdminExample example = new AdminExample();
        /**
         * select * from admin where a_name = "admin"
         */
        //添加用户名的条件
        example.createCriteria().andANameEqualTo(name);

        List<Admin> list = adminMapper.selectByExample(example);
        if (list.size() > 0) {
            Admin admin = list.get(0);
            /**
             * admin.getApass==>c984aed014aec7623a54f0591da07a85fd4b762d
             * pwd==>000000
             * 再进行密码比对是，要将传入的pwd进行MD5加密，再与数据库中查询到的对象的密码进行比对
             */
            String mipwd = MD5Util.getMD5(pwd);
            if (mipwd.equals(admin.getaPass())) {
                return  admin;
            }
        }
        return  null;
    }
}
