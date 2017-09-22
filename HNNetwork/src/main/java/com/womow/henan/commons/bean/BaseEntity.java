package com.womow.henan.commons.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 蔡长盟
 * @description 实体类基类
 * @version 2017年8月4日
 * @eamil modules@163.com
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -4628502407962327435L;
	private Integer id; // 唯一标识
	private Integer createUserId; // 创建者ID
	private Date createDate; // 创建时间
	private Integer updateUserId; // 修改者ID
	private Date updateDate; // 修改时间
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
