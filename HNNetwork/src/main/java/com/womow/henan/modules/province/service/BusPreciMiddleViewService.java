package com.womow.henan.modules.province.service;

import java.util.List;

import com.womow.henan.modules.province.bean.dto.BusPrecisionEntityDo;

/**
 * 精益化指标中间层指标(非末端指标)图表业务层
 */
public interface BusPreciMiddleViewService {

	/**
	 * 查询业扩报装服务规范率指标
	 */
	public List<BusPrecisionEntityDo> queryMiddleQuota(int year,int month,String quotaName) throws Exception;
}
