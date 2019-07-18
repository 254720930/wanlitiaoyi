package com.xcy.controller;

import com.xcy.service.AdminService;
import com.xcy.utils.EmailYzmUtils;
import com.xcy.utils.MailUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: http://www/qfedu.com
 * @Date: 2019/7/18
 * @Description:
 * @version: 1.0
 */

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("validEmail")
    @ResponseBody
    @ApiOperation("检查email是否存在，如果不存在，发送验证码，返回值0代表邮箱已被注册，1代表发送成功,-1代表发送验证码失败")
    public String validEmail(String email,@ApiParam("用来获取session，不用传值") HttpServletRequest request){
        System.out.println(email+"++++++++++++++++++++++++++++++++++++++++++");
        int result = adminService.validEmail(email);
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
}
