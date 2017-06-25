package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.module.device.bean.Device;
import com.module.device.dao.DeviceDao;

@SpringBootApplication
@RestController
public class DeviceController {
	@Autowired
	private DeviceDao deviceDAO;

	@RequestMapping("/device/list")
	public String list() {
		List<Device> devices = deviceDAO.findAll();
		return new Gson().toJson(devices);
	}

	@RequestMapping("/device/find/{id}")
	public String findById(@PathVariable("id") String id) {
		Device device = deviceDAO.findOne(id);
		return new Gson().toJson(device);
	}

	@RequestMapping("/device/delete/{id}")
	public String delete(@PathVariable("id") String id) {
		deviceDAO.delete(id);
		return "删除成功";
	}

	@RequestMapping("/device/save/{name}/{system}")
	public String save(@PathVariable("name") String name, @PathVariable("system") String system) {
		Device device = new Device();
		device.setName(name);
		device.setSystem(system);
		deviceDAO.save(device);
		return "保存成功";
	}
}