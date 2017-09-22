package com.womow.henan.modules.province.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import com.womow.henan.commons.bean.vo.ServerResponse;
import com.womow.henan.commons.utils.BaseDataUtils;
import com.womow.henan.commons.utils.PoiUtils;
import com.womow.henan.modules.province.bean.dto.BusValueEntityDo;
import com.womow.henan.modules.province.dao.BusValueDao;
import com.womow.henan.modules.province.service.BusValueService;
import com.womow.henan.modules.sys.security.utils.ShiroUtils;

/**
 * @author 蔡长盟
 * @description
 * @version 2017年8月4日
 * @eamil modules@163.com
 */
@Service
@Transactional
public class BusValueServiceImpl implements BusValueService {

	private Logger logger = LoggerFactory.getLogger(BusValueService.class);

	@Autowired
	private BusValueDao busValueDao;

	public String valueFileUp(MultipartFile file) {

		// 文件名
		String fileName = file.getOriginalFilename();
		String message = "";
		// 文件扩展名
		String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (!"xls".equals(extensionName) && !"xlsx".equals(extensionName)) {
			message = "请上传excel文档";
			return message;
		} else {
			InputStream io = null;
			try {
				// 文件读取流
				io = file.getInputStream();
				// poi excel读取对象
				Workbook workbook;
				if ("xls".equals(extensionName)) {
					workbook = new HSSFWorkbook(io);
				} else {
					workbook = new XSSFWorkbook(io);
				}
				int numberOfSheets = workbook.getNumberOfSheets();
				if (numberOfSheets == 0) {
					message = "请上传有内容的excel文档";
					return message;
				}
				Sheet sheet = workbook.getSheetAt(0);
				// 获取模板中第一行中的年与季度
				Row row = sheet.getRow(0);
				if (row.getCell(0) == null || row.getCell(1) == null) {
					message = "请输入该文档的年份与季度";
					return message;
				}

				Cell yearCell = row.getCell(0);
				Cell partYearCell = row.getCell(1);
				yearCell.setCellType(Cell.CELL_TYPE_STRING);
				partYearCell.setCellType(Cell.CELL_TYPE_STRING);

				int year = Integer.parseInt(yearCell.getStringCellValue());
				String partYear = row.getCell(1).getStringCellValue();
				if ("".equals(partYear)) {
					message = "请输入该文档的年份与季度";
					return message;
				}
				// 获取当前sheet页的行数-1
				int lastRowNum = sheet.getLastRowNum();
				if (lastRowNum <= 1) {
					message = "文档中没有数据";
					return message;
				}
				// 放置指标名,用于判断指标名称是否重复
				List<String> quotaNames = new ArrayList<>();
				List<Cell> cells = new ArrayList<>();
				// 获取cell的长度
				int cellLength = sheet.getRow(1).getLastCellNum();

				// 创建实体对象,用于保存
				BusValueEntityDo doo = new BusValueEntityDo();
				Date date = new Date();
				doo.setYear(year);
				doo.setPartYear(partYear);
				doo.setCreateUserId(ShiroUtils.getUserId());
				doo.setCreateDate(date);
				// 存储指标名称,用于判断不得重复.
				List<String> quotaNameList = new ArrayList<>();
				for (int i = 2; i <= lastRowNum; i++) {
					Row dataRow = sheet.getRow(i);
					for (int j = 0; j < cellLength; j++) {
						cells.add(dataRow.getCell(j));
					}
					List<String> cellValues = PoiUtils.getCellValue(sheet,cells);
					if (cellValues == null || cellValues.size() == 0) {
						message = "指标名称不能为空";
						return message;
					}
					// 校验指标名
					String quotaName = cellValues.get(0);
					if (quotaNameList.contains(quotaName)) {
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						message = "指标名称重复-" + quotaName;
						return message;
					} else {
						quotaNameList.add(quotaName);
					}
					if ("".equals(quotaName.trim())) {
						StringBuffer stringBuilder = new StringBuffer();
						stringBuilder.append("第");
						stringBuilder.append((i + 1));
						stringBuilder.append("行,第1列的数据有误");
						message = stringBuilder.toString();
						return message;
					}
					doo.setQuotaName(quotaName);
					doo.setHeadDept(cellValues.get(1));
					doo.setQuotaFullMark(cellValues.get(2));
					doo.setPublishCycle(cellValues.get(3));
					doo.setQuotaUnit(cellValues.get(4));
					doo.setAppraiseMethod(cellValues.get(5));
					doo.setPosAndNegDir(cellValues.get(6));
					doo.setAttribute(cellValues.get(7));

					// 对段位进行处理,如果是字母,将其转化为对应的数字
					doo.setNowYearTarGrade(BaseDataUtils.getValue(cellValues.get(8)));
					doo.setCheckBaseLineGrade(BaseDataUtils.getValue(cellValues.get(11)));

					doo.setNowYearTarScore(cellValues.get(9));
					doo.setNowYearTarValue(cellValues.get(10));
					doo.setCheckBaseLineScore(cellValues.get(12));
					doo.setQuotaType(cellValues.get(13));
					String quotaFullMark = doo.getQuotaFullMark();
					if (quotaFullMark.equals("")) {
						message = "指标权重不能为空";
						return message;
					}
					busValueDao.save(doo);
					cells.clear();

					// 日志
					// 用于日志文件记录信息
					StringBuffer slog = new StringBuffer();
					slog.append(BaseDataUtils.dateToString(date));
					slog.append("用户ID-");
					slog.append(ShiroUtils.getUserId());
					slog.append("-上传年度对标段位评价文档,执行了BusValueServiceImpl.dataFileUp方法,添加了-");
					slog.append(year);
					slog.append(" ");
					slog.append(partYear);
					slog.append(" ");
					slog.append(quotaName);
					slog.append("-的数据");
					logger.info(slog.toString());
				}
				message = "文件导入成功";
				return message;
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				if (io != null) {
					try {
						io.close();
					} catch (IOException e) {
						io = null;
					}
				}
			}
			message = "文件导入失败";
			return message;
		}
	}

}
