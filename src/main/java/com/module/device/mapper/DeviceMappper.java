package com.module.device.mapper;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.module.device.bean.Device;
import com.module.device.provider.DeviceProvider;

public interface DeviceMappper {

	@SelectProvider(type = DeviceProvider.class, method = "findByOneField")
	public List<Device> findByOneField(String field, Object value);

	@SelectProvider(type = DeviceProvider.class, method = "findById")
	public Device findById(int id);

	@UpdateProvider(type = DeviceProvider.class, method = "update")
	public int update(Device device);

}