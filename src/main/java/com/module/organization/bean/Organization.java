package com.module.organization.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.bean.IdEntity;

@Entity
@Table(catalog = "mmp", name = "tb_organization")
public class Organization extends IdEntity {

	private static final long serialVersionUID = 1L;
	/* 组织机构名 */
	private String name;
	/* 显示顺序 */
	private int priority;
	/* 父编号 */
	private String parentId;
	/* 父编列表 */
	private String parentIds;
	/* 是否可用 */
	private boolean available;

	@Column(length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}


}
