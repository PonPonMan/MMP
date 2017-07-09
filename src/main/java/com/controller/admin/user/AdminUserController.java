package com.controller.admin.user;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.core.date.DateTool;
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
	 * @描述：展示列表
	 * @作者：傅文城
	 * @param searchParam
	 *            账号关键字
	 * @param pageNumber
	 *            0表示第一页
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(String searchParam, @RequestParam(defaultValue = "0") int pageNumber,
			@RequestParam(defaultValue = "5") int pageSize, Model model) {
		Page<User> users = null;
		// 排序
		Sort sort = new Sort(Direction.ASC, "username").and(new Sort(Direction.ASC, "salt"));
		if (StringUtils.isNoneBlank(searchParam)) {
			User u = new User();
			u.setUsername(searchParam);
			ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("username",
					GenericPropertyMatchers.contains());
			Example<User> ex = Example.of(u, matcher);
			users = userDAO.findAll(ex, new PageRequest(pageNumber, pageSize, sort));
		} else {
			users = userDAO.findAll(new PageRequest(pageNumber, pageSize, sort));
		}
		for (User user : users.getContent()) {
			user.setRoleList(null);
		}
		model.addAttribute("userPage", users);
		model.addAttribute("searchParam", searchParam);
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
		User isExist = userDAO.findByUsername(user.getUsername());
		if (isExist != null) {
			return JsonTool.genErrorMsg("账号已存在");
		}
		new PasswordHelper().encryptPasswordNoSalt(user);
		user.setCreateTime(DateTool.getCurrTimesDate());
		user.setUpdateTime(user.getCreateTime());
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
		if (u.getUsername().equals(user.getUsername())) {
			u.setPassword(user.getPassword());
			u.setUpdateTime(DateTool.getCurrTimesDate());
			new PasswordHelper().encryptPassworHaveSalt(u);
			userDAO.saveAndFlush(u);
			return JsonTool.genSuccessMsg("更新成功");
		} else {
			User isExist = userDAO.findByUsername(user.getUsername());
			if (isExist != null) {
				return JsonTool.genErrorMsg("用户名已存在");
			} else {
				u.setPassword(user.getPassword());
				u.setUpdateTime(DateTool.getCurrTimesDate());
				new PasswordHelper().encryptPassworHaveSalt(u);
				userDAO.saveAndFlush(u);
				return JsonTool.genSuccessMsg("更新成功");
			}
		}
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
		if (StringUtils.isNoneBlank(id)) {
			userDAO.delete(id);
		}
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

	/**
	 * 
	 * @描述 查找账号信息
	 * @作者 傅文城
	 * @date 2017年7月9日
	 * @param id
	 * @return
	 */
	public User get(String id) {
		User user = userDAO.findOne(id);
		user.setRoleList(null);
		return user;
	}
}
