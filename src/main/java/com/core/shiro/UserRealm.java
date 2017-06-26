//package com.core.shiro;
//
//import java.util.Set;
//
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.core.utils.Transfer;
//import com.module.user.bean.User;
//import com.module.user.dao.UserDao;
//
//public class UserRealm extends AuthorizingRealm {
//	@Autowired
//	private UserDao userDAO;
//
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		String username = (String) principals.getPrimaryPrincipal();
//		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//		User user = userDAO.getByUserName(username);
//		authorizationInfo.setRoles(Transfer.stringToSet(user.getRole_ids(), Transfer.COMMA));
//		authorizationInfo.setStringPermissions(Transfer.stringToSet(user.g, Transfer.COMMA));
//		System.out.println(userService.findPermissions(username));
//		return authorizationInfo;
//	}
//
//	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//		String username = (String) token.getPrincipal();
//		User user = userService.findByUsername(username);
//		if (user == null) {
//			throw new UnknownAccountException();// 没找到帐号
//		}
//		if (Boolean.TRUE.equals(user.getLocked())) {
//			throw new LockedAccountException(); // 帐号锁定
//		}
//		return new SimpleAuthenticationInfo(user.getUsername(), // 用户名
//				user.getPassword(), // 密码
//				ByteSource.Util.bytes(user.getCredentialsSalt()), // salt=username+salt
//				getName() // realm name
//		);
//	}
//}
