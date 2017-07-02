package com.portal.admin.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminUserIndexController")
public class AdminUserIndexController {
	@RequestMapping("/admin/user/index")
	public String adminIndex() {
		return "admin/user/index";
	}

}
