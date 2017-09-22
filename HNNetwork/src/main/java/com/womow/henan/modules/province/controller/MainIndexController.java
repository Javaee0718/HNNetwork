package com.womow.henan.modules.province.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.womow.henan.commons.bean.BaseDataEntity;
import com.womow.henan.commons.bean.PageUtils;
import com.womow.henan.commons.bean.Query;
import com.womow.henan.commons.bean.json.ReportDataBean;
import com.womow.henan.commons.service.BusBaseDataService;
import com.womow.henan.commons.utils.BaseDataUtils;
import com.womow.henan.commons.web.BaseController;
import com.womow.henan.modules.province.bean.dto.BusDataManageEntityDo;
import com.womow.henan.modules.province.bean.po.BusDataManageEntity;
import com.womow.henan.modules.province.bean.po.BusSortEntity;
import com.womow.henan.modules.province.service.BusMainIndexService;

/**
 * @Description 数据管理controller
 * @author CAI modules@163.com
 * @data 2017年8月11日下午5:56:13
 * @version V1.0
 */
@Controller
@RequestMapping("/mainIndex")
public class MainIndexController extends BaseController {

	@Autowired
	private BusMainIndexService busMainIndexService;
	@Autowired
	private BusBaseDataService busBaseDataService;

	
	/**
	 * 查询视图中所有的部门名称
	 * @param map
	 * @return
	 */
	@RequestMapping("/headDept")
	@ResponseBody
	public ReportDataBean findAllHeadDept() throws Exception{
		List<String> headDeptList = busMainIndexService.findAllHeadDept();
		String[] headDept = new String[headDeptList.size()];
		for (int i = 0; i < headDeptList.size(); i++) {
			headDept[i]="'"+headDeptList.get(i).toString()+"'";
		}
		ReportDataBean reportDataBean = new ReportDataBean();
		reportDataBean.setCategories(headDeptList);
		return reportDataBean;
	}
	
	/**
	 * 获取河南省的所有D段出现次数
	 * @param i
	 * @return
	 */
	@RequestMapping("/dGrade")
	@ResponseBody
	public String[] findHenanDGrade() throws Exception{
		List<BusDataManageEntityDo> Dlist = busMainIndexService.findHenanDGrade();
		List<String> headDeptList = busMainIndexService.findAllHeadDept();
		String[] dGrade = new String[headDeptList.size()];
		for (int i = 0; i < dGrade.length; i++) {
			dGrade[i]="0";
		}
		outer:for (int i = 0; i < Dlist.size(); i++) {
			for (int j = 0; j < headDeptList.size(); j++) {
				if(Dlist.get(i).getHeadDept().equals(headDeptList.get(j))){
					dGrade[j]=String.valueOf(Dlist.get(i).getCount());
					continue outer;
				}
			}
		}
		return dGrade;
	}
	
	/**
	 * 获取河南省的所有E段出现次数
	 * @param i
	 * @return
	 */
	@RequestMapping("/eGrade")
	@ResponseBody
	public String[] findHenanEGrade() throws Exception{
		List<BusDataManageEntityDo> Elist = busMainIndexService.findHenanEGrade();
		List headDeptList = busMainIndexService.findAllHeadDept();
		String[] eGrade = new String[headDeptList.size()];
		for (int i = 0; i < eGrade.length; i++) {
			eGrade[i]="0";
		}
		outer:for (int i = 0; i < Elist.size(); i++) {
			for (int j = 0; j < headDeptList.size(); j++) {
				if(Elist.get(i).getHeadDept().equals(headDeptList.get(j))){
					eGrade[j]=String.valueOf(Elist.get(i).getCount());
					continue outer;
				}
			}
		}
		return eGrade;
	}
	
	/**
	 * 获取2016年全年河南省的所有段位出现次数
	 * @param i
	 * @return
	 */
	@RequestMapping("/henanAGrade")
	@ResponseBody
	public String[] getHenanAGrade(String grade) throws Exception{
		List<BusDataManageEntityDo> Dlist = busMainIndexService.countHenanGrade(grade);
		List<BusDataManageEntityDo> Elist = busMainIndexService.getHenanTargetGrade(grade);
		String[] henanGrade = new String[4];
		for (int i = 0; i < henanGrade.length; i++) {
			henanGrade[i]="0";
		}
		if (Elist.get(0).getCount()!=0) {
			henanGrade[3]=String.valueOf(Elist.get(0).getCount());
		}
		for (BusDataManageEntityDo bd : Dlist) {
			if(bd.getPartYear().equals("全年")){
				henanGrade[0]=String.valueOf(bd.getCount());
			}else if(bd.getPartYear().equals("上半年")){
				henanGrade[2]=String.valueOf(bd.getCount());
			}else if(bd.getPartYear().equals("第一季度")){
				henanGrade[1]=String.valueOf(bd.getCount());
			}
		}
		return henanGrade;
	}
	
	/**
	 * 获得河南省近10年综合排名
	 * @param i
	 * @return
	 */
	@RequestMapping("/henanPai")
	@ResponseBody
	public ReportDataBean getHenanPai() throws Exception{
		List<BusSortEntity> listH = busMainIndexService.findHenanPai();
		ReportDataBean reportDataBean = new ReportDataBean();
		List<String> sortList = new ArrayList<>();
		List<String> yearList = new ArrayList<>();
		for (int i = 0; i < listH.size(); i++) {
			sortList.add(listH.get(i).getSort());
			yearList.add(listH.get(i).getYear());
		}
		reportDataBean.setSortCategories(sortList);
		reportDataBean.setYearCategories(yearList);
		return reportDataBean;
	}
	
}
