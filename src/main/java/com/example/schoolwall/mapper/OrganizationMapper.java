package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.Organization;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface OrganizationMapper extends BaseMapper<Organization> {
    @Update("update organization set upwd=#{pwd} where uid=#{id} and zstudent=#{name} and zmail=#{mail}")
    public int update(int id,String name,String mail,String pwd);

    @Update("update organization set utype=1 where uid=#{id}")
    public int upd(int id);
    @Delete("delete from organization where uid=#{idd}")
    public int del(int idd);
}
