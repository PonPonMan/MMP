package com.portal.admin.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controller.admin.user.AdminUserController;

@Controller("adminUserIndexController")
public class AdminUserIndexController {
	@Resource(name = "adminUserController")
	private AdminUserController adminUserController;

	@RequestMapping("/admin/user")
	public String adminIndex(HttpServletRequest request, Model model) {
		String root = "admin/user/";
		String p = request.getParameter("p");
		String id = request.getParameter("id");
		// 进入编辑页面初始化数据
		if (StringUtils.isNoneBlank(id)) {
			model.addAttribute("user", adminUserController.get(id));
		}
		if (StringUtils.isBlank(p)) {
			return root + "index";
		} else {
			return root + p;
		}
	}

}
