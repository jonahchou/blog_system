package com.jonah.blog_system.controller;

import com.alibaba.fastjson.JSON;
import com.jonah.blog_system.common.Result;
import com.jonah.blog_system.entity.User;
import com.jonah.blog_system.excption.MyException;
import com.jonah.blog_system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Jonah
 * @date 2023/5/31 11:55
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User user){
        Result json;
        String username = user.getUsername();
        String password = user.getPassword();
        try {
            User user1 = userService.login(username, password);
            json = Result.success("登录成功",user1);
        }catch (MyException e){
            log.info("************************业务处理异常**********************");
            log.info("异常信息：{}", e);
            json = Result.error("fail",e.getMessage());
        }catch (Exception e){
            log.warn("*************************非业务处理异常***********************");
            log.warn("异常信息：{}",e);
            json = Result.error("登录失败");
        }
        return JSON.toJSONString(json);
    }

}
