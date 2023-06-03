package com.jonah.blog_system.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jonah.blog_system.common.Content;
import com.jonah.blog_system.common.StringUtil;
import com.jonah.blog_system.entity.LiuYao;
import com.jonah.blog_system.entity.extend.LiuYaoExtend;
import com.jonah.blog_system.mapper.LiuYaoMapper;
import com.jonah.blog_system.service.LiuYaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jonah
 * @date 2023/5/29 17:16
 */
@Service
public class LiuYaoServiceImpl extends ServiceImpl<LiuYaoMapper, LiuYao> implements LiuYaoService {

    @Resource
    private LiuYaoMapper liuYaoMapper;

    @Override
    public void saveOrUpdateLiuYao(LiuYaoExtend liuYaoExtend) {
        //为空则新建，不为空则修改
        if (liuYaoExtend.getId()==null) {
            liuYaoMapper.insert(liuYaoExtend);
        } else {
            liuYaoMapper.updateById(liuYaoExtend);
        }
    }

    @Override
    public void delLiuYao(List<Integer> ids) {
        for (Integer id : ids) {
            LiuYao liuYao = liuYaoMapper.selectOne(new QueryWrapper<LiuYao>().eq("id", id));
            liuYao.setDel("1");
            liuYaoMapper.updateById(liuYao);
        }

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
