package com.womow.henan.modules.province.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.womow.henan.commons.utils.BaseDataUtils;
import com.womow.henan.commons.utils.PoiUtils;
import com.womow.henan.modules.province.bean.dto.BusPrecisionEntityDo;
import com.womow.henan.modules.province.bean.po.BusPrecisionQuestionEntity;
import com.womow.henan.modules.province.dao.BusPrecisionDao;
import com.womow.henan.modules.province.dao.BusPresQuestionDao;
import com.womow.henan.modules.province.service.BusPrecisionService;

@Service
@Transactional
public class BusPrecisionServiceImpl implements BusPrecisionService {

	private Logger logger = LoggerFactory.getLogger(BusPrecisionService.class);

	@Autowired
	private BusPrecisionDao busPrecisionDao;
	@Autowired
	private BusPresQuestionDao busPresQuestionDao;

	public String precisionFileUpload(MultipartFile file) throws Exception {

		int cellNum = 0;
		String returnMessage = "";
		try {
			String fileName = file.getOriginalFilename();
			String fileExtension = FilenameUtils.getExtension(fileName);
			Workbook workbook;
			if (fileExtension.equals("xls")) {
				workbook = new HSSFWorkbook(file.getInputStream());
			} else {
				workbook = new XSSFWorkbook(file.getInputStream());
			}
			Sheet sheet = null;
			/*------------------营销部  start--------------------------*/
			if ((sheet = workbook.getSheet(BaseDataUtils.getValue("zkzyxtfwgfl"))) != null) {
				returnMessage = "指标 " + sheet.getSheetName() + ": " + zkzyxtfwgflQuota(sheet);
			}
			if ((sheet = workbook.getSheet(BaseDataUtils.getValue("yzfwpjzs"))) != null) {
				if (!returnMessage.equals("")) {
					returnMessage = returnMessage + "\n" + "指标 " + sheet.getSheetName() + ": " + yzfwpjzsQuota(sheet);
				} else {
					returnMessage = "指标 " + sheet.getSheetName() + ": " + yzfwpjzsQuota(sheet);
				}
			}
			if ((sheet = workbook.getSheet(BaseDataUtils.getValue("yxfwgfl"))) != null) {
				if (!returnMessage.equals("")) {
					returnMessage = returnMessage + "\n" + "指标 " + sheet.getSheetName() + ": " + yxfwgflQuota(sheet);
				} else {
					returnMessage = "指标 " + sheet.getSheetName() + ": " + yxfwgflQuota(sheet);
				}
			}
			/*------------------营销部  end--------------------------*/
			/*------------------物资部  start--------------------------*/
			// 物资采购计划完成率
			if ((sheet = workbook.getSheet(BaseDataUtils.getValue("wzcgjhwcl"))) != null) {
				if (!returnMessage.equals("")) {
					returnMessage = returnMessage + "\n" + "指标 " + sheet.getSheetName() + ": " + wzcgjhwclQuota(sheet);
				} else {
					returnMessage = "指标 " + sheet.getSheetName() + ": " + wzcgjhwclQuota(sheet);
				}
			}
			// 物资合同履约完成率
			if ((sheet = workbook.getSheet(BaseDataUtils.getValue("wzhtlywcl"))) != null) {
				if (!returnMessage.equals("")) {
					returnMessage = returnMessage + "\n" + "指标 " + sheet.getSheetName() + ": " + wzhtlywclQuota(sheet);
				} else {
					returnMessage = "指标 " + sheet.getSheetName() + ": " + wzhtlywclQuota(sheet);
				}
			}
			/*------------------物资部  end--------------------------*/
			/*------------------调控中心 start--------------------------*/
			// 智能电网调度功能应用完成率
			if ((sheet = workbook.getSheet(BaseDataUtils.getValue("zndwddgnyywcl"))) != null) {
				if (!returnMessage.equals("")) {
					returnMessage = returnMessage + "\n" + "指标 " + sheet.getSheetName() + ": "
							+ zndwddgnyywclQuota(sheet);
				} else {
					returnMessage = "指标 " + sheet.getSheetName() + ": " + zndwddgnyywclQuota(sheet);
				}
			}
			/*------------------调控中心 end--------------------------*/
			/*------------------科信部 start--------------------------*/
			// 信息通信系统运行指数
			if ((sheet = workbook.getSheet(BaseDataUtils.getValue("xxtxxtyxzs"))) != null) {
				if (!returnMessage.equals("")) {
					returnMessage = returnMessage + "\n" + "指标 " + sheet.getSheetName() + ": " + xxtxxtyxzsQuota(sheet);
				} else {
					returnMessage = "指标 " + sheet.getSheetName() + ": " + xxtxxtyxzsQuota(sheet);
				}
			}
			/*------------------科信部 end--------------------------*/
		} catch (Exception e) {

		}
		return returnMessage;
	}

