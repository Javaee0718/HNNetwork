package com.womow.henan.modules.sys.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.womow.henan.modules.sys.security.dto.BusAuthorityEntityDo;
import com.womow.henan.modules.sys.security.dto.BusRoleEntityDo;
import com.womow.henan.modules.sys.user.dao.BusAuthorityDao;
import com.womow.henan.modules.sys.user.service.BusAuthorityService;

@Service
@Transactional
public class BusAuthorityServiceImpl implements BusAuthorityService {

	@Autowired
	private BusAuthorityDao busAuthorityDao;

	public List<List<BusAuthorityEntityDo>> findOnAll() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("isDel", 1);
		//TODO CAI_类型
		//map.put("type", "");
		map.put("type", "1");
		List<BusAuthorityEntityDo> deptRole = busAuthorityDao.findAll(map);
		map.put("type", "2");
		List<BusAuthorityEntityDo> otherRegion = busAuthorityDao.findAll(map);
		map.put("type", "3");
		List<BusAuthorityEntityDo> outOfPro = busAuthorityDao.findAll(map);
		List<List<BusAuthorityEntityDo>> list = new ArrayList<>();
		list.add(deptRole);
		list.add(otherRegion);
		list.add(outOfPro);
		return list;
	}

}
