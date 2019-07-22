package com.xcy.controller;

import com.xcy.pojo.*;
import com.xcy.service.DynamicService;
import com.xcy.service.HotlistService;
import com.xcy.service.UserService;
import com.xcy.utils.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
@RequestMapping(value = "user",method = {RequestMethod.GET,RequestMethod.POST})
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    HotlistService hotlistService;
    @Autowired
    DynamicService dynamicService;
    @Autowired
    JedisClient jedisClient;

    @Value("${IMAGE_DIR}")
    String image_dir;
    @Value("${IMAGE_URL}")
    String image_url;

    @RequestMapping("validEmail")
    @ApiOperation("检查email是否存在，如果不存在，发送验证码，返回值0代表邮箱已被注册，1代表发送成功,-1代表发送验证码失败")
    public String validEmail(String email,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        int result = userService.validEmail(email);
        if (result > 0){
            return "0";//说明该邮箱已被注册
        } else {
            String yzm = EmailYzmUtils.getYzm();
            boolean flag = MailUtils.sendMail(email, "你好，你现在正在进行邂逅之恋的注册，验证码为" + yzm + "，15分钟内有效。", "邂逅之恋");
            if (flag){
                jedisClient.set(email,yzm);
                System.out.println(jedisClient.get(email)+"2222222222222");
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
                jedisClient.set(email,yzm);
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

        String registerYzm = jedisClient.get(email);

        boolean equals = registerYzm.equals(yzm);
        if (equals){
            User user = new User();
            user.setEmail(email);
            user.setPassword(Md5Util.encodeByMd5(password));
            int result = userService.register(user);
            if (result > 0){
                jedisClient.del(email);
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
    public int resetPassword(String email,String password,HttpServletResponse response,HttpServletRequest request) throws Exception {
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
    public String vaildYzm(String email,HttpServletResponse response, String yzm,HttpServletRequest request) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");

        String registerYzm = jedisClient.get(email);
        boolean equals = registerYzm.equals(yzm);
        if (equals) {
            jedisClient.del(email);
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

        return dynamicService.selectAllDynamic();
    }

    @RequestMapping("showDynamicById")
    @ApiOperation("展示当前用户的所有动态")
    public List<Dynamic> showDynamicById(int id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return dynamicService.selectAllDynamicById(id);
    }

    @RequestMapping("addDynamic")
    @ApiOperation("添加动态，需要数据：登录用户的ID，动态上传的图片，动态上传的内容.发布成功返回发布成功，失败返回发布失败")
    public String addDynamic(int userId, String dynamiccontent, HttpServletResponse response, MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Dynamic dynamic = new Dynamic();
        //定义文件名

        //1.获取原始文件名
        if (uploadFile != null){
            String fileName = "";
            String uploadFileName = uploadFile.getOriginalFilename();
            //2.截取文件扩展名
            String	extendName	= uploadFileName.substring(uploadFileName.lastIndexOf(".")+1, uploadFileName.length());
            //3.把文件加上随机数，防止文件重复
            String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();

            fileName = uuid+"."+extendName;

            System.out.println(fileName);
            //2.获取文件路径
            ServletContext context = request.getServletContext();
            String basePath = context.getRealPath("/uploads");
            //3.解决同一文件夹中文件过多问题
            String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            //4.判断路径是否存在
            File file = new File(image_dir + "/" + datePath);
            if(!file.exists()) {
                file.mkdirs();
            }
            //5.使用 MulitpartFile 接口中方法，把上传的文件写到指定位置
            uploadFile.transferTo(new File(file,fileName));
            String DynamicImgUrl = image_url+datePath + "/" +fileName;

            dynamic.setDynamicImgUrl(DynamicImgUrl);
        }
        dynamic.setDynamiccontent(dynamiccontent);
        dynamic.setUserId(userId);

        int result = dynamicService.addDynamic(dynamic);
        if (result > 0){
            return "发布成功";
        } else {
            return "发布失败";
        }
    }

    @RequestMapping("upDynamic")
    @ApiOperation("动态置顶，需要传参，需要置顶动态的id值，用户的userId，成功返回1，失败返回0")
    public int upDynamic(int id,HttpServletResponse response,int userId){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return dynamicService.upDynamic(id,userId);

    }

    @RequestMapping("updateDynamic")
    @ApiOperation("修改动态，需要数据：需要修改的动态的ID，修改成功返回修改成功，失败返回修改失败")
    public String updateDynamic(int id, String dynamiccontent, HttpServletResponse response, MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Dynamic dynamic = new Dynamic();
        //定义文件名

        //1.获取原始文件名
        if (uploadFile != null){
            String fileName = "";
            String uploadFileName = uploadFile.getOriginalFilename();
            //2.截取文件扩展名
            String	extendName	= uploadFileName.substring(uploadFileName.lastIndexOf(".")+1, uploadFileName.length());
            //3.把文件加上随机数，防止文件重复
            String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();

            fileName = uuid+"."+extendName;

            System.out.println(fileName);
            //2.获取文件路径
            ServletContext context = request.getServletContext();
            String basePath = context.getRealPath("/uploads");
            //3.解决同一文件夹中文件过多问题
            String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            //4.判断路径是否存在
            File file = new File(image_dir + "/" + datePath);
            if(!file.exists()) {
                file.mkdirs();
            }
            //5.使用 MulitpartFile 接口中方法，把上传的文件写到指定位置
            uploadFile.transferTo(new File(file,fileName));
            String DynamicImgUrl = image_url+datePath + "/" +fileName;

            dynamic.setDynamicImgUrl(DynamicImgUrl);
        }
        dynamic.setDynamiccontent(dynamiccontent);
        dynamic.setId(id);
        int result = dynamicService.updateDynamic(dynamic);
        if (result > 0){
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @RequestMapping("sendMessage")
    @ApiOperation("发送信息,需要传参:1发送人的ID,2收件人的ID，3发送的内容;返回1表示发送成功，0表示失败")
    public int sendMessage(Information information ,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return userService.sendMessage(information);
    }

    @RequestMapping("myNotReadSystemMessage")
    @ApiOperation("我的未读系统消息，传参：收件人ID，返回系统发送的未读消息")
    public List<Information> myNotReadSystemMessage(int addresser,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return userService.myNotReadSystemMessage(addresser);
    }

    @RequestMapping("myReadSystemMessage")
    @ApiOperation("我的已读系统消息，传参：收件人ID，返回系统发送的已读消息")
    public List<Information> myReadSystemMessage(int addresser,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return userService.myReadSystemMessage(addresser);
    }

    @RequestMapping("myReadUserMessage")
    @ApiOperation("我的已读用户消息，传参：收件人ID，返回用户发送的已读消息")
    public List<Information> myReadUserMessage(int addresser,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return userService.myReadUserMessage(addresser);
    }

    @RequestMapping("myNotReadUserMessage")
    @ApiOperation("我的未读用户消息，传参：收件人ID，返回系统发送的未读消息")
    public List<Information> myNotReadUserMessage(int addresser,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return userService.myNotReadUserMessage(addresser);
    }

    @RequestMapping("readMessage")
    @ApiOperation("读取信息功能,传入读取的信息ID，返回1表示已读状态，0表示读取失败")
    public int readMessage(int id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return userService.readMessage(id);
    }


    @RequestMapping("deleteDynamic")
    @ApiOperation("删除动态，传参动态的ID值，删除成功返回1，失败返回0")
    public int deleteDynamic(int id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return dynamicService.deleteDynamic(id);
    }

    @RequestMapping("updateUserInfo")
    @ApiOperation("个人中心修改成员信息，修改成功返回1，修改失败返回0")
    public int updateUserInfo(User user,HttpServletRequest request,HttpServletResponse response,MultipartFile uploadFile) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");

            if (uploadFile != null) {
                String fileName = "";
                //1.获取原始文件名
                String uploadFileName = uploadFile.getOriginalFilename();
                //2.截取文件扩展名
                String extendName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1, uploadFileName.length());
                //3.把文件加上随机数，防止文件重复
                String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();

                fileName = uuid + "." + extendName;

                System.out.println(fileName);
                //2.获取文件路径
                ServletContext context = request.getServletContext();
                String basePath = context.getRealPath("/uploads");
                //3.解决同一文件夹中文件过多问题
                String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                //4.判断路径是否存在
                File file = new File(image_dir + "/" + datePath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                //5.使用 MulitpartFile 接口中方法，把上传的文件写到指定位置
                uploadFile.transferTo(new File(file, fileName));
                user.setHeadportrait(image_url + datePath + "/" + fileName);
            }

        return userService.updateUserInfo(user);
    }

    @RequestMapping("editMate")
    @ApiOperation("编辑心仪对象信息，编辑成功返回1，修改失败返回0")
    public int editUserInfo(Mate mate,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        Mate mate1 = userService.selectMyMateById(mate.getId());
        if (mate1 != null){
            return userService.updateUserMate(mate);
        } else {
            return userService.addUserMate(mate);
        }
    }

    @RequestMapping("chooseMate")
    @ApiOperation("通过条件筛选心仪对象")
    public List<User> chooseUserInfo(Mate mate, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return userService.selectUserByMate(mate);

    }




}
