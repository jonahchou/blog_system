package com.jonah.blog_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jonah.blog_system.entity.User;

public interface UserService extends IService<User> {

    User login(String username, String password);

}