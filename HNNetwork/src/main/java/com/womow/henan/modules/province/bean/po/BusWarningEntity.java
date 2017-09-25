package com.womow.henan.modules.province.bean.po;

/**
 * 精益化指标预警实体类
 * @author root
 */

public class BusWarningEntity {

	private int id;
	private int year;
	private int month;
	private String headDept;
	private String quotaName;
	private double quotaValue;
	private String notEndQuotaName;
	private double notEndQuotaValue;
	private String endQuotaName;
	private double endQuotaValue;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getHeadDept() {
		return headDept;
	}
	public void setHeadDept(String headDept) {
		this.headDept = headDept;
	}
	public String getQuotaName() {
		return quotaName;
	}
	public void setQuotaName(String quotaName) {
		this.quotaName = quotaName;
	}
	public double getQuotaValue() {
		return quotaValue;
	}
	public void setQuotaValue(double quotaValue) {
		this.quotaValue = quotaValue;
	}
	public String getNotEndQuotaName() {
		return notEndQuotaName;
	}
	public void setNotEndQuotaName(String notEndQuotaName) {
		this.notEndQuotaName = notEndQuotaName;
	}
	public double getNotEndQuotaValue() {
		return notEndQuotaValue;
	}
	public void setNotEndQuotaValue(double notEndQuotaValue) {
		this.notEndQuotaValue = notEndQuotaValue;
	}
	public String getEndQuotaName() {
		return endQuotaName;
	}
	public void setEndQuotaName(String endQuotaName) {
		this.endQuotaName = endQuotaName;
	}
	public double getEndQuotaValue() {
		return endQuotaValue;
	}
	public void setEndQuotaValue(double endQuotaValue) {
		this.endQuotaValue = endQuotaValue;
	}
}
