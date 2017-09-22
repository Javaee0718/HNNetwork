package com.womow.henan.modules.province.bean.po;

import com.womow.henan.commons.bean.BaseEntity;

/**
 * @Description 精益化指标实体类
 * @author CAI modules@163.com
 * @data 2017年9月17日下午8:54:47
 * @version V1.0
 */
public class BusPrecisionEntity extends BaseEntity {

	private Integer year; // 年
	private Integer month; // 月
	private String quotaName; // 一级指标名称
	private double quotaValue; // 一级指标值
	// private String quotaGrade; //段位
	private String headDept; // 牵头部门
	private String notEndQuotaName; // 非末端指标名称
	private double notEndQuotaValue; // 非末端指标值
	private String endQuotaName; // 末端指标名称
	private String endQuotaValue; // 末端指标值
	// private String quotaFullMark; // 指标满分
	// private String publishCycle; // 发布周期
	// private String attribute; // 属性

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getQuotaName() {
		return quotaName;
	}

	public void setQuotaName(String quotaName) {
		this.quotaName = quotaName;
	}

	public String getHeadDept() {
		return headDept;
	}

	public void setHeadDept(String headDept) {
		this.headDept = headDept;
	}

	public String getNotEndQuotaName() {
		return notEndQuotaName;
	}

	public void setNotEndQuotaName(String notEndQuotaName) {
		this.notEndQuotaName = notEndQuotaName;
	}

	public String getEndQuotaName() {
		return endQuotaName;
	}

	public void setEndQuotaName(String endQuotaName) {
		this.endQuotaName = endQuotaName;
	}

	public String getEndQuotaValue() {
		return endQuotaValue;
	}

	public void setEndQuotaValue(String endQuotaValue) {
		this.endQuotaValue = endQuotaValue;
	}

	public double getQuotaValue() {
		return quotaValue;
	}

	public void setQuotaValue(double quotaValue) {
		this.quotaValue = quotaValue;
	}

	public double getNotEndQuotaValue() {
		return notEndQuotaValue;
	}

	public void setNotEndQuotaValue(double notEndQuotaValue) {
		this.notEndQuotaValue = notEndQuotaValue;
	}

	// private String twoQuotaName; //二级指标
	// private String twoQuotaWeight; //二级指标权重
	// private String threeQuotaName; //三级指标
	// private String threeQuotaWeight; //三级指标权重
	// private String fourQuotaName; //四级指标
	// private String fourQuotaWeight; //四级指标权重
	// private String fiveQuotaName; //五级指标
	// private String fiveQuotaWeight; //五级指标
	// private String dataSource; //数据来源
	// private String notEndQuotaUnit; //非末端指标单位
	// private String endQuotaUnit; //末端指标单位
	// private String notEndQuotaValue; //非末端指标值

}
