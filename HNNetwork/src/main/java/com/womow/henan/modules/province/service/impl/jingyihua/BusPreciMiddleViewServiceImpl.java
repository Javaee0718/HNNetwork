package com.womow.henan.modules.province.service.impl.jingyihua;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.womow.henan.modules.province.bean.dto.BusPrecisionEntityDo;
import com.womow.henan.modules.province.dao.BusPrecisionDao;
import com.womow.henan.modules.province.service.BusPreciMiddleViewService;

@Service
public class BusPreciMiddleViewServiceImpl implements BusPreciMiddleViewService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private BusPrecisionDao busPrecisionDao;

	public List<BusPrecisionEntityDo> queryMiddleQuota(int year, int month, String quotaName) throws Exception {
		try {
			return busPrecisionDao.findNotEndQuotaAndValue(year, month, quotaName);
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return null;
		}
	}

}
