package com.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
		return "userD";
	}

	/**
	 * 用户删除;
	 * 
	 * @return
	 */
	@RequestMapping("/user/del")
	@RequiresPermissions("user:del") // 权限管理;
	public String userDel() {
		return "userD";
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
	/**
	 * 用户删除;
	 * 
	 * @return
	 */
	@RequestMapping("/hehe")
	public String userVie1w() {
		return "hehe";
	}
	/**
	 * 用户删除;
	 * 
	 * @return
	 */
	@RequestMapping("/403")
	public String userVie1w1() {
		return "403";
	}

}
