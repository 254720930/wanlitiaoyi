package com.xcy.service.impl;

import com.xcy.mapper.AdminMapper;
import com.xcy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Auther: http://www/qfedu.com
 * @Date: 2019/7/18
 * @Description:
 * @version: 1.0
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public int validEmail(String email) {
        System.out.println(email);
        int a =  adminMapper.validEmail(email);
        return a;
    }
}
