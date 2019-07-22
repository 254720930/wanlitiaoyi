package com.xcy.mapper;

import com.xcy.pojo.Dynamic;
import com.xcy.pojo.Information;
import com.xcy.pojo.Mate;
import com.xcy.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {

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

    User selectUserById(int id);

    int apply(int userId, int hotlistId);

    int updateApplyNum(int hotlistId);

    int sendMessage(Information information);

    List<Information> myNotReadSystemMessage(int addresser);

    List<Information> myReadSystemMessage(int addresser);

    List<Information> myReadUserMessage(int addresser);

    List<Information> myNotReadUserMessage(int addresser);

    int readMessage(int id);

    int updateUserInfo(User user);

    Mate selectMyMateById(int id);

    int updateUserMate(Mate mate);

    int addUserMate(Mate mate);

    List<User> selectUserByMate(Mate mate);
}