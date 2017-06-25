package com.module.user.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.bean.IdEntity;

@Entity
@Table(catalog = "mmp", name = "tb_user")
public class User extends IdEntity {

	private static final long serialVersionUID = 1L;
	/* 姓名 */
	private String name;
	/* 账号 */
	private String userName;
	/* 密码 */
	private String password;

	@Column(length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 50)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
