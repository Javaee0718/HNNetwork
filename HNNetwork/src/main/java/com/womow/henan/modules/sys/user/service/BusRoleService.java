package com.womow.henan.modules.sys.user.service;

import java.util.List;
import java.util.Map;

import com.womow.henan.modules.sys.security.dto.BusRoleEntityDo;

/**
 * @Description Role service
 * @author CAI modules@163.com
 * @data 2017年8月8日上午10:44:53
 * @version V1.0
 */
public interface BusRoleService {

	/**
	 * 查询所有的Role
	 * @return
	 */
	List<BusRoleEntityDo> findAll(Map<String, Object> params) throws Exception;

	/**
	 * 根绝ID查询改角色
	 * @param id
	 * @return
	 */
	BusRoleEntityDo findById(int id) throws Exception;

	/**
	 * 修改Role
	 * @param role
	 */
	void update(BusRoleEntityDo role) throws Exception;

	/**
	 * 查询所有再使用中的role
	 * @return
	 */
	List<BusRoleEntityDo> findOnAll() throws Exception;

	/**
	 * 删除角色(禁用)
	 * @param ids
	 */
	void delete(int[] ids) throws Exception;

	/**
	 * 添加角色
	 * @param role
	 * @throws Exception
	 */
	void save(BusRoleEntityDo role) throws Exception;

	/** 
	 * 查询数据总量
	 * @return
	 * @throws Exception
	 */
	public int dataCount() throws Exception;

	/**
	 * 根据role查询该对象
	 * @param role
	 * @return
	 */
	BusRoleEntityDo findByRole(String role)throws Exception;
}
