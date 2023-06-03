package com.jonah.blog_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jonah.blog_system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    // 查询用户名
    User login(@Param("userName") String userName, @Param("passWord") String passWord);

}