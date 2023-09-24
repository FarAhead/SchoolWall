package com.example.schoolwall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.lang.reflect.Type;
@Data
public class User {
    @TableId(value = "uid",type = IdType.AUTO)
    private long uid;
    private String uname;
    private String usex;
    private String upwd;
    private String umail;
    private String uavatar;  //头像
    private int utype;

}
