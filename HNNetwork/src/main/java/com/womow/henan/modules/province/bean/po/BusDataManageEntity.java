package com.womow.henan.modules.province.bean.po;

/**
 * @Description 国网体系数据管理实体类
 * @author CAI modules@163.com
 * @data 2017年8月11日下午5:43:23
 * @version V1.0
 */
public class BusDataManageEntity extends BusValueEntity {

	private String moduleName; // 模块名称
	private String childQuotaName; // 总指标与分项指标名称
	private int avgValue; //平均值
	// 1:是;0:否
	private int isBigQuota; // 是否是总指标
	// 实际值
	private double henanValue;
	private double beijingValue;
	private double tianjinValue;
	private double hebeiValue;
	private double yibeiValue;
	private double shanxiValue;
	private double shandongValue;
	private double shanghaiValue;
	private double jiangsuValue;
	private double zhejiangValue;
	private double anhuiValue;
	private double fujianValue;
	private double hubeiValue;
	private double hunanValue;
	private double jiangxiValue;
	private double sichuanValue;
	private double chongqingValue;
	private double liaoningValue;
	private double jilinValue;
	private double heilongjiangValue;
	private double mengdongValue;
	private double shanxi1Value;
	private double gansuValue;
	private double qinghaiValue;
	private double ningxiaValue;
	private double xinjiangValue;

	// 实际得分
	private double beijingScore;// 北京
	private double tianjinScore;// 天津
	private double hebeiScore;// 河北
	private double yibeiScore;// 翼北
	private double shanxiScore;// 山西
	private double shandongScore;// 山东
	private double shanghaiScore;// 上海
	private double jiangsuScore;// 江苏
	private double zhejiangScore;// 浙江
	private double anhuiScore;// 安徽
	private double fujianScore;// 福建
	private double hubeiScore;// 湖北
	private double hunanScore;// 湖南
	private double henanScore;// 河南
	private double jiangxiScore;// 江西
	private double sichuanScore;// 四川
	private double chongqingScore;// 重庆
	private double liaoningScore;// 辽宁
	private double jilinScore;// 吉林
	private double heilongjiangScore;// 黑龙江
	private double mengdongScore;// 蒙东
	private double shanxi1Score;// 陕西
	private double gansuScore;// 甘肃
	private double qinghaiScore;// 青海
	private double ningxiaScore;// 宁夏
	private double xinjiangScore;// 新疆

	// 实际段位
	private double henanGrade;
	private double beijingGrade;
	private double tianjinGrade;
	private double hebeiGrade;
	private double yibeiGrade;
	private double shanxiGrade;
	private double shandongGrade;
	private double shanghaiGrade;
	private double jiangsuGrade;
	private double zhejiangGrade;
	private double anhuiGrade;
	private double fujianGrade;
	private double hubeiGrade;
	private double hunanGrade;
	private double jiangxiGrade;
	private double sichuanGrade;
	private double chongqingGrade;
	private double liaoningGrade;
	private double jilinGrade;
	private double heilongjiangGrade;
	private double mengdongGrade;
	private double shanxi1Grade;
	private double gansuGrade;
	private double qinghaiGrade;
	private double ningxiaGrade;
	private double xinjiangGrade;

	
	public int getAvgValue() {
		return avgValue;
	}

	public void setAvgValue(int avgValue) {
		this.avgValue = avgValue;
	}

	public double getHenanValue() {
		return henanValue;
	}

	public void setHenanValue(double henanValue) {
		this.henanValue = henanValue;
	}

	public double getBeijingValue() {
		return beijingValue;
	}

	public void setBeijingValue(double beijingValue) {
		this.beijingValue = beijingValue;
	}

	public double getTianjinValue() {
		return tianjinValue;
	}

	public void setTianjinValue(double tianjinValue) {
		this.tianjinValue = tianjinValue;
	}

	public double getHebeiValue() {
		return hebeiValue;
	}

	public void setHebeiValue(double hebeiValue) {
		this.hebeiValue = hebeiValue;
	}

	public double getYibeiValue() {
		return yibeiValue;
	}

	public void setYibeiValue(double yibeiValue) {
		this.yibeiValue = yibeiValue;
	}

	public double getShanxiValue() {
		return shanxiValue;
	}

	public void setShanxiValue(double shanxiValue) {
		this.shanxiValue = shanxiValue;
	}

