package com.womow.henan.modules.province.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.womow.henan.commons.bean.Query;
import com.womow.henan.commons.dao.BaseDao;
import com.womow.henan.modules.province.bean.dto.BusDataManageEntityDo;

/**
 * @Description 国网数据管理DAO
 * @author CAI modules@163.com
 * @data 2017年8月12日上午6:55:48
 * @version V1.0
 */
public interface BusDataManageDao extends BaseDao<BusDataManageEntityDo>{

	/**
	 * 查询视图中所有的模块名称(可能含有"")
	 * @param map
	 * @return
	 */
	List<String> findAllQuotaName(Map<String, Object> map);

	/**
	 * 通过模块查询视图表中的数据
	 * @param module
	 * @param map
	 */
	List<BusDataManageEntityDo> queryByYearAndModule(Map<String, Object> map);

	/**
	 * 查询某期某模块下的
	 * @param map
	 * @return
	 */
	List<String> queryQuotaNameByYearAndModule(Map<String, Object> map);

	/**
	 * 获取视图中最新的year
	 * @return
	 */
	String findNewYear();

	/**
	 * 获取视图中的partYear
	 * @return
	 */
	List<String> findPartYearByYear(String year);

	/**
	 * 获取该年河南省的所有实际段位
	 * @param i
	 * @return
	 */
	List<Integer> findHenanGradeByYear(int year);

	/**
	 * 获取该年河南省的所有实际值
	 * @param i
	 * @return
	 */
	List<Integer> findHenanValueByYear(int year);

	/**
	 * 查询视图中的所有的年
	 */
	List<Integer> findYears();

	/**
	 * 查询数据数量
	 * @param map
	 * @return
	 */
	int querydataSize(Map<String, Object> map);

	/**
	 * 查询该年该季度下所有版块
	 * @param query
	 * @return
	 */
	List<String> findallModules(Query query);
	
}
