package com.xcy.service.impl;

import com.xcy.mapper.UserApplyMapper;
import com.xcy.pojo.User;
import com.xcy.service.UserApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/7/18.
 */
@Service
public class UserApplyServiceImpl implements UserApplyService {

    @Autowired
    private UserApplyMapper userApplyMapper;
    @Override
    public List<User> selectUserApply(User user) {
        return userApplyMapper.selectUserApply();
    }

    @Override
    public void insertUserApply(User user) {
        userApplyMapper.insertUserApply(user);
    }
}
