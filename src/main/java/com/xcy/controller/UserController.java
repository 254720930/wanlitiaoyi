package com.xcy.controller;

import com.xcy.pojo.Dynamic;
import com.xcy.pojo.Hotlist;
import com.xcy.pojo.User;
import com.xcy.service.DynamicService;
import com.xcy.service.HotlistService;
import com.xcy.service.UserService;
import com.xcy.utils.EmailYzmUtils;
import com.xcy.utils.MailUtils;
import com.xcy.utils.Md5Util;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: http://www/qfedu.com
 * @Date: 2019/7/18
 * @Description:
 * @version: 1.0
 */

@RestController
@RequestMapping(value = "user",method = RequestMethod.POST)
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    HotlistService hotlistService;
    @Autowired
    DynamicService dynamicService;


    @RequestMapping("validEmail")
    @ApiOperation("检查email是否存在，如果不存在，发送验证码，返回值0代表邮箱已被注册，1代表发送成功,-1代表发送验证码失败")
    public String validEmail(String email, HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

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

    @RequestMapping("myAttention")
    @ApiOperation("我关注的，传参登录者id，返回我关注的列表人员")
    public List<User> myAttention(int id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<User> userList = userService.selectMyAttention(id);
        return userList;
    }

    @RequestMapping("myFocused")
    @ApiOperation("关注我的，传参登录者id，返回关注我的列表人员信息")
    public List<User> myFocused(int id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<User> userList = userService.selectMyFocused(id);
        return userList;
    }



    @RequestMapping("forgetPassword")
    @ApiOperation("忘记密码，检查email是否存在，如果不存在，返回-1，存在则发送验证码成功,返回1，发送验证码失败返回0")
    public int forgetPasword(String email,HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        int result = userService.validEmail(email);
        if(result > 0){
            String yzm = EmailYzmUtils.getYzm();
            boolean flag = MailUtils.sendMail(email, "你好，你现在正在进行邂逅之恋的密码找回，验证码为" + yzm + "，15分钟内有效。", "邂逅之恋");
            if (flag){
                request.getSession().setAttribute(email,yzm);
                return 1;//发送验证码成功
            } else {
                return 0;//发送验证码失败
            }
        } else {
            return -1;//该账户不存在
        }
    }


    @RequestMapping("register")
    @ApiOperation("注册功能,需要传入的值为邮箱和密码，验证码，注册成功返回该用户ID，注册失败返回-1,验证码错误返回－2")
    public int register(String email,HttpServletResponse response, String password,String yzm,HttpServletRequest request) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");

        Object registerYzm = request.getSession().getAttribute(email);
        boolean equals = registerYzm.equals(yzm);
        if (equals){
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
        } else {
            return -2;
        }
    }


    @RequestMapping("login")
    @ApiOperation("登录功能,需要传入的值为邮箱和密码，登录成功返回该用户ID，登录失败返回-1")
    public int login(String email, String password,HttpServletResponse response) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");

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
    public int resetPassword(String email,String password,HttpServletResponse response, String yzm,HttpServletRequest request) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");

        User user = new User();
        user.setEmail(email);
        user.setPassword(Md5Util.encodeByMd5(password));
        int isReset = userService.resetPassword(user);
        if (isReset > 0) {
            return 1;
        } else {
            return 0;
        }

    }

    @RequestMapping("vaildYzm")
    @ApiOperation("检验验证码是否正确，需要传参 邮箱 验证码， 成功则返回邮箱，不成功返回fail")
    public String vaildYzm(String email,String password,HttpServletResponse response, String yzm,HttpServletRequest request) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");

        Object registerYzm = request.getSession().getAttribute("registerYzm");
        boolean equals = registerYzm.equals(yzm);
        if (equals) {
            return email;
        } else {
            return "fail";
        }
    }

    @RequestMapping("showAllHotlist")
    @ApiOperation("展示所有的活动")
    public List<Hotlist> showAllHotlist(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return hotlistService.selectAllHotlist();
    }

    @RequestMapping("showUserById")
    @ApiOperation("通过用户登录的id，来获取该用户的信息，并返回用户信息")
    public User showUserById(int id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        User user = userService.selectUserById(id);
        return user;
    }

    @RequestMapping("apply")
    @ApiOperation("活动报名，需要传参，用户的ID，活动的id，报名成功返回1，报名失败返回0")
    public int apply(int userId,int hotlistId, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        int isApply = userService.apply(userId,hotlistId);


        return isApply;
    }



    @RequestMapping("showDynamic")
    @ApiOperation("展示所有动态")
    public List<Dynamic> showDynamic(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return userService.selectAllDynamic();
    }

    @RequestMapping("addDynamic")
    @ApiOperation("添加动态，需要数据：登录用户的ID，动态上传的图片，动态上传的内容.发布成功返回发布成功，失败返回发布失败")
    public String addDynamic(int userId, String dynamiccontent, HttpServletResponse response, MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");

        //定义文件名
        String fileName = "";
        //1.获取原始文件名
        String uploadFileName = uploadFile.getOriginalFilename();
        //2.截取文件扩展名
        String	extendName	= uploadFileName.substring(uploadFileName.lastIndexOf(".")+1, uploadFileName.length());
        //3.把文件加上随机数，防止文件重复
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();

        fileName = uuid+"."+extendName;

        System.out.println(fileName);
        //2.获取文件路径
        ServletContext context = request.getServletContext(); String basePath = context.getRealPath("/uploads");
        //3.解决同一文件夹中文件过多问题
        String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //4.判断路径是否存在
        File file = new File(basePath+"/"+datePath);
        if(!file.exists()) {
            file.mkdirs();
        }
        //5.使用 MulitpartFile 接口中方法，把上传的文件写到指定位置
        uploadFile.transferTo(new File(file,fileName));

        Dynamic dynamic = new Dynamic();
        dynamic.setDynamicImgUrl(fileName);
        dynamic.setDynamiccontent(dynamiccontent);
        dynamic.setUserId(userId);

        int result = dynamicService.addDynamic(dynamic);
        if (result > 0){
            return "发布成功";
        } else {
            return "发布失败";
        }
    }

}
