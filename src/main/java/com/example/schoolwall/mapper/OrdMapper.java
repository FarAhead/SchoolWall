package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.Ord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;

@Mapper
public interface OrdMapper extends BaseMapper<Ord> {

    @Update("update ord set obid=#{obd},ofinishdate=#{p} where cid=#{cd}")
    public int insert1(int cd, long obd,Timestamp p);
}
