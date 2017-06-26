package com.module.user.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.bean.IdEntity;

@Entity
@Table(catalog = "mmp", name = "tb_user")
public class User extends IdEntity {

	private static final long serialVersionUID = 1L;
	/* 账号 */
	private String userName;
	/* 密码 */
	private String password;
	/* 盐 */
	private String salt;
	/* 角色列表 */
	private String role_ids;

	/* 账户是否锁定 */
	private boolean locked;

	@Column(length = 100)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(length = 100)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 50)
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(length = 100)
	public String getRole_ids() {
		return role_ids;
	}

	public void setRole_ids(String role_ids) {
		this.role_ids = role_ids;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
}
