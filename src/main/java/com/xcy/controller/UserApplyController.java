package com.xcy.controller;

import com.xcy.pojo.User;
import com.xcy.service.UserApplyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2019/7/18.
 */
@Controller
@RequestMapping("/userApply")
public class UserApplyController {
    @Autowired
    private UserApplyService userApplyService;
    @RequestMapping("/selectAll")
    @ApiOperation("会比较看好吧")
    public String selectUserApply(Model model , User user){
        List<User> users = userApplyService.selectUserApply(user);
        model.addAttribute("list",users);
        return "userList";
    }
    @RequestMapping("/insertUserList")
    @ApiOperation("查询")
    public String insertUserList(User user){
        userApplyService.insertUserApply(user);
        return "redirect:/userApply/selectAll";
    }
    @RequestMapping("/insertUser")
    @ApiOperation("插入")
    public String insertUser(){
        return "insertUser";
    }




}
