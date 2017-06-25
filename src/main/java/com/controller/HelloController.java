package com.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 启动web
 * @author 傅文城
 * 2017年4月26日 上午11:14:24
 */
@SpringBootApplication
@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
	
//	public static void main(String[] args) throws Exception {
//		SpringApplication.run(HelloController.class, args);
//	}
}