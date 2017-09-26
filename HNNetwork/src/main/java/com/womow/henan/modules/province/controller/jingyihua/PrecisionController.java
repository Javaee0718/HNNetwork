package com.womow.henan.modules.province.controller.jingyihua;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.womow.henan.commons.utils.BaseDataUtils;
import com.womow.henan.commons.web.BaseController;
import com.womow.henan.modules.province.bean.dto.BusPrecisionEntityDo;
import com.womow.henan.modules.province.service.BusPrecisionService;
import com.womow.henan.modules.sys.security.utils.ShiroUtils;
import com.womow.henan.modules.sys.user.dao.BusUserDao;

/**
 * @Description 精益化指标controller
 * @author CAI modules@163.com
 * @data 2017年9月17日下午8:45:53
 * @version V1.0
 */
@Controller
@RequestMapping("precision")
public class PrecisionController extends BaseController {

	@Autowired
	private BusPrecisionService busPrecisionService;
	@Autowired
	private BusUserDao busUserDao;

	/**
	 * 跳转至精益化指标数据导入页面
	 */
	@RequestMapping("toPg")
	public String toPreImpl(Model model) {
		Subject subject = ShiroUtils.getSubject();
		boolean isAdmin = subject.hasRole("admin");
		// 携带是否是管理员的角色,该页面对非管理员删除数据功能有限制
		if (isAdmin) {
			model.addAttribute("isAdmin", "1");
		}
		return "jingyihua/Quanxian_set";
	}

