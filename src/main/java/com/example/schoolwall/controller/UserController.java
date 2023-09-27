package com.example.schoolwall.controller;

import com.example.schoolwall.entity.Organization;
import com.example.schoolwall.entity.User;
import com.example.schoolwall.mapper.OrganizationMapper;
import com.example.schoolwall.mapper.UserMapper;
import com.example.schoolwall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController  //接收前段的请求，默认会将返回的对象数据转换成JSON格式
@RequestMapping("/user")
public class UserController {

    @Autowired   //spring的功能,自动把UserMapper实例化出来的对象注入注入userMapper
    private UserMapper userMapper;
    @Autowired
    private OrganizationMapper organizationMapper;

    @Value("${upload.path}")
    private String uploadPath;

    @PostMapping("/upload")
    public Result uploadFile(@RequestParam("uid") Long id,@RequestParam("uavatar") MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            String filePath = uploadPath + File.separator + originalFilename;
            File dest = new File(filePath);
            file.transferTo(dest);

            // 构建文件的URL
            String fileUrl = filePath; // 这里返回文件的绝对路径

            // 更新数据库中用户的uavazar字段
            userMapper.updateUserAvatar(id, fileUrl);

            // 返回成功响应
            return Result.success(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            // 返回上传失败的响应
            return Result.error();
        }
    }
    @Value("${upload.path2}")
    private String uploadPath2;
    @PostMapping("/upload2")
    public Result uploadFile2(@RequestParam("uid") Long id,@RequestParam("zavatar") MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            String filePath = uploadPath2 + File.separator + originalFilename;
            File dest = new File(filePath);
            file.transferTo(dest);

            // 构建文件的URL
            String fileUrl = filePath; // 这里返回文件的绝对路径

            // 更新数据库中组织的zavazar字段
            organizationMapper.updateUserAvatar(id, fileUrl);

            // 返回成功响应
            return Result.success(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            // 返回上传失败的响应
            return Result.error();
        }
    }
    @PostMapping("/query")  //管理员查询所有用户
    public Result query(){
        List<User> list =  userMapper.selectList(null);
        return Result.success(list);
    }

    @PostMapping("/query1")  //根据uid查询用户名称头像
    public Result query1(@RequestBody User user){
        List list =  userMapper.selectAll1(user.getUid());
        return Result.success(list);
    }

    @PostMapping("/query2")  //根据uid查询组织名称头像
    public Result query2(@RequestBody Organization organization){
        List list =  organizationMapper.selectAll2(organization.getUid());
        return Result.success(list);
    }

    @PostMapping("/delete") //管理员根据用户id删除该用户
    public Result delete(@RequestBody User user){
//        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        queryWrapper.eq("uid",idd);
        int cnt = userMapper.del(user.getUid());
        if(cnt>0)return Result.success();  //deleteById不是
        else return Result.error();
    }

    @PostMapping("/updpwd") //管理员重置某位用户的密码
    public Result upd(@RequestBody User user){
        int cnt = userMapper.update2(user.getUid(),user.getUpwd());
        if(cnt>0)return Result.success();  //deleteById不是
        else return Result.error();
    }


    @PostMapping("/insert")   //用户注册，插入用户信息，管理员添加用户
    public Result insert(@RequestBody User user){
        int cnt = userMapper.insert(user);
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

    @PostMapping("/oinsert")   //组织注册，插入组织信息，管理员添加组织
    public Result insert(@RequestBody Organization organization){
        int cnt = organizationMapper.insert(organization);
        int cnt1 = organizationMapper.upd(organization.getUid());
        if(cnt>0){
            return Result.success();
        } else return Result.error();
    }

}
