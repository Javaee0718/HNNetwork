package com.womow.henan.modules.sys.user.controller;

import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.womow.henan.modules.sys.security.utils.ShiroUtils;
import com.womow.henan.modules.sys.user.bean.dto.BusUserEntityDo;

@Controller
@RequestMapping("sys")
public class SysLoginController {

	/**
	 * GET请求方式,跳转至登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin() {
		return "login/login";
	}

	/**
	 * POST请求方式,用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password, Model model,RedirectAttributes redirectAttributes) {
		try {
			Subject subject = ShiroUtils.getSubject();
			password = Base64.encodeToString(password.getBytes());
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);
			String nickname = ShiroUtils.getUserEntity().getNickname();
			ShiroUtils.setSessionAttribute("username", nickname);
		} catch (UnknownAccountException e) {
			// TODO CAI_login
			
			redirectAttributes.addFlashAttribute("message", e.getMessage());
			return "login/login";
		} catch (LockedAccountException e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
			model.addAttribute("message", e.getMessage());
			return "login/login";
		}
		return "main/main";
	}
}
