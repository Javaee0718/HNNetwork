package com.womow.henan.modules.province.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.womow.henan.modules.province.bean.dto.BusPrecisionEntityDo;
import com.womow.henan.modules.province.bean.dto.BusWarningEntityDo;

/**
 * 精益化指标预警信息统计业务层
 * @author root
 */
public interface BusWarningService {

	Integer[] quotaMonitorDetail(int year,int month) throws Exception;

	/**
	 * 查询该年该月的所有预警指标
	 * 以创建时间降序
	 */
	List<BusWarningEntityDo> queryWarnQuota(int year, int month)throws Exception;

	/**
	 * 监控结果趋势统计 (6个月之内)
	 * @param year
	 * @param month
	 * @return
	 */
	List<List<Object>> monitorTrend(Date date) throws Exception;

	/**
	 * 部门问题统计
	 * @param date
	 * @return
	 * @throws Exception
	 */
	List<List<Object>> deptCount(int year, int month) throws Exception;

	/**
	 * 查询该年该月的精益化指标预警排序
	 * @param year
	 * @param month
	 * @return
	 */
	List<BusPrecisionEntityDo> sortQuery(Map<String, Object> map) throws Exception;
}
