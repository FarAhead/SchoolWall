package com.example.schoolwall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.schoolwall.entity.Lik;
import com.example.schoolwall.entity.Notice;
import com.example.schoolwall.entity.Question;
import com.example.schoolwall.entity.User;
import com.example.schoolwall.mapper.LikMapper;
import com.example.schoolwall.mapper.NoticeMapper;
import com.example.schoolwall.mapper.QuestionMapper;
import com.example.schoolwall.mapper.UserMapper;
import com.example.schoolwall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController  //默认会将返回的对象数据转换成JSON格式
@RequestMapping("/lik")
public class LikController {
    @Autowired
    private LikMapper likMapper;

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    @PostMapping("my")   //查询某人的收藏
    public Result query1(@RequestBody User user){
        List list = questionMapper.selectAll3(user.getUid());
        return Result.success(list);
    }
}
