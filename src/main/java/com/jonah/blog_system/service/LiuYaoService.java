package com.jonah.blog_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jonah.blog_system.entity.LiuYao;
import com.jonah.blog_system.entity.extend.LiuYaoExtend;

/**
 * @author Jonah
 * @date 2023/5/29 17:14
 */

public interface LiuYaoService extends IService<LiuYao> {
    //增
    void saveLiuYao(LiuYaoExtend liuYaoExtend);

    //删
    void delLiuYao(Integer id);

    //改
    void updateLiuYao(LiuYaoExtend liuYaoExtend);

    //查
    Object findLiuYaoPage(LiuYaoExtend liuYaoExtend);
}
