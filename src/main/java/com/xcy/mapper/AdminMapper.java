package com.xcy.mapper;

import com.xcy.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AdminMapper {
    /*通过id删除数据*/
    int deleteByPrimaryKey(int id);

    /*添加数据传参为Admin类型的数据*/
    int insert(Admin record);

    /*通过判断里面是否为空进行添加*/
    int insertSelective(Admin record);

    int updateByPrimaryKey(Admin record);

    /*通过email查询是否有该用户*/
    int validEmail(String email);
}