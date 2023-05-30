package com.jonah.blog_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jonah.blog_system.common.Content;
import com.jonah.blog_system.common.StringUtil;
import com.jonah.blog_system.entity.LiuYao;
import com.jonah.blog_system.entity.extend.LiuYaoExtend;
import com.jonah.blog_system.mapper.LiuYaoMapper;
import com.jonah.blog_system.service.LiuYaoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Jonah
 * @date 2023/5/29 17:16
 */
@Service
public class LiuYaoServiceImpl extends ServiceImpl<LiuYaoMapper, LiuYao> implements LiuYaoService {

    @Resource
    private LiuYaoMapper liuYaoMapper;

    @Override
    public void saveLiuYao(LiuYaoExtend liuYaoExtend) {
        liuYaoMapper.insert(liuYaoExtend);
    }

    @Override
    public void delLiuYao(Integer id) {
        LiuYao liuYao = liuYaoMapper.selectOne(new QueryWrapper<LiuYao>().eq("id", id));
        liuYao.setDel("1");
        liuYaoMapper.updateById(liuYao);
    }

    @Override
    public void updateLiuYao(LiuYaoExtend liuYaoExtend) {
        liuYaoMapper.updateById(liuYaoExtend);
    }

    @Override
    public Object findLiuYaoPage(LiuYaoExtend liuYaoExtend) {
        QueryWrapper<LiuYao> queryWrapper = new QueryWrapper<>();
        if (StringUtil.notEmpty(liuYaoExtend.getWenTi())) {
            queryWrapper.like("wen_ti", liuYaoExtend.getWenTi());
        }
        if (StringUtil.notEmpty(liuYaoExtend.getGuaMing())) {
            queryWrapper.like("gua_ming", liuYaoExtend.getGuaMing());
        }
        if (StringUtil.notEmpty(liuYaoExtend.getStartTime()) && StringUtil.notAllEmpty(liuYaoExtend.getEndTime())) {
            queryWrapper.between("create_time", liuYaoExtend.getStartTime().trim(), liuYaoExtend.getEndTime().trim());
        }
        queryWrapper.eq("del", Content.LOGIN_NOTDELETED);
        Page<LiuYao> liuYaoPage = liuYaoMapper.selectPage(new Page<>(liuYaoExtend.getPageNum(), liuYaoExtend.getPageSize()), queryWrapper);
        return liuYaoPage;
    }
}
