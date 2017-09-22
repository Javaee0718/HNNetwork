package com.womow.henan.modules.province.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.womow.henan.commons.bean.Query;
import com.womow.henan.commons.utils.BaseDataUtils;
import com.womow.henan.modules.province.bean.dto.BusDataManageEntityDo;
import com.womow.henan.modules.province.dao.BusDataManageDao;
import com.womow.henan.modules.province.service.BusDataManageService;

@Service
@Transactional
public class BusDataManageServiceImpl implements BusDataManageService {

	private Logger logger = LoggerFactory.getLogger(BusDataManageService.class);

	@Autowired
	private BusDataManageDao busDataManageDao;

	public List<String> findAllQuotaName(Map<String, Object> map) throws Exception {
		List<String> modules = busDataManageDao.findAllQuotaName(map);
		return modules;
	}

	public List<List<BusDataManageEntityDo>> queryAllData(List<String> quotaNames, Map<String, Object> map)
			throws Exception {
		List<List<BusDataManageEntityDo>> list = new ArrayList<>();

		if (quotaNames != null && quotaNames.size() > 0) {
			for (String quotaName : quotaNames) {
				map.put("quotaName", quotaName);
				List<BusDataManageEntityDo> daMas = busDataManageDao.queryByYearAndModule(map);
				if (daMas != null && daMas.size() > 0) {
					BusDataManageEntityDo do1 = null;
					for (BusDataManageEntityDo dama : daMas) {
						// 计算该数据的排名
						int daMaSort = BaseDataUtils.daMaSort(dama);
						dama.setSortRank(daMaSort);
						// 修改指标名称,用于前台展示
						String childQuotaName = dama.getChildQuotaName();

						// 将总指标放于集合中的第一个位置
						if (dama.getChildQuotaName().equals(dama.getQuotaName())) {
							do1 = dama;
						}
						// 转换段位(数字与字母的转换)
						if (!BaseDataUtils.getValue(dama.getNowYearTarGrade()).equals("")) {
							dama.setNowYearTarGrade(BaseDataUtils.getValue(dama.getNowYearTarGrade())); // 当年段位
						}
						if (!BaseDataUtils.getValue(dama.getCheckBaseLineGrade()).equals("")) {
							dama.setCheckBaseLineGrade(BaseDataUtils.getValue(dama.getCheckBaseLineGrade())); // 考核底线段位
						}
						if (!BaseDataUtils.getValue(String.valueOf((int) dama.getHenanGrade())).equals("")) {
							dama.setHenanGradeView(BaseDataUtils.getValue(String.valueOf((int) dama.getHenanGrade()))); // 河南实际段位
						}
					}
					if (do1 != null) {
						daMas.remove(do1);
						daMas.add(0, do1);
					}
				}
				if (daMas != null && daMas.size() > 0) {
					list.add(daMas);
				}
			}
		}
		return list;

	}

	@Override
	public String findNewYear() throws Exception {
		String year = busDataManageDao.findNewYear();
		List<String> partYears = busDataManageDao.findPartYearByYear(year);
		if (partYears != null && partYears.size() > 0) {
			if (partYears.contains(BaseDataUtils.getValue("quannian"))) {
				return year + "=" + BaseDataUtils.getValue("quannian");
			} else if (partYears.contains(BaseDataUtils.getValue("disanjidu"))) {
				return year + "=" + BaseDataUtils.getValue("disanjidu");
			} else if (partYears.contains(BaseDataUtils.getValue("shangbannian"))) {
				return year + "=" + BaseDataUtils.getValue("shangbannian");
			} else if (partYears.contains(BaseDataUtils.getValue("diyijidu"))) {
				return year + "=" + BaseDataUtils.getValue("diyijidu");
			}
		}
		return "";
	}

