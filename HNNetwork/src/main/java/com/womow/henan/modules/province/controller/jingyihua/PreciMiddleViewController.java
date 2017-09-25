package com.womow.henan.modules.province.controller.jingyihua;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.womow.henan.modules.province.bean.dto.BusPrecisionEntityDo;
import com.womow.henan.modules.province.service.BusPreciMiddleViewService;

/**
 * 精益化指标中间层指标(非末端指标)图表控制层
 * @author root
 */
@Controller
@RequestMapping("mdl")
public class PreciMiddleViewController {

	@Autowired
	private BusPreciMiddleViewService BusPreciMiddleViewService;
	
	//	精益化指标名称列表
	
	/*  业扩报装服务规范率
		优质服务评价指数
		物资采购计划完成率
		物资合同履约完成率
		智能电网调度功能应用完成率
		营销服务规范率
		信息通信系统运行指数
	*/
	
	/**
	 * 业扩报装服务规范率
	 * @param date 日期
	 * @param quotaName 指标名称
	 * @return 中间view
	 */
	@RequestMapping("ykbzfwgfl")
	public String ykbzfwgflQuota(Date date,String quotaName) {
		try {
			int year ;
			int month ;
			if (date != null) {
				year = date.getYear();
				month = date.getMonth()+1;
			} else {
				Date dt = new Date();
				year = dt.getYear();
				month = dt.getMonth() +1;
			} 
			List<BusPrecisionEntityDo> lists = BusPreciMiddleViewService.queryMiddleQuota(year,month,quotaName);
		} catch (Exception e) {
			
		}
		return null;
	}
}
