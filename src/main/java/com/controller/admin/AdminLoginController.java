package com.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminLoginController")
public class AdminLoginController {
	private Logger log = Logger.getLogger(getClass().getName());

	@RequestMapping(value = "/admin/login")
	public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
		log.info("HomeController.login()");
		// 登录失败从request中获取shiro处理的异常信息。shiroLoginFailure:就是shiro异常类的全类名.
		String exception = (String) request.getAttribute("shiroLoginFailure");
		String msg = "";
		if (exception != null) {
			if (LockedAccountException.class.getName().equals(exception)) {
				log.info("LockedAccountException -- > 账号被锁：");
				msg = "LockedAccountException -- > 账号被锁：";
			} else if (UnknownAccountException.class.getName().equals(exception)) {
				log.info("UnknownAccountException -- > 账号不存在：");
				msg = "UnknownAccountException -- > 账号不存在：";
			} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
				log.info("IncorrectCredentialsException -- > 密码不正确：");
				msg = "IncorrectCredentialsException -- > 密码不正确：";
			} else if (ExcessiveAttemptsException.class.getName().equals(exception)) {
				log.info("ExcessiveAttemptsException -- > 登录失败次数过多：");
				msg = "ExcessiveAttemptsException -- > 登录失败次数过多：";
			} else if ("kaptchaValidateFailed".equals(exception)) {
				log.info("kaptchaValidateFailed -- > 验证码错误");
				msg = "kaptchaValidateFailed -- > 验证码错误";
			} else {
				msg = "else >> " + exception;
				log.info("else -- >" + exception);
			}
		}
		map.put("msg", msg);
		// 此方法不处理登录成功,由shiro进行处理.
		return "admin/login";
	}
}
