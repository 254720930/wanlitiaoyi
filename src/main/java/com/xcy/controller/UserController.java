package com.xcy.controller;

import com.xcy.pojo.User;
import com.xcy.service.UserService;
import com.xcy.utils.EmailYzmUtils;
import com.xcy.utils.MailUtils;
import com.xcy.utils.Md5Util;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: http://www/qfedu.com
 * @Date: 2019/7/18
 * @Description:
 * @version: 1.0
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("validEmail")
    @ApiOperation("检查email是否存在，如果不存在，发送验证码，返回值0代表邮箱已被注册，1代表发送成功,-1代表发送验证码失败")
    public String validEmail(String email, HttpServletRequest request){
        System.out.println(email+"++++++++++++++++++++++++++++++++++++++++++");
        int result = userService.validEmail(email);
        if (result > 0){
            return "0";//说明该邮箱已被注册
        } else {
            String yzm = EmailYzmUtils.getYzm();
            boolean flag = MailUtils.sendMail(email, "你好，你现在正在进行注册邂逅之恋的注册，验证码为" + yzm + "，15分钟内有效。", "邂逅之恋");
            if (flag){
                request.getSession().setAttribute("registerYzm",yzm);
                return "1";//发送验证码成功
            } else {
                return "-1";//发送验证码失败
            }

        }
    }

    @RequestMapping("register")
    @ApiOperation("注册功能,需要传入的值为邮箱和密码，注册成功返回该用户ID，注册失败返回-1")
    public int register(String email, String password) throws Exception {
        User user = new User();
        user.setEmail(email);
        user.setPassword(Md5Util.encodeByMd5(password));
        int result = userService.register(user);
        if (result > 0){
            User user1 = userService.selectUserByEmail(user.getEmail());
            return user1.getId();
        } else {
            return -1;
        }

    }


    @RequestMapping("login")
    @ApiOperation("登录功能,需要传入的值为邮箱和密码，登录成功返回该用户ID，登录失败返回-1")
    public int login(String email, String password) throws Exception {
        User user = new User();
        user.setEmail(email);
        user.setPassword(Md5Util.encodeByMd5(password));
        int ifLogin = userService.login(user);
        if (ifLogin > 0){
            User user1 = userService.selectUserByEmail(user.getEmail());
            return user1.getId();
        } else {
            return -1;
        }

    }
}
