package com.controller.admin.user;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.core.shiro.PasswordHelper;
import com.core.utils.JsonTool;
import com.core.web.BaseController;
import com.module.user.bean.User;
import com.module.user.dao.UserDao;

@Controller("adminUserController")
@RequestMapping("/admin/user")
public class AdminUserController extends BaseController {
	@Resource
	private UserDao userDAO;

	/**
	 * 
	 * @描述：展示列表 @跳转：无
	 * @作者：傅文城
	 *
	 * @param pageNumber
	 *            0表示第一页
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "5") int pageSize,
			Model model) {
		Page<User> users = userDAO.findAll(new PageRequest(pageNumber, pageSize));
		for (User user : users.getContent()) {
			user.setRoleList(null);
		}
		model.addAttribute("userPage", users);
		return "admin/user/index";
	}

	/**
	 * post 保存用户.
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject add(User user) {
		if (!beanValidator(user)) {
			return JsonTool.genErrorMsg(message());
		}
		new PasswordHelper().encryptPasswordNoSalt(user);
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
		if (!beanValidator(user)) {
			return JsonTool.genErrorMsg(message());
		}
		User u = userDAO.findOne(user.getId());
		u.setPassword(user.getPassword());
		new PasswordHelper().encryptPassworHaveSalt(u);
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

	/**
	 * 使用delete删除用户组.
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/deleteAll")
	@ResponseBody
	public JSONObject deleteAll(@RequestParam(value = "ids[]") String[] ids) {
		for (String id : ids) {
			userDAO.delete(id);
		}
		return JsonTool.genSuccessMsg("删除成功");
	}

	public User get(String id) {
		User user = userDAO.findOne(id);
		user.setRoleList(null);
		return user;
	}
}
