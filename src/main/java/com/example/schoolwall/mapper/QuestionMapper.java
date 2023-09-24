package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.Question;
import com.example.schoolwall.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

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

    @Delete("delete from question where qid=#{id}")  //删除帖子
    public int del(int id);
}