	@Override
	public List<List<BusDataManageEntityDo>> earlyWarning(Map<String, Object> map, List<String> modules)
			throws Exception {
		List<List<BusDataManageEntityDo>> list = new ArrayList<List<BusDataManageEntityDo>>();
		if (modules != null && modules.size() > 0) {
			for (String module : modules) {
				map.put("module", module);
				// 总指标名集合
				List<String> quotaNames = busDataManageDao.queryQuotaNameByYearAndModule(map);
				if (quotaNames != null && quotaNames.size() > 0) {
					for (String quotaName : quotaNames) {
						map.put("quotaName", quotaName);
						List<BusDataManageEntityDo> dataMn = busDataManageDao.queryByYearAndModule(map);
						if (dataMn != null && dataMn.size() > 0) {
							List<String> warnMessage;
							List<BusDataManageEntityDo> ll = new ArrayList<>();
							for (BusDataManageEntityDo dtMn : dataMn) {
								warnMessage = new ArrayList<>();
								String quotaNamess = "";
								// 总指标
								if (dtMn.getIsBigQuota() == 1) {
									// 总指标
									double henanGrade = dtMn.getHenanGrade(); // 实际段位
									double henanScore = dtMn.getHenanScore(); // 实际得分
									String nowYearTarGrade = dtMn.getNowYearTarGrade(); // 目标段位
									double nowGra;
									String nowYearTarScore = dtMn.getNowYearTarScore(); // 目标得分
									double nowSc; // 目标得分

									if (nowYearTarGrade == null || "".equals(nowYearTarGrade)) { // 目标段位
										nowGra = 0;
									} else {
										nowGra = Double.parseDouble(nowYearTarGrade);
									}
									// 比较段位
									BigDecimal b1 = new BigDecimal(String.valueOf(nowGra));
									BigDecimal b2 = new BigDecimal(String.valueOf(henanGrade));
									if (b1.subtract(b2).doubleValue() >= 3) {
										dtMn.setWarningGrade("第1等级");
										warnMessage.add("实际段位低于当年目标段位3段及以上");
									} else if (b1.subtract(b2).doubleValue() >= 2
											&& b1.subtract(b2).doubleValue() < 3) {
										dtMn.setWarningGrade("第2等级");
										warnMessage.add("实际段位低于当年目标段位2段及以上");
									} else if (b1.subtract(b2).doubleValue() > 0 && b1.subtract(b2).doubleValue() < 2) {
										dtMn.setWarningGrade("第3等级");
										warnMessage.add("实际段位低于当年目标段位1段及以上");
									}

									if (nowYearTarScore == null || "".equals(nowYearTarScore)) { // 目标得分
										nowSc = 0;
									} else {
										nowSc = Double.parseDouble(nowYearTarScore);
									}
									// 比较得分
									BigDecimal b3 = new BigDecimal(String.valueOf(nowSc));
									BigDecimal b4 = new BigDecimal(String.valueOf(henanScore));
									if (b3.subtract(b4).doubleValue() > 6) {
										dtMn.setWarningGrade("第1等级");
										warnMessage.add(0, "指标负贡献超过6分");
									} else if (b3.subtract(b4).doubleValue() > 4
											&& b3.subtract(b4).doubleValue() <= 6) {
										if (!"第1等级".equals(dtMn.getWarningGrade())) {
											dtMn.setWarningGrade("第2等级");
											warnMessage.add(0, "指标负贡献超过4分");
										} else {
											warnMessage.add("指标负贡献超过4分");
										}
									} else if (b3.subtract(b4).doubleValue() > 0
											&& b3.subtract(b4).doubleValue() <= 4) {
										if (!"第1等级".equals(dtMn.getWarningGrade())
												&& !"第2等级".equals(dtMn.getWarningGrade())) {
											dtMn.setWarningGrade("第3等级");
										}
										warnMessage.add("指标负贡献超过0分");
									}

									// TODO CAI_实际值中包含有 ">="等符号的意义

									// 实际值与目标值
									double henanValue = dtMn.getHenanValue(); // 实际值
									String nowYearTarValue = dtMn.getNowYearTarValue(); // 当前目标值
									double nowVal;

									if (nowYearTarValue == null || "".equals(nowYearTarValue)) {
										nowVal = 0;
									} else {
										nowVal = Double.parseDouble(nowYearTarValue);
									}
									if (nowVal - henanValue > 0) {
										if (!"第1等级".equals(dtMn.getWarningGrade())
												&& !"第2等级".equals(dtMn.getWarningGrade())) {
											dtMn.setWarningGrade("");
											dtMn.setWarningInfo("力争提升指标");
											warnMessage.add(0, "实际值低于当年目标值");
										} else {
											warnMessage.add("实际值低于当年目标值");
										}
									}
									// 重点提升指标
									// 一级指标未达到国网实际平均段位的报警,false,则达到,true,则未达到
									boolean is = BaseDataUtils.checkGradeTrOrFal(dtMn);
									if (is) {
										if (!"第1等级".equals(dtMn.getWarningGrade())
												&& !"第2等级".equals(dtMn.getWarningGrade())) {
											dtMn.setWarningGrade("");
											dtMn.setWarningInfo("力争提升指标");
											warnMessage.add(0, "实际段位未达到国网平均段位水平");
										} else {
											warnMessage.add("实际段位未达到国网平均段位水平");
										}
									}
									// 同浙江相比段位水平预警
									double zhejiangGrade = dtMn.getZhejiangGrade();
									if (henanGrade - zhejiangGrade < 0) {
										if (is) {
											if (!"第1等级".equals(dtMn.getWarningGrade())
													&& !"第2等级".equals(dtMn.getWarningGrade())) {
												dtMn.setWarningGrade("");
												dtMn.setWarningInfo("重点提升指标");
												warnMessage.add(0, "实际段位未达到浙江公司段位水平");
											} else {
												warnMessage.add("实际段位未达到浙江公司段位水平");
											}
										}
									}
									// 与去年全年段位水平进行比较
									List<Integer> grades = busDataManageDao.findHenanGradeByYear(dtMn.getYear() - 1);
									if (grades != null && grades.size() > 0) {
										while (grades.indexOf(0) != -1) {
											grades.remove(0);
										}
										int gradeN = 0;
										for (Integer gradeNum : grades) {
											gradeN += gradeNum;
										}
										if (henanGrade - gradeN / grades.size() < 0) {

											if (!"第1等级".equals(dtMn.getWarningGrade())
													&& !"第2等级".equals(dtMn.getWarningGrade())) {
												dtMn.setWarningGrade("");
												dtMn.setWarningInfo("重点提升指标");
												warnMessage.add(0, "指标段位低于去年全年段位平均水平");
											} else {
												warnMessage.add("指标段位低于去年全年段位平均水平");
											}
										}
									}

									// 较历史段位,做同比与环比
									// 环比.
									Map<String, Object> map2 = new HashMap<>();
									int year = dtMn.getYear();
									map2.put("year", year);
									map2.put("module", dtMn.getModuleName());
									map2.put("quotaNames", dtMn.getQuotaName());
									map2.put("childQuotaName", dtMn.getChildQuotaName());

									String partYear = dtMn.getPartYear();
									if (partYear != null) {
										if (partYear.contains(BaseDataUtils.getValue("quannian"))) {
											map2.put("partYear", BaseDataUtils.getValue("disanjidu"));
										} else if (partYear.contains(BaseDataUtils.getValue("disanjidu"))) {
											map2.put("partYear", BaseDataUtils.getValue("shangbannian"));
										} else if (partYear.contains(BaseDataUtils.getValue("shangbannian"))) {
											map2.put("partYear", BaseDataUtils.getValue("diyijidu"));
										} else if (partYear.contains(BaseDataUtils.getValue("diyijidu"))) {
											map2.put("year", year - 1);
											map2.put("partYear", BaseDataUtils.getValue("quannian"));
										}
									}
									List<BusDataManageEntityDo> huanbiData = busDataManageDao
											.queryByYearAndModule(map2);
									if (huanbiData != null) {
										if (huanbiData.size() == 1) {
											// 环比 比较段位
											BusDataManageEntityDo doo = huanbiData.get(0);
											double oldGrade = doo.getHenanGrade();
											double newGrade = dtMn.getHenanGrade();
											if (oldGrade - newGrade > 0) {
												if (!"第1等级".equals(dtMn.getWarningGrade())
														&& !"第2等级".equals(dtMn.getWarningGrade())) {
													dtMn.setWarningGrade("第3等级");
												}
												warnMessage.add("本季度实际段位低于上季度实际段位");
											}

										} else if (huanbiData.size() > 1) {
											logger.warn(BaseDataUtils.dateToString(new Date()) + "有重复数据"
													+ map2.get("year") + map2.get("partYear") + map2.get("module")
													+ map2.get("quotaNames") + map2.get("childQuotaName"));
										}
									}
									// 同比
									map2.put("year", year - 1);
									List<BusDataManageEntityDo> tongbiData = busDataManageDao
											.queryByYearAndModule(map2);
									if (huanbiData != null) {
										if (huanbiData.size() == 1) {
											// 环比 比较段位
											BusDataManageEntityDo doo = tongbiData.get(0);
											double oldGrade = doo.getHenanGrade();
											double newGrade = dtMn.getHenanGrade();
											if (oldGrade - newGrade > 0) {
												if (!"第1等级".equals(dtMn.getWarningGrade())
														&& !"第2等级".equals(dtMn.getWarningGrade())) {
													dtMn.setWarningGrade("第3等级");
												}
												warnMessage.add("本季度实际段位低于上年同季度实际段位");
											}

										} else if (huanbiData.size() > 1) {
											logger.warn(BaseDataUtils.dateToString(new Date()) + "有重复数据"
													+ map2.get("year") + map2.get("partYear") + map2.get("module")
													+ map2.get("quotaNames") + map2.get("childQuotaName"));
										}
									}
								} else {
									// 分项子指标
									// 去掉其实际段位.因为分项子指标是没有段位的
									dtMn.setHenanGrade(-1l);
									dtMn.setNowYearTarGrade("");
									/*
									 * if (dtMn.getChildQuotaName().indexOf(":")
									 * != -1) {
									 * 
									 * dtMn.setChildQuotaName(dtMn.
									 * getChildQuotaName()
									 * .substring(dtMn.getChildQuotaName().
									 * indexOf(":") + 1)); } // 修改指标名称,用于前台展示 if
									 * (dtMn.getChildQuotaName().indexOf("：") !=
									 * -1) { dtMn.setChildQuotaName(dtMn.
									 * getChildQuotaName()
									 * .substring(dtMn.getChildQuotaName().
									 * indexOf("：") + 1)); }
									 */
								}
								// 比较河南与浙江实际值
								double henanValue = dtMn.getHenanValue();
								double zhejiangValue = dtMn.getZhejiangValue();
								if (henanValue - zhejiangValue < 0) {
									if (!"第1等级".equals(dtMn.getWarningGrade())
											&& !"第2等级".equals(dtMn.getWarningGrade())) {
										dtMn.setWarningGrade("");
										dtMn.setWarningInfo("力争提升指标");
										warnMessage.add(0, "指标实际值低于浙江指标值");
									} else {
										warnMessage.add("指标实际值低于浙江指标值");
									}
								}
								// 比较河南与上年全年平均值
								List<Integer> values = busDataManageDao.findHenanValueByYear(dtMn.getYear() - 1);
								if (values != null && values.size() > 0) {
									while (values.contains(0)) {
										values.remove(new Integer(0));
									}
									int henanVal = 0;
									for (Integer value : values) {
										henanVal += value;
									}
									if (henanValue - (henanVal / values.size()) < 0) {
										if (!"第1等级".equals(dtMn.getWarningGrade())
												&& !"第2等级".equals(dtMn.getWarningGrade())) {
											dtMn.setWarningGrade("");
											dtMn.setWarningInfo("力争提升指标");
											warnMessage.add(0, "指标实际值低于上年平均值");
										} else {
											warnMessage.add("指标实际值低于上年平均值");
										}
									}
								}

								// TODO CAI_5.有段位下降风险的预警

								// 总与分项的实际值进行比较,false,则高于,true则低于
								// 该指标平均值
								int avgValue = dtMn.getAvgValue();
								if ((henanValue - avgValue) < 0 && avgValue != 0) {
									if (!"第1等级".equals(dtMn.getWarningGrade())
											&& !"第2等级".equals(dtMn.getWarningGrade())) {
										dtMn.setWarningGrade("");
										dtMn.setWarningInfo("力争提升指标");
										warnMessage.add(0, "指标实际值低于国网平均实际值");
									} else {
										warnMessage.add("指标实际值低于国网平均实际值");
									}
								}
								/*
								 * boolean is =
								 * BaseDataUtils.checkValueTrOrFal(dtMn); if
								 * (is) { if
								 * (!"第1等级".equals(dtMn.getWarningGrade()) &&
								 * !"第2等级".equals(dtMn.getWarningGrade())) {
								 * dtMn.setWarningGrade("");
								 * dtMn.setWarningInfo("力争提升指标");
								 * warnMessage.add(0, "指标实际值低于国网平均实际值"); } else
								 * { warnMessage.add("指标实际值低于国网平均实际值"); } }
								 */
								if (warnMessage.size() > 0) {
									dtMn.setMessages(warnMessage);
									String s = "";
									if (warnMessage.size() > 1) {
										for (String msg : warnMessage) {
											s += msg + BaseDataUtils.getEnter();
										}
										dtMn.setWarnMessage(s);
									}
									ll.add(dtMn);
								}
							}
							if (ll != null && ll.size() > 0) {
								BusDataManageEntityDo aaa = null;
								for (BusDataManageEntityDo doo : ll) {
									// 转换段位(数字与字母的转换)
									if (!BaseDataUtils.getValue(doo.getNowYearTarGrade()).equals("")) {
										doo.setNowYearTarGrade(BaseDataUtils.getValue(doo.getNowYearTarGrade())); // 当年段位
									}
									if (!BaseDataUtils.getValue(doo.getCheckBaseLineGrade()).equals("")) {
										doo.setCheckBaseLineGrade(BaseDataUtils.getValue(doo.getCheckBaseLineGrade())); // 考核底线段位
									}
									if (!BaseDataUtils.getValue(String.valueOf((int) doo.getHenanGrade())).equals("")) {
										doo.setHenanGradeView(
												BaseDataUtils.getValue(String.valueOf((int) doo.getHenanGrade()))); // 河南实际段位
									}
									// doo.setNowYearTarGrade(BaseDataUtils.getValue(doo.getNowYearTarGrade()));
									// // 当年段位
									// doo.setCheckBaseLineGrade(BaseDataUtils.getValue(doo.getCheckBaseLineGrade()));
									// // 考核底线段位
									// doo.setHenanGradeView(
									// BaseDataUtils.getValue(String.valueOf((int)
									// doo.getHenanGrade()))); // 河南实际段位
									if (doo.getQuotaName().equals(doo.getChildQuotaName())) {
										aaa = doo;
									}
								}
								if (aaa != null) {
									ll.remove(aaa);
									ll.add(0, aaa);
								}
								list.add(ll);
							}
						}
					}
				}
			}
		}
		return list;
	}

	public List<Integer> findYears() {
		return busDataManageDao.findYears();
	}

	public int findCont(Map<String, Object> map) throws Exception {

		return busDataManageDao.dataCount(map);
	}

	@Override
	public List<String> findAllModules(Query query) {

		return busDataManageDao.findallModules(query);
	}

}
