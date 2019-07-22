package com.xcy.service;

import com.xcy.pojo.Information;
import com.xcy.pojo.Mate;
import com.xcy.pojo.User;

import java.util.List;

/**
 * @Auther: http://www/qfedu.com
 * @Date: 2019/7/18
 * @Description:
 * @version: 1.0
 */
public interface UserService {
    int validEmail(String email);

    int register(User admin);

    User selectUserByEmail(String email);

    int login(User user);

    int resetPassword(User user);

    List<User> selectMyAttention(int id);

    List<User> selectMyFocused(int id);

    User selectUserById(int id);

    int apply(int userId, int hotlistId);

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
