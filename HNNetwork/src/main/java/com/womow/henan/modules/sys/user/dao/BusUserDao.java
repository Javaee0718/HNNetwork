package com.womow.henan.modules.sys.user.dao;

import java.util.List;

import com.womow.henan.commons.dao.BaseDao;
import com.womow.henan.modules.sys.user.bean.dto.BusUserEntityDo;

/**
 * @Description 用户DAO
 * @author CAI modules@163.com
 * @data 2017年8月7日下午9:25:30
 * @version V1.0
 */
public interface BusUserDao extends BaseDao<BusUserEntityDo> {

	/**
	 * 查询该用户的所有权限
	 * 
	 * @param id
	 * @return
	 */
	List<String> findAllPerms(Integer id);

	/**
	 * 查询该用户的所有角色
	 * @param id
	 * @return
	 */
	List<String> findRoleByUserId(Integer id);
}