	public double getShandongValue() {
		return shandongValue;
	}

	public void setShandongValue(double shandongValue) {
		this.shandongValue = shandongValue;
	}

	public double getShanghaiValue() {
		return shanghaiValue;
	}

	public void setShanghaiValue(double shanghaiValue) {
		this.shanghaiValue = shanghaiValue;
	}

	public double getJiangsuValue() {
		return jiangsuValue;
	}

	public void setJiangsuValue(double jiangsuValue) {
		this.jiangsuValue = jiangsuValue;
	}

	public double getZhejiangValue() {
		return zhejiangValue;
	}

	public void setZhejiangValue(double zhejiangValue) {
		this.zhejiangValue = zhejiangValue;
	}

	public double getAnhuiValue() {
		return anhuiValue;
	}

	public void setAnhuiValue(double anhuiValue) {
		this.anhuiValue = anhuiValue;
	}

	public double getFujianValue() {
		return fujianValue;
	}

	public void setFujianValue(double fujianValue) {
		this.fujianValue = fujianValue;
	}

	public double getHubeiValue() {
		return hubeiValue;
	}

	public void setHubeiValue(double hubeiValue) {
		this.hubeiValue = hubeiValue;
	}

	public double getHunanValue() {
		return hunanValue;
	}

	public void setHunanValue(double hunanValue) {
		this.hunanValue = hunanValue;
	}

	public double getJiangxiValue() {
		return jiangxiValue;
	}

	public void setJiangxiValue(double jiangxiValue) {
		this.jiangxiValue = jiangxiValue;
	}

	public double getSichuanValue() {
		return sichuanValue;
	}

	public void setSichuanValue(double sichuanValue) {
		this.sichuanValue = sichuanValue;
	}

	public double getChongqingValue() {
		return chongqingValue;
	}

	public void setChongqingValue(double chongqingValue) {
		this.chongqingValue = chongqingValue;
	}

	public double getLiaoningValue() {
		return liaoningValue;
	}

	public void setLiaoningValue(double liaoningValue) {
		this.liaoningValue = liaoningValue;
	}

	public double getJilinValue() {
		return jilinValue;
	}

	public void setJilinValue(double jilinValue) {
		this.jilinValue = jilinValue;
	}

	public double getHeilongjiangValue() {
		return heilongjiangValue;
	}

	public void setHeilongjiangValue(double heilongjiangValue) {
		this.heilongjiangValue = heilongjiangValue;
	}

	public double getMengdongValue() {
		return mengdongValue;
	}

	public void setMengdongValue(double mengdongValue) {
		this.mengdongValue = mengdongValue;
	}

	public double getShanxi1Value() {
		return shanxi1Value;
	}

	public void setShanxi1Value(double shanxi1Value) {
		this.shanxi1Value = shanxi1Value;
	}

	public double getGansuValue() {
		return gansuValue;
	}

	public void setGansuValue(double gansuValue) {
		this.gansuValue = gansuValue;
	}

	public double getQinghaiValue() {
		return qinghaiValue;
	}

	public void setQinghaiValue(double qinghaiValue) {
		this.qinghaiValue = qinghaiValue;
	}

	public double getNingxiaValue() {
		return ningxiaValue;
	}

	public void setNingxiaValue(double ningxiaValue) {
		this.ningxiaValue = ningxiaValue;
	}

	public double getXinjiangValue() {
		return xinjiangValue;
	}

	public void setXinjiangValue(double xinjiangValue) {
		this.xinjiangValue = xinjiangValue;
	}

	public double getBeijingScore() {
		return beijingScore;
	}

	public void setBeijingScore(double beijingScore) {
		this.beijingScore = beijingScore;
	}

	public double getTianjinScore() {
		return tianjinScore;
	}

	public void setTianjinScore(double tianjinScore) {
		this.tianjinScore = tianjinScore;
	}

	public double getHebeiScore() {
		return hebeiScore;
	}

	public void setHebeiScore(double hebeiScore) {
		this.hebeiScore = hebeiScore;
	}

	public double getYibeiScore() {
		return yibeiScore;
	}

	public void setYibeiScore(double yibeiScore) {
		this.yibeiScore = yibeiScore;
	}

	public double getShanxiScore() {
		return shanxiScore;
	}

	public void setShanxiScore(double shanxiScore) {
		this.shanxiScore = shanxiScore;
	}

