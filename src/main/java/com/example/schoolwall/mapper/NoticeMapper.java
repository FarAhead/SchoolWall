package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {
    @Delete("delete from notice where nid=#{id}")
    public int del(int id);

    @Update("update notice set checked=1 where nid=#{id} ") //审核公告通过
    public int agr(int id);
}
