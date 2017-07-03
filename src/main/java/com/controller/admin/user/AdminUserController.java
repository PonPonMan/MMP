package com.controller.admin.user;

import java.util.List;

import javax.annotation.Resource;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.core.utils.JsonTool;
import com.module.user.bean.User;
import com.module.user.dao.UserDao;

@Controller("adminUserController")
@RequestMapping("/admin/user")
public class AdminUserController {
	@Resource
	private UserDao userDAO;

	@RequestMapping(value = "", method = RequestMethod.GET)
	// @RequiresPermissions("user:list")
	public String getUserList(Model model) {
		List<User> users = userDAO.findAll();
		for (User user : users) {
			user.setRoleList(null);
		}
		model.addAttribute("users", users);
		return "admin/user/index";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	// @RequiresPermissions("user:get")
	@ResponseBody
	public JSONObject getUser(@PathVariable String id) {
		User user = userDAO.findOne(id);
		user.setRoleList(null);
		return JsonTool.genSuccessMsg(user);
	}

	/**
	 * post 保存用户.
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	// @RequiresPermissions("user:add")
	@ResponseBody
	public JSONObject postUser(User user) {
		userDAO.save(user);
		return JsonTool.genSuccessMsg("保存成功");
	}

	/**
	 * 使用put 进行更新用户.
	 * 
	 * @param id
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	// @RequiresPermissions("user:update")
	@ResponseBody
	public JSONObject putUser(@PathVariable String id, User user) {
		User u = userDAO.findOne(id);
		u.setPassword(user.getPassword());
		userDAO.saveAndFlush(u);
		return JsonTool.genSuccessMsg("更新成功");
	}

	/**
	 * 使用delete删除用户.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	// @RequiresPermissions("user:del")
	@ResponseBody
	public JSONObject deleteUser(@PathVariable String id) {
		userDAO.delete(id);
		return JsonTool.genSuccessMsg("删除成功");
	}
}
