package com.example.schoolwall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class Ord {
    @TableId(value = "oid",type = IdType.AUTO)
    private int oid;  //交易编号
    private long obid; //买方id
    private long osid; //卖方id
    private double price;  //交易金额
    private String cname; //商品名称
    private int cid; //商品编号
    private String description; //商品描述
    private String cavatar; //商品图片
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp ofinishdate = new Timestamp(System.currentTimeMillis());
}
