package com.example.schoolwall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.schoolwall.entity.Commodity;
import com.example.schoolwall.entity.Ord;
import com.example.schoolwall.mapper.CommodityMapper;
import com.example.schoolwall.mapper.OrdMapper;
import com.example.schoolwall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController  //默认会将返回的对象数据转换成JSON格式
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private OrdMapper ordMapper;
    @PostMapping("/add")   //用户发布商品
    public Result insert(@RequestBody Commodity commodity){
        int cnt = commodityMapper.insert(commodity);
        Ord ord1 = new Ord();
        ord1.setPrice(commodity.getPrice());
        ord1.setOsid(commodity.getUid());
        ord1.setCname(commodity.getCname());
        ord1.setDescription(commodity.getDescription());
        ord1.setCavatar(commodity.getCavatar());
        ord1.setCid(commodity.getCid());
        int cnt1 = ordMapper.insert(ord1);
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @Value("${upload.path3}")
    private String uploadPath;
    @PostMapping("/upload")
    public Result uploadFile(@RequestParam("cid") Long id,@RequestParam("cavatar") MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            String filePath = uploadPath + File.separator + originalFilename;
            String filePath2 = "http://localhost:8088/src/main/resources/commodity/"  + originalFilename;
            File dest = new File(filePath);
            file.transferTo(dest);

            // 构建文件的URL
            String fileUrl = filePath2; // 这里返回文件的绝对路径

            // 更新数据库中商品的cavazar字段
            commodityMapper.updateCAvatar(id, fileUrl);

            // 返回成功响应
            return Result.success(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            // 返回上传失败的响应
            return Result.error();
        }
    }
    @PostMapping("/query")  //查询所有在售商品
    public Result query(){
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<Commodity>();
        queryWrapper.eq("sold",0);
        List<Commodity> list =  commodityMapper.selectList(queryWrapper);
        return Result.success(list);
    }

    @PostMapping("/buy") //购买商品
    public Result buy(@RequestBody Ord order1){
        int cnt1 = commodityMapper.buy(order1.getCid());
        int cnt = ordMapper.insert1(order1.getCid(),order1.getObid(),order1.getOfinishdate());
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }


}
