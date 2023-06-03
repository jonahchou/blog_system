package com.jonah.blog_system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jonah.blog_system.entity.User;
import com.jonah.blog_system.excption.MyException;
import com.jonah.blog_system.mapper.UserMapper;
import com.jonah.blog_system.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
        if (user == null) {
            throw new MyException("用户不存在");
        } else {
            User login = userMapper.login(username, password);
            if(login==null) {
                throw new MyException("账号或密码错误。");
            }
            return login;
        }
    }
}