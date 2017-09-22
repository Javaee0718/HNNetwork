package com.womow.henan.modules.sys.security.po;

import com.womow.henan.commons.bean.BaseEntity;

/**
 * @Description 角色表
 * @author CAI modules@163.com
 * @data 2017年8月7日下午8:54:02
 * @version V1.0
 */
public class BusRoleEntity extends BaseEntity {

	private String role;
	private String description;
	private Integer isDel;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}
