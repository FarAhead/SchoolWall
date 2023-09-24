package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.Answer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AnswerMapper extends BaseMapper<Answer> {
    @Delete("delete from answer where aid=#{id}")
    public int del(int id);
    @Update("update answer set reported=0 where aid=#{id} ")  //撤销审核
    public int agre(int id);

}
