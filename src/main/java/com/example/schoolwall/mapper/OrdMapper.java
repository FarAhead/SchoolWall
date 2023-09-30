package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.Commodity;
import com.example.schoolwall.entity.Ord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface OrdMapper extends BaseMapper<Ord> {

    @Update("update ord set obid=#{obd},ofinishdate=#{p} where cid=#{cd}")
    public int insert1(int cd, long obd,Timestamp p);

    @Update("update ord set price=#{price} where cid=#{cid}")
    public int up(int cid,float price);

    @Select("select oid,obid,osid,price,cname,description,cavatar,cid from ord where osid=#{osid}")
    public List<Ord> selectList1(long osid);
}
