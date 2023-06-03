package com.jonah.blog_system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Jonah
 * @date 2023/5/31 11:08
 */
@Data
@TableName("user")
public class User {

    private Integer id;

    private String username;

    private String password;

    private String uid;
}
