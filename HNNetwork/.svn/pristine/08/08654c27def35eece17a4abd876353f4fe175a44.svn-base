package com.womow.henan.modules.sys.user.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.womow.henan.modules.sys.security.dto.BusRoleEntityDo;
import com.womow.henan.modules.sys.security.po.BusRoleAuthorityEntity;
import com.womow.henan.modules.sys.security.utils.ShiroUtils;
import com.womow.henan.modules.sys.user.dao.BusRoleAuthorityDao;
import com.womow.henan.modules.sys.user.dao.BusRoleDao;
import com.womow.henan.modules.sys.user.service.BusRoleService;

@Service
@Transactional
public class BusRoleServiceImpl implements BusRoleService {

	@Autowired
	private BusRoleDao busRoleDao;
	@Autowired
	private BusRoleAuthorityDao busRoleAuthorityDao;

	public List<BusRoleEntityDo> findAll(Map<String, Object> params) throws Exception {

		return busRoleDao.findAll(params);
	}

	public BusRoleEntityDo findById(int id) throws Exception {

		return busRoleDao.findById(id);
	}

	public void update(BusRoleEntityDo role) throws Exception {
		Integer isDel = role.getIsDel();
		// 该角色禁用
		Map<String, Object> map = new HashMap<>();
		map.put("roleId", role.getId());
		// 断掉之前的关系
		busRoleAuthorityDao.delete(map);
		// 重新关联关系
		Integer[] authIds = role.getAuthIds();
		if (authIds != null && authIds.length > 0) {
			BusRoleAuthorityEntity roleAuth = new BusRoleAuthorityEntity();
			// Date date = new Date();
			// roleAuth.setCreateDate(date);
			// roleAuth.setUpdateDate(date);
			// roleAuth.setCreateUserId(ShiroUtils.getUserId());
			roleAuth.setRoleId(role.getId());
			roleAuth.setIsDel(1);
			for (int i = 0; i < authIds.length; i++) {
				roleAuth.setAuthorityId(authIds[i]);
				busRoleAuthorityDao.save(roleAuth);
			}
		}
		busRoleDao.update(role);
	}

	public List<BusRoleEntityDo> findOnAll() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("isDel", 1);
		return busRoleDao.findAll(map);
	}

	public void delete(int[] ids) throws Exception {
		if (ids != null && ids.length > 0) {
			Date date = new Date();
			BusRoleEntityDo role = new BusRoleEntityDo();
			role.setUpdateDate(date);
			role.setUpdateUserId(ShiroUtils.getUserId());
			role.setIsDel(0);
			for (int i = 0; i < ids.length; i++) {
				role.setId(ids[i]);
				busRoleDao.update(role);
			}
		}
	}

	public void save(BusRoleEntityDo role) throws Exception {
		Date date = new Date();
		role.setCreateUserId(ShiroUtils.getUserId());
		role.setCreateDate(date);
		role.setUpdateDate(date);
		role.setUpdateUserId(ShiroUtils.getUserId());
		busRoleDao.save(role);
		Integer roleId = role.getId();
		Integer[] authIds = role.getAuthIds();
		if (authIds != null && authIds.length > 0) {
			BusRoleAuthorityEntity roleAuth = new BusRoleAuthorityEntity();
			roleAuth.setRoleId(roleId);
			for (int i = 0; i < authIds.length; i++) {
				roleAuth.setAuthorityId(authIds[i]);
				roleAuth.setIsDel(1);
				busRoleAuthorityDao.save(roleAuth);
			}
		}
	}

	public int dataCount() throws Exception {
		return busRoleDao.dataCount(null);
	}

	public BusRoleEntityDo findByRole(String role) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("role", role);
		return busRoleDao.find(map);
	}
}
