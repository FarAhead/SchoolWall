package com.example.schoolwall.mapper;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleCreateTableStatement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.Organization;
import com.example.schoolwall.entity.Question;
import com.example.schoolwall.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

    @Select("select * from question where qid=#{qid}")
    public List<Question>  selectById(int qid);
    @Update("update question set qbrowsecount=qbrowsecount+1 where qid= #{id}") //访问量加一
    public int browse(int id);
    @Update("update question set qlikecount=qlikecount+1 where qid= #{id}") //赞同加一
    public int like(int id);
    @Update("update question set qlikecount=qlikecount-1 where qid= #{id}") //取消赞同
    public int unlike(int id);
    @Update("update question set qcollectcount=qcollectcount+1 where qid= #{id}") //收藏加一
    public int coll(int id);
    @Update("update question set qcollectcount=qcollectcount-1 where qid= #{id}") //取消收藏
    public int uncoll(int id);

    @Update("update question set qanswercount=qanswercount+1 where qid= #{id}") //回答数加一
    public int rep(int id);
    @Update("update question set qanswercount=qanswercount-1 where qid= #{id}") //回答数减一
    public int unrep(int id);
    @Delete("delete from question where qid=#{id}")  //删除帖子
    public int del(int id);

    @Select("select * from question")
    @Results({
            @Result(column = "qid",property = "qid"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "qtitle",property = "qtitle"),
            @Result(column = "qcontent",property = "qcontent"),
            @Result(column = "qtime",property = "qtime"),
            @Result(column = "qbrowsecount",property = "qbrowsecount"),
            @Result(column = "qlikecount",property = "qlikecount"),
            @Result(column = "qanswercount",property = "qanswercount"),
            @Result(column = "qlabel",property = "qlabel"),
            @Result(column = "qcollectcount",property = "qcollectcount"),
            @Result(column = "uid",property = "user",javaType = User.class,
            one = @One(select = "com.example.schoolwall.mapper.UserMapper.selectById")
            ),
    })
    List<Question> selectAll();

    @Select("select * from question where uid=#{id}")
    @Results({
            @Result(column = "qid",property = "qid"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "qtitle",property = "qtitle"),
            @Result(column = "qcontent",property = "qcontent"),
            @Result(column = "qtime",property = "qtime"),
            @Result(column = "qbrowsecount",property = "qbrowsecount"),
            @Result(column = "qlikecount",property = "qlikecount"),
            @Result(column = "qanswercount",property = "qanswercount"),
            @Result(column = "qlabel",property = "qlabel"),
            @Result(column = "qcollectcount",property = "qcollectcount"),
            @Result(column = "uid",property = "user",javaType = User.class,
                    one = @One(select = "com.example.schoolwall.mapper.UserMapper.selectById")
            ),
    })
    List<Question> selectAll2(long id);

}
