package com.module.user.dao;

import com.core.dao.BaseDao;
import com.module.user.bean.User;

public interface UserDao extends BaseDao<User, String> {
	User findByUsername(String username);
}
