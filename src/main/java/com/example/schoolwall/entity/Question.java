package com.example.schoolwall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class Question {
    @TableId(value = "qid",type = IdType.AUTO)
    private int qid;
    private long uid;
    private String qtitle;
    private String qcontent;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp qtime = new Timestamp(System.currentTimeMillis());
    @TableField(exist = false)
    private User user;
//    @TableField(exist = false)
    private int qbrowsecount;  //浏览次数
    private int qlikecount;  //点赞次数
    private int qanswercount; //回答次数
    private int qcollectcount; //收藏次数
    private int qlabel;  //标签
    private int qreported;  //标签
}
