package com.xcy.mapper;

import com.xcy.pojo.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    /*通过id删除数据*/
    int deleteByPrimaryKey(int id);

    /*通过判断里面是否为空进行添加*/
    int insertSelective(User record);

    int updateByPrimaryKey(User record);

    /*通过email查询是否有该用户*/
    int validEmail(String email);

    int register(User user);

    User selectUserByEmail(String email);

    int login(User user);
}