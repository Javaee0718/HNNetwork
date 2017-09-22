package com.womow.henan.modules.sys.user.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.womow.henan.commons.bean.PageUtils;
import com.womow.henan.commons.bean.Query;
import com.womow.henan.commons.utils.BaseDataUtils;
import com.womow.henan.commons.web.BaseController;
import com.womow.henan.modules.sys.security.dto.BusAuthorityEntityDo;
import com.womow.henan.modules.sys.security.dto.BusRoleEntityDo;
import com.womow.henan.modules.sys.user.service.BusAuthorityService;
import com.womow.henan.modules.sys.user.service.BusRoleService;

/**
 * @Description 角色controller
 * @author CAI modules@163.com
 * @data 2017年8月8日上午10:40:44
 * @version V1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

	@Autowired
	private BusRoleService busRoleService;
	@Autowired
	private BusAuthorityService busAuthorityService;

	/**
	 * 查询所有角色
	 * 
	 * @return
	 */
	@RequestMapping
	public String roles(@RequestParam Map<String, Object> params, Model model, ModelMap map) {
		try {
			Query query = new Query(params);
			List<BusRoleEntityDo> roles = busRoleService.findAll(query);
			int dataCount = busRoleService.dataCount();
			PageUtils page = new PageUtils(roles, dataCount, query.getLimit(), query.getPage());
			model.addAttribute("page", page);
			model.addAttribute(map);
		} catch (Exception e) {
			logger.warn(BaseDataUtils.dateToString(new Date()) + " RoleController.roles 异常 " + e);
			model.addAttribute("message", "响应异常,请与管理员联系");
		}
		return "user/Quanxian_set";
	}

	/**
	 * 跳转至添加角色页面
	 */
	@RequestMapping(value = "/saUs", method = RequestMethod.GET)
	public String toAdd(Model model,ModelMap map) {
		try {
			// 查询所有可用权限
			List<List<BusAuthorityEntityDo>> list = busAuthorityService.findOnAll();
			model.addAttribute("deptRole", list.get(0));
			model.addAttribute("otherRegion", list.get(1));
			model.addAttribute("outOfPro", list.get(2));
			model.addAttribute(map);
		} catch (Exception e) {
			logger.warn(BaseDataUtils.dateToString(new Date()) + " RoleController.toAdd 异常 " + e);
			model.addAttribute("message", "响应异常,请与管理员联系");
		}
		return "user/Quanxian_new";
	}

	/**
	 * 添加角色
	 */
	@RequestMapping(value = "/saUs", method = RequestMethod.POST)
	public String saveUser(BusRoleEntityDo role, Model model, RedirectAttributes redirectAttributes) {
		try {
			BusRoleEntityDo r = busRoleService.findByRole(role.getRole());
			if (r == null) {
				busRoleService.save(role);
				addMessage(redirectAttributes, "添加角色成功");
				return "redirect:/role?page=" + page + "&limit=" + limit;
			} else {
				// 查询所有可用权限
				List<List<BusAuthorityEntityDo>> list = busAuthorityService.findOnAll();
				model.addAttribute("deptRole", list.get(0));
				model.addAttribute("otherRegion", list.get(1));
				model.addAttribute("outOfPro", list.get(2));
				model.addAttribute("role", role);
				model.addAttribute("message", "角色名已存在");
				return "user/Quanxian_new";
			}
		} catch (Exception e) {
			logger.warn(BaseDataUtils.dateToString(new Date()) + " RoleController.saveUser 异常 " + e);
			model.addAttribute("message", "响应异常,请与管理员联系");
			return "redirect:saUs";
		}

	}

	/**
	 * 查询某一个角色, 并调至修改页面
	 */
	@RequestMapping(value = "/upRole", method = RequestMethod.GET)
	public String toUpRole(int ids, Model model) {
		try {
			// 查询该角色,级联查询权限信息
			BusRoleEntityDo role = busRoleService.findById(ids);
			// 查询所有可用权限
			List<List<BusAuthorityEntityDo>> list = busAuthorityService.findOnAll();
			model.addAttribute("deptRole", list.get(0));
			model.addAttribute("otherRegion", list.get(1));
			model.addAttribute("outOfPro", list.get(2));
			model.addAttribute("role", role);
		} catch (Exception e) {
			logger.warn(BaseDataUtils.dateToString(new Date()) + " RoleController.toUpRole GET 异常 " + e);
			model.addAttribute("message", "响应异常,请与管理员联系");
		}
		return "user/Quanxian_update";
	}

	/**
	 * 修改角色
	 */
	@RequestMapping(value = "/upRole", method = RequestMethod.POST)
	public String upRole(BusRoleEntityDo role, RedirectAttributes redirectAttributes, Model model) {
		try {
			BusRoleEntityDo r = busRoleService.findById(role.getId());
			if (r.getRole().equals(role.getRole())) {
				busRoleService.update(role);
				addMessage(redirectAttributes, "修改角色成功");
				return "redirect:/role?page=" + page + "&limit=" + limit;
			}
			r = busRoleService.findByRole(role.getRole());
			if (r == null) {
				busRoleService.update(role);
				addMessage(redirectAttributes, "修改角色成功");
				return "redirect:/role?page=" + page + "&limit=" + limit;
			} else {
				// 查询所有可用权限
				List<List<BusAuthorityEntityDo>> list = busAuthorityService.findOnAll();
				model.addAttribute("deptRole", list.get(0));
				model.addAttribute("otherRegion", list.get(1));
				model.addAttribute("outOfPro", list.get(2));
				model.addAttribute("role", role);
				model.addAttribute("message", "该role已存在");
				return "user/Quanxian_update";
			}
		} catch (Exception e) {
			logger.warn(BaseDataUtils.dateToString(new Date()) + " RoleController.toUpRole POST 异常 " + e);
			model.addAttribute("message", "响应异常,请与管理员联系");
			return "user/Quanxian_update";
		}
	}

	/**
	 * 删除角色(禁用)
	 */
	@RequestMapping("/delRol")
	public String delRole(int[] ids, RedirectAttributes redirectAttributes) {
		try {
			busRoleService.delete(ids);
			addMessage(redirectAttributes, "禁用角色成功");
		} catch (Exception e) {
			logger.warn(BaseDataUtils.dateToString(new Date()) + " RoleController.delRole 异常 " + e);
			addMessage(redirectAttributes, "禁用角色失败");
		}
		return "redirect:/role?page=" + page + "&limit=" + limit;
	}
}
