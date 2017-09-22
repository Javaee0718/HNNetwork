package com.womow.henan.modules.province.bean.po;

/**
 * @author 蔡长盟
 * @description b_dataTab pojo 各省市相应指标值实体类
 * @version 2017年7月31日
 * @eamil modules@163.com
 */
public class BusDataEntity extends BusProvinceEntity {

	private static final long serialVersionUID = 1L;
	
	private String moduleName;// 模块名称
	
	private String childQuotaName;// 分项指标名称
	
	private String avgValue; //指标平均值
	
	public String getAvgValue() {
		return avgValue;
	}
	public void setAvgValue(String avgValue) {
		this.avgValue = avgValue;
	}
	// 1:是;0:否
	private int isBigQuota; //是否是总指标
	
	
	public int getIsBigQuota() {
		return isBigQuota;
	}
	public void setIsBigQuota(int isBigQuota) {
		this.isBigQuota = isBigQuota;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getChildQuotaName() {
		return childQuotaName;
	}
	public void setChildQuotaName(String childQuotaName) {
		this.childQuotaName = childQuotaName;
	}
}
