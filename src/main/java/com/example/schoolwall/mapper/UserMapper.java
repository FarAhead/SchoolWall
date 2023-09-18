package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper

// public interface UserMapper {
//    @Select("select * from user")
//    public List<User> find();   //我们只需要声明，所有的实现都让mybatis来完成
//
//    @Insert("insert into user values (#{uID},#{uSex},#{uPwd},#{uMail},#{uType})")
//    public int insert(User user);
// }

public interface UserMapper extends BaseMapper<User> {   //mybatis plus 提供的继承类，里面有许多功能

}