package com.jonah.blog_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jonah.blog_system.entity.LiuYao;
import com.jonah.blog_system.entity.extend.LiuYaoExtend;

import java.util.List;

/**
 * @author Jonah
 * @date 2023/5/29 17:14
 */

public interface LiuYaoService extends IService<LiuYao> {
    //增/改
    void saveOrUpdateLiuYao(LiuYaoExtend liuYaoExtend);

    //删
    void delLiuYao(List<Integer> ids);


    //查
    Object findLiuYaoPage(LiuYaoExtend liuYaoExtend);
}
