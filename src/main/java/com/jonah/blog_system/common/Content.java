package com.jonah.blog_system.common;

/**
 *
 */
public class Content {


	public static String USER_INFO="userInfo";

	public static String DEL_SUCCESS="删除成功";
	public static String FIND_SUCCESS="查询成功";
	public static String INSERT_SUCCESS="添加成功";
	public static String MOD_SUCCESS="修改成功";
	public static String CAOZUO_SUCCESS="操作成功";
	public static String DAORU_SUCCESS="导入成功";
	public static String DAOCHU_SUCCESS="导出成功";
	public static Integer LOGIC_DELETED=1;
	public static Integer LOGIN_NOTDELETED=0;
	public static String NOT_FOUND="404";
    public static String NOT_FOUND_MESSAGE="该会议已被删除，无法继续查看或编辑";


//	会议模块
	public static String MEETING_SAVE_SUCCESS = "会议保存成功";


	//系统错误提示
	public static String SYS_ERROR="系统出错，请联系相关技术人员";
	public static String DATABASE_ERROR="数据库异常，请刷新后重试";

	//	用户登录管理员
	public static String USER_MANNAGER="1";
	// 用户登录普通用户
	public static String USER_NORMAL="2";
	//	会议状态--草稿
	public static Integer MEETING_CAOGAO=1;
	//	会议状态--完成
	public static Integer MEETING_WANCHENG=0;
	// 人员类型--专家
	public static Integer RENYUAN_ZHUANJIA = 1;
	public static String RENYUAN_ZHUANJIA_S = "1";
	// 人员类型--课题组
	public static String RENYUAN_KETIZU = "2";
	//参会人员组长
	public static Integer RENYUAN_ZUZHANG = 1;
	//参会人员非组长
	public static Integer RENYUAN_NOT_ZUZHANG = 0;
	public static String  RENYUAN_BEIZHU_ZUZHANG = "组长";

	//计算税率的基数800
	public static Integer BASE_NUM= 800;
	//计算税率的倍数0.25
	public static  Double BASE_BEILV = 0.25;
	//计算税率的固定减数
	public static Integer BASE_JIANSHU = 200;

	//计算天数，0是半天，1是全天。2是两天，2.5是三天
	public static String TIANSHU_BANTIAN = "0";

	public static String TIANSHU_QUANTIAN = "1";

	public static String TIANSHU_LIANGTIAN = "2";

	public static String TIANSHU_SANTIAN = "2.5";
	public static Double BEI_LV_LINGDIANWU = 0.5;
	public static Double BEI_LV_JI_SHU = 2.0;

	//模块-
	public static String MUKUAI_HUIYI="会议信息";
	public static String MUKUAI_RENYUAN="人员信息";
	public static String MUKUAI_XIANGMU="项目信息";
	public static String MUKUAI_ZHICHENG="职称信息";

	//职称档位
	public static String ZHICHENG_FIRST="第一档";
	public static String ZHICHENG_SECOND="第二档";

	//是否打印专家费
	public static String PRINTJINE="1";
	public static String NOPRINTJINE="2";

	//表格导入空值：默认值为  待完善
	public static String DAI_WAN_SHAN = "待完善";


}
