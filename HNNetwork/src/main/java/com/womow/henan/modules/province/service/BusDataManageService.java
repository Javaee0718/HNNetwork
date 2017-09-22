package com.womow.henan.modules.province.service;

import java.util.List;
import java.util.Map;

import com.womow.henan.commons.bean.Query;
import com.womow.henan.modules.province.bean.dto.BusDataManageEntityDo;

/**
 * @Description 国网数据管理service
 * @author CAI modules@163.com
 * @data 2017年8月12日上午6:51:17
 * @version V1.0
 */
public interface BusDataManageService {

	/**
	 * 查询视图中所有的模块名称(可能含有"",需要去除)
	 * @param map
	 * @return
	 */
	List<String> findAllQuotaName(Map<String, Object> map)throws Exception;

	/**
	 * 通过总指标名称以及年.季度查询视图表中的数据
	 * @param modules
	 * @param map
	 * @return
	 */
	List<List<BusDataManageEntityDo>> queryAllData(List<String> quotaNames, Map<String, Object> map)throws Exception;

	//从数据库中获取到年与季度,获取最新的年和季度
	String findNewYear() throws Exception;

	/**
	 * 预警页面查询
	 * @param map
	 * @return
	 */
	List<List<BusDataManageEntityDo>> earlyWarning(Map<String, Object> map,List<String> modules)throws Exception;

	/**
	 * 查询视图中的所有的年
	 */
	List<Integer> findYears();

	/**
	 * 统计数据总量
	 * @param query
	 * @return
	 */
	int findCont(Map<String, Object> map) throws Exception ;

	/**
	 * 查询该年该季度下的所有版块
	 * @param query
	 * @return
	 */
	List<String> findAllModules(Query query);

}
