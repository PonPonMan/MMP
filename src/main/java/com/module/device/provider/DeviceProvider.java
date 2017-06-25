package com.module.device.provider;

import org.apache.ibatis.jdbc.SQL;

import com.module.device.bean.Device;

public class DeviceProvider {

	public String findByOneField(String field, Object value) {
		return "select * from device where " + field + " = " + value;
	}

	public String findById(Object id) {
		return "select * from device where id = " + id;
	}

	public String update(final Device device) {
		return new SQL() {
			{
				UPDATE("device");
				//set各种字段
				SET("connectStatus = #{connectStatus}");
				SET("lastLeaveTime = #{lastLeaveTime}");
				WHERE("id = #{id}");
			}
		}.toString();
	}
}
