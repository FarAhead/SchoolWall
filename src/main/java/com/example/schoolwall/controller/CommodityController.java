package com.example.schoolwall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.schoolwall.entity.Commodity;
import com.example.schoolwall.entity.User;
import com.example.schoolwall.mapper.CommodityMapper;
import com.example.schoolwall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController  //默认会将返回的对象数据转换成JSON格式
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityMapper commodityMapper;

    @PostMapping("/add")   //用户发布商品
    public Result insert(@RequestBody Commodity commodity){
        int cnt = commodityMapper.insert(commodity);
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @PostMapping("/query")  //查询所有在售商品
    public Result query(){
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<Commodity>();
        queryWrapper.eq("sold",0);
        List<Commodity> list =  commodityMapper.selectList(queryWrapper);
        return Result.success(list);
    }


}