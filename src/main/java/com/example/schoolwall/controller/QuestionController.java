package com.example.schoolwall.controller;

import com.example.schoolwall.entity.Question;
import com.example.schoolwall.entity.Respon;
import com.example.schoolwall.entity.User;
import com.example.schoolwall.mapper.QuestionMapper;
import com.example.schoolwall.mapper.UserMapper;
import com.example.schoolwall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //默认会将返回的对象数据转换成JSON格式
@RequestMapping("/question")
public class QuestionController {
    @Autowired   //spring的功能,自动把UserMapper实例化出来的对象注入注入userMapper
    private QuestionMapper questionMapper;

    @PostMapping("/add")  //发布一个帖子
    public Result add(@RequestBody Question question){
        int cnt = questionMapper.insert(question);
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @GetMapping("/queryall")  //查询所有的帖子
    public Result query(){
        List<Question> list =  questionMapper.selectList(null);
        return Result.success(list);
    }


}
