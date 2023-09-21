package com.example.schoolwall.entity;

import lombok.Data;

@Data
public class Organization {
    private String zname;  //组织名称
    private int uid; //组织代码，长四位
    private String zstudent; //负责人
    private String zphone; //联系电话
    private String upwd; //密码
    private String zmail; //邮箱
}
