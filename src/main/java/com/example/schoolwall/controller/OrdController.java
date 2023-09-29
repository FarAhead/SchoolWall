package com.example.schoolwall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.schoolwall.entity.Notice;
import com.example.schoolwall.entity.Ord;
import com.example.schoolwall.mapper.OrdMapper;
import com.example.schoolwall.mapper.OrganizationMapper;
import com.example.schoolwall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController  //接收前段的请求，默认会将返回的对象数据转换成JSON格式
@RequestMapping("/order")
public class OrdController {
    @Autowired
    private OrdMapper ordMapper;
    @PostMapping("query")   //管理员查询所有订单
    public Result query(){
        List<Ord> list = ordMapper.selectList(null);
        if(list.isEmpty()){
            return Result.error();
        } else return Result.success(list);
    }
    @PostMapping("del")   //删除某一订单
    public Result del(@RequestBody Ord ord){
        QueryWrapper<Ord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("oid",ord.getOid());
        int cnt = ordMapper.delete(queryWrapper);
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @PostMapping("query1")   //某用户的买入
    public Result query1(@RequestBody Ord ord){
        QueryWrapper<Ord> queryWrapper = new QueryWrapper<Ord>();
        queryWrapper.eq("obid",ord.getObid());
        List<Ord> list = ordMapper.selectList(queryWrapper);
        if(list.isEmpty()){
            return Result.error();
        } else return Result.success(list);
    }
    @PostMapping("query2")   //某用户的卖出
    public Result query2(@RequestBody Ord ord){
        QueryWrapper<Ord> queryWrapper = new QueryWrapper<Ord>();
        queryWrapper.eq("osid",ord.getOsid());
        List<Ord> list = ordMapper.selectList(queryWrapper);
        if(list.isEmpty()){
            return Result.error();
        } else return Result.success(list);
    }
}
