package com.example.schoolwall.controller;

import com.example.schoolwall.entity.Respon;
import com.example.schoolwall.entity.User;
import com.example.schoolwall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  //接收前段的请求，默认会将返回的对象数据转换成JSON格式
@RequestMapping("/user")
public class UserController {

    @Autowired   //spring的功能,自动把UserMapper实例化出来的对象注入注入userMapper
    private UserMapper userMapper;

//    @GetMapping("/query")
//    public List query(){
//       List<User> list =  userMapper.find();
//       System.out.println(list);
//        return list;
//    }
//    @PostMapping("insert")
//    public String insert(User user){
//        int cnt = userMapper.insert(user);
//        if(cnt>0){
//            return "插入成功";
//        } else return "插入失败";
//    }

    @GetMapping("/query")  //查询所有用户
    public List query(){

        List<User> list =  userMapper.selectList(null);
//        System.out.println(list);
        return list;
    }

    @PostMapping("insert")   //插入用户信息
    public Respon insert(User user){
        Respon respon = new Respon();
        int cnt = userMapper.insert(user);
        if(cnt>0){
            respon.setRes(1);
        } else respon.setRes(0);
        return respon;
    }
}