	/**
	 * 信息通信系统运行指数
	 * 
	 * @param sheet
	 * @return
	 */
	private String xxtxxtyxzsQuota(Sheet sheet) {
		String message = "";
		String quotaName = sheet.getSheetName();
		int rowNum = 0;
		int cellNum = 0;
		try {
			int year = 0;
			int month = 0;
			try {
				Row row = sheet.getRow(0);
				Cell yearCell = row.getCell(0);
				yearCell.setCellType(Cell.CELL_TYPE_NUMERIC);
				year = (int) yearCell.getNumericCellValue();
				Cell monthCell = row.getCell(1);
				monthCell.setCellType(Cell.CELL_TYPE_NUMERIC);
				month = (int) monthCell.getNumericCellValue();
			} catch (Exception e) {
				message = "请输入正确的年与月";
				logger.warn(BaseDataUtils.dateToString(new Date()) + " BusPrecisionServiceImpl.wzcgjhwclQuota()方法异常"
						+ " " + message);
				return message;
			}
			List<Cell> list = new ArrayList<>();
			// 导入精益化指标数据
			List<BusPrecisionEntityDo> doList = new ArrayList<>();
			for (int i = 0; i < 14; i++) {
				BusPrecisionEntityDo precision = new BusPrecisionEntityDo();
				precision.setYear(year);
				precision.setMonth(month);
				precision.setQuotaName(quotaName);
				precision.setHeadDept(BaseDataUtils.getValue("kexinbu"));
				list.add(sheet.getRow(1).getCell(i));
				list.add(sheet.getRow(2).getCell(i));
				list.add(sheet.getRow(3).getCell(i));
				List<String> dataList = PoiUtils.getCellValue(sheet, list);
				list.clear();
				precision.setNotEndQuotaName(dataList.get(0));
				precision.setEndQuotaName(dataList.get(1));
				precision.setEndQuotaValue(dataList.get(2));
				doList.add(precision);
			}
			// 运算规则
			// 计算公式：信息通信系统运行指数=0.3×（1-重要信息系统非计划停运率）+0.3×通信网络运行可靠率+0.2×信息资源监控指数+0.2×通信管理系统综合应用评价指数
			// 其中：
			// 1.重要信息系统非计划停运率=0.7×[统计周期内重要信息系统非计划停运时长/（统计周期总时长×10）]×100%
			// +0.3×[统计周期内信息通信管理系统非计划停运时长/（统计周期总时长×2）]×100%
			// （1）重要信息系统包括营销应用、生产管理2.0、财务管控、ERP、内网门户、外网门户、运营监测、统一权限、电力交易2.0等9个系统；
			// （2）非计划停运率计算的信息通信管理系统包括I6000、TMS等2个系统；
			// （3）统计周期：每月21日00：00至下月20日23：59。

			// 2.通信网络运行可靠率=0.3×属地化通信设备及光缆故障处置及时率+0.3×省公司通信设备及光缆故障处置及时率
			// +0.05×通信运行故障上报及时率+0.15×公司数据通信网运维管理评价指数+0.2×一体化电视电话会议系统运行保障评价指数
			// 3.信息资源监控指数=0.5×资源监控覆盖率+0.5×资源数据完整率
			// 4.通信管理系统综合应用评价指数=0.4×数据应用规范率+0.15×设备网管接入及采集正确率+0.3×运行维护工作完成率+0.15×横向集成工作完成率
			BusPrecisionEntityDo do2 = doList.get(2);
			String do22 = do2.getEndQuotaValue();
			if (do22 != null && !"".equals(do22) && !do22.equals("0")) {
				// 值一计算开始
				BigDecimal do22BD = new BigDecimal(do22);

				BusPrecisionEntityDo do0 = doList.get(0);
				String do02 = do0.getEndQuotaValue();
				cellNum = 1;
				BigDecimal do02BD = new BigDecimal(do02);

				BusPrecisionEntityDo do1 = doList.get(1);
				String do12 = do0.getEndQuotaValue();
				cellNum = 2;
				BigDecimal do12BD = new BigDecimal(do12);

				BigDecimal v11 = do02BD.divide(do22BD.multiply(new BigDecimal("10")), 4, BigDecimal.ROUND_HALF_UP)
						.multiply(new BigDecimal("0.7")).multiply(new BigDecimal("100"));
				BigDecimal v12 = do12BD.divide(do22BD.multiply(new BigDecimal("2")), 4, BigDecimal.ROUND_HALF_UP)
						.multiply(new BigDecimal("0.3")).multiply(new BigDecimal("100"));
				// 值一
				BigDecimal v1 = v11.add(v12);
				// 值二计算开始
				BusPrecisionEntityDo do3 = doList.get(3);
				String do32 = do3.getEndQuotaValue();
				cellNum = 4;
				BigDecimal do32BD = new BigDecimal(do32);
				BusPrecisionEntityDo do4 = doList.get(4);
				String do42 = do3.getEndQuotaValue();
				cellNum = 5;
				BigDecimal do42BD = new BigDecimal(do42);
				BusPrecisionEntityDo do5 = doList.get(5);
				String do52 = do3.getEndQuotaValue();
				cellNum = 6;
				BigDecimal do52BD = new BigDecimal(do52);
				BusPrecisionEntityDo do6 = doList.get(6);
				String do62 = do3.getEndQuotaValue();
				cellNum = 7;
				BigDecimal do62BD = new BigDecimal(do62);
				BusPrecisionEntityDo do7 = doList.get(7);
				String do72 = do3.getEndQuotaValue();
				cellNum = 8;
				BigDecimal do72BD = new BigDecimal(do72);
				BigDecimal v21 = do32BD.multiply(new BigDecimal("0.3"));
				BigDecimal v22 = do42BD.multiply(new BigDecimal("0.3"));
				BigDecimal v23 = do52BD.multiply(new BigDecimal("0.05"));
				BigDecimal v24 = do62BD.multiply(new BigDecimal("0.15"));
				BigDecimal v25 = do72BD.multiply(new BigDecimal("0.2"));
				BigDecimal v2 = v21.add(v22).add(v23).add(v24).add(v25);
				// 值三计算开始
				BusPrecisionEntityDo do8 = doList.get(8);
				String do82 = do8.getEndQuotaValue();
				cellNum = 9;
				BigDecimal do82BD = new BigDecimal(do82);
				BusPrecisionEntityDo do9 = doList.get(9);
				String do92 = do9.getEndQuotaValue();
				cellNum = 10;
				BigDecimal do92BD = new BigDecimal(do92);
				BigDecimal v3 = do82BD.add(do92BD).multiply(new BigDecimal("0.5"));
				// 值四开始计算
				BusPrecisionEntityDo do10 = doList.get(10);
				String do102 = do10.getEndQuotaValue();
				cellNum = 11;
				BigDecimal do102BD = new BigDecimal(do102);
				BusPrecisionEntityDo do11 = doList.get(11);
				String do112 = do11.getEndQuotaValue();
				cellNum = 12;
				BigDecimal do112BD = new BigDecimal(do112);
				BusPrecisionEntityDo da12 = doList.get(12);
				String do122 = da12.getEndQuotaValue();
				cellNum = 13;
				BigDecimal do122BD = new BigDecimal(do122);
				BusPrecisionEntityDo do13 = doList.get(13);
				String do132 = do13.getEndQuotaValue();
				cellNum = 14;
				BigDecimal do132BD = new BigDecimal(do132);
				BigDecimal v41 = do102BD.multiply(new BigDecimal("0.4"));
				BigDecimal v42 = do112BD.multiply(new BigDecimal("0.15"));
				BigDecimal v43 = do122BD.multiply(new BigDecimal("0.3"));
				BigDecimal v44 = do132BD.multiply(new BigDecimal("0.15"));
				BigDecimal v4 = v41.add(v42).add(v43).add(v44);

				// 值汇总
				// 计算公式：信息通信系统运行指数=0.3×（1-重要信息系统非计划停运率）
				// +0.3×通信网络运行可靠率+0.2×信息资源监控指数+0.2×通信管理系统综合应用评价指数
				BigDecimal va1 = new BigDecimal("1");
				BigDecimal fullMarkBD = va1.subtract(v1).multiply(new BigDecimal("0.3"))
						.add(v2.multiply(new BigDecimal("0.3"))).add(v3.multiply(new BigDecimal("0.2")))
						.add(v4.multiply(new BigDecimal("0.2")));
				double quotaValue = fullMarkBD.doubleValue();
				do0.setQuotaValue(quotaValue);
				cellNum = 1;
				busPrecisionDao.save(do0);
				do1.setQuotaValue(quotaValue);
				// do1.setNotEndQuotaName(do0.getNotEndQuotaName());
				cellNum = 2;
				busPrecisionDao.save(do1);
				do2.setQuotaValue(quotaValue);
				// do2.setNotEndQuotaName(do0.getNotEndQuotaName());
				cellNum = 3;
				busPrecisionDao.save(do2);
				do3.setQuotaValue(quotaValue);
				cellNum = 4;
				busPrecisionDao.save(do3);
				do4.setQuotaValue(quotaValue);
				// do4.setNotEndQuotaName(do3.getNotEndQuotaName());
				cellNum = 5;
				busPrecisionDao.save(do4);
				do5.setQuotaValue(quotaValue);
				// do5.setNotEndQuotaName(do3.getNotEndQuotaName());
				cellNum = 6;
				busPrecisionDao.save(do5);
				do6.setQuotaValue(quotaValue);
				// do6.setNotEndQuotaName(do3.getNotEndQuotaName());
				cellNum = 7;
				busPrecisionDao.save(do6);
				do7.setQuotaValue(quotaValue);
				// do7.setNotEndQuotaName(do3.getNotEndQuotaName());
				cellNum = 8;
				busPrecisionDao.save(do7);
				do8.setQuotaValue(quotaValue);
				cellNum = 9;
				busPrecisionDao.save(do8);
				do9.setQuotaValue(quotaValue);
				// do9.setNotEndQuotaName(do8.getNotEndQuotaName());
				cellNum = 10;
				busPrecisionDao.save(do9);
				do10.setQuotaValue(quotaValue);
				cellNum = 11;
				busPrecisionDao.save(do10);
				do11.setQuotaValue(quotaValue);
				// do11.setNotEndQuotaName(do10.getNotEndQuotaName());
				cellNum = 12;
				busPrecisionDao.save(do11);
				da12.setQuotaValue(quotaValue);
				// da12.setNotEndQuotaName(do10.getNotEndQuotaName());
				cellNum = 13;
				busPrecisionDao.save(da12);
				do13.setQuotaValue(quotaValue);
				// do13.setNotEndQuotaName(do10.getNotEndQuotaName());
				cellNum = 14;
				busPrecisionDao.save(do13);
				message = precisionQuestionImp(sheet, year, month, quotaName);
				if (!message.equals("")) {
					return message;
				}
			} else {
				message = "第三列数据异常";
				return message;
			}
			message = "导入成功";
		} catch (Exception e) {
			message = "第" + cellNum + "列数据有问题";
			logger.warn(BaseDataUtils.dateToString(new Date()) + "BusPrecisionServiceImpl.wzcgjhwclQuota()异常 " + e + " "
					+ quotaName + " " + message);
			return message;
		}
		return message;
	}

