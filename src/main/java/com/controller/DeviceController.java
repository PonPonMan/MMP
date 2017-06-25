//package com.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.github.pagehelper.PageHelper;
//import com.module.device.bean.Device;
//import com.module.device.service.DeviceService;
//import com.module.managedevice.bean.ManageDevice;
//import com.module.managedevice.service.ManageDeviceService;
//
//@SpringBootApplication
//@RestController
//
//public class DeviceController {
//	@Autowired
//	private DeviceService deviceService;
//	@Autowired
//	private ManageDeviceService manageDeviceService;
//
//	@RequestMapping("/device/findByOneField")
//	public List<Device> findByOneField(String field, String value, int pageNum, int pageSize) {
//		PageHelper.startPage(pageNum, pageSize);
//		return deviceService.findByOneField(field, value);
//	}
//
//	@RequestMapping("/device/updateExeStatus")
//	public String updateExeStatus(int id) {
//		Device device = deviceService.findById(id);
//		device.setExeStatus(0);
//		deviceService.update(device);
//		return "success";
//	}
//	@RequestMapping("/device/updateFlag")
//	public String updateFlag(int id) {
//		ManageDevice managedevice = manageDeviceService.findById(id);
//		managedevice.setFlag(3);
//		manageDeviceService.update(managedevice);
//		return "success";
//	}
//}