package com.xcy.mapper;

import com.xcy.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    /*通过id删除数据*/
    int deleteByPrimaryKey(int id);

    /*通过email查询是否有该用户*/
    int validEmail(String email);

    int register(User user);

    User selectUserByEmail(String email);

    int login(User user);

    int resetPassword(User user);

    Integer[] selectMyAttention(int id);

    List<User> selectMyAttentionUser(Integer[] ids);

    Integer[] selectMyFocused(int id);

    List<User> selectMyFocusedUser(Integer[] ids);
}