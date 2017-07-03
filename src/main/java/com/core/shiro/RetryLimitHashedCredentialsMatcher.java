package com.core.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

/**
 * 密码错误重试机制
 * 
 * @author 傅文城
 *
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
	private Cache<String, AtomicInteger> passwordRetryCache;

	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		String username = (String) token.getPrincipal();
		AtomicInteger retryCount = passwordRetryCache.get(username);
		// 查看缓存中的尝试次数
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		// 超过五次，抛异常
		if (retryCount.incrementAndGet() > 5) {
			throw new ExcessiveAttemptsException();
		}
		// 判断登录
		boolean matches = super.doCredentialsMatch(token, info);
		if (matches) {
			passwordRetryCache.remove(username);
		}
		return matches;
	}
}