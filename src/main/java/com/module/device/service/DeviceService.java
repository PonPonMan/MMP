package com.module.device.service;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.device.bean.Device;
import com.module.device.mapper.DeviceMappper;

@Service("deviceService")
//扫描接口注解
@MapperScan("com.module.device.mapper")
public class DeviceService {
	@Autowired
	private DeviceMappper deviceMappper;

	public List<Device> findByOneField(String field, Object value) {
		return deviceMappper.findByOneField(field, value);
	}
	public int update(Device device) {
		return deviceMappper.update(device);
	}
	public Device findById(int id) {
		return deviceMappper.findById(id);
	}
}