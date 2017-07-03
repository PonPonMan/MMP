package com.core.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfiguration {
	private Logger log = Logger.getLogger(getClass().getName());

	/**
	 * 
	 * @描述 注解ShiroFilterFactoryBean
	 * @作者 傅文城
	 * @date 2017年7月2日
	 * @return
	 */
	@Bean
	public ShiroFilterFactoryBean shirFilter() {
		log.info("ShiroConfiguration.shirFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 必须设置 SecurityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager());
		// 拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 配置记住我或认证通过可以访问的地址
		filterChainDefinitionMap.put("/admin/index", "user");
		filterChainDefinitionMap.put("/admin/", "user");
		filterChainDefinitionMap.put("/", "user");
		// 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了,默认登出跳转到登录login
		filterChainDefinitionMap.put("/admin/logout", "logout");
		// <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		// 解除静态资源的限制
		filterChainDefinitionMap.put("/assets/**", "anon");
		// <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
		filterChainDefinitionMap.put("/**", "authc");
		// 如果不设置默认会自动寻找Web工程根目录下的"/admin/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/admin/login");
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/admin/index");
		// 未授权界面;
		// shiroFilterFactoryBean.setUnauthorizedUrl("/error");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	/**
	 * 
	 * @描述 SecurityManager
	 * @作者 傅文城
	 * @date 2017年7月2日
	 * @return
	 */
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		securityManager.setCacheManager(ehCacheManager());
		securityManager.setRememberMeManager(rememberMeManager());
		return securityManager;
	}

	/**
	 * 
	 * @描述 设置 MyShiroRealm
	 * @作者 傅文城
	 * @date 2017年7月2日
	 * @return
	 */
	@Bean
	public MyShiroRealm myShiroRealm() {
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}

	/**
	 * 
	 * @描述 加密算法MD5 散列算法2次
	 * @作者 傅文城
	 * @date 2017年7月2日
	 * @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new RetryLimitHashedCredentialsMatcher(ehCacheManager());
		hashedCredentialsMatcher.setHashAlgorithmName(ShiroConstant.ALGORITHM_NAME);
		hashedCredentialsMatcher.setHashIterations(ShiroConstant.HASH_ITERATIONS);
		return hashedCredentialsMatcher;
	}

	/**
	 * 
	 * @描述 开启aop注解，启动MyShiriRealm中的doGetAuthorizationInfo限制
	 * @作者 傅文城
	 * @date 2017年7月2日
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	/**
	 * 
	 * @描述 设置登录缓存
	 * @作者 傅文城
	 * @date 2017年7月2日
	 * @return
	 */
	@Bean
	public EhCacheManager ehCacheManager() {
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
		return cacheManager;
	}

	/**
	 * 
	 * @描述 cookie记录管理器
	 * @作者 傅文城
	 * @date 2017年7月2日
	 * @return
	 */
	@Bean
	public CookieRememberMeManager rememberMeManager() {
		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(rememberMeCookie());
		return cookieRememberMeManager;
	}

	/**
	 * 
	 * @描述 配合前端的rememberMe 设置cookie
	 * @作者 傅文城
	 * @date 2017年7月2日
	 * @return
	 */
	@Bean
	public SimpleCookie rememberMeCookie() {
		// 这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		// <!-- 记住我cookie生效时间30天 ,单位秒;-->
		simpleCookie.setMaxAge(259200);
		return simpleCookie;
	}

	/**
	 * 
	 * @描述 配合前端shiro标签
	 * @作者 傅文城
	 * @date 2017年7月3日
	 * @return
	 */
	@Bean
	public ShiroDialect shiroDialect() {
		return new ShiroDialect();
	}
}