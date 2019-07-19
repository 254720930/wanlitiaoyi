package com.xcy.service;

import com.xcy.pojo.Dynamic;
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

    List<Dynamic> selectAllDynamic();

}
