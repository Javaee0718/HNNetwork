package com.womow.henan.modules.province.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.womow.henan.modules.province.bean.dto.BusDataManageEntityDo;
import com.womow.henan.modules.province.bean.po.BusDataManageEntity;
import com.womow.henan.modules.province.bean.po.BusSortEntity;
import com.womow.henan.modules.province.dao.BusMainIndexDao;
import com.womow.henan.modules.province.service.BusMainIndexService;

@Service
@Transactional
public class BusMainIndexServiceImpl implements BusMainIndexService {

	private Logger logger = LoggerFactory.getLogger(BusMainIndexService.class);

	@Autowired
	private BusMainIndexDao busMainIndexDao;
	
	public List<String> findAllHeadDept() throws Exception{
		List<String> modules = busMainIndexDao.findAllHeadDept();
		return modules;
	}
	
	public List<BusDataManageEntityDo> findHenanDGrade() throws Exception{
		List<BusDataManageEntityDo> modules = busMainIndexDao.findHenanDGrade();
		return modules;
	}
	
	public List<BusDataManageEntityDo> findHenanEGrade() throws Exception{
		List<BusDataManageEntityDo> modules = busMainIndexDao.findHenanEGrade();
		return modules;
	}
	
	public List<BusDataManageEntityDo> countHenanGrade(String henanGrade) throws Exception{
		List<BusDataManageEntityDo> modules = busMainIndexDao.countHenanGrade(henanGrade);
		return modules;
	}
	
	public List<BusDataManageEntityDo> getHenanTargetGrade(String henanGrade) throws Exception{
		List<BusDataManageEntityDo> modules = busMainIndexDao.getHenanTargetGrade(henanGrade);
		return modules;
	}
	
	public List<BusSortEntity> findHenanPai() throws Exception{
		List<BusSortEntity> modules = busMainIndexDao.findHenanPai();
		return modules;
	}
	
}
