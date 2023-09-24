package com.example.schoolwall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.schoolwall.entity.Answer;
import com.example.schoolwall.entity.Notice;
import com.example.schoolwall.mapper.AnswerMapper;
import com.example.schoolwall.mapper.QuestionMapper;
import com.example.schoolwall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController  //默认会将返回的对象数据转换成JSON格式
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @PostMapping("/reply") //回答一个帖子
    public Result repl(@RequestBody Answer answer){
        int cnt = answerMapper.insert(answer);
        int cnt1 =questionMapper.rep(answer.getQid());
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @PostMapping("query")   //查询某帖子下的所有回答
    public Result query(@RequestBody Answer answer){
        QueryWrapper<Answer> queryWrapper = new QueryWrapper<Answer>();
        queryWrapper.eq("qid",answer.getQid());
        List<Answer> list =  answerMapper.selectList(queryWrapper);
        return Result.success(list);
    }

    @PostMapping("query1")   //查询某用户的所有回答
    public Result query1(@RequestBody Answer answer){
        QueryWrapper<Answer> queryWrapper = new QueryWrapper<Answer>();
        queryWrapper.eq("uid",answer.getUid());
        List<Answer> list =  answerMapper.selectList(queryWrapper);
        return Result.success(list);
    }

    @PostMapping("query2")   //管理员查询所有被举报的回答
    public Result query2(){
        QueryWrapper<Answer> queryWrapper = new QueryWrapper<Answer>();
        queryWrapper.eq("reported",1);
        List<Answer> list =  answerMapper.selectList(queryWrapper);
        return Result.success(list);
    }

    @PostMapping("del")   //管理员或用户删除某回答
    public Result del(@RequestBody Answer answer){
        int cnt = answerMapper.del(answer.getAid());
        int cnt1 = questionMapper.unrep(answer.getQid());
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @PostMapping("agree") //撤销举报
    public Result agr(@RequestBody Answer answer){
        int cnt = answerMapper.agre(answer.getAid());
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

}


