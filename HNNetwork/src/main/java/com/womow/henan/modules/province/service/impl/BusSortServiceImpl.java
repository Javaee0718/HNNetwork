package com.womow.henan.modules.province.service.impl;

import java.io.InputStream;
import java.util.Date;

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
import com.womow.henan.modules.province.bean.po.BusSortEntity;
import com.womow.henan.modules.province.dao.BusSortDao;
import com.womow.henan.modules.province.service.BusSortService;

@Service
@Transactional
public class BusSortServiceImpl implements BusSortService {

	@Autowired
	private BusSortDao busSortDao;

	private Logger logger = LoggerFactory.getLogger(BusSortService.class);

	public String sortFileUp(MultipartFile file) {
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
				io = file.getInputStream();
				Workbook workbook;
				if ("xls".equals(extensionName)) {
					workbook = new HSSFWorkbook(io);
				} else {
					workbook = new XSSFWorkbook(io);
				}
				int numberOfSheets = workbook.getNumberOfSheets();
				if (numberOfSheets >= 1) {
					Sheet firstSheet = workbook.getSheetAt(0);
					// 读取cell文档()
					// row索引
					int rowNum = firstSheet.getLastRowNum();
					if (rowNum == 0) {
						message = "文档中没有相关数据";
						return message;
					}
					String yearReg = "\\d{4}";
					String sortReg = "\\d+";
					BusSortEntity sortEnt = new BusSortEntity();
					logger.info(BaseDataUtils.dateToString(new Date()) + " 开始导入河南省年度排名文档");
					for (int i = 1; i < rowNum + 1; i++) {
						Row eveRow = firstSheet.getRow(i);
						Cell yearCell = eveRow.getCell(0);
						yearCell.setCellType(Cell.CELL_TYPE_STRING);
						String year = yearCell.getStringCellValue();
						if (!year.matches(yearReg)) {
							message = "第" + (i + 1) + "行,第1列年份有误";
							return message;
						}
						Cell sortCell = eveRow.getCell(1);
						sortCell.setCellType(Cell.CELL_TYPE_STRING);
						String sort = sortCell.getStringCellValue();
						if (!sort.matches(sortReg)) {
							message = "第" + (i + 1) + "行,第2列数据有误,且不能为空";
							return message;
						}
						sortEnt.setYear(year);
						sortEnt.setSort(sort);
						busSortDao.save(sortEnt);
						logger.info(BaseDataUtils.dateToString(new Date()) + " 河南省年度排名文档 " + year + " " + sort);
					}
					logger.info(BaseDataUtils.dateToString(new Date()) + " 导入河南省年度排名文档成功");
					message = "文档导入成功";
					return message;
				} else {
					message = "文档内容为空";
					return message;
				}
			} catch (Exception e) {
				logger.warn(BaseDataUtils.dateToString(new Date()) + " 导入河南省年度排名文档异常 " + e.getMessage());
			}
		}
		message = "导入失败";
		return message;
	}
}
