package com.jonah.blog_system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Jonah
 * @date 2023/5/29 17:03
 */

@Data
public class LiuYao {
    /**
     *
     */
    @TableId(value="id",type = IdType.AUTO)
    private Integer id;
    /**
     * 所占之事
     */
    private String wenTi;
    /**
     * 本卦加变卦
     */
    private String guaXiang;
    /**
     * 排盘
     */
    private String paiPan;
    /**
     * 解卦
     */
    private String duanGua;
    /**
     *
     */
    private String createTime;
    /**
     * 默认0是未删除，1是已删除
     */
    private String del;
    /**
     *
     */
    private String beiZhu;
}
