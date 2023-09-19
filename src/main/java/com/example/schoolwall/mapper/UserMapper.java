package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper

// public interface UserMapper {
//    @Select("select * from user")
//    public List<User> find();   //我们只需要声明，所有的实现都让mybatis来完成
//
//    @Insert("insert into user values (#{uID},#{uSex},#{uPwd},#{uMail},#{uType})")
//    public int insert(User user);
// }

public interface UserMapper extends BaseMapper<User> {   //mybatis plus 提供的继承类，里面有许多功能
    @Update("update user set upwd=#{pwd} where uid=#{id} and uname=#{name} and umail=#{mail}")
    public int update(int id,String name,String mail,String pwd);

    @Delete("delete from user where uid=#{uid}")
    public int del(int idd);
}