package com.controller.admin.user;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<User> users = userDAO.findAll();
		for (User user : users) {
			user.setRoleList(null);
		}
		model.addAttribute("users", users);
		return "admin/user/index";
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject get(String id) {
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
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject add(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			return JsonTool.genErrorMsg(list);
		}
		userDAO.save(user);
		return JsonTool.genSuccessMsg("保存成功");
	}

	/**
	 * 更新用户.
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject update(User user) {
		User u = userDAO.findOne(user.getId());
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
	@RequestMapping(value = "/delete")
	@ResponseBody
	public JSONObject delete(String id) {
		userDAO.delete(id);
		return JsonTool.genSuccessMsg("删除成功");
	}
}
