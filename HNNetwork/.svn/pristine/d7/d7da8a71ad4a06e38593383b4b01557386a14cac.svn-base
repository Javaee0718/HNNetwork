package com.womow.henan.commons.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.Case;

import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

import com.womow.henan.modules.province.bean.dto.BusDataManageEntityDo;

/**
 * @author 蔡长盟
 * @description 基础工具类
 * @version 2017年8月4日
 * @eamil modules@163.com
 */
public class BaseDataUtils {

	private static PropertiesLoader loader = new PropertiesLoader("properties/province.properties");

	/**
	 * @param date
	 *            转换时间格式
	 * @return String 时间
	 */
	public static String dateToString(Date date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(date);
	}

	/**
	 * 根据操作系统获取该系统的回车换行符
	 * 
	 * @return
	 */
	public static String getEnter() {
		String sta = System.getProperty("line.separator");
		if (sta.equals("\r\n")) {
			return "\r\n";
		} else if (sta.equals("\r")) {
			return "\r";
		} else if (sta.equals("\n")) {
			return "\n";
		}
		return null;
	}

	/**
	 * 在配置文件中.通过key获取值
	 */
	public static String getValue(String key) {
		return loader.getConfig(key);
	}


	/**
	 * 清空集合中的所有空串
	 * @param modules
	 * @return
	 */
	public static List<String> removeEmp(List<String> modules) {
		while (modules.indexOf("") != -1) {
			modules.remove("");
		}
		return modules;
	}
	
	public static int daMaSort(BusDataManageEntityDo daMa) {
		Double[] scores = new Double[26];
		double beijingScore = daMa.getBeijingScore();
		scores[0]=beijingScore;
		double tianjinScore = daMa.getTianjinScore();
		scores[1]=tianjinScore;
		double hebeiScore = daMa.getHebeiScore();
		scores[2]=hebeiScore;
		double yibeiScore = daMa.getYibeiScore();
		scores[3]=yibeiScore;
		double shanxiScore = daMa.getShanxiScore();
		scores[4]=shanxiScore;
		double shandongScore = daMa.getShandongScore();
		scores[5]=shandongScore;
		double shanghaiScore = daMa.getShanghaiScore();
		scores[6]=shanghaiScore;
		double jiangsuScore = daMa.getJiangsuScore();
		scores[7]=jiangsuScore;
		double zhejiangScore = daMa.getZhejiangScore();
		scores[8]=zhejiangScore;
		double anhuiScore = daMa.getAnhuiScore();
		scores[9]=anhuiScore;
		double fujianScore = daMa.getFujianScore();
		scores[10]=fujianScore;
		double hubeiScore = daMa.getHubeiScore();
		scores[11]=hubeiScore;
		double hunanScore = daMa.getHunanScore();
		scores[12]=hunanScore;
		double henanScore = daMa.getHenanScore();
		scores[13]=henanScore;
		double jiangxiScore = daMa.getJiangxiScore();
		scores[14]=jiangxiScore;
		double sichuanScore = daMa.getSichuanScore();
		scores[15]=sichuanScore;
		double chongqingScore = daMa.getChongqingScore();
		scores[16]=chongqingScore;
		double liaoningScore = daMa.getLiaoningScore();
		scores[17]=liaoningScore;
		double jilinScore = daMa.getJilinScore();
		scores[18]=jilinScore;
		double heilongjiangScore = daMa.getHeilongjiangScore();
		scores[19]=heilongjiangScore;
		double mengdongScore = daMa.getMengdongScore();
		scores[20]=mengdongScore;
		double shanxi1Score = daMa.getShanxi1Score();
		scores[21]=shanxi1Score;
		double gansuScore = daMa.getGansuScore();
		scores[22]=gansuScore;
		double qinghaiScore = daMa.getQinghaiScore();
		scores[23]=qinghaiScore;
		double ningxiaScore = daMa.getNingxiaScore();
		scores[24]=ningxiaScore;
		double xinjiangScore = daMa.getXinjiangScore();
		scores[25]=xinjiangScore;
		Arrays.sort(scores);
		List<Double> asList = Arrays.asList(scores);
		
		Collections.reverse(asList);
		int rank = asList.indexOf(henanScore);
		//int rank = Arrays.binarySearch(scores, henanScore);
		return rank+1;
	}

