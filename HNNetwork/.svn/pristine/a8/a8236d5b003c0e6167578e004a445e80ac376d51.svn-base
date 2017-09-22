package com.womow.henan.modules.sys.user.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.PUT;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.womow.henan.commons.utils.BaseDataUtils;
import com.womow.henan.modules.sys.security.po.BusUserRoleEntity;
import com.womow.henan.modules.sys.security.utils.ShiroUtils;
import com.womow.henan.modules.sys.user.bean.dto.BusUserEntityDo;
import com.womow.henan.modules.sys.user.dao.BusUserDao;
import com.womow.henan.modules.sys.user.dao.BusUserRoleDao;
import com.womow.henan.modules.sys.user.service.BusUserService;

@Service
@Transactional
public class BusUserServiceImpl implements BusUserService {

	@Autowired
	private BusUserDao busUserDao;
	@Autowired
	private BusUserRoleDao busUserRoleDao;

	public List<BusUserEntityDo> findAll(Map<String, Object> map) throws Exception {
		List<BusUserEntityDo> users = busUserDao.findAll(map);
		return users;
	}

	public int dataCount() throws Exception {
		return busUserDao.dataCount(null);
	}

	public void add(BusUserEntityDo user) throws Exception {
		user.setCreateUserId(ShiroUtils.getUserId());
		user.setCreateDate(new Date());
		String password = user.getPassword();
		password = ShiroUtils.getPwdAndSecurity(password);
		user.setPassword(password);
		busUserDao.save(user);

		// 维护用户角色关系.
		Integer[] roleIds = user.getRoleIds();
		if (roleIds != null && roleIds.length > 0) {
			BusUserRoleEntity userRole = new BusUserRoleEntity();
			userRole.setIsDel(1);
			userRole.setUserId(user.getId());
			for (int i = 0; i < roleIds.length; i++) {
				userRole.setRoleId(roleIds[i]);
			}
			busUserRoleDao.save(userRole);
		}
	}

	public BusUserEntityDo queryById(int userId) throws Exception {
		BusUserEntityDo user = busUserDao.findById(userId);
		user.setPassword(ShiroUtils.getPwd(user.getPassword()));
		return user;
	}

	public int dataCountOfName(String username) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("username", username);
		return busUserDao.dataCount(map);
	}

	public void update(BusUserEntityDo user) throws Exception {
		// 禁用该用户
		user.setUpdateUserId(ShiroUtils.getUserId());
		user.setUpdateDate(new Date());
		user.setPassword(ShiroUtils.getPwdAndSecurity(user.getPassword()));
		// 断掉以前的角色
		Map<String, Object> map = new HashMap<>();
		map.put("userId", user.getId());
		busUserRoleDao.delete(map);
		// 维护新的角色
		Integer[] roleIds = user.getRoleIds();
		if (roleIds != null && roleIds.length > 0) {
			BusUserRoleEntity userRole = new BusUserRoleEntity();
			userRole.setUserId(user.getId());
			userRole.setIsDel(1);
			for (int i = 0; i < roleIds.length; i++) {
				userRole.setRoleId(roleIds[i]);
				busUserRoleDao.save(userRole);
			}
		}
		busUserDao.update(user);
	}

	public void delete(int[] ids) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("ids", ids);
		map.put("userId", ShiroUtils.getUserId());
		map.put("date", new Date());
		busUserDao.delete(map);
	}

	public BusUserEntityDo findByUsername(BusUserEntityDo user) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("username", user.getUsername());
		return busUserDao.find(map);
	}
}
