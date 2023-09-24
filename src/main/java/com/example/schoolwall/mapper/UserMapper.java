package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.Organization;
import com.example.schoolwall.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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

    @Delete("delete from user where uid=#{uid}") //根据id删除某个用户
    public int del(long uid);
    @Update("update user set upwd=#{pwd} where uid=#{id} and uname=#{name} and umail=#{mail}") //修改密码
    public int update(long id,String name,String mail,String pwd);

    @Update("update user set upwd=#{pwd} where uid=#{id}") //管理员重置密码
    public int update2(long id,String pwd);

    @Select("select * from user where uid=#{uid}")
    public User selectById(long uid);
}