package com.example.schoolwall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.schoolwall.entity.Notice;
import com.example.schoolwall.mapper.NoticeMapper;
import com.example.schoolwall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //接收前段的请求，默认会将返回的对象数据转换成JSON格式
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeMapper noticeMapper;

    @PostMapping("add")   //社群组织添加公告
    public Result add(@RequestBody Notice notice){
        int cnt = noticeMapper.insert(notice);
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @GetMapping("del") //删除某个公告
    public Result del(@RequestBody Notice notice){
        int cnt = noticeMapper.del(notice.getNid());
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @GetMapping("queryall")   //查询所有公告
    public Result query(){
        List<Notice> list =  noticeMapper.selectList(null);
//        System.out.println(list);
        return Result.success(list);
    }

    @GetMapping("query")   //社团组织查询所有自己已发布的公告
    public Result query(@RequestBody Notice notice){
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<Notice>();
        queryWrapper.eq("uid",notice.getUid());
        List<Notice> list = noticeMapper.selectList(queryWrapper);
        if(list.isEmpty()){
            return Result.error();
        } else return Result.success(list);
    }


}