	/**
	 * 总与分项的实际值进行比较,false,则高于,true则低于
	 * @param dtMn
	 * @return
	 */
	public static boolean checkValueTrOrFal(BusDataManageEntityDo dtMn) {
		
		boolean is = false;
		List<Double> values = new ArrayList<>();
		
		double henanValue = dtMn.getHenanValue();
		values.add(henanValue);
		double beijingValue = dtMn.getBeijingValue();
		values.add(beijingValue);
		double tianjinValue = dtMn.getTianjinValue();
		values.add(tianjinValue);
		double hebeiValue = dtMn.getHebeiValue();
		values.add(hebeiValue);
		double yibeiValue = dtMn.getYibeiValue();
		values.add(yibeiValue);
		double shanxiValue = dtMn.getShanxiValue();
		values.add(shanxiValue);
		double shandongValue = dtMn.getShandongValue();
		values.add(shandongValue);
		double shanghaiValue = dtMn.getShanghaiValue();
		values.add(shanghaiValue);
		double jiangsuValue = dtMn.getJiangsuValue();
		values.add(jiangsuValue);
		double zhejiangValue = dtMn.getZhejiangValue();
		values.add(zhejiangValue);
		double anhuiValue = dtMn.getAnhuiValue();
		values.add(anhuiValue);
		double fujianValue = dtMn.getFujianValue();
		values.add(fujianValue);
		double hubeiValue = dtMn.getHubeiValue();
		values.add(hubeiValue);
		double hunanValue = dtMn.getHunanValue();
		values.add(hunanValue);
		double jiangxiValue = dtMn.getJiangxiValue();
		values.add(jiangxiValue);
		double sichuanValue = dtMn.getSichuanValue();
		values.add(sichuanValue);
		double chongqingValue = dtMn.getChongqingValue();
		values.add(chongqingValue);
		double liaoningValue = dtMn.getLiaoningValue();
		values.add(liaoningValue);
		double jilinValue = dtMn.getJilinValue();
		values.add(jilinValue);
		double heilongjiangValue = dtMn.getHeilongjiangValue();
		values.add(heilongjiangValue);
		double mengdongValue = dtMn.getMengdongValue();
		values.add(mengdongValue);
		double shanxi1Value = dtMn.getShanxi1Value();
		values.add(shanxi1Value);
		double gansuValue = dtMn.getGansuValue();
		values.add(gansuValue);
		double qinghaiValue = dtMn.getQinghaiValue();
		values.add(qinghaiValue);
		double ningxiaValue = dtMn.getNingxiaValue();
		values.add(ningxiaValue);
		double xinjiangValue = dtMn.getXinjiangValue();
		values.add(xinjiangValue);
		
		double sum = 0;
		int len = 0;
		
		for (Double i : values) {
			if (i != 0) {
				sum += i;
				len++;
			}
		}
		if (len != 0) {
			BigDecimal b1 = new BigDecimal(String.valueOf(sum));
			BigDecimal b2 = new BigDecimal(String.valueOf(len));
			double doubleValue = b1.divide(b2,10,RoundingMode.HALF_DOWN).doubleValue();
			if (henanValue - doubleValue < 0) {
				is = true;
			}
		}
		return is;
	}
	
	/**
	 * 一级指标未达到国网实际平均段位的报警,false,则达到,true,则未达到
	 * @param dtMn
	 * @return
	 */
	public static boolean checkGradeTrOrFal(BusDataManageEntityDo dtMn) {
		boolean is = false;
		List<Double> values = new ArrayList<>();
		
		double henanValue = dtMn.getHenanGrade();
		values.add(henanValue);
		double beijingValue = dtMn.getBeijingGrade();
		values.add(beijingValue);
		double tianjinValue = dtMn.getTianjinGrade();
		values.add(tianjinValue);
		double hebeiValue = dtMn.getHebeiGrade();
		values.add(hebeiValue);
		double yibeiValue = dtMn.getYibeiGrade();
		values.add(yibeiValue);
		double shanxiValue = dtMn.getShanxiGrade();
		values.add(shanxiValue);
		double shandongValue = dtMn.getShandongGrade();
		values.add(shandongValue);
		double shanghaiValue = dtMn.getShanghaiGrade();
		values.add(shanghaiValue);
		double jiangsuValue = dtMn.getJiangsuGrade();
		values.add(jiangsuValue);
		double zhejiangValue = dtMn.getZhejiangGrade();
		values.add(zhejiangValue);
		double anhuiValue = dtMn.getAnhuiGrade();
		values.add(anhuiValue);
		double fujianValue = dtMn.getFujianGrade();
		values.add(fujianValue);
		double hubeiValue = dtMn.getHubeiGrade();
		values.add(hubeiValue);
		double hunanValue = dtMn.getHunanGrade();
		values.add(hunanValue);
		double jiangxiValue = dtMn.getJiangxiGrade();
		values.add(jiangxiValue);
		double sichuanValue = dtMn.getSichuanGrade();
		values.add(sichuanValue);
		double chongqingValue = dtMn.getChongqingGrade();
		values.add(chongqingValue);
		double liaoningValue = dtMn.getLiaoningGrade();
		values.add(liaoningValue);
		double jilinValue = dtMn.getJilinGrade();
		values.add(jilinValue);
		double heilongjiangValue = dtMn.getHeilongjiangGrade();
		values.add(heilongjiangValue);
		double mengdongValue = dtMn.getMengdongGrade();
		values.add(mengdongValue);
		double shanxi1Value = dtMn.getShanxi1Grade();
		values.add(shanxi1Value);
		double gansuValue = dtMn.getGansuGrade();
		values.add(gansuValue);
		double qinghaiValue = dtMn.getQinghaiGrade();
		values.add(qinghaiValue);
		double ningxiaValue = dtMn.getNingxiaGrade();
		values.add(ningxiaValue);
		double xinjiangValue = dtMn.getXinjiangGrade();
		values.add(xinjiangValue);
		
		double sum = 0;
		int len = 0;
		
		for (Double i : values) {
			if (i != 0) {
				sum += i;
				len++;
			}
		}
		if (len != 0) {
			BigDecimal b1 = new BigDecimal(String.valueOf(sum));
			BigDecimal b2 = new BigDecimal(String.valueOf(len));
			double doubleValue = b1.divide(b2,10,RoundingMode.HALF_DOWN).doubleValue();
			if (henanValue - doubleValue < 0) {
				is = true;
			}
		}
		return is;
	}

}
