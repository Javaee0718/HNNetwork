package com.womow.henan.modules.sys.security.realm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.womow.henan.modules.sys.user.bean.dto.BusUserEntityDo;
import com.womow.henan.modules.sys.user.dao.BusAuthorityDao;
import com.womow.henan.modules.sys.user.dao.BusUserDao;

/**
 * @Description 自定义Realm
 * @author CAI modules@163.com
 * @data 2017年8月7日下午2:18:46
 * @version V1.0
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private BusUserDao busUserDao;
	@Autowired
	private BusAuthorityDao busAuthorityDao;

	/**
	 * 认证
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken tok = (UsernamePasswordToken) token;
		String username = tok.getUsername();
		String password = new String(tok.getPassword());
		Map<String, Object> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		BusUserEntityDo user = null;
		try {
			user = busUserDao.find(map);
		} catch (Exception e) {
		}
		
		// 账号不存在
		if (user == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}
		// 账号锁定
		if (user.getIsDel() == 0) {
			throw new LockedAccountException("账号已禁用,请联系管理员");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
		return info;
	}

	/**
	 * 授权
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		BusUserEntityDo user = (BusUserEntityDo) principals.getPrimaryPrincipal();
		List<String> permsList = null;

		if (user.getId() == 1) {
			// 最高管理员
			permsList = busAuthorityDao.findAllPermis();
		} else {
			permsList = busUserDao.findAllPerms(user.getId());
		}
		//查询该用户的所有角色
		List<String> roless = busUserDao.findRoleByUserId(user.getId());
		Set<String> roles = new HashSet<>();
		if (roless != null && roless.size() > 0) {
			for (String role : roless) {
				roles.add(role);
			}
		}
		Set<String> perms = new HashSet<>();
		perms.addAll(permsList);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(perms);
		info.setRoles(roles);
		return info;
	}

}
