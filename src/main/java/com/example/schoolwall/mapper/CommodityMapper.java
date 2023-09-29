package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.Commodity;
import com.example.schoolwall.entity.Organization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CommodityMapper extends BaseMapper<Commodity> {
    @Update("update commodity set sold=1 where cid=#{id} ")  //撤销审核
    public int buy(int id);

    @Update("update commodity set price=#{p} where cid=#{cid} ")  //修改价格
    public int up(int cid,double p);

    @Select("select * from commodity where cname=#{cname}")
    public Commodity getby(String cname);
    @Update("UPDATE commodity SET cavatar = #{avatarUrl} WHERE cid = #{userId}")
    void updateCAvatar(@Param("userId") Long userId, @Param("avatarUrl") String avatarUrl);
}