	/**
	 * 智能电网调度功能应用完成率
	 * 
	 * @param sheet
	 * @return
	 */
	private String zndwddgnyywclQuota(Sheet sheet) {
		String message = "";
		String quotaName = sheet.getSheetName();
		int rowNum = 0;
		int cellNum = 0;
		try {
			int year = 0;
			int month = 0;
			try {
				Row row = sheet.getRow(0);
				Cell yearCell = row.getCell(0);
				yearCell.setCellType(Cell.CELL_TYPE_NUMERIC);
				year = (int) yearCell.getNumericCellValue();
				Cell monthCell = row.getCell(1);
				monthCell.setCellType(Cell.CELL_TYPE_NUMERIC);
				month = (int) monthCell.getNumericCellValue();
			} catch (Exception e) {
				message = "请输入正确的年与月";
				logger.warn(BaseDataUtils.dateToString(new Date()) + " BusPrecisionServiceImpl.wzcgjhwclQuota()方法异常"
						+ " " + message);
				return message;
			}
			List<Cell> list = new ArrayList<>();
			// 导入精益化指标数据
			List<BusPrecisionEntityDo> doList = new ArrayList<>();
			for (int i = 0; i < 11; i++) {
				BusPrecisionEntityDo precision = new BusPrecisionEntityDo();
				precision.setYear(year);
				precision.setMonth(month);
				precision.setQuotaName(quotaName);
				precision.setHeadDept(BaseDataUtils.getValue("tiaokongzhongxin"));
				list.add(sheet.getRow(1).getCell(i));
				list.add(sheet.getRow(2).getCell(i));
				list.add(sheet.getRow(3).getCell(i));
				List<String> dataList = PoiUtils.getCellValue(sheet, list);
				list.clear();
				precision.setNotEndQuotaName(dataList.get(0));
				precision.setEndQuotaName(dataList.get(1));
				precision.setEndQuotaValue(dataList.get(2));
				doList.add(precision);
			}
			// 运算规则
			// 计算公式：智能电网调度功能应用完成率=0.3×日前负荷预测合格率+0.1×电网实时分析基准潮流计算合格率+0.2×日内计划数据合格率+0.2×电网设备运行状态准确率+0.2×电网在线安全分析合格率
			// 其中：
			// 1.日前负荷预测合格率=（统计周期内日历天数-不合格天数）/统计周期内日历天数×100％。
			// 2.电网实时分析基准潮流计算合格率=[1-（重要断面有功误差率×0.8+中枢点电压误差率×0.2）]×100%；99.5%及以上取100%。
			// 3.日内计划数据合格率=0.7×日内计划数据完整率+0.3×母线超短期负荷预测合格率 =
			// Σ96×16×统计周期内日历天数单套日内数据完整率/96×16×统计周期内日历天数×70%+（统计周期内日历天数-不合格天数）/统计周期内日历天数×30%。
			// 4.电网设备运行状态准确率=（1-在线数据中设备状态与实际状态不一致个数/设备总数）×100%，其中设备包括在线数据建模范围内的发电机、线路、变压器。
			// 5.电网在线安全分析合格率=电网实时分析合格率×75%+电网预想分析合格率×25%+电网在线分析优秀案例次数×0.02/次×100%；99.9%及以上取100%。

		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * 物资合同履约完成率
	 * 
	 * @param sheet
	 * @return
	 */
	private String wzhtlywclQuota(Sheet sheet) {
		String message = "";
		String quotaName = sheet.getSheetName();
		int rowNum = 0;
		int cellNum = 0;
		try {
			int year = 0;
			int month = 0;
			try {
				Row row = sheet.getRow(0);
				Cell yearCell = row.getCell(0);
				yearCell.setCellType(Cell.CELL_TYPE_NUMERIC);
				year = (int) yearCell.getNumericCellValue();
				Cell monthCell = row.getCell(1);
				monthCell.setCellType(Cell.CELL_TYPE_NUMERIC);
				month = (int) monthCell.getNumericCellValue();
			} catch (Exception e) {
				message = "请输入正确的年与月";
				logger.warn(BaseDataUtils.dateToString(new Date()) + " BusPrecisionServiceImpl.wzcgjhwclQuota()方法异常"
						+ " " + message);
				return message;
			}
			List<Cell> list = new ArrayList<>();
			// 导入精益化指标数据
			List<BusPrecisionEntityDo> doList = new ArrayList<>();
			for (int i = 0; i < 11; i++) {
				BusPrecisionEntityDo precision = new BusPrecisionEntityDo();
				precision.setYear(year);
				precision.setMonth(month);
				precision.setQuotaName(quotaName);
				precision.setHeadDept(BaseDataUtils.getValue("wuzibu"));
				list.add(sheet.getRow(1).getCell(i));
				list.add(sheet.getRow(2).getCell(i));
				list.add(sheet.getRow(3).getCell(i));
				List<String> dataList = PoiUtils.getCellValue(sheet, list);
				list.clear();
				precision.setNotEndQuotaName(dataList.get(0));
				precision.setEndQuotaName(dataList.get(1));
				precision.setEndQuotaValue(dataList.get(2));
				doList.add(precision);
			}

			// 计算公式：物资合同履约完成率=0.3×物资供应完成率+0.4×物资合同到货结算率+0.3×协议库存合同执行完成率
			// 其中：
			// 1.物资供应完成率=∑月度物资供应计划实际到货入库金额/∑月度物资供应计划总金额×100%。
			// 其中：“实际到货入库金额”是指与月度供应计划相匹配在物资供应计划交货期前30日内及后30日内办理到货入库金额
			// （每月1日零时提取，以产生入库凭证为准）；“月度物资供应计划总金额”是指上月提取和当月新增月度供应计划约定交货总金额
			// （每月1日零时提取下月供应计划，并核实当月新增供应计划）。对于单个采购订单行项目多次到货情况，
			// 按当月最终完成交货的供应计划交货时间进行统计。
			// 2.物资合同到货结算率=物资合同到货款支付完成金额/物资合同到货款应付金额×100%。
			// 其中：“物资合同到货款支付完成金额”是指已办理接收入库75天内完成支付比例中到货款，
			// 并将支付完成标识正确上传至电子商务平台的总金额（每月1日零时提取数据）。
			// “物资合同到货款应付款总金额”是指采购订单中已接收办理入库75天后，按照合同条款支付比例应付到货款的金额。
			// 电商化采购结算及时率作为物资合同到货结算率减分项，电商采购结算及时率高于85%及以上的，不扣分；
			// 低于85%的，每降低5%扣0.5%；结算及时率=（30天内及时结算订单数/应结算订单总数）×100%。
			// 3.协议库存合同执行完成率=完成协议库存份数/到期协议库存总份数×100%。
			// “完成协议库存份数”是指考核期内，协议库存采购订单签订完成比例在合同约定比例
			// （2015年协议库存按照[90%,110%],2016年协议库存按照[80%,120%]）区间内的协议份数。
			// “到期协议总份数”是指已到截止日期的协议总份数。
			// 4.“物资供应基础管理年”专项检查活动中发现的物资合同、物资供应关键问题，
			// 纳入物资合同履约完成率整体指标扣分项（扣分明细见检查标准）。
			BusPrecisionEntityDo do0 = doList.get(0);
			BusPrecisionEntityDo do1 = doList.get(1);
			String do12 = do1.getEndQuotaValue();
			if (do12 != null && !"".equals(do12) && !do12.equals("0")) {
				cellNum = 1;
				BigDecimal do12BD = new BigDecimal(do12);
				String do02 = do0.getEndQuotaValue();
				BigDecimal do02BD = new BigDecimal(do02);
				// 值一
				BigDecimal v1 = do02BD.divide(do12BD).multiply(new BigDecimal("100"));
				do0.setNotEndQuotaValue(v1.doubleValue());
				do1.setNotEndQuotaValue(v1.doubleValue());
				BusPrecisionEntityDo do2 = doList.get(2);
				BusPrecisionEntityDo do3 = doList.get(3);
				String do32 = do3.getEndQuotaValue();
				String do22 = do2.getEndQuotaValue();
				if (do32 == null || do32.equals("") || do32.equals("0")) {
					message = "第4列数据异常";
					return message;
				}
				cellNum = 3;
				BigDecimal do22BD = new BigDecimal(do22);
				cellNum = 4;
				BigDecimal do32BD = new BigDecimal(do32);
				// 值二
				BigDecimal v2 = do22BD.divide(do32BD, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100"));
				do2.setNotEndQuotaValue(v2.doubleValue());
				do3.setNotEndQuotaValue(v2.doubleValue());
				BusPrecisionEntityDo do4 = doList.get(4);
				BusPrecisionEntityDo do5 = doList.get(5);
				String do42 = do4.getEndQuotaValue();
				String do52 = do5.getEndQuotaValue();
				if (do52 == null || do52.equals("") || do52.equals("0")) {
					message = "第6列数据异常";
					return message;
				}
				cellNum = 5;
				BigDecimal do42BD = new BigDecimal(do42);
				cellNum = 6;
				BigDecimal do52BD = new BigDecimal(do52);
				// 值三
				BigDecimal v3 = do42BD.divide(do52BD, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100"));
				do4.setNotEndQuotaValue(v3.doubleValue());
				do5.setNotEndQuotaValue(v3.doubleValue());

				// 计算公式：物资合同履约完成率=0.3×物资供应完成率+0.4×物资合同到货结算率+0.3×协议库存合同执行完成率
				BigDecimal fullmarkBD = v1.multiply(new BigDecimal("0.3")).add(v2.multiply(new BigDecimal("0.4")))
						.add(v3.multiply(new BigDecimal("0.3")));
				BusPrecisionEntityDo do6 = doList.get(6);
				String do62 = do6.getEndQuotaValue();
				if (do62 != null && !do62.trim().equals("") && !do62.equals("0")) {
					cellNum = 7;
					BigDecimal do62BD = new BigDecimal(do62);
					fullmarkBD = fullmarkBD.add(do62BD);
				}

				BusPrecisionEntityDo do7 = doList.get(7);
				String do72 = do7.getEndQuotaValue();
				if (do72 != null && !do72.trim().equals("") && !do72.equals("0")) {
					cellNum = 8;
					BigDecimal do72BD = new BigDecimal(do72);
					fullmarkBD = fullmarkBD.add(do72BD);
				}

				BusPrecisionEntityDo do8 = doList.get(8);
				String do82 = do8.getEndQuotaValue();
				if (do82 != null && !do82.trim().equals("") && !do82.equals("0")) {
					cellNum = 9;
					BigDecimal do82BD = new BigDecimal(do82);
					fullmarkBD = fullmarkBD.add(do82BD);
				}

				BusPrecisionEntityDo do9 = doList.get(9);
				String do92 = do9.getEndQuotaValue();
				if (do92 != null && !do92.trim().equals("") && !do92.equals("0")) {
					cellNum = 10;
					BigDecimal do92BD = new BigDecimal(do92);
					fullmarkBD = fullmarkBD.add(do92BD);
				}

				BusPrecisionEntityDo do10 = doList.get(10);
				String do102 = do10.getEndQuotaValue();
				if (do102 != null && !do102.trim().equals("") && !do102.equals("0")) {
					cellNum = 11;
					BigDecimal do102BD = new BigDecimal(do102);
					fullmarkBD = fullmarkBD.add(do102BD);
				}
				// 保存数据
				double fullMark = fullmarkBD.doubleValue();
				do0.setQuotaValue(fullMark);
				cellNum = 1;
				busPrecisionDao.save(do0);
				do1.setQuotaValue(fullMark);
				// do1.setNotEndQuotaName(do0.getNotEndQuotaName());
				cellNum = 2;
				busPrecisionDao.save(do1);
				do2.setQuotaValue(fullMark);
				cellNum = 3;
				busPrecisionDao.save(do2);
				do3.setQuotaValue(fullMark);
				// do3.setNotEndQuotaName(do2.getNotEndQuotaName());
				cellNum = 4;
				busPrecisionDao.save(do3);
				do4.setQuotaValue(fullMark);
				cellNum = 5;
				busPrecisionDao.save(do4);
				do5.setQuotaValue(fullMark);
				// do5.setNotEndQuotaName(do4.getNotEndQuotaName());
				cellNum = 6;
				busPrecisionDao.save(do5);
				do6.setQuotaValue(fullMark);
				cellNum = 7;
				busPrecisionDao.save(do6);
				do7.setQuotaValue(fullMark);
				// do7.setNotEndQuotaName(do6.getNotEndQuotaName());
				do7.setEndQuotaValue(do6.getEndQuotaValue());
				cellNum = 8;
				busPrecisionDao.save(do7);
				do8.setQuotaValue(fullMark);
				// do8.setNotEndQuotaName(do6.getNotEndQuotaName());
				do8.setEndQuotaValue(do6.getEndQuotaValue());
				cellNum = 9;
				busPrecisionDao.save(do8);
				do9.setQuotaValue(fullMark);
				// do9.setNotEndQuotaName(do6.getNotEndQuotaName());
				do9.setEndQuotaValue(do6.getEndQuotaValue());
				cellNum = 10;
				busPrecisionDao.save(do9);
				do10.setQuotaValue(fullMark);
				// do10.setNotEndQuotaName(do6.getNotEndQuotaName());
				do10.setEndQuotaValue(do6.getEndQuotaValue());
				cellNum = 11;
				busPrecisionDao.save(do10);
				message = precisionQuestionImp(sheet, year, month, quotaName);
				if (!message.equals("")) {
					return message;
				}
			} else {
				message = "第2列数据异常";
				return message;
			}
			message = "导入成功";
		} catch (Exception e) {
			message = "第" + cellNum + "列数据有问题";
			logger.warn(BaseDataUtils.dateToString(new Date()) + "BusPrecisionServiceImpl.wzhtlywclQuota()异常 " + e + " "
					+ quotaName + " " + message);
			return message;
		}
		return message;
	}

	/**
	 * 物资采购计划完成率
	 * 
	 * @param sheet
	 * @return
	 */
	private String wzcgjhwclQuota(Sheet sheet) {
		String message = "";
		String quotaName = sheet.getSheetName();
		int rowNum = 0;
		int cellNum = 0;
		try {
			int year = 0;
			int month = 0;
			try {
				Row row = sheet.getRow(0);
				Cell yearCell = row.getCell(0);
				yearCell.setCellType(Cell.CELL_TYPE_NUMERIC);
				year = (int) yearCell.getNumericCellValue();
				Cell monthCell = row.getCell(1);
				monthCell.setCellType(Cell.CELL_TYPE_NUMERIC);
				month = (int) monthCell.getNumericCellValue();
			} catch (Exception e) {
				message = "请输入正确的年与月";
				logger.warn(BaseDataUtils.dateToString(new Date()) + " BusPrecisionServiceImpl.wzcgjhwclQuota()方法异常"
						+ " " + message);
				return message;
			}
			List<Cell> list = new ArrayList<>();
			// 导入精益化指标数据
			List<BusPrecisionEntityDo> doList = new ArrayList<>();
			for (int i = 0; i < 6; i++) {
				BusPrecisionEntityDo precision = new BusPrecisionEntityDo();
				precision.setYear(year);
				precision.setMonth(month);
				precision.setQuotaName(quotaName);
				precision.setHeadDept(BaseDataUtils.getValue("wuzibu"));
				list.add(sheet.getRow(1).getCell(i));
				list.add(sheet.getRow(2).getCell(i));
				list.add(sheet.getRow(3).getCell(i));
				List<String> dataList = PoiUtils.getCellValue(sheet, list);
				list.clear();
				precision.setNotEndQuotaName(dataList.get(0));
				precision.setEndQuotaName(dataList.get(1));
				precision.setEndQuotaValue(dataList.get(2));
				doList.add(precision);
			}
			// "计算公式：物资采购计划完成率=按计划到货物资条目数/按计划应到货物资总体条目数×100%
			// 其中：
			// 1.实际交货时间指ERP系统生成入库凭证时间；计划交货时间指采购申请“交货日期”时间。
			// 2.“按计划到货物资条目数”是考核期内按计划到货数量（招标文件允许变更范围）
			// 和实际交货时间距离计划到货时间60天及以内的到货物资条目数。
			// 3.“按计划应到货物资总条目数”是指考核期内按计划应到货物资总条目数。
			// 包含考核期内采购申请对应的采购订单已全部办理接收入库（产生入库凭证）的采购申请条目数、
			// 考核期内未产生采购订单的采购申请条目数。
			// 4.加减分项：因本单位管理原因，导致单独安排批次采购或调整批次安排的，每发生一次扣0.5%，
			// 满足“绿色通道”【物资计划〔2016〕39号】文件要求的，不纳入考核；未按时向总部报送统计数据或数据质量存在问题的，
			// 每发生一次扣0.2%；要求各单位建立责任分解机制，未完成的扣物资计划完成率指标0.5分；
			// 整站招标任务未完成，每差一项目扣0.5%。"
			BusPrecisionEntityDo do0 = doList.get(0);
			BusPrecisionEntityDo do1 = doList.get(1);
			String do02 = do0.getEndQuotaValue();
			String do12 = do1.getEndQuotaValue();
			if (do12 != null && !do12.equals("") && !do12.equals("0")) {
				cellNum = 1;
				BigDecimal do02BD = new BigDecimal(do02);
				cellNum = 2;
				BigDecimal do12BD = new BigDecimal(do12);
				BigDecimal fullMarkBD = do02BD.divide(do12BD, 4, BigDecimal.ROUND_HALF_UP)
						.multiply(new BigDecimal("100"));

				// 开始计算
				cellNum = 3;
				BusPrecisionEntityDo do2 = doList.get(2);
				String do22 = do2.getEndQuotaValue();
				if (do22 != null && !do22.equals("") && !do22.equals("0")) {
					BigDecimal do22BD = new BigDecimal(do22);
					fullMarkBD = fullMarkBD.subtract(do22BD.multiply(new BigDecimal("0.5")));
				}
				cellNum = 4;
				BusPrecisionEntityDo do3 = doList.get(3);
				String do32 = do3.getEndQuotaValue();
				if (do32 != null && !do32.equals("") && !do32.equals("0")) {
					BigDecimal do32BD = new BigDecimal(do32);
					fullMarkBD = fullMarkBD.subtract(do32BD.multiply(new BigDecimal("0.2")));
				}
				cellNum = 5;
				BusPrecisionEntityDo do4 = doList.get(4);
				String do42 = do4.getEndQuotaValue();
				if (do42 != null && !do42.equals("") && do42.equals("1")) {
					fullMarkBD = fullMarkBD.subtract(new BigDecimal("0.5"));
				}
				cellNum = 6;
				BusPrecisionEntityDo do5 = doList.get(5);
				String do52 = do5.getEndQuotaValue();
				if (do52 != null && !do52.equals("") && do52.equals("0")) {
					BigDecimal do52BD = new BigDecimal(do52);
					fullMarkBD = fullMarkBD.subtract(do52BD.multiply(new BigDecimal("0.5")));
				}
				double fullMark = fullMarkBD.doubleValue();
				if (fullMark < 0) {
					fullMark = 0;
				}
				// 指标值赋值 非末端指标名赋值 保存 异常处理
				do0.setQuotaValue(fullMark);
				cellNum = 1;
				busPrecisionDao.save(do0);

				do1.setQuotaValue(fullMark);
				// do1.setNotEndQuotaName(quotaName);
				cellNum = 2;
				busPrecisionDao.save(do1);

				do2.setQuotaValue(fullMark);
				cellNum = 3;
				busPrecisionDao.save(do2);

				do3.setQuotaValue(fullMark);
				// do3.setNotEndQuotaName(do2.getNotEndQuotaName());
				cellNum = 4;
				busPrecisionDao.save(do3);

				do4.setQuotaValue(fullMark);
				// do4.setNotEndQuotaName(do2.getNotEndQuotaName());
				cellNum = 5;
				busPrecisionDao.save(do4);

				do5.setQuotaValue(fullMark);
				// do5.setNotEndQuotaName(do2.getNotEndQuotaName());
				cellNum = 6;
				busPrecisionDao.save(do5);
				message = precisionQuestionImp(sheet, year, month, quotaName);
				if (!message.equals("")) {
					return message;
				}
			} else {
				message = do1.getEndQuotaName() + "数据异常";
				return message;
			}
			message = "导入成功";
		} catch (Exception e) {
			message = "第" + cellNum + "列数据有问题";
			logger.warn(BaseDataUtils.dateToString(new Date()) + "BusPrecisionServiceImpl.wzcgjhwclQuota()异常 " + e + " "
					+ quotaName + " " + message);
			return message;
		}
		return message;
	}

	/**
	 * 导入精益化指标相关意见的功能
	 * 
	 * @param sheet
	 * @param year
	 * @param month
	 * @param quotaName
	 * @return
	 * @throws Exception
	 */
	public String precisionQuestionImp(Sheet sheet, int year, int month, String quotaName) throws Exception {
		String message = "";
		int cellNum = 0;
		try {
			// 导入指标相关意见数据
			int lastRowNum = sheet.getLastRowNum();
			BusPrecisionQuestionEntity preQuest = new BusPrecisionQuestionEntity();
			preQuest.setYear(year);
			preQuest.setMonth(month);
			preQuest.setQuotaName(quotaName);
			if (lastRowNum > 4) {
				short lastCellNum = sheet.getRow(4).getLastCellNum();
				List<Cell> list = new ArrayList<>();
				for (int i = 5; i <= lastRowNum; i++) {
					Row nextRow = sheet.getRow(i);
					for (int j = 0; j < lastCellNum; j++) {
						list.add(nextRow.getCell(j));
					}
					List<String> dataList = PoiUtils.getCellValue(sheet, list);
					cellNum = i + 1;
					list.clear();
					preQuest.setMonitorDate(dataList.get(0));
					preQuest.setQuestionType(dataList.get(1));
					preQuest.setDutyUnit(dataList.get(2));
					preQuest.setQuestionReason(dataList.get(3));
					preQuest.setCureOpinion(dataList.get(4));
					preQuest.setCureTerm(dataList.get(5));
					preQuest.setCureResult(dataList.get(6));
					busPresQuestionDao.save(preQuest);
				}
			}
		} catch (Exception e) {
			message = quotaName + ":第" + cellNum + "列数据有问题";
			logger.warn(BaseDataUtils.dateToString(new Date()) + "BusPrecisionServiceImpl.precisionQuestionImp()异常 " + e
					+ " " + message);
			return message;
		}
		return message;
	}

	/**
	 * 营销服务规范率
	 * 
	 * @param sheet
	 * @return
	 */
	private String yxfwgflQuota(Sheet sheet) {
		String message = "";
		String quotaName = sheet.getSheetName();
		int rowNum = 0;
		int cellNum = 0;
		try {
			int year = 0;
			int month = 0;
			try {
				Row row = sheet.getRow(0);
				Cell yearCell = row.getCell(0);
				yearCell.setCellType(Cell.CELL_TYPE_NUMERIC);
				year = (int) yearCell.getNumericCellValue();
				Cell monthCell = row.getCell(1);
				monthCell.setCellType(Cell.CELL_TYPE_NUMERIC);
				month = (int) monthCell.getNumericCellValue();
			} catch (Exception e) {
				message = "请输入正确的年与月";
				logger.warn(BaseDataUtils.dateToString(new Date()) + " BusPrecisionServiceImpl.yxfwgflQuota()方法异常" + " "
						+ message);
				return message;
			}
			List<Cell> list = new ArrayList<>();
			// 导入精益化指标数据
			List<BusPrecisionEntityDo> doList = new ArrayList<>();
			for (int i = 0; i < 8; i++) {
				BusPrecisionEntityDo precision = new BusPrecisionEntityDo();
				precision.setYear(year);
				precision.setMonth(month);
				precision.setQuotaName(quotaName);
				precision.setHeadDept(BaseDataUtils.getValue("yingxiaobu"));
				list.add(sheet.getRow(1).getCell(i));
				list.add(sheet.getRow(2).getCell(i));
				list.add(sheet.getRow(3).getCell(i));
				List<String> dataList = PoiUtils.getCellValue(sheet, list);
				list.clear();
				precision.setNotEndQuotaName(dataList.get(0));
				precision.setEndQuotaName(dataList.get(1));
				precision.setEndQuotaValue(dataList.get(2));
				doList.add(precision);
			}
			// 运算规则
			// "计算公式：营销服务规范率=0.7×[1-一类服务不规范投诉数/(人工话务量/100×50%+当期营业户数/1000×50%)]+0.2×[1-二类服务不规范投诉数/(人工话务量/100×50%+当期营业户数/1000×50%)]+0.1×[1-服务不规范举报数/(人工话务量/100×50%+当期营业户数/1000×50%)]
			// 其中：
			// 1.每发生一起报告及报表类等信息报送不及时或报送质量不合格的，扣减总指标0.2个百分点。
			// 2.被国网营销部督办的事项，每件扣减总指标0.5个百分点。
			// 3.服务不规范投诉数包含投诉和其他业务分类中应派为投诉的服务不规范工单数，其中：
			// （1）一类服务不规范投诉包括5项三级投诉：营业厅服务，收费标准，收费项目，业扩报装超时限，抄表。
			// （2）二类服务不规范投诉包括19项三级投诉：营业厅、计量、用电检查、勘测、抄催人员服务态度和服务规范，电费，电价，环节处理不当，业务办理超时限，环节处理问题，计量装置，表计线路接错，验表，轮换户表改造。
			// （3）服务不规范举报包括4个二级举报：以电谋私，服务行为，里勾外联，三指定。
			// （4）催缴费，欠费停复电2项不纳入指标考核。
			// （5）其他由于公司新业务推广引发的投诉原则上不纳入指标考核。
			// 4.每发现一起违约用电和窃电举报处理不规范（通过举报工单答复质量、与营销系统内处理传票信息比对获取），扣减总指标0.1个百分点。

			/*------------------------------------------*/
			// 人工话务量
			BusPrecisionEntityDo do1 = doList.get(1);
			String do12 = do1.getEndQuotaValue();
			// 当期营业户数
			BusPrecisionEntityDo do2 = doList.get(2);
			String do22 = do2.getEndQuotaValue();

			// 人工话务量/100×50%+当期营业户数/1000×50%
			BigDecimal do12BD = new BigDecimal(do12);
			BigDecimal do22BD = new BigDecimal(do22);
			BigDecimal cm1 = do12BD.divide(new BigDecimal("100")).multiply(new BigDecimal("50"));
			BigDecimal cm2 = do22BD.divide(new BigDecimal("1000")).multiply(new BigDecimal("50"));
			BigDecimal cmV = new BigDecimal("1");
			// 共用值
			BigDecimal cm = cm1.add(cm2);
			if (cm.doubleValue() != 0) {
				BusPrecisionEntityDo do0 = doList.get(0);
				String do02 = do0.getEndQuotaValue();
				BigDecimal do02BD = new BigDecimal(do02);
				BigDecimal cmV1 = new BigDecimal("0.7");
				// 值1
				BigDecimal rt1 = cmV1.multiply(cmV.subtract(do02BD.divide(cm, 4, BigDecimal.ROUND_HALF_UP)));

				BusPrecisionEntityDo do3 = doList.get(3);
				String do32 = do3.getEndQuotaValue();
				BigDecimal do32BD = new BigDecimal(do32);
				BigDecimal cmV2 = new BigDecimal("0.2");
				// 值2
				BigDecimal rt2 = cmV2.multiply(cmV.subtract(do32BD.divide(cm, 4, BigDecimal.ROUND_HALF_UP)));

				BusPrecisionEntityDo do4 = doList.get(4);
				String do42 = do4.getEndQuotaValue();
				BigDecimal do42BD = new BigDecimal(do42);
				BigDecimal cmV3 = new BigDecimal("0.1");
				// 值3
				BigDecimal rt3 = cmV3.multiply(cmV.subtract(do42BD.divide(cm, 4, BigDecimal.ROUND_HALF_UP)));

				// 总值
				BigDecimal fullMarkBD = rt1.add(rt2).add(rt3);
				if (fullMarkBD.doubleValue() > 0) {
					/*---------------------------------*/
					BusPrecisionEntityDo do5 = doList.get(5);
					String do52 = do5.getEndQuotaValue();
					if (do52 != null && !"".equals(do52)) {
						BigDecimal do52BD = new BigDecimal(do52);
						fullMarkBD = fullMarkBD.subtract(do52BD.multiply(new BigDecimal("0.2")));
					}
					if (fullMarkBD.doubleValue() > 0) {
						BusPrecisionEntityDo do6 = doList.get(6);
						String do62 = do6.getEndQuotaValue();
						if (do62 != null && !"".equals(do62)) {
							BigDecimal do62BD = new BigDecimal(do62);
							fullMarkBD = fullMarkBD.subtract(do62BD.multiply(new BigDecimal("0.5")));
						}
						if (fullMarkBD.doubleValue() > 0) {
							BusPrecisionEntityDo do7 = doList.get(7);
							String do72 = do6.getEndQuotaValue();
							if (do72 != null && !"".equals(do72)) {
								BigDecimal do72BD = new BigDecimal(do72);
								fullMarkBD = fullMarkBD.subtract(do72BD.multiply(new BigDecimal("0.1")));
							}
						}
					}
				}
				double fullMark = fullMarkBD.doubleValue();
				if (fullMark < 0) {
					fullMark = 0;
				}
				BusPrecisionEntityDo do5 = doList.get(5);
				BusPrecisionEntityDo do6 = doList.get(6);
				BusPrecisionEntityDo do7 = doList.get(7);
				do0.setQuotaValue(fullMark);
				cellNum = 1;
				busPrecisionDao.save(do0);
				do1.setQuotaValue(fullMark);
				// do1.setNotEndQuotaName(do0.getNotEndQuotaName());
				cellNum = 2;
				busPrecisionDao.save(do1);
				do2.setQuotaValue(fullMark);
				// do2.setNotEndQuotaName(do0.getNotEndQuotaName());
				cellNum = 3;
				busPrecisionDao.save(do2);
				do3.setQuotaValue(fullMark);
				// do3.setNotEndQuotaName(do0.getNotEndQuotaName());
				cellNum = 4;
				busPrecisionDao.save(do3);
				do4.setQuotaValue(fullMark);
				// do4.setNotEndQuotaName(do0.getNotEndQuotaName());
				cellNum = 5;
				busPrecisionDao.save(do4);
				do5.setQuotaValue(fullMark);
				cellNum = 6;
				busPrecisionDao.save(do5);
				do6.setQuotaValue(fullMark);
				// do6.setNotEndQuotaName(do5.getNotEndQuotaName());
				cellNum = 7;
				busPrecisionDao.save(do6);
				do7.setQuotaValue(fullMark);
				// do7.setNotEndQuotaName(do5.getNotEndQuotaName());
				cellNum = 8;
				busPrecisionDao.save(do7);
			}
			// TODO 允许值为空嘛?
			message = precisionQuestionImp(sheet, year, month, quotaName);
			if (!message.equals("")) {
				return message;
			}
			message = "导入成功";
		} catch (Exception e) {
			message = quotaName + ":第" + cellNum + "列数据有问题";
			logger.warn(BaseDataUtils.dateToString(new Date()) + "BusPrecisionServiceImpl.yxfwgflQuota()异常 " + e + " "
					+ message);
			return message;
		}
		return message;
	}

	/**
	 * 优质服务评价指数
	 * 
	 * @param sheet
	 * @return
	 */
	private String yzfwpjzsQuota(Sheet sheet) {
		String message = "";
		int rowNum = 0;
		int cellNum = 0;
		try {
			int year = 0;
			int month = 0;
			try {
				Row row = sheet.getRow(0);
				Cell yearCell = row.getCell(0);
				yearCell.setCellType(Cell.CELL_TYPE_NUMERIC);
				year = (int) yearCell.getNumericCellValue();
				Cell monthCell = row.getCell(1);
				monthCell.setCellType(Cell.CELL_TYPE_NUMERIC);
				month = (int) monthCell.getNumericCellValue();
			} catch (Exception e) {
				message = "请输入正确的年与月";
				logger.warn(BaseDataUtils.dateToString(new Date()) + " BusPrecisionServiceImpl.zkzyxtfwgflQuota()方法异常"
						+ " " + message);
				return message;
			}

			String quotaName = sheet.getSheetName();
			List<Cell> list = new ArrayList<>();
			// 导入精益化指标数据
			List<BusPrecisionEntityDo> doList = new ArrayList<>();
			for (int i = 0; i < 6; i++) {
				BusPrecisionEntityDo precision = new BusPrecisionEntityDo();
				precision.setYear(year);
				precision.setMonth(month);
				precision.setQuotaName(quotaName);
				precision.setHeadDept(BaseDataUtils.getValue("yingxiaobu"));
				list.add(sheet.getRow(1).getCell(i));
				list.add(sheet.getRow(2).getCell(i));
				list.add(sheet.getRow(3).getCell(i));
				List<String> dataList = PoiUtils.getCellValue(sheet, list);
				list.clear();
				precision.setNotEndQuotaName(dataList.get(0));
				precision.setEndQuotaName(dataList.get(1));
				precision.setEndQuotaValue(dataList.get(2));
				doList.add(precision);
			}
			// 值运算规则如下
			// 计算公式：优质服务评价指数=（1-客户对同一事件重复致电三次及以上的事件数/业务处理量）×100%其中：1.经国网认定为恶意诉求的事件除外。
			// 2.业务处理回访满意率低于到95%的，每减少0.1%扣减总指标0.1个百分点。
			// 3.经查95598工单办理不真实，每发现一起扣减总指标0.1个百分点，扣完为止。
			// 4.每发生一起供电企业责任的负面服务类舆情，扣减总指标5个百分点，扣完为止。
			// 5.国网组织的服务检查中，每发现一起查证属实的投诉举报弄虚作假、业扩报装“三指定”、乱收费、吃拿卡要、屏蔽、旁路95598、营业场所无人值班等事件，扣减总指标0.2个百分点，扣完为止。
			// 6.业务处理量指除故障报修、表扬和国网客服中心一次答复办结咨询以外的业务量。
			BusPrecisionEntityDo do0 = doList.get(0);
			BusPrecisionEntityDo do1 = doList.get(1);
			cellNum = 1;
			BigDecimal b02 = new BigDecimal(do0.getEndQuotaValue());
			cellNum = 2;
			BigDecimal b12 = new BigDecimal(do1.getEndQuotaValue());
			BigDecimal b012 = b02.divide(b12, 4, BigDecimal.ROUND_HALF_UP);
			BigDecimal fullMarkBD = new BigDecimal("1");
			fullMarkBD = fullMarkBD.subtract(b012).multiply(new BigDecimal("100"));

			cellNum = 3;
			BusPrecisionEntityDo do2 = doList.get(2);
			String endQuotaValue = do2.getEndQuotaValue();
			if (endQuotaValue != null && !endQuotaValue.equals("")) {
				BigDecimal nfBD = new BigDecimal("95");
				BigDecimal endQuotaValueBD = new BigDecimal(endQuotaValue);
				BigDecimal subtract = nfBD.subtract(endQuotaValueBD);
				if (subtract.doubleValue() > 0) {
					fullMarkBD = fullMarkBD.subtract(subtract);
				}
			}

			cellNum = 4;
			BusPrecisionEntityDo do3 = doList.get(3);
			String endQuotaValue3 = do3.getEndQuotaValue();
			if (endQuotaValue3 != null && !endQuotaValue3.equals("") && !endQuotaValue3.equals("0")) {
				BigDecimal endQuotaValue3BD = new BigDecimal(endQuotaValue3);
				BigDecimal multiply = endQuotaValue3BD.multiply(new BigDecimal("0.1"));
				fullMarkBD = fullMarkBD.subtract(multiply);
			}

			cellNum = 5;
			BusPrecisionEntityDo do4 = doList.get(4);
			String endQuotaValue4 = do4.getEndQuotaValue();
			if (endQuotaValue4 != null && !endQuotaValue4.equals("") && !endQuotaValue4.equals("0")) {
				BigDecimal endQuotaValue3BD = new BigDecimal(endQuotaValue3);
				BigDecimal multiply = endQuotaValue3BD.multiply(new BigDecimal("5"));
				fullMarkBD = fullMarkBD.subtract(multiply);
			}

			cellNum = 6;
			BusPrecisionEntityDo do5 = doList.get(5);
			String endQuotaValue5 = do5.getEndQuotaValue();
			if (endQuotaValue5 != null && !endQuotaValue5.equals("") && !endQuotaValue5.equals("0")) {
				BigDecimal endQuotaValue3BD = new BigDecimal(endQuotaValue3);
				BigDecimal multiply = endQuotaValue3BD.multiply(new BigDecimal("0.2"));
				fullMarkBD = fullMarkBD.subtract(multiply);
			}
			double fullMark = fullMarkBD.doubleValue();
			if (fullMark < 0) {
				fullMark = 0;
			}
			cellNum = 1;
			do0.setQuotaValue(fullMark);
			busPrecisionDao.save(do0);
			cellNum = 2;
			do1.setQuotaValue(fullMark);
			// do1.setNotEndQuotaName(do0.getNotEndQuotaName());
			busPrecisionDao.save(do1);
			cellNum = 3;
			do2.setQuotaValue(fullMark);
			busPrecisionDao.save(do2);
			cellNum = 4;
			do3.setQuotaValue(fullMark);
			// do3.setNotEndQuotaName(do2.getNotEndQuotaName());
			busPrecisionDao.save(do3);
			cellNum = 5;
			do4.setQuotaValue(fullMark);
			// do4.setNotEndQuotaName(do2.getNotEndQuotaName());
			busPrecisionDao.save(do4);
			cellNum = 6;
			do5.setQuotaValue(fullMark);
			// do5.setNotEndQuotaName(do2.getNotEndQuotaName());
			busPrecisionDao.save(do5);
			list.clear();
			// 导入指标相关意见数据
			message = precisionQuestionImp(sheet, year, month, quotaName);
			if (!message.equals("")) {
				return message;
			}
			message = "导入成功";
		} catch (Exception e) {
			logger.warn(BaseDataUtils.dateToString(new Date()) + " BusPrecisionServiceImpl.yzfwpjzsQuota()异常 " + e);
			message = "第" + cellNum + "列数据异常";
		}
		return message;
	}

	/**
	 * 业扩报装服务规范率指标导入
	 * 
	 * @param sheet
	 * @return
	 * @throws Exception
	 */
	private String zkzyxtfwgflQuota(Sheet sheet) throws Exception {

		String message = "";
		int cellNum = 0;
		try {
			int year = 0;
			int month = 0;
			try {
				Row row = sheet.getRow(0);
				Cell yearCell = row.getCell(0);
				yearCell.setCellType(Cell.CELL_TYPE_NUMERIC);
				year = (int) yearCell.getNumericCellValue();
				Cell monthCell = row.getCell(1);
				monthCell.setCellType(Cell.CELL_TYPE_NUMERIC);
				month = (int) monthCell.getNumericCellValue();
			} catch (Exception e) {
				message = "请输入正确的年与月";
				logger.warn(BaseDataUtils.dateToString(new Date()) + " BusPrecisionServiceImpl.zkzyxtfwgflQuota()方法异常"
						+ " " + message);
				return message;
			}

			String quotaName = sheet.getSheetName();
			List<Cell> list = new ArrayList<>();
			// 导入精益化指标数据
			List<BusPrecisionEntityDo> doList = new ArrayList<>();
			for (int i = 0; i < 6; i++) {
				BusPrecisionEntityDo precision = new BusPrecisionEntityDo();
				precision.setYear(year);
				precision.setMonth(month);
				precision.setQuotaName(quotaName);
				precision.setHeadDept(BaseDataUtils.getValue("yingxiaobu"));
				list.add(sheet.getRow(1).getCell(i));
				list.add(sheet.getRow(2).getCell(i));
				list.add(sheet.getRow(3).getCell(i));
				List<String> dataList = PoiUtils.getCellValue(sheet, list);
				list.clear();
				precision.setNotEndQuotaName(dataList.get(0));
				precision.setEndQuotaName(dataList.get(1));
				precision.setEndQuotaValue(dataList.get(2));
				doList.add(precision);
			}
			// 对数据进行遍历,运算值
			// 运算公式如下
			// 业扩报装服务规范率=0.4×业扩专业协同服务规范率+0.3×业扩服务时限达标率+0.3×客户服务满意率。
			// 业扩专业协同服务规范率=各协同环节未超时限的已归档业扩流程数/已归档的业扩流程总数×100%
			// 业扩服务时限达标率=业务办理时限达标的已归档业扩新装、增容流程数/已归档的业扩新装、增容流程数总和×100%
			// 客户服务满意率=客户评价满意的已归档业扩新装、增容流程数/已归档的业扩新装、增容流程总数×100%
			/* -------------- */
			BusPrecisionEntityDo da0 = doList.get(0);
			BusPrecisionEntityDo da1 = doList.get(1);
			// da1.setNotEndQuotaName(da0.getNotEndQuotaName());
			BigDecimal da02 = new BigDecimal(da0.getEndQuotaValue());
			BigDecimal da12 = new BigDecimal(da1.getEndQuotaValue());
			double notV1 = da02.divide(da12, 4, BigDecimal.ROUND_HALF_UP).doubleValue() * 100;
			da0.setNotEndQuotaValue(notV1);
			da1.setNotEndQuotaValue(notV1);
			/* -------------- */
			BusPrecisionEntityDo da2 = doList.get(2);
			BusPrecisionEntityDo da3 = doList.get(3);
			// da3.setNotEndQuotaName(da2.getNotEndQuotaName());
			BigDecimal da22 = new BigDecimal(da2.getEndQuotaValue());
			BigDecimal da32 = new BigDecimal(da3.getEndQuotaValue());
			double notV2 = da22.divide(da32, 4, BigDecimal.ROUND_HALF_UP).doubleValue() * 100;
			da2.setNotEndQuotaValue(notV2);
			da3.setNotEndQuotaValue(notV2);
			/* -------------- */
			BusPrecisionEntityDo da4 = doList.get(4);
			BusPrecisionEntityDo da5 = doList.get(5);
			// da5.setNotEndQuotaName(da4.getNotEndQuotaName());
			BigDecimal da42 = new BigDecimal(da4.getEndQuotaValue());
			BigDecimal da52 = new BigDecimal(da5.getEndQuotaValue());
			double notV3 = da42.divide(da52, 4, BigDecimal.ROUND_HALF_UP).doubleValue() * 100;
			da4.setNotEndQuotaValue(notV3);
			da5.setNotEndQuotaValue(notV3);
			BigDecimal d1 = new BigDecimal(String.valueOf(notV1));
			BigDecimal d2 = new BigDecimal(String.valueOf(notV2));
			BigDecimal d3 = new BigDecimal(String.valueOf(notV3));
			BigDecimal d11 = d1.multiply(new BigDecimal("0.4"));
			BigDecimal d21 = d2.multiply(new BigDecimal("0.3"));
			BigDecimal d31 = d3.multiply(new BigDecimal("0.3"));
			// 指标值
			double quotaValue = d11.add(d21).add(d31).doubleValue();
			da0.setQuotaValue(quotaValue);
			da1.setQuotaValue(quotaValue);
			da2.setQuotaValue(quotaValue);
			da3.setQuotaValue(quotaValue);
			da4.setQuotaValue(quotaValue);
			da5.setQuotaValue(quotaValue);
			cellNum = 1;
			// TODO _可以再次进行值的运算,保存进数据库.
			busPrecisionDao.save(da0);
			cellNum = 2;
			busPrecisionDao.save(da1);
			cellNum = 3;
			busPrecisionDao.save(da2);
			cellNum = 4;
			busPrecisionDao.save(da3);
			cellNum = 5;
			busPrecisionDao.save(da4);
			cellNum = 6;
			busPrecisionDao.save(da5);
			list.clear();
			// 导入指标相关意见数据
			message = precisionQuestionImp(sheet, year, month, quotaName);
			if (!message.equals("")) {
				return message;
			}
			message = "导入成功";
		} catch (Exception e) {
			message = "文档数据第" + cellNum + "行有异常";
			logger.warn(BaseDataUtils.dateToString(new Date()) + " BusPrecisionServiceImpl.zkzyxtfwgflQuota()方法异常" + e);
		}
		return message;
	}

	public void delteDat(int year, int month, String[] depts) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("year", year);
		map.put("month", month);
		map.put("depts", depts);

		// 查询该部门下的所有一级指标名称
		for (String dept : depts) {
			List<String> quotaList = busPrecisionDao.findQuotaName(year, month, dept);
			map.put("quotaNames", quotaList);
			if (quotaList != null && quotaList.size() > 0) {
				busPresQuestionDao.delete(map);
			}
		}
		busPrecisionDao.delete(map);

	}

	public List<BusPrecisionEntityDo> notEndQuotaQuery(int year, int month, String quotaName) throws Exception {
		return busPrecisionDao.findNotEndQuotaAndValue(year, month, quotaName);
	}
}
