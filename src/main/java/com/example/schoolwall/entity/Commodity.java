package com.example.schoolwall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class Commodity {
    private int cid;
    private float price;
    private long uid;
    private String cname;
    private String cavatar;
    private String description;  //描述
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp ctime = new Timestamp(System.currentTimeMillis());  //发布时间
    private int sold;  //是否被购买
    private int ctype; //商品类型
}
