package com.womow.henan.commons.constance;

/**
 * @author 蔡长盟
 * @description vo对象内的所需常量
 * @version 2017年7月28日
 * @eamil modules@163.com
 */
public enum ResponseCode {

	SUCCESS(1,"SUCCESS"),
	ERROR(0,"ERROR");
	
	private final int code;
	private final String message;
	
	private ResponseCode(int code,String message) {
		this.code=code;
		this.message=message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
