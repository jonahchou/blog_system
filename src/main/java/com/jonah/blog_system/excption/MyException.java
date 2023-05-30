package com.jonah.blog_system.excption;
/**
 * 异常处理类
 * @author Administrator
 *
 */
public class MyException extends RuntimeException {
	private String errorCode ;

	/**
	 * 
	 */
	private static final long serialVersionUID = -4420532220573434869L;
	/**
	 * 
	 * @param errorCode 错误码
	 * @param errorMsg  错误信息
	 */
	public MyException(String errorCode, String errorMsg) {
		
		super(errorMsg);
		this.errorCode=errorCode;
	}
	/**
	 * 
	 *
	 */
	public MyException(String message) {
		super(message);
	}

	public String getErrorCode() {
		return errorCode;
	}
}


