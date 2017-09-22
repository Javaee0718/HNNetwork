package com.womow.henan.commons.service;

import java.util.List;

import com.womow.henan.commons.bean.BaseDataEntity;

/**
 * @Description 数据字典service
 * @author CAI modules@163.com
 * @data 2017年8月16日上午11:15:25
 * @version V1.0
 */
public interface BusBaseDataService {

	/**
	 * 根据type查询数据
	 * @param type
	 * @return
	 */
	public List<BaseDataEntity> findByType(String type);
}
