package com.core.shiro;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.module.user.bean.User;

public class PasswordHelper {

	public void encryptPassword(User user) {
		user.setSalt(new SecureRandomNumberGenerator().nextBytes().toHex());
		String newPassword = new SimpleHash(ShiroConstant.ALGORITHM_NAME, user.getPassword(),
				ByteSource.Util.bytes(user.getCredentialsSalt()), ShiroConstant.HASH_ITERATIONS).toHex();
		user.setPassword(newPassword);
	}
}
