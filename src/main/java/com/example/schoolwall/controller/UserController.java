package com.example.schoolwall.controller;

import com.example.schoolwall.entity.Organization;
import com.example.schoolwall.entity.User;
import com.example.schoolwall.mapper.OrganizationMapper;
import com.example.schoolwall.mapper.UserMapper;
import com.example.schoolwall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController  //接收前段的请求，默认会将返回的对象数据转换成JSON格式
@RequestMapping("/user")
public class UserController {

    @Autowired   //spring的功能,自动把UserMapper实例化出来的对象注入注入userMapper
    private UserMapper userMapper;
    @Autowired
    private OrganizationMapper organizationMapper;
    @PostMapping("/query")  //管理员查询所有用户
    public Result query(){
        List<User> list =  userMapper.selectList(null);
        return Result.success(list);
    }


    @PostMapping("/delete") //管理员根据用户id删除该用户
    public Result delete(@RequestBody User user){
//        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        queryWrapper.eq("uid",idd);
        int cnt = userMapper.del(user.getUid());
        if(cnt>0)return Result.success();  //deleteById不是
        else return Result.error();
    }

    @PostMapping("/updpwd") //管理员重置某位用户的密码
    public Result upd(@RequestBody User user){
        int cnt = userMapper.update2(user.getUid(),user.getUpwd());
        if(cnt>0)return Result.success();  //deleteById不是
        else return Result.error();
    }


    @PostMapping("/insert")   //用户注册，插入用户信息，管理员添加用户
    public Result insert(@RequestBody User user){
        int cnt = userMapper.insert(user);
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @PostMapping("/oinsert")   //组织注册，插入组织信息，管理员添加组织
    public Result insert(@RequestBody Organization organization){
        int cnt = organizationMapper.insert(organization);
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }
}