	/**
	 * 各部门精益化文档导入
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/precisionFile")
	public Map<String, String> precisionFileUpload(@RequestParam("file") MultipartFile file) {
		// 该功能要求 -> 上传者只能上传其所属部门的指标文档
		String message = "";
		Map<String, String> map = new HashMap<>();
		if (file == null) {
			message = "请上传文档";
			map.put("msg", message);
			return map;
		}
		String fileName = file.getOriginalFilename();
		try {
			String fileExtension = FilenameUtils.getExtension(fileName);
			Subject subject = SecurityUtils.getSubject();
			if (!fileExtension.equals("xls") && !fileExtension.equals("xlsx")) {
				message = "请上传excel文档";
				map.put("msg", message);
				return map;
			}
			// TODO 判断用户的权限,是否是该部门. 用该部门的用户权限与文档进行对比.
			if (fileName.startsWith(BaseDataUtils.getValue("yingxiaobu"))) {
				if (subject.isPermitted("yingxiaobu")) {
					message = busPrecisionService.precisionFileUpload(file);
				} else {
					message = "您并没有获得该部门的权限";
				}
				map.put("msg", message);
				return map;
			}
			if (fileName.startsWith(BaseDataUtils.getValue("wuzibu"))) {
				if (subject.isPermitted("wuzibu")) {
					message = busPrecisionService.precisionFileUpload(file);
				} else {
					message = "您并没有获得该部门的权限";
				}
				map.put("msg", message);
				return map;
			}
			if (fileName.startsWith(BaseDataUtils.getValue("tiaokongzhongxin"))) {
				if (subject.isPermitted("tiaokongzhongxin")) {
					message = busPrecisionService.precisionFileUpload(file);
				} else {
					message = "您并没有获得该部门的权限";
				}
				map.put("msg", message);
				return map;
			}
			if (fileName.startsWith(BaseDataUtils.getValue("kexinbu"))) {
				if (subject.isPermitted("kexinbu")) {
					message = busPrecisionService.precisionFileUpload(file);
				} else {
					message = "您并没有获得该部门的权限";
				}
				map.put("msg", message);
				return map;
			}
			message = fileName + " 文档名称不符合规则";
		} catch (Exception e) {
			logger.warn(BaseDataUtils.dateToString(new Date()) + "PrecisionController.precisionFileUpload()异常"
					+ e.getMessage());
			message = fileName + " 上传异常";
		}
		map.put("msg", message);
		return map;
	}

	/**
	 * 用户删除某部门的某日期所有数据
	 */
	@RequestMapping("/delDat")
	public String deleteData(Date date, String[] depts, RedirectAttributes redirectAttributes) {
		// 要求-> 删除者,除了拥有管理员权限之外,均删除其所属部门的数据
		// -> 管理员,可以删除多个部门的数据
		String message = "";
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			// 判断是否是管理员 -> 是 -> 对部门进行解析,获取部门 ->删除
			// -> 否 -> 获取该用户的权限与部门 ->删除
			Subject subject = ShiroUtils.getSubject();
			if (subject.hasRole("admin")) {
				// 是管理员
				if (depts != null) {
					if (depts.length == 0) {
						message = "请选择部门";
						addMessage(redirectAttributes, message);
						return "redirect:toPg";
					} else {
						busPrecisionService.delteDat(year, month, depts);
					}
				}
			} else {
				List<String> allPerms = busUserDao.findAllPerms(ShiroUtils.getUserId());
				depts = (String[]) allPerms.toArray();
			}
			message = "删除成功";
			addMessage(redirectAttributes, message);
			return "redirect:toPg";
		} catch (Exception e) {
			message = "删除失败";
			addMessage(redirectAttributes, message);
			logger.warn(BaseDataUtils.dateToString(new Date()) + this.getClass() + e.getMessage());
			return "redirect:toPg";
		}
	}

	/**
	 * 精益化一级指标 跳转至 -> 精益化指标中间层展示页面
	 * 
	 * @param quotaName
	 *            指标名称
	 * @return String 逻辑视图
	 */
	@RequestMapping("/preQuota")
	public String onePageView(Date date, String quotaName, Model model) {
		/**
		 * 首页点击某图表 (源头:预警相关数据库): -> 展示相关精益化一级指标 (源头 : 根据上页面源头库,可获取精益化一级指标名 ->
		 * 然后根据页面,去查询相关精益化指标,跳转至某一页面 ) ++> : 所以:精益化统计首页,一级指标页 ,目前均不能开发.
		 * ->需等待预警指标确定后再进行相关开发操作.
		 */
		/**
		 * 思路: 再一个大的controller中,判断是哪一个指标,然后统一调用service提供的对应指标的接口,进行开发
		 */
		try {
			if (date != null) {
				int year = date.getYear();
				int month = date.getMonth() + 1;
				if ("业扩报装服务规范率".equals(quotaName)) {
					/*--------------  该三个指标非末端指标结构类似  start  --------------*/
					List<BusPrecisionEntityDo> list = busPrecisionService.notEndQuotaQuery(year, month, quotaName);
					return "jingyihua/newPage1";
				} else if ("智能电网调度功能应用完成率".equals(quotaName)) {
					List<BusPrecisionEntityDo> list = busPrecisionService.notEndQuotaQuery(year, month, quotaName);
					return "jingyihua/newPage4";
				} else if ("信息通信系统运行指数".equals(quotaName)) {
					List<BusPrecisionEntityDo> list = busPrecisionService.notEndQuotaQuery(year, month, quotaName);
					return "jingyihua/newPage7";
					/*--------------  该三个指标非末端指标结构类似  end  --------------*/
				} else if ("优质服务评价指数".equals(quotaName)) {
					/*--------------  该四个指标非末端指标结构类似  start  --------------*/
					List<BusPrecisionEntityDo> list = busPrecisionService.notEndQuotaQuery(year, month, quotaName);
					// 扣分项 -> 四个末端指标
					return "jingyihua/newPage6";
				} else if ("物资采购计划完成率".equals(quotaName)) {
					List<BusPrecisionEntityDo> list = busPrecisionService.notEndQuotaQuery(year, month, quotaName);
					// 加减分项 ->四个末端指标
					return "jingyihua/newPage2";
				} else if ("物资合同履约完成率".equals(quotaName)) {
					List<BusPrecisionEntityDo> list = busPrecisionService.notEndQuotaQuery(year, month, quotaName);
					// 减分项 ->五个末端指标
					return "jingyihua/newPage3";
				} else if ("营销服务规范率".equals(quotaName)) {
					List<BusPrecisionEntityDo> list = busPrecisionService.notEndQuotaQuery(year, month, quotaName);
					// 加减分项 ->三个末端指标
					return "jingyihua/newPage5";
					/*--------------  该四个指标非末端指标结构类似  end  --------------*/
				}
			}
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
		logger.warn(BaseDataUtils.dateToString(new Date()) + " 没有匹配到该指标");
		return null;
	}
}
