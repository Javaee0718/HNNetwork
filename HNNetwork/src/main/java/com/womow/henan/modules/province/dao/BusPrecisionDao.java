package com.womow.henan.modules.province.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.womow.henan.commons.dao.BaseDao;
import com.womow.henan.modules.province.bean.dto.BusPrecisionEntityDo;

/**
 * @Description 精益化指标DAO
 * @author CAI modules@163.com
 * @data 2017年9月18日下午1:19:50
 * @version V1.0
 */
public interface BusPrecisionDao extends BaseDao<BusPrecisionEntityDo> {

	/**
	 * 查询该指标的非末端指标,指标如下: 业扩报装服务规范率
	 */
	List<BusPrecisionEntityDo> findNotEndQuotaAndValue(@Param("year") int year, @Param("month") int month,
			@Param("quotaName") String quotaName);

	/**
	 * 根据部门 日期 查询一级指标名称
	 * @param year
	 * @param month
	 * @param dept
	 * @return
	 */
	List<String> findQuotaName(@Param("year") int year,@Param("month") int month,@Param("dept") String dept);

}
