package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 启动web
 * @author 傅文城
 * 2017年4月26日 上午11:14:24
 */
@Controller
public class HtmlController {
	
	@RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
	@RequestMapping("/index")
	public String hello(Model model) {
		return "index";
	}
}