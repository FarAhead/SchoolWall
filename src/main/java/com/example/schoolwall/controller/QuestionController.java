package com.example.schoolwall.controller;

import com.example.schoolwall.entity.Lik;
import com.example.schoolwall.entity.Question;
import com.example.schoolwall.mapper.LikMapper;
import com.example.schoolwall.mapper.QuestionMapper;
import com.example.schoolwall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //默认会将返回的对象数据转换成JSON格式
@RequestMapping("/question")
public class QuestionController {
    @Autowired   //spring的功能,自动把UserMapper实例化出来的对象注入注入userMapper
    private QuestionMapper questionMapper;
    @Autowired
    private LikMapper likMapper;
    @PostMapping("/add")  //发布一个帖子
    public Result add(@RequestBody Question question){
        int cnt = questionMapper.insert(question);
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @GetMapping("del") //删除某个帖子
    public Result del(@RequestBody Question question){
        int cnt = questionMapper.del(question.getQid());
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @GetMapping("/queryall")  //查询所有的帖子
    public Result query(){
        List<Question> list =  questionMapper.selectList(null);
        return Result.success(list);
    }


    @GetMapping("/browse") //点击查看，该帖子访问量+1
    public Result browse(@RequestBody Question question){
        int cnt = questionMapper.browse(question.getQid());
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }


    @PostMapping("/like") //点击喜欢，该帖子的喜欢人数加一，并放到自己的喜欢列表
    public Result lik(@RequestBody Lik li){
        int cnt = questionMapper.like(li.getQid());
        int cnt2 = likMapper.insert(li);
        if(cnt2>0){
            return Result.success();
        } else return Result.error();
    }

    @PostMapping("unlike") //取消喜欢
    public Result unlik(@RequestBody Lik li){
        int cnt = questionMapper.unlike(li.getQid());
        int cnt2 = likMapper.del(li.getQid());
        if(cnt2>0){
            return Result.success();
        } else return Result.error();
    }
    @GetMapping("/querylike")
    public Result li(){
        List<Lik> list = likMapper.selectList(null);
        return Result.success(list);
    }
}