	public double getShandongScore() {
		return shandongScore;
	}

	public void setShandongScore(double shandongScore) {
		this.shandongScore = shandongScore;
	}

	public double getShanghaiScore() {
		return shanghaiScore;
	}

	public void setShanghaiScore(double shanghaiScore) {
		this.shanghaiScore = shanghaiScore;
	}

	public double getJiangsuScore() {
		return jiangsuScore;
	}

	public void setJiangsuScore(double jiangsuScore) {
		this.jiangsuScore = jiangsuScore;
	}

	public double getZhejiangScore() {
		return zhejiangScore;
	}

	public void setZhejiangScore(double zhejiangScore) {
		this.zhejiangScore = zhejiangScore;
	}

	public double getAnhuiScore() {
		return anhuiScore;
	}

	public void setAnhuiScore(double anhuiScore) {
		this.anhuiScore = anhuiScore;
	}

	public double getFujianScore() {
		return fujianScore;
	}

	public void setFujianScore(double fujianScore) {
		this.fujianScore = fujianScore;
	}

	public double getHubeiScore() {
		return hubeiScore;
	}

	public void setHubeiScore(double hubeiScore) {
		this.hubeiScore = hubeiScore;
	}

	public double getHunanScore() {
		return hunanScore;
	}

	public void setHunanScore(double hunanScore) {
		this.hunanScore = hunanScore;
	}

	public double getHenanScore() {
		return henanScore;
	}

	public void setHenanScore(double henanScore) {
		this.henanScore = henanScore;
	}

	public double getJiangxiScore() {
		return jiangxiScore;
	}

	public void setJiangxiScore(double jiangxiScore) {
		this.jiangxiScore = jiangxiScore;
	}

	public double getSichuanScore() {
		return sichuanScore;
	}

	public void setSichuanScore(double sichuanScore) {
		this.sichuanScore = sichuanScore;
	}

	public double getChongqingScore() {
		return chongqingScore;
	}

	public void setChongqingScore(double chongqingScore) {
		this.chongqingScore = chongqingScore;
	}

	public double getLiaoningScore() {
		return liaoningScore;
	}

	public void setLiaoningScore(double liaoningScore) {
		this.liaoningScore = liaoningScore;
	}

	public double getJilinScore() {
		return jilinScore;
	}

	public void setJilinScore(double jilinScore) {
		this.jilinScore = jilinScore;
	}

	public double getHeilongjiangScore() {
		return heilongjiangScore;
	}

	public void setHeilongjiangScore(double heilongjiangScore) {
		this.heilongjiangScore = heilongjiangScore;
	}

	public double getMengdongScore() {
		return mengdongScore;
	}

	public void setMengdongScore(double mengdongScore) {
		this.mengdongScore = mengdongScore;
	}

	public double getShanxi1Score() {
		return shanxi1Score;
	}

	public void setShanxi1Score(double shanxi1Score) {
		this.shanxi1Score = shanxi1Score;
	}

	public double getGansuScore() {
		return gansuScore;
	}

	public void setGansuScore(double gansuScore) {
		this.gansuScore = gansuScore;
	}

	public double getQinghaiScore() {
		return qinghaiScore;
	}

	public void setQinghaiScore(double qinghaiScore) {
		this.qinghaiScore = qinghaiScore;
	}

	public double getNingxiaScore() {
		return ningxiaScore;
	}

	public void setNingxiaScore(double ningxiaScore) {
		this.ningxiaScore = ningxiaScore;
	}

	public double getXinjiangScore() {
		return xinjiangScore;
	}

