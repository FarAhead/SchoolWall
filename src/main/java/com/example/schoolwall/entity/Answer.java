package com.example.schoolwall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class Answer {
    @TableId(value = "aid",type = IdType.AUTO)
    private int aid; //回答id
    private int qid;  //问题id
    private int auid;  //回答者id
    private String acontent; //回答内容
    private Timestamp atime; //回答时间
    private Timestamp alikecount; //回答点赞次数
}
