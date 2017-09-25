package com.womow.henan.modules.province.controller.jingyihua;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.realm.AuthorizingRealm;
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
	 * 
	 */
	@RequestMapping("toPg")
	public String toPreImpl(Model model) {
		Subject subject = ShiroUtils.getSubject();
		boolean isAdmin = subject.hasRole("admin");
		if (isAdmin) {
			model.addAttribute("isAdmin", "1");
		}
		return "jingyihua/Quanxian_set.jsp";
	}
	
	/**
	 * 各部门精益化文档导入
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/precisionFile")
	public Map<String, String> precisionFileUpload(@RequestParam("file") MultipartFile file) {
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
		String message = "";
		try {
			/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date dt = format.parse(date);*/
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH)+1;
			// 判断是否是管理员 -> 是 -> 对部门进行解析,获取部门 ->删除
			// -> 否 -> 获取该用户的权限与部门 ->删除
			Subject subject = ShiroUtils.getSubject();
			if (subject.hasRole("admin")) {
				// 是管理员
				if (depts != null) {
					if (depts.length == 0) {
						message = "请选择部门";
						addMessage(redirectAttributes, message);
						return "redirect:/jingyihua/Quanxian_set";
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
			return "redirect:/incl/jingyihua/Quanxian_set";
		} catch (Exception e) {
			message = "删除失败";
			addMessage(redirectAttributes, message);
			logger.warn(BaseDataUtils.dateToString(new Date()) + this.getClass() + e.getMessage());
			return "redirect:/incl/jingyihua/Quanxian_set";
		}
	}
	
	/**
	 * 精益化指标中间层页面四个末端指标读取方法
	 */
	@RequestMapping("/onePre")
	public String onePageView(Date date) {
		/**
		 * 首页点击某图表 (源头:预警相关数据库): -> 
		 * 					展示相关精益化一级指标 (源头 : 根据上页面源头库,可获取精益化一级指标名 -> 然后根据页面,去查询相关精益化指标,跳转至某一页面 )
		 * 		++> : 所以:精益化统计首页,一级指标页 ,目前均不能开发. ->需等待预警指标确定后再进行相关开发操作.
		 */
		try {
			
		} catch (Exception e) {
			
		}
		return null;
	}
}
