package com.womow.henan.commons.dao;

import java.util.List;

import com.womow.henan.commons.bean.BaseDataEntity;

/**
 * @Description 数据字典dao
 * @author CAI modules@163.com
 * @data 2017年8月16日上午11:20:57
 * @version V1.0
 */
public interface BaseDataDao extends BaseDao<BaseDataEntity>{

	List<BaseDataEntity> findByType(String type);
}
