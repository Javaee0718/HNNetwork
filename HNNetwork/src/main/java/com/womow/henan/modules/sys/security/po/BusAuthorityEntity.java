package com.womow.henan.modules.sys.security.po;

import com.womow.henan.commons.bean.BaseEntity;

/**
 * @Description 权限实体类
 * @author CAI modules@163.com
 * @data 2017年8月7日下午8:54:41
 * @version V1.0
 */
public class BusAuthorityEntity extends BaseEntity {

	private String authority; //权限标识
	private String description; //权限描述
	private Integer isDel; //删除
	private String type; //类型
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
