package com.portal.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminIndexController")
public class AdminIndexController {
	@RequestMapping("/admin/index")
	public String adminIndex() {
		return "admin/index";
	}

	@RequestMapping("/admin/")
	public String admin() {
		return "admin/index";
	}

	@RequestMapping("/")
	public String root() {
		return "admin/index";
	}
}
