package com.bjpowernode.mapper;

import com.bjpowernode.pojo.Myusers;
import com.bjpowernode.pojo.MyusersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyusersMapper {
    int countByExample(MyusersExample example);

    int deleteByExample(MyusersExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(Myusers record);

    int insertSelective(Myusers record);

    List<Myusers> selectByExampleWithBLOBs(MyusersExample example);

    List<Myusers> selectByExample(MyusersExample example);

    Myusers selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") Myusers record, @Param("example") MyusersExample example);

    int updateByExampleWithBLOBs(@Param("record") Myusers record, @Param("example") MyusersExample example);

    int updateByExample(@Param("record") Myusers record, @Param("example") MyusersExample example);

    int updateByPrimaryKeySelective(Myusers record);

    int updateByPrimaryKeyWithBLOBs(Myusers record);

    int updateByPrimaryKey(Myusers record);
}