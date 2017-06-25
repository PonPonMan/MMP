package com;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 打成jar包需要一个启动接口main， 扫描所有包
 * 
 * @author 傅文城 2017年4月26日 下午4:23:05
 */
@Configuration
@ComponentScan(basePackages = "com")
@EnableAutoConfiguration
public class MyStartup {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MyStartup.class);
		app.setWebEnvironment(true);
		Set<Object> set = new HashSet<Object>();
		app.setSources(set);
		app.run(args);
	}
}