package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.Lik;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LikMapper extends BaseMapper<Lik> {

    @Delete("delete from lik where qid=#{id} and typ=1")  //取消赞同
    public int del1(int id);

    @Delete("delete from lik where qid=#{id} and typ=2")  //取消收藏
    public int del2(int id);

    @Update("update lik set typ=1 where qid=#{qd} and uid=#{ud}") //赞同
    public int update1(int qd,long ud);

    @Update("update lik set typ=2 where qid=#{qd} and uid=#{ud}") //收藏
    public int update2(int qd,long ud);
}
