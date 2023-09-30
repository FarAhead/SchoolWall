package com.example.schoolwall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.schoolwall.entity.*;
import com.example.schoolwall.mapper.LikMapper;
import com.example.schoolwall.mapper.QuestionMapper;
import com.example.schoolwall.result.Constants;
import com.example.schoolwall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController  //默认会将返回的对象数据转换成JSON格式
@RequestMapping("/question")
public class QuestionController {
    @Autowired
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

    @PostMapping("del") //删除某个帖子
    public Result del(@RequestBody Question question){
        int cnt = questionMapper.del(question.getQid());
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @PostMapping("/queryall")  //查询所有的帖子
    public Result query(){
        List list =  questionMapper.selectAll();
        return Result.success(list);
    }

    @PostMapping("/queryself")  //查询所有某用户的帖子
    public Result query2(@RequestBody Question question){
        List list =  questionMapper.selectAll2(question.getUid());
        return Result.success(list);
    }

    @PostMapping("/find1") //查询某用户是否赞同该帖子
    public Result find1(@RequestBody Lik lik){
        Cnt cnt = new Cnt();
        QueryWrapper<Lik> queryWrapper1 = new QueryWrapper<Lik>();
        queryWrapper1.eq("qid",lik.getQid());
        queryWrapper1.eq("uid",lik.getUid());
        queryWrapper1.eq("typ",1);
        List<Lik> list2 = likMapper.selectList(queryWrapper1);
//        System.out.println(list2.get(0).getTyp());
        if(!list2.isEmpty()&&list2.get(0).getTyp()==1){
            cnt.setCnt1(1);
//            return Result.success(list2.get(0).getTyp());
        }
            QueryWrapper<Lik> queryWrapper2 = new QueryWrapper<Lik>();
            queryWrapper2.eq("qid",lik.getQid());
            queryWrapper2.eq("uid",lik.getUid());
            queryWrapper2.eq("typ",2);
            List<Lik> list1 = likMapper.selectList(queryWrapper2);
            if(!list1.isEmpty()&&list1.get(0).getTyp()==2){
                cnt.setCnt2(1);
//                return Result.success(list1.get(0).getTyp());
            }
        return Result.success(cnt);
    }

//    @PostMapping("/find2") //查询某用户是否收藏该帖子
//    public Result find2(@RequestBody Lik lik){
//        QueryWrapper<Lik> queryWrapper2 = new QueryWrapper<Lik>();
//        queryWrapper2.eq("qid",lik.getQid());
//        queryWrapper2.eq("uid",lik.getUid());
//        queryWrapper2.eq("typ",2);
//        List<Lik> list2 = likMapper.selectList(queryWrapper2);
//        if(!list2.isEmpty()&&list2.get(0).getTyp()==2){
//            return Result.success();
//        }
//        else
//            return Result.error();
//    }
    @PostMapping("/browse") //点击查看，该帖子访问量+1
    public Result browse(@RequestBody Question question){
        int cnt = questionMapper.browse(question.getQid());
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }


    @PostMapping("/like") //点击赞同，该帖子的赞同人数加一，并放到自己的赞同列表
    public Result lik(@RequestBody Lik li){
        int cnt = questionMapper.like(li.getQid());
        int cnt2 = likMapper.insert(li);
        int cnt1 = likMapper.update1(li.getQid(),li.getUid());
        if(cnt2>0){
            return Result.success();
        } else return Result.error();
    }

    @PostMapping("unlike") //取消赞同
    public Result unlik(@RequestBody Lik li){
        int cnt = questionMapper.unlike(li.getQid());
        int cnt2 = likMapper.del1(li.getQid());
        if(cnt2>0){
            return Result.success();
        } else return Result.error();
    }

    @PostMapping("/coll") //点击收藏，该帖子的收藏人数加一，并放到自己的收藏列表
    public Result coll(@RequestBody Lik li){
        int cnt = questionMapper.coll(li.getQid());
        int cnt2 = likMapper.insert(li);
        int cnt1 = likMapper.update2(li.getQid(),li.getUid());
        if(cnt2>0){
            return Result.success();
        } else return Result.error();
    }

    @PostMapping("uncoll") //取消收藏
    public Result uncoll(@RequestBody Lik li){
        int cnt = questionMapper.uncoll(li.getQid());
        int cnt2 = likMapper.del2(li.getQid());
        if(cnt2>0){
            return Result.success();
        } else return Result.error();
    }
    @PostMapping("query2")   //管理员查询所有被举报的帖子
    public Result query2(){
        List<Question> list =  questionMapper.selectAll4();
        return Result.success(list);
    }

    @PostMapping("agree") //撤销举报
    public Result agr(@RequestBody Question question){
        int cnt = questionMapper.agre(question.getQid());
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @PostMapping("rep") //举报某帖子
    public Result rep(@RequestBody Question question){
        int cnt = questionMapper.repo(question.getQid());
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }
}

