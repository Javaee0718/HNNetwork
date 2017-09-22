package com.womow.henan.modules.province.bean.po;

import com.womow.henan.commons.bean.BaseEntity;

/**
 * @author 蔡长盟
 * @description 国网对标值表模板实体类
 * @version 2017年8月4日
 * @eamil modules@163.com
 */
public class BusValueEntity extends BaseEntity {

	private int year;// 年份
	private String partYear;// 季度
	private String quotaName; // 指标名称
	private String headDept; // 牵头部门
	private String quotaFullMark; // 指标满分
	private String publishCycle; // 发布周期
	private String quotaUnit; // 指标单位
	private String appraiseMethod; // 评价方式
	private String posAndNegDir; // 正反向
	private String attribute; // 属性
	private String nowYearTarGrade; // 当年目标段位
	private String nowYearTarScore; // 当年目标得分
	private String nowYearTarValue; // 当年目标值
	private String checkBaseLineGrade; // 考核底线段位
	private String checkBaseLineScore; // 考核底线得分
	private String quotaType; // 指标类别

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPartYear() {
		return partYear;
	}

	public void setPartYear(String partYear) {
		this.partYear = partYear;
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

	public String getQuotaFullMark() {
		return quotaFullMark;
	}

	public void setQuotaFullMark(String quotaFullMark) {
		this.quotaFullMark = quotaFullMark;
	}

	public String getPublishCycle() {
		return publishCycle;
	}

	public void setPublishCycle(String publishCycle) {
		this.publishCycle = publishCycle;
	}

	public String getQuotaUnit() {
		return quotaUnit;
	}

	public void setQuotaUnit(String quotaUnit) {
		this.quotaUnit = quotaUnit;
	}

	public String getAppraiseMethod() {
		return appraiseMethod;
	}

	public void setAppraiseMethod(String appraiseMethod) {
		this.appraiseMethod = appraiseMethod;
	}

	public String getPosAndNegDir() {
		return posAndNegDir;
	}

	public void setPosAndNegDir(String posAndNegDir) {
		this.posAndNegDir = posAndNegDir;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getNowYearTarGrade() {
		return nowYearTarGrade;
	}

	public void setNowYearTarGrade(String nowYearTarGrade) {
		this.nowYearTarGrade = nowYearTarGrade;
	}

	public String getNowYearTarScore() {
		return nowYearTarScore;
	}

	public void setNowYearTarScore(String nowYearTarScore) {
		this.nowYearTarScore = nowYearTarScore;
	}

	public String getNowYearTarValue() {
		return nowYearTarValue;
	}

	public void setNowYearTarValue(String nowYearTarValue) {
		this.nowYearTarValue = nowYearTarValue;
	}

	public String getCheckBaseLineGrade() {
		return checkBaseLineGrade;
	}

	public void setCheckBaseLineGrade(String checkBaseLineGrade) {
		this.checkBaseLineGrade = checkBaseLineGrade;
	}

	public String getCheckBaseLineScore() {
		return checkBaseLineScore;
	}

	public void setCheckBaseLineScore(String checkBaseLineScore) {
		this.checkBaseLineScore = checkBaseLineScore;
	}

	public String getQuotaType() {
		return quotaType;
	}

	public void setQuotaType(String quotaType) {
		this.quotaType = quotaType;
	}

}
