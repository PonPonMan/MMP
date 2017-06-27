package com.module.role.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.core.bean.IdEntity;
import com.module.permission.bean.Permission;
import com.module.user.bean.User;

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
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_role_permission", joinColumns = { @JoinColumn(name = "rid") }, inverseJoinColumns = {
			@JoinColumn(name = "pid") })
	private List<Permission> permissions;
	@ManyToMany
	@JoinTable(name = "tb_user_role", joinColumns = { @JoinColumn(name = "rid") }, inverseJoinColumns = {
			@JoinColumn(name = "uid") })
	private List<User> users;

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


	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
