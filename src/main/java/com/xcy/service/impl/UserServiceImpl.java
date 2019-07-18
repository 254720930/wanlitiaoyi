package com.xcy.service.impl;

import com.xcy.mapper.UserMapper;
import com.xcy.pojo.User;
import com.xcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Auther: http://www/qfedu.com
 * @Date: 2019/7/18
 * @Description:
 * @version: 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int validEmail(String email) {
        int a =  userMapper.validEmail(email);
        return a;
    }

    @Override
    public int register(User user) {
        int a =  userMapper.register(user);
        return a;
    }

    @Override
    public User selectUserByEmail(String email) {
        return userMapper.selectUserByEmail(email);
    }

    @Override
    public int login(User user) {
        return userMapper.login(user);
    }

    @Override
    public int resetPassword(User user) {
        return userMapper.resetPassword(user);
    }
}
