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

	
}
