package com.womow.henan.modules.sys.user.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.womow.henan.commons.bean.BaseDataEntity;
import com.womow.henan.commons.bean.PageUtils;
import com.womow.henan.commons.bean.Query;
import com.womow.henan.commons.service.BusBaseDataService;
import com.womow.henan.commons.utils.BaseDataUtils;
import com.womow.henan.commons.web.BaseController;
import com.womow.henan.modules.sys.security.dto.BusRoleEntityDo;
import com.womow.henan.modules.sys.user.bean.dto.BusUserEntityDo;
import com.womow.henan.modules.sys.user.service.BusRoleService;
import com.womow.henan.modules.sys.user.service.BusUserService;

/**
 * @Description 用户controller
 * @author CAI modules@163.com
 * @data 2017年8月7日下午10:35:01
 * @version V1.0
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

	@Autowired
	private BusUserService busUserService;
	@Autowired
	private BusRoleService busRoleService;
	@Autowired
	private BusBaseDataService busBaseDataService;

	/**
	 * 查询所有用户
	 */
	@RequestMapping
	public String findAllUser(@RequestParam(required = false) Map<String, Object> params, Model model, ModelMap map) {
		try {
			Query query = new Query(params);
			List<BusUserEntityDo> users = busUserService.findAll(query);
			int count = busUserService.dataCount();
			PageUtils page = new PageUtils(users, count, query.getLimit(), query.getPage());
			model.addAttribute("page", page);
			model.addAttribute(map);
		} catch (Exception e) {
			logger.warn(BaseDataUtils.dateToString(new Date()) + " UserController.findAllUser 异常" + e);
			model.addAttribute("message", "响应异常,请与管理员联系");
		}
		return "user/User_gl";
	}

	/**
	 * 跳转至添加页面
	 */
	@RequestMapping(value = "/adU", method = RequestMethod.GET)
	public String toAddUser(Model model, ModelMap modelMap) {
		try {
			List<BusRoleEntityDo> roles = busRoleService.findOnAll();
			List<BaseDataEntity> depts = busBaseDataService.findByType("dept");
			model.addAttribute("depts", depts);
			model.addAttribute("roles", roles);
			model.addAttribute(modelMap);
		} catch (Exception e) {
			logger.warn(BaseDataUtils.dateToString(new Date()) + " UserController.toAddUser 异常" + e);
			model.addAttribute("message", "操作异常,请与管理员联系");
		}
		return "user/User_new";
	}

	/**
	 * 添加用户的方法
	 */
	@RequestMapping(value = "/adU", method = RequestMethod.POST)
	public String addUser(BusUserEntityDo user, RedirectAttributes redirectAttributes, Model model) {
		try {
			// 根据用户名查询改用户名是否存在.
			BusUserEntityDo u = busUserService.findByUsername(user);
			if (u == null) {
				busUserService.add(user);
				addMessage(redirectAttributes, "保存用户" + user.getNickname() + "成功");
				return "redirect:/user?page=" + page + "&limit=" + limit;
			} else {
				Integer[] roleIds = user.getRoleIds();
				if (roleIds != null && roleIds.length > 0) {
					user.setRoleId(roleIds[0]);
				}
				model.addAttribute("user", user);
				model.addAttribute("message", "该用户名已存在");
				return "user/User_new";
			}

		} catch (Exception e) {
			logger.warn(BaseDataUtils.dateToString(new Date()) + " UserController.addUser POST 异常" + e);
			String messages = "操作异常,请与管理员联系";
			addMessage(redirectAttributes, messages);
			return "redirect:adU";
		}
	}

	/**
	 * 查询单个用户信息,并跳转至用户修改
	 */
	@RequestMapping(value = "/upUser", method = RequestMethod.GET)
	public String queryUser(int ids, Model model) {
		try {
			// 用户信息
			BusUserEntityDo user = busUserService.queryById(ids);
			List<BusRoleEntityDo> rols = user.getRoles();
			if (rols != null && rols.size() > 0) {
				user.setRoleId(rols.get(0).getId());
			}
			model.addAttribute("user", user);
			List<BaseDataEntity> depts = busBaseDataService.findByType("dept");
			model.addAttribute("depts", depts);
			// 查询可用角色
			List<BusRoleEntityDo> roles = busRoleService.findOnAll();
			model.addAttribute("roles", roles);
		} catch (Exception e) {
			logger.warn(BaseDataUtils.dateToString(new Date()) + " UserController.queryUser GET 异常" + e);
			model.addAttribute("message", "操作异常,请与管理员联系");
		}
		return "user/User_update";
	}

	/**
	 * 修改用户的方法
	 */
	@RequestMapping(value = "/upUser", method = RequestMethod.POST)
	public String updateUser(BusUserEntityDo user, RedirectAttributes redirectAttributes, Model model) {
		try {
			// 通过ID查询改用户
			BusUserEntityDo u = busUserService.queryById(user.getId());
			String username = u.getUsername();
			if (username.equals(user.getUsername())) {
				busUserService.update(user);
				addMessage(redirectAttributes, "修改用户" + user.getNickname() + "成功");
				return "redirect:/user?page=" + page + "&limit=" + limit;
			}
			// 根据用户名查询改用户名是否存在.
			u = busUserService.findByUsername(user);
			if (u == null) {
				busUserService.update(user);
				addMessage(redirectAttributes, "修改用户" + user.getNickname() + "成功");
				return "redirect:/user?page=" + page + "&limit=" + limit;
			} else {
				Integer[] roleIds = user.getRoleIds();
				if (roleIds != null && roleIds.length > 0) {
					user.setRoleId(roleIds[0]);
				}
				model.addAttribute("user", user);
				model.addAttribute("message", "该用户名已存在");
			}
			return "user/User_update";
		} catch (Exception e) {
			logger.warn(BaseDataUtils.dateToString(new Date()) + " UserController.updateUser POST 异常" + e);
			model.addAttribute("message", "操作异常,请与管理员联系");
			return "user/User_update";
		}
	}

	/**
	 * 删除用户的方法
	 */
	@RequestMapping("/delU")
	public String deleteUser(int[] ids, Model model, RedirectAttributes redirectAttributes) {
		try {
			if (ids.length > 0) {
				busUserService.delete(ids);
				addMessage(redirectAttributes, "禁用用户成功");
			}
		} catch (Exception e) {
			logger.warn(BaseDataUtils.dateToString(new Date()) + " UserController.deleteUser 异常" + e);
			addMessage(redirectAttributes, "禁用用户失败");
		}
		return "redirect:/user?page=" + page + "&limit=" + limit;
	}
}
