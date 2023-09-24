package com.example.schoolwall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class Notice {
    private int nid;
    private int uid;
    private int checked;  //默认为零，表示还没被审核
    private String ntitle;
    private String ncontent;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp ntime = new Timestamp(System.currentTimeMillis());
    private int nbrowsecount;
}
