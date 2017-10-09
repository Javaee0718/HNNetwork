package com.womow.henan.modules.province.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.womow.henan.commons.dao.BaseDao;
import com.womow.henan.modules.province.bean.dto.BusPrecisionEntityDo;
import com.womow.henan.modules.province.bean.dto.BusWarningEntityDo;

/*
 * 
 */
public interface BusWarningDao extends BaseDao<BusWarningEntityDo>{

	/**
	 * 查询数据库中最新的年,月
	 * @return
	 */
	BusWarningEntityDo findYearAndMonth();

	/**
	 * 通过年月,预警等级查询该等级下的指标个数
	 * @param year 年
	 * @param month 月
	 * @param warnGrade 预警等级
	 * @param dept 部门
	 * @return
	 */
	Integer queryWarnNum(@Param("year") int year,@Param("month") int month,@Param("warnGrade") Integer warnGrade);

	/**
	 * 查询该年该月的预警指标列表,按创建时间降序
	 * @param year
	 * @param month
	 * @return
	 */
	List<BusWarningEntityDo> queryWarnQuota(@Param("year") int year,@Param("month") int month);

	/**
	 * 查询该部门的问题统计个数
	 * @return
	 */
	List<BusWarningEntityDo> queryDeptAndNum(@Param("year") int year,@Param("month") int month);

	/**
	 * 第一等级预警,.查询前几名的指标名称
	 * @param year
	 * @param month
	 * @return
	 */
	List<BusPrecisionEntityDo> deptAndGradeSort(int year, int month);

	/**
	 * 精益化指标分页排序查询
	 * @param map
	 * @return
	 */
	List<BusPrecisionEntityDo> deptAndGradeSort(Map<String, Object> map);
}
