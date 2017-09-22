package com.womow.henan.commons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.womow.henan.commons.bean.BaseDataEntity;
import com.womow.henan.commons.dao.BaseDataDao;
import com.womow.henan.commons.service.BusBaseDataService;

@Service
@Transactional
public class BusBaseDataServiceImpl implements BusBaseDataService{

	@Autowired
	private BaseDataDao baseDataDao;
	
	@Override
	public List<BaseDataEntity> findByType(String type) {
		return baseDataDao.findByType(type);
	}

}
