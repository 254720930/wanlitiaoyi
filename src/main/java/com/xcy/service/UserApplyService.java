package com.xcy.service;

import com.xcy.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2019/7/18.
 */
public interface UserApplyService {
    List<User> selectUserApply(User user);
    void insertUserApply(User user);
}
