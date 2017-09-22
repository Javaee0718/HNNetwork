package com.womow.henan.modules.sys.user.service;

import java.util.List;
import java.util.Map;

import com.womow.henan.modules.sys.user.bean.dto.BusUserEntityDo;

public interface BusUserService {

	/**
	 * 查询所有用户,以创建时间降序排列
	 */
	public List<BusUserEntityDo> findAll(Map<String, Object> map) throws Exception;

	/**
	 * 查询数据总量
	 */
	public int dataCount() throws Exception;

	/**
	 * 添加用户的方法
	 * 
	 * @param user
	 * @return
	 */
	public void add(BusUserEntityDo user) throws Exception;

	/**
	 * 根据ID查询改用户
	 * 
	 * @param userId
	 * @return
	 */
	public BusUserEntityDo queryById(int userId) throws Exception;

	/**
	 * 查询该用户名称数据总量
	 */
	public int dataCountOfName(String username) throws Exception;

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	public void update(BusUserEntityDo user) throws Exception;

	/**
	 * 批量删除用户的方法
	 * 
	 * @param ids
	 */
	public void delete(int[] ids) throws Exception;

	/**
	 * 根据用户名查询该用户
	 * @param user
	 * @return
	 */
	public BusUserEntityDo findByUsername(BusUserEntityDo user) throws Exception ;
}
