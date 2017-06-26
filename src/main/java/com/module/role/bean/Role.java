package com.module.role.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.bean.IdEntity;

@Entity
@Table(catalog = "mmp", name = "tb_role")
public class Role extends IdEntity {

	private static final long serialVersionUID = 1L;
	/* 角色名称 */
	private String role;
	/* 角色描述 */
	private String description;
	/* 授权的资源 */
	private String resource_ids;
	/* 是否可用 */
	private boolean available;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResource_ids() {
		return resource_ids;
	}

	public void setResource_ids(String resource_ids) {
		this.resource_ids = resource_ids;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
