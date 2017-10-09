package com.womow.henan.modules.province.service.impl.jingyihua;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.womow.henan.modules.province.bean.dto.BusPrecisionEntityDo;
import com.womow.henan.modules.province.bean.dto.BusWarningEntityDo;
import com.womow.henan.modules.province.dao.BusPrecisionDao;
import com.womow.henan.modules.province.dao.BusWarningDao;
import com.womow.henan.modules.province.service.BusWarningService;

@Service
@Transactional
public class BusWarningServiceImpl implements BusWarningService {

	private static Logger logger = LoggerFactory.getLogger(BusWarningService.class);

	@Autowired
	private BusWarningDao busWarningDao;
	@Autowired
	private BusPrecisionDao busPrecisionDao;

	public Integer[] quotaMonitorDetail(int year, int month) throws Exception {
		// 通过年月,预警等级查询该等级下的指标个数
		Integer g1Num = busWarningDao.queryWarnNum(year, month, 1);
		Integer g2Num = busWarningDao.queryWarnNum(year, month, 2);
		Integer g3Num = busWarningDao.queryWarnNum(year, month, 3);
		Integer allNum = busPrecisionDao.queryNum(year, month);
		int normal = allNum - g1Num - g2Num - g3Num;
		Integer[] ints = new Integer[] { g1Num, g2Num, g3Num, normal };
		return ints;
	}

	public List<BusWarningEntityDo> queryWarnQuota(int year, int month) throws Exception {
		List<BusWarningEntityDo> list = busWarningDao.queryWarnQuota(year, month);
		return list;
	}
	
	public List<List<Object>> monitorTrend(Date date) throws Exception {
		List<List<Object>> container = new ArrayList<>();
		List<Object> dateList = new ArrayList<>();
		List<Object> numList = new ArrayList<>();
		container.add(dateList);
		container.add(numList);
		//设置日期
		//值1
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		c1.add(Calendar.MONTH, -5);
		int year = c1.get(Calendar.YEAR);
		int month = c1.get(Calendar.MONTH)+1;
		Integer num1 = busWarningDao.queryWarnNum(year, month, null);
		dateList.add(c1);
		numList.add(num1);
		//值2
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date);
		c2.add(Calendar.MONTH, -4);
		year = c2.get(Calendar.YEAR);
		month = c2.get(Calendar.MONTH)+1;
		Integer num2 = busWarningDao.queryWarnNum(year, month, null);
		dateList.add(c2);
		numList.add(num2);
		//值3
		Calendar c3 = Calendar.getInstance();
		c3.setTime(date);
		c3.add(Calendar.MONTH, -3);
		year = c3.get(Calendar.YEAR);
		month = c3.get(Calendar.MONTH)+1;
		Integer num3 = busWarningDao.queryWarnNum(year, month, null);
		dateList.add(c3);
		numList.add(num3);
		//值4
		Calendar c4 = Calendar.getInstance();
		c4.setTime(date);
		c4.add(Calendar.MONTH, -2);
		year = c4.get(Calendar.YEAR);
		month = c4.get(Calendar.MONTH)+1;
		Integer num4 = busWarningDao.queryWarnNum(year, month, null);
		dateList.add(c4);
		numList.add(num4);
		//值5
		Calendar c5 = Calendar.getInstance();
		c5.setTime(date);
		c5.add(Calendar.MONTH, -1);
		year = c5.get(Calendar.YEAR);
		month = c5.get(Calendar.MONTH)+1;
		Integer num5 = busWarningDao.queryWarnNum(year, month, null);
		dateList.add(c5);
		numList.add(num5);
		//值6
		Calendar c6 = Calendar.getInstance();
		c6.setTime(date);
		year = c6.get(Calendar.YEAR);
		month = c6.get(Calendar.MONTH)+1;
		Integer num6 = busWarningDao.queryWarnNum(year, month, null);
		dateList.add(c6);
		numList.add(num6);
		return container;
	}

	public List<List<Object>> deptCount(int year, int month) throws Exception {
		List<List<Object>> container = new ArrayList<>();
		List<Object> depts = new ArrayList<>();
		List<Object> nums = new ArrayList<>();
		List<BusWarningEntityDo> list = busWarningDao.queryDeptAndNum(year,month);
		for (int i = 0; i < list.size(); i++) {
			depts.add(list.get(i).getHeadDept());
			nums.add(list.get(i).getNum());
		}
		return container;
	}

	public List<BusPrecisionEntityDo> sortQuery(Map<String, Object> map) {
		/**
		 * 排序规则
		 * -: 比较第一等级预警个数
		 * 其次: 比较第二等级预警个数
		 * 再次: 比较第三等级预警个数 
		 */
		//TODO 此处排序,暂定位第一等级个数排序
		List<BusPrecisionEntityDo> list = busWarningDao.deptAndGradeSort(map);
		
		return null;
	}

}
