package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.Lik;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikMapper extends BaseMapper<Lik> {
    @Insert("insert into like values(#{qid},#{uid})")
    int inser(Lik lik);
    @Delete("delete from lik where qid=#{id}")
    public int del(int id);
}
