package com.example.schoolwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolwall.entity.Organization;
import com.example.schoolwall.entity.Question;
import com.example.schoolwall.entity.User;
import org.apache.ibatis.annotations.*;

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

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(Long id);


    @Update("UPDATE user SET uavatar = #{avatarUrl} WHERE uid = #{userId}")
    void updateUserAvatar(@Param("userId") Long userId, @Param("avatarUrl") String avatarUrl);

    @Delete("delete from user where uid=#{uid}") //根据id删除某个用户
    public int del(long uid);
    @Update("update user set upwd=#{pwd} where uid=#{id} and uname=#{name} and umail=#{mail}") //修改密码
    public int update(long id,String name,String mail,String pwd);

    @Update("update user set upwd=#{pwd} where uid=#{id}") //管理员重置密码
    public int update2(long id,String pwd);

    @Select("select uid,uname,uavatar from user where uid=#{uid}")
    public User selectById(long uid);

    @Select("select uid,uname,uavatar from user where uid=#{id}")
    @Results({
            @Result(column = "uname",property = "uname"),
            @Result(column = "uavatar",property = "uavatar"),
    })
    List<User> selectAll1(long id);


}