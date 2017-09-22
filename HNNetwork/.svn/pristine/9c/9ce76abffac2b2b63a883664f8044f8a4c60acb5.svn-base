package com.womow.henan.commons.dao;

import java.util.List;
import java.util.Map;

/**
 * @author 蔡长盟
 * @description 数据持久层类
 * @version 2017年7月28日
 * @eamil modules@163.com
 */
public interface BaseDao<T> {

	/**
	 * 保存
	 * @param data
	 */
	public int save(T data)  throws Exception;
	
	/**
	 * 根据条件查询
	 * @param map
	 * @return
	 */
	public T find(Map<String, Object> map)  throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public T findById(int id)  throws Exception;
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<T> findAll(Map<String, Object> map)  throws Exception;
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<T> findAll() throws Exception;
	
	/**
	 * 条件查询数据总量
	 */
	public int dataCount(Map<String, Object> map) throws Exception;
	
	/**
	 * 修改用户信息
	 * @param data
	 * @return
	 */
	void update(T data) throws Exception;
	
	/**
	 * 删除用户
	 */
	public void delete(Map<String, Object> map) throws Exception;
}
