package com.example.schoolwall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.lang.reflect.Type;
@Data
public class User {
    @TableId(value = "uid",type = IdType.AUTO)
    private int uid;
    private String uname;
    private String usex;
    private String upwd;
    private String umail;
    private int utype;

//    public int getUid() {
//        return uid;
//    }
//
//    public void setUid(int uid) {
//        this.uid = uid;
//    }
//
//    public String getUsex() {
//        return usex;
//    }
//
//    public void setUsex(String usex) {
//        this.usex = usex;
//    }
//
//    public String getUpwd() {
//        return upwd;
//    }
//
//    public void setUpwd(String upwd) {
//        this.upwd = upwd;
//    }
//
//    public String getUmail() {
//        return umail;
//    }
//
//    public void setUmail(String umail) {
//        this.umail = umail;
//    }
//
//    public int getUtype() {
//        return utype;
//    }
//
//    public void setUtype(int utype) {
//        this.utype = utype;
//    }
}
