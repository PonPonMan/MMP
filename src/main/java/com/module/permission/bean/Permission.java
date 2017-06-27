package com.module.permission.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.core.bean.IdEntity;
import com.module.role.bean.Role;

@Entity
@Table(catalog = "mmp", name = "tb_permission")
public class Permission extends IdEntity {

	private static final long serialVersionUID = 1L;
	/* 资源名 */
	private String name;
	/* 资源类型 */
	private String type;
	/* 资源路径 */
	private String url;
	/* 显示顺序 */
	private int priority;
	/* 父编号 */
	private String parentId;
	/* 父编列表 */
	private String parentIds;
	/* 权限字符串 */
	private String permission;
	/* 是否可用 */
	private boolean available;
	@ManyToMany
	@JoinTable(name = "tb_role_permission", joinColumns = { @JoinColumn(name = "pid") }, inverseJoinColumns = {
			@JoinColumn(name = "rid") })
	private List<Role> roles;

	@Column(length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 50, columnDefinition = "enum('menu','button')")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(length = 100)
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	@Column(length = 100)
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
