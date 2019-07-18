package com.xcy.service;

import com.xcy.pojo.User;

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
}
