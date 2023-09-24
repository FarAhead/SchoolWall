package com.example.schoolwall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.schoolwall.entity.Organization;
import com.example.schoolwall.entity.User;
import com.example.schoolwall.mapper.OrganizationMapper;
import com.example.schoolwall.mapper.UserMapper;
import com.example.schoolwall.result.Constants;
import com.example.schoolwall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController  //默认会将返回的对象数据转换成JSON格式
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrganizationMapper organizationMapper;
    //管理员账号就一个，登录的话可以直接在前端设置
    @PostMapping("/user")    //普通用户登录
    public Result login(@RequestBody User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("uid",user.getUid());
//        System.out.println("----------"+user.getUid()+"-----------------"+user.getUpwd());
        List<User> list = userMapper.selectList(queryWrapper);
        if (list.isEmpty()) {
//            System.out.println("error!--------------");
            return Result.error(Constants.CODE_210, "用户名不存在");  //用户名不存在
        } else {
            queryWrapper.eq("uid",user.getUid());
            queryWrapper.eq("upwd",user.getUpwd());
            List<User> list2 = userMapper.selectList(queryWrapper);
            if(list2.isEmpty()){
                return Result.error(Constants.CODE_220, "密码错误");  //密码错误
            }
            else
                return Result.success(list2.get(0)); //说明用户名跟密码都在数据库中,登录成功,返回该user
        }
    }

    //对于普通用户忘记密码，可通过输入基本信息等方式来重置密码。
    @PostMapping("/user/reset")
    public Result reset(@RequestBody User user){
        int cnt = userMapper.update(user.getUid(), user.getUname(), user.getUmail(), user.getUpwd());
        if(cnt>0) return Result.success();
        return Result.error();
    }

    @PostMapping("/org")    //组织登录
    public Result login(@RequestBody Organization organization){
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<Organization>();
        queryWrapper.eq("uid",organization.getUid());
        List<Organization> list = organizationMapper.selectList(queryWrapper);
        if (list.isEmpty()) {
            return Result.error(Constants.CODE_210, "组织不存在");  //组织不存在
        } else {
            queryWrapper.eq("uid", organization.getUid());
            queryWrapper.eq("upwd",organization.getUpwd());
            List<Organization> list2 = organizationMapper.selectList(queryWrapper);
            if(list2.isEmpty()){
                return Result.error(Constants.CODE_220, "密码错误");  //密码错误
            }
            else  return Result.success(list2.get(0));
        }
    }

    //对于组织忘记密码，可通过输入负责人，负责人邮箱，组织代码方式来重置密码。
    @PostMapping("/org/reset")
    public Result reset(@RequestBody Organization organization){
        int cnt = organizationMapper.update(organization.getUid(), organization.getZstudent(), organization.getZmail(),organization.getUpwd());
        if(cnt>0) return Result.success();
        return Result.error();
    }

}
