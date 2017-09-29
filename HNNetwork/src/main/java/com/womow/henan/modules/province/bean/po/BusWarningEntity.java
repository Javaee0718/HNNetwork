package com.womow.henan.modules.province.bean.po;

import com.womow.henan.commons.bean.BaseEntity;

/**
 * 精益化指标预警信息统计实体类
 * @author root
 */
public class BusWarningEntity extends BaseEntity{

	private int warnYear; //年
	private int warnMonth; //月
	private String warnQuota; //预警一级指标名
	private String warnEndQuota; //预警末端指标名
	private String headDept; //牵头部门
	private String warnReason; //预警原因
	private String warnGrade; //预警等级 --> 等级分为1,2,3 共三个等级
	public int getWarnYear() {
		return warnYear;
	}
	public void setWarnYear(int warnYear) {
		this.warnYear = warnYear;
	}
	public int getWarnMonth() {
		return warnMonth;
	}
	public void setWarnMonth(int warnMonth) {
		this.warnMonth = warnMonth;
	}
	public String getWarnQuota() {
		return warnQuota;
	}
	public void setWarnQuota(String warnQuota) {
		this.warnQuota = warnQuota;
	}
	public String getWarnEndQuota() {
		return warnEndQuota;
	}
	public void setWarnEndQuota(String warnEndQuota) {
		this.warnEndQuota = warnEndQuota;
	}
	public String getHeadDept() {
		return headDept;
	}
	public void setHeadDept(String headDept) {
		this.headDept = headDept;
	}
	public String getWarnReason() {
		return warnReason;
	}
	public void setWarnReason(String warnReason) {
		this.warnReason = warnReason;
	}
	public String getWarnGrade() {
		return warnGrade;
	}
	public void setWarnGrade(String warnGrade) {
		this.warnGrade = warnGrade;
	}
}
