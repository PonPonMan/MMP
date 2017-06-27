package com.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.module.user.bean.User;
import com.module.user.dao.UserDao;

@Controller
public class UserController {
	@Resource
	private UserDao userDAO;

	/**
	 * 用户添加;
	 * 
	 * @return
	 */
	@RequestMapping("/user/add")
	@RequiresPermissions("user:add") // 权限管理;
	public String userInfoAdd() {
		return "userInfoAdd";
	}

	/**
	 * 用户删除;
	 * 
	 * @return
	 */
	@RequestMapping("/user/del")
	@RequiresPermissions("user:del") // 权限管理;
	public String userDel() {
		return "userInfoDel";
	}
	
	/**
	 * 用户删除;
	 * 
	 * @return
	 */
	@RequestMapping("/user/list")
	@RequiresPermissions("user:view") // 权限管理;
	public String userView() {
		return "userInfoDel";
	}

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
		System.out.println("HomeController.login()");
		// 登录失败从request中获取shiro处理的异常信息。
		// shiroLoginFailure:就是shiro异常类的全类名.
		String exception = (String) request.getAttribute("shiroLoginFailure");

		System.out.println("exception=" + exception);
		String msg = "";
		if (exception != null) {
			if (UnknownAccountException.class.getName().equals(exception)) {
				System.out.println("UnknownAccountException -- > 账号不存在：");
				msg = "UnknownAccountException -- > 账号不存在：";
			} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
				System.out.println("IncorrectCredentialsException -- > 密码不正确：");
				msg = "IncorrectCredentialsException -- > 密码不正确：";
			} else if ("kaptchaValidateFailed".equals(exception)) {
				System.out.println("kaptchaValidateFailed -- > 验证码错误");
				msg = "kaptchaValidateFailed -- > 验证码错误";
			} else {
				msg = "else >> " + exception;
				System.out.println("else -- >" + exception);
			}
		}
		map.put("msg", msg);
		// 此方法不处理登录成功,由shiro进行处理.
		return "/login";
	}
}