package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CommodityMapper extends BaseMapper<Commodity> {
    @Update("update commodity set sold=1 where cid=#{id} ")  //撤销审核
    public int buy(int id);

    @Update("UPDATE commodity SET cavatar = #{avatarUrl} WHERE cid = #{userId}")
    void updateCAvatar(@Param("userId") Long userId, @Param("avatarUrl") String avatarUrl);
}
