package com.example.schoolwall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.schoolwall.entity.Notice;
import com.example.schoolwall.entity.User;
import com.example.schoolwall.mapper.NoticeMapper;
import com.example.schoolwall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController  //接收前段的请求，默认会将返回的对象数据转换成JSON格式
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeMapper noticeMapper;

    @PostMapping("add")   //社群组织添加公告并提交审核
    public Result add(@RequestBody Notice notice){
        int cnt = noticeMapper.insert(notice);
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @PostMapping("query")   //社团组织查询所有自己已发布的公告
    public Result query(@RequestBody Notice notice){
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<Notice>();
        queryWrapper.eq("uid",notice.getUid());
        List<Notice> list = noticeMapper.selectList(queryWrapper);
        if(list.isEmpty()){
            return Result.error();
        } else return Result.success(list);
    }

    @PostMapping("del") //删除某个公告
    public Result del(@RequestBody Notice notice){
        int cnt = noticeMapper.del(notice.getNid());
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @PostMapping("queryall")   //查询所有审核过的公告
    public Result query(){
        List list =  noticeMapper.selectAll1();
        return Result.success(list);
    }

    @PostMapping("queryall2")   //管理员查询所有待审核的公告
    public Result query2(){
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<Notice>();
        queryWrapper.eq("checked",0);
        List<Notice> list =  noticeMapper.selectList(queryWrapper);
        return Result.success(list);
    }

    @PostMapping("agree") //审核通过
    public Result agr(@RequestBody Notice notice){
        int cnt = noticeMapper.agr(notice.getNid());
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @PostMapping("disagree") //审核不通过，删除
    public Result disagr(@RequestBody Notice notice){
        int cnt = noticeMapper.del(notice.getNid());
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @PostMapping("change") //修改公告内容
    public Result chang(@RequestBody Notice notice){
        int cnt = noticeMapper.chang(notice.getNid(),notice.getNcontent());
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }
}
