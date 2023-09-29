package com.example.schoolwall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Lik {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private int qid;
    private int typ; //id跟qid之间的关系类型是1赞同还是2收藏
    private long uid;
    @TableField(exist = false)
    private Question question;

}
