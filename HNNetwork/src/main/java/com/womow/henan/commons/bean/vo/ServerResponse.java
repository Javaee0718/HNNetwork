package com.womow.henan.commons.bean.vo;

import java.util.HashMap;

import com.womow.henan.commons.constance.ResponseCode;

/**
 * @author 蔡长盟
 * @description 视图层展示对象
 * @version 2017年7月28日
 * @eamil modules@163.com
 */
public class ServerResponse extends HashMap<String, String>{

	/** 状态码 1:成功,0:失败  */
	private int status;
	/** 提示信息  */
	private String msg;
	
	public ServerResponse() {
	}
	public ServerResponse(int status) {
		this.status = status;
	}
	
	public ServerResponse(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	public int getStatus() {
		return status;
	}
	public String getMsg() {
		return msg;
	}
	/**
	 * 判断操作状态是否成功
	 * @return
	 */
	public boolean isSuccess() {
		return this.status==ResponseCode.SUCCESS.getCode();
	}
	
	/** ====================== success start ========================== */
	public static ServerResponse createBySuccess(){
		return new ServerResponse(ResponseCode.SUCCESS.getCode());
	}
	public static ServerResponse createBySuccess(String msg){
		return new ServerResponse(ResponseCode.SUCCESS.getCode(),msg);
	}
	/** ====================== success end ========================== */
	
	/** ====================== error start ========================== */
	public static ServerResponse createByError(){
		return new ServerResponse(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
	}
	public static ServerResponse createByErrorMessage(String errorMessage){
		return new ServerResponse(ResponseCode.ERROR.getCode(),errorMessage);
	}
	/** ====================== error end ========================== */
	
	/** ====================== auto defined ========================== */
	public static ServerResponse createByCodeAndMessage(int code,String message){
		return new ServerResponse(code,message);
	}
}
