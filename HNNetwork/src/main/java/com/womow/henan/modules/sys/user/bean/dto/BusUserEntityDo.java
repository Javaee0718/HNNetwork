package com.womow.henan.modules.sys.user.bean.dto;

import java.util.List;

import com.womow.henan.modules.sys.security.dto.BusRoleEntityDo;
import com.womow.henan.modules.sys.user.bean.po.BusUserEntity;

public class BusUserEntityDo extends BusUserEntity{

	private Integer roleId; //单个权限ID,前台显示用
	
	private Integer[] roleIds; //角色ID
	
	private List<String> roleDes; //角色描述
	
	private List<BusRoleEntityDo> roles; //角色集合
	
	
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public List<String> getRoleDes() {
		return roleDes;
	}

	public void setRoleDes(List<String> roleDes) {
		this.roleDes = roleDes;
	}

	public List<BusRoleEntityDo> getRoles() {
		return roles;
	}

	public void setRoles(List<BusRoleEntityDo> roles) {
		this.roles = roles;
	}

	public Integer[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Integer[] roleIds) {
		this.roleIds = roleIds;
	}
}
