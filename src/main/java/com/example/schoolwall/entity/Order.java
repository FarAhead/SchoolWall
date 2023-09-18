package com.example.schoolwall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Order {
    @TableId(value = "oid",type = IdType.AUTO)
    private int oid;  //交易编号
    private int obid; //买方id
    private int osid; //卖方id
    private double oprice;  //交易金额
    private String oname; //商品名称
    private String odescription; //商品描述
    private String oimageurl; //商品图片
    private Timestamp ocreatedate; //交易创建时间
    private Timestamp ofinishdate; //交易完成时间

}
