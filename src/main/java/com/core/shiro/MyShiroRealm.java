package com.core.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.module.permission.bean.Permission;
import com.module.role.bean.Role;
import com.module.user.bean.User;
import com.module.user.dao.UserDao;

public class MyShiroRealm extends AuthorizingRealm {

	@Resource
	private UserDao userDAO;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		User user = userDAO.findByUsername(username);
		if (user == null) {
			return null;
		}
		return new SimpleAuthenticationInfo(username, user.getPassword(),
				ByteSource.Util.bytes(user.getCredentialsSalt()), getName());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		String username = (String) principals.getPrimaryPrincipal();
		User user = userDAO.findByUsername(username);
		for (Role role : user.getRoleList()) {
			authorizationInfo.addRole(role.getRole());
			for (Permission p : role.getPermissions()) {
				authorizationInfo.addStringPermission(p.getPermission());
			}
		}
		return authorizationInfo;
	}
}