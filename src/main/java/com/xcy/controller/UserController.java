package com.xcy.controller;

import com.xcy.pojo.User;
import com.xcy.service.UserService;
import com.xcy.utils.EmailYzmUtils;
import com.xcy.utils.MailUtils;
import com.xcy.utils.Md5Util;
import io.swagger.annotations.ApiModelProperty;
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
        int result = userService.validEmail(email);
        if (result > 0){
            return "0";//说明该邮箱已被注册
        } else {
            String yzm = EmailYzmUtils.getYzm();
            boolean flag = MailUtils.sendMail(email, "你好，你现在正在进行邂逅之恋的注册，验证码为" + yzm + "，15分钟内有效。", "邂逅之恋");
            if (flag){
                request.getSession().setAttribute("registerYzm",yzm);
                return "1";//发送验证码成功
            } else {
                return "-1";//发送验证码失败
            }

        }
    }


    @RequestMapping("forgetPassword")
    @ApiModelProperty("忘记密码，检查email是否存在，如果不存在，返回-1，存在则发送验证码成功,返回1，发送验证码失败返回0")
    public int forgetPasword(String email,HttpServletRequest request){
        int result = userService.validEmail(email);
        if(result > 0){
            String yzm = EmailYzmUtils.getYzm();
            boolean flag = MailUtils.sendMail(email, "你好，你现在正在进行邂逅之恋的密码找回，验证码为" + yzm + "，15分钟内有效。", "邂逅之恋");
            if (flag){
                request.getSession().setAttribute("registerYzm",yzm);
                return 1;//发送验证码成功
            } else {
                return 0;//发送验证码失败
            }
        } else {
            return -1;//该账户不存在
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

    @RequestMapping("resetPassword")
    @ApiOperation("重置密码功能，需要传参 邮箱 密码 反回1表示重置成功,0表示失败")
    public int resetPassword(String email,String password) throws Exception {
        User user = new User();
        user.setEmail(email);
        user.setPassword(Md5Util.encodeByMd5(password));
        int isReset = userService.resetPassword(user);
        if (isReset > 0){
            return 1;
        } else {
            return 0;
        }
    }

}
