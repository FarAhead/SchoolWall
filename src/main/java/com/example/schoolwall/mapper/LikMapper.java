package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.Lik;
import com.example.schoolwall.entity.Question;
import com.example.schoolwall.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    @Select("select * from lik where uid=#{uid}")
    @Results({
            @Result(column = "qid",property = "qid"),
            @Result(column = "uid",property = "uid"),
//            @Result(column = "id",property = "question",javaType = Question.class,
//                    one = @One(select = "com.example.schoolwall.mapper.QuestionMapper.selectById")
//            ),
            @Result(column = "uid",property = "user",javaType = User.class,
                    one = @One(select = "com.example.schoolwall.mapper.UserMapper.selectById")
            ),
    })
    List<Lik> selectAll2(long uid);
}
