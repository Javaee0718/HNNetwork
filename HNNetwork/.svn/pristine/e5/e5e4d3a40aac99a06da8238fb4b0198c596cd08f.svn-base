package com.womow.henan.modules.sys.security.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.womow.henan.modules.sys.user.bean.dto.BusUserEntityDo;

/**
 * @Description shirl工具类
 * @author CAI modules@163.com
 * @data 2017年8月7日下午9:36:45
 * @version V1.0
 */
public class ShiroUtils {

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	public static BusUserEntityDo getUserEntity() {
		return (BusUserEntityDo)SecurityUtils.getSubject().getPrincipal();
	}

	public static int getUserId() {
		return getUserEntity().getId();
	}
	
	public static void setSessionAttribute(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static Object getSessionAttribute(Object key) {
		return getSession().getAttribute(key);
	}

	public static boolean isLogin() {
		return SecurityUtils.getSubject().getPrincipal() != null;
	}

	public static void logout() {
		SecurityUtils.getSubject().logout();
	}
	
	/**
	 * 获取加密前的密码
	 * @param password
	 * @return
	 */
	public static String getPwd(String password) {
		return Base64.decodeToString(password);
	}
	
	public static String getPwdAndSecurity(String password) {
		return Base64.encodeToString(password.getBytes());
	}
}
