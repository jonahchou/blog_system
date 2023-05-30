package com.jonah.blog_system.entity.extend;

import com.jonah.blog_system.entity.LiuYao;
import lombok.Data;

/**
 * @author Jonah
 * @date 2023/5/29 17:06
 */
@Data
public class LiuYaoExtend extends LiuYao {
    //    页数
    public Integer pageNum;
    //    页大小
    public Integer pageSize;
    //查询开始时间
    public String StartTime;
    //结束时间
    public String EndTime;
}
