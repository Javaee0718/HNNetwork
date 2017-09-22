package com.womow.henan.commons.dao;

/**
 * 
 * @author 蔡长盟
 * @description baseDao子类
 * @version 2017年7月28日
 * @eamil modules@163.com
 */
public interface CurdDao<T> extends BaseDao{

	/**
	 * 查询
	 * @param data
	 * @return
	 */
	T get(T data);
	
	/**
	 * 添加
	 * @param data
	 * @return
	 */
	int insert(T data);
	
}
