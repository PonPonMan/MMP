package com.portal.admin.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminUserIndexController")
public class AdminUserIndexController {
	@RequestMapping("/admin/user")
	public String adminIndex(HttpServletRequest request, Model model) {
		String root = "admin/user/";
		String p = request.getParameter("p");
		return root + p;
	}

}
