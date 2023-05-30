package com.jonah.blog_system.common;
/**
 * String工具类
 * 
 * @Data 2015/5/25
 * @Atuh fang fei
 * @return
 */
public class StringUtil {
	
	/**
	 * 
	 * 不为空
	 */
	public static boolean notEmpty(String str){
		if(str==null) return false;
		else return !"".equals(str.trim());
	}
	
	
	/**
	 * 
	 * 不为null
	 */
	public static boolean notNull(String str){
		return str != null;
	}
	
	
	/**
	 * 都不为空
	 * @param str
	 * @return
	 */
	public static boolean allNotEmpty(String... str){
		if(str.length<1)return false;
		boolean flag=false;
		for (int i = 0; i < str.length; i++) {
			flag=notEmpty(str[i]);
			if(!flag)
				break;
		}
		return flag;
	}
	/**
	 * 都不为空
	 * @param str
	 * @return
	 */
	public static boolean notAllEmpty(String... str){
		if(str.length<1)return false;
		boolean flag=false;
		for (int i = 0; i < str.length; i++) {
			flag=notEmpty(str[i]);
			if(flag)
				break;
		}
		return flag;
	}
	
	/**
	 * 为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		
		if(str==null || "".equals(str.trim())) 
			return true;
		else 
			return false;
		
	}
	/**
	 * 为空
	 * @param str
	 * @return
	 */
	public static boolean allIsEmpty(String... str){
		
		if(str.length<1) return false;
		
		boolean flag=true;
		for (int i = 0; i < str.length; i++) {
			flag=isEmpty(str[i]);
			if(!flag)
				break;
		}
		return flag;
		
	}
	/**
	 * 
	 * 获取字符串中所有的数字字符串 如1a2b3v 返回的是123
	 * @param str
	 * @return
	 */
	public static String getIntStr(String str){
		
		StringBuffer newStr=new StringBuffer();
		char[] chars=str.toCharArray();
		
		for (int i = 0; i < chars.length; i++) {
			Character c=chars[i];
			if(c.toString().matches("\\d"))
				newStr.append(c);
		}
		return newStr.toString();
	}
	
	/**
	 * oldStr-xxxx{},xxxx{}
	 * rexStr-\\{\\}
	 * strs-{"aaa","bbb"}
	 * return -xxxxxaaa,xxxxbbb
	 * @param oldStr
	 * @param rexStr
	 * @param strs
	 * @return
	 */
	public static String replace(String oldStr,String rexStr,String[] strs){
		if(StringUtil.isEmpty(rexStr)) rexStr="\\{\\}";
		for (int i = 0; i < strs.length; i++) {
			if(strs[i]==null)
				oldStr=oldStr.replaceFirst(rexStr, "null");
			else
				oldStr=oldStr.replaceFirst(rexStr, strs[i]);
		}
		return oldStr;
	}

	public static String replace(String oldStr,String... strs){
		return replace(oldStr, null, strs);
	}

	//	 字符串转换成时间戳类型
	public static  String getDanHao(String type,int increameId){


		String danHao=null;
		if("hui_yi_bian_hao".equals(type)){
			danHao="hybh";
		}else if("xiang_mu_bian_hao".equals(type)){
			danHao="xmbh";
		}else if("xiang_mu_bian_hao".equals(type)){
			danHao="xmbh";
		}


		return danHao+StringUtil.toString(increameId, 8);
	}

	public static String  toString(Object obj,int length){
		if(obj==null )
			return null;
		else if(obj.toString().length()-length>=0){
			return obj.toString();
		}

		StringBuffer strBuffer=new StringBuffer();

		for (int i = 0; i <length-obj.toString().length(); i++) {
			strBuffer.append("0");
		}


		strBuffer.append(obj.toString());

		return strBuffer.toString();
	};
	
}
