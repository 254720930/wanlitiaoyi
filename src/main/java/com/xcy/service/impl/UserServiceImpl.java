package com.xcy.service.impl;

import com.xcy.mapper.UserMapper;
import com.xcy.pojo.Information;
import com.xcy.pojo.Mate;
import com.xcy.pojo.User;
import com.xcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;


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

    @Override
    public List<User> selectMyAttention(int id) {
        Integer[] ids = userMapper.selectMyAttention(id);
        List<User> userList = userMapper.selectMyAttentionUser(ids);
        return userList;
    }

    @Override
    public List<User> selectMyFocused(int id) {
        Integer[] ids = userMapper.selectMyFocused(id);
        List<User> userList = userMapper.selectMyFocusedUser(ids);
        return userList;
    }

    @Override
    public User selectUserById(int id) {
        return userMapper.selectUserById(id);
    }


    @Override
    @Transient
    public int apply(int userId, int hotlistId) {
        int isApply = userMapper.apply(userId, hotlistId);
        if (isApply > 0){
            int addApplyNum = userMapper.updateApplyNum(hotlistId);
            if (addApplyNum > 0){
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    @Override
    public int sendMessage(Information information) {
        return userMapper.sendMessage(information);
    }

    @Override
    public List<Information> myNotReadSystemMessage(int addresser) {
        return userMapper.myNotReadSystemMessage(addresser);
    }

    @Override
    public List<Information> myReadSystemMessage(int addresser) {
        return userMapper.myReadSystemMessage(addresser);
    }

    @Override
    public List<Information> myReadUserMessage(int addresser) {
        return userMapper.myReadUserMessage(addresser);
    }

    @Override
    public List<Information> myNotReadUserMessage(int addresser) {
        return userMapper.myNotReadUserMessage(addresser);
    }

    @Override
    public int readMessage(int id) {
        return userMapper.readMessage(id);
    }

    @Override
    public int updateUserInfo(User user) {
        return userMapper.updateUserInfo(user);
    }

    @Override
    public Mate selectMyMateById(int id) {
        return userMapper.selectMyMateById(id);
    }

    @Override
    public int updateUserMate(Mate mate) {
        return userMapper.updateUserMate(mate);
    }

    @Override
    public int addUserMate(Mate mate) {
        return userMapper.addUserMate(mate);
    }

    @Override
    public List<User> selectUserByMate(Mate mate) {
        return userMapper.selectUserByMate(mate);
    }

}
