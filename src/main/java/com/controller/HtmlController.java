package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.module.device.bean.Device;
import com.module.device.dao.DeviceDao;

@Controller
public class HtmlController {
	@Autowired
	private DeviceDao deviceDAO;

	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

	@RequestMapping("/index")
	public String hello(Model model) {
		List<Device> devices = deviceDAO.findAll();
		model.addAttribute("devices", devices);
		model.addAttribute("message", "fej");
		return "list";
	}
}