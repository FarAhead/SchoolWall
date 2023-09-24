package com.example.schoolwall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class Answer {
    @TableId(value = "aid",type = IdType.AUTO)
    private int aid; //回答id
    private int qid;  //问题id
    private long uid;  //回答者id
    private String acontent; //回答内容
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp atime = new Timestamp(System.currentTimeMillis()); //回答时间
    private int alikecount; //回答点赞次数
    private int reported;  //是否被举报
}
