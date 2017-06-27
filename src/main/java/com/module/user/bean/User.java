package com.module.user.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.core.bean.IdEntity;
import com.module.role.bean.Role;

@Entity
@Table(catalog = "mmp", name = "tb_user")
public class User extends IdEntity {

	private static final long serialVersionUID = 1L;
	/* 账号 */
	private String username;
	/* 密码 */
	private String password;
	/* 盐 */
	private String salt;
	/* 角色列表 */
	@ManyToMany(fetch = FetchType.EAGER) // 立即从数据库中进行加载数据;
	@JoinTable(name = "tb_user_role", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns = {
			@JoinColumn(name = "rid") })
	private List<Role> roleList;

	/* 账户是否锁定 */
	private boolean locked;

	@Column(length = 100, unique = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * 密码盐.
	 * 
	 * @return
	 */
	public String getCredentialsSalt() {
		return this.username + this.salt;
	}
}
