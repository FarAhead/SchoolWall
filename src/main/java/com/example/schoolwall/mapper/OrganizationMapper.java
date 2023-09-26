package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.Organization;
import com.example.schoolwall.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrganizationMapper extends BaseMapper<Organization> {
    @Update("update organization set upwd=#{pwd} where uid=#{id} and zstudent=#{name} and zmail=#{mail}")
    public int update(int id,String name,String mail,String pwd);
    @Select("select * from organization where uid=#{uid}")
    public Organization selectById(long uid);
    @Update("update organization set utype=1 where uid=#{id}")
    public int upd(int id);
    @Delete("delete from organization where uid=#{idd}")
    public int del(int idd);
    @Select("select uid,zname,zavatar from organization where uid=#{id}")
    @Results({
            @Result(column = "zname",property = "zname"),
            @Result(column = "zavatar",property = "zavatar"),
    })
    List<Organization> selectAll2(long id);
}
