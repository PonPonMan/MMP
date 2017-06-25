package com.module.device.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.bean.IdEntity;

@Entity
@Table(catalog = "mmp", name = "tb_device")
public class Device extends IdEntity {

	private static final long serialVersionUID = 1L;
	/* 设备名 */
	private String name;
	/* 设备系统 */
	private String system;

	@Column(length = 50)
	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	@Column(length = 255)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
