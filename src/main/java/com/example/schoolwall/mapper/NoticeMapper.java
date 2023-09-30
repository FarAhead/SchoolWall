package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {
    @Delete("delete from notice where nid=#{id}")
    public int del(int id);

    @Update("update notice set checked=1 where nid=#{id} ") //审核公告通过
    public int agr(int id);

    @Update("update notice set ncontent=#{ncontent} where nid=#{nid} ") //修改公告内容
    public int chang(int nid,String ncontent);

    @Select("select * from notice where checked=1")
    @Results({
            @Result(column = "nid",property = "nid"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "ntitle",property = "ntitle"),
            @Result(column = "ncontent",property = "ncontent"),
            @Result(column = "ntime",property = "ntime"),
            @Result(column = "uid",property = "organization",javaType = Organization.class,
                    one = @One(select = "com.example.schoolwall.mapper.OrganizationMapper.selectById")
            ),
    })
    List<Notice> selectAll1();
}
