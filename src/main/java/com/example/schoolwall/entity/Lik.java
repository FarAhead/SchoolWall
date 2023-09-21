package com.example.schoolwall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Lik {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private int qid;
    private long uid;

}
