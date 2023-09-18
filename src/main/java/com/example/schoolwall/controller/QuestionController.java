package com.example.schoolwall.controller;

import com.example.schoolwall.entity.Question;
import com.example.schoolwall.entity.Respon;
import com.example.schoolwall.entity.User;
import com.example.schoolwall.mapper.QuestionMapper;
import com.example.schoolwall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  //默认会将返回的对象数据转换成JSON格式
@RequestMapping("/question")
public class QuestionController {
    @Autowired   //spring的功能,自动把UserMapper实例化出来的对象注入注入userMapper
    private QuestionMapper questionMapper;

    @PostMapping("/add")  //新建一个帖子
    public Respon add(Question question){
        Respon respon = new Respon();
        int cnt = questionMapper.insert(question);
        if(cnt>0){
            respon.setRes(1);
        } else respon.setRes(0);
        return respon;
    }

    @GetMapping("/queryall")  //查询所有的帖子
    public List query(){
        List<Question> list =  questionMapper.selectList(null);
        return list;
    }


}