	public void setXinjiangScore(double xinjiangScore) {
		this.xinjiangScore = xinjiangScore;
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

	public double getHenanGrade() {
		return henanGrade;
	}

	public void setHenanGrade(double henanGrade) {
		this.henanGrade = henanGrade;
	}

	public double getBeijingGrade() {
		return beijingGrade;
	}

	public void setBeijingGrade(double beijingGrade) {
		this.beijingGrade = beijingGrade;
	}

	public double getTianjinGrade() {
		return tianjinGrade;
	}

	public void setTianjinGrade(double tianjinGrade) {
		this.tianjinGrade = tianjinGrade;
	}

	public double getHebeiGrade() {
		return hebeiGrade;
	}

	public void setHebeiGrade(double hebeiGrade) {
		this.hebeiGrade = hebeiGrade;
	}

	public double getYibeiGrade() {
		return yibeiGrade;
	}

	public void setYibeiGrade(double yibeiGrade) {
		this.yibeiGrade = yibeiGrade;
	}

	public double getShanxiGrade() {
		return shanxiGrade;
	}

	public void setShanxiGrade(double shanxiGrade) {
		this.shanxiGrade = shanxiGrade;
	}

	public double getShandongGrade() {
		return shandongGrade;
	}

	public void setShandongGrade(double shandongGrade) {
		this.shandongGrade = shandongGrade;
	}

	public double getShanghaiGrade() {
		return shanghaiGrade;
	}

	public void setShanghaiGrade(double shanghaiGrade) {
		this.shanghaiGrade = shanghaiGrade;
	}

	public double getJiangsuGrade() {
		return jiangsuGrade;
	}

	public void setJiangsuGrade(double jiangsuGrade) {
		this.jiangsuGrade = jiangsuGrade;
	}

	public double getZhejiangGrade() {
		return zhejiangGrade;
	}

	public void setZhejiangGrade(double zhejiangGrade) {
		this.zhejiangGrade = zhejiangGrade;
	}

	public double getAnhuiGrade() {
		return anhuiGrade;
	}

	public void setAnhuiGrade(double anhuiGrade) {
		this.anhuiGrade = anhuiGrade;
	}

	public double getFujianGrade() {
		return fujianGrade;
	}

	public void setFujianGrade(double fujianGrade) {
		this.fujianGrade = fujianGrade;
	}

	public double getHubeiGrade() {
		return hubeiGrade;
	}

	public void setHubeiGrade(double hubeiGrade) {
		this.hubeiGrade = hubeiGrade;
	}

	public double getHunanGrade() {
		return hunanGrade;
	}

	public void setHunanGrade(double hunanGrade) {
		this.hunanGrade = hunanGrade;
	}

	public double getJiangxiGrade() {
		return jiangxiGrade;
	}

	public void setJiangxiGrade(double jiangxiGrade) {
		this.jiangxiGrade = jiangxiGrade;
	}

	public double getSichuanGrade() {
		return sichuanGrade;
	}

	public void setSichuanGrade(double sichuanGrade) {
		this.sichuanGrade = sichuanGrade;
	}

	public double getChongqingGrade() {
		return chongqingGrade;
	}

	public void setChongqingGrade(double chongqingGrade) {
		this.chongqingGrade = chongqingGrade;
	}

	public double getLiaoningGrade() {
		return liaoningGrade;
	}

	public void setLiaoningGrade(double liaoningGrade) {
		this.liaoningGrade = liaoningGrade;
	}

	public double getJilinGrade() {
		return jilinGrade;
	}

	public void setJilinGrade(double jilinGrade) {
		this.jilinGrade = jilinGrade;
	}

	public double getHeilongjiangGrade() {
		return heilongjiangGrade;
	}

	public void setHeilongjiangGrade(double heilongjiangGrade) {
		this.heilongjiangGrade = heilongjiangGrade;
	}

	public double getMengdongGrade() {
		return mengdongGrade;
	}

	public void setMengdongGrade(double mengdongGrade) {
		this.mengdongGrade = mengdongGrade;
	}

	public double getShanxi1Grade() {
		return shanxi1Grade;
	}

	public void setShanxi1Grade(double shanxi1Grade) {
		this.shanxi1Grade = shanxi1Grade;
	}

	public double getGansuGrade() {
		return gansuGrade;
	}

	public void setGansuGrade(double gansuGrade) {
		this.gansuGrade = gansuGrade;
	}

	public double getQinghaiGrade() {
		return qinghaiGrade;
	}

	public void setQinghaiGrade(double qinghaiGrade) {
		this.qinghaiGrade = qinghaiGrade;
	}

	public double getNingxiaGrade() {
		return ningxiaGrade;
	}

	public void setNingxiaGrade(double ningxiaGrade) {
		this.ningxiaGrade = ningxiaGrade;
	}

	public double getXinjiangGrade() {
		return xinjiangGrade;
	}

	public void setXinjiangGrade(double xinjiangGrade) {
		this.xinjiangGrade = xinjiangGrade;
	}

	public int getIsBigQuota() {
		return isBigQuota;
	}

	public void setIsBigQuota(int isBigQuota) {
		this.isBigQuota = isBigQuota;
	}
}
