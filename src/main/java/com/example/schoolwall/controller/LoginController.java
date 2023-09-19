package com.example.schoolwall.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.schoolwall.entity.Respon;
import com.example.schoolwall.entity.User;
import com.example.schoolwall.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController  //默认会将返回的对象数据转换成JSON格式
public class LoginController {

    @Autowired
    private LoginMapper loginMapper;

    @GetMapping("/login")
    public Respon login(int id, String pd){
        Respon respon = new Respon();
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("uid",id);
        List<User> list = loginMapper.selectList(queryWrapper);
        if (list.isEmpty()) {
            respon.setRes(1);  //用户名不存在
        } else {
            queryWrapper.eq("uid",id);
            queryWrapper.eq("upwd",pd);
            List<User> list2 = loginMapper.selectList(queryWrapper);
            if(list2.isEmpty()){
                respon.setRes(2);  //密码错误
            }
            else respon.setRes(3);;  //说明用户名跟密码都在数据库中,登录成功
            respon.setUser(list2.get(0));
        }
        return respon;
    }

}
