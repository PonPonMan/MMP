/**
 * 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.core.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 控制器支持类
 * 
 * @author lilin
 * @version 2013-3-23
 */
public abstract class BaseController {
	/**
	 * 验证Bean实例对象
	 */
	@Autowired
	protected Validator validator;
	private static List<String> list = new ArrayList<String>();
	/**
	 * 实体验证返回信息
	 * 
	 * @param object
	 * @param groups
	 * @return
	 */
	protected boolean beanValidator(Object object, Class<?>... groups) {
		try {
			BeanValidators.validateWithException(validator, object, groups);
		} catch (ConstraintViolationException ex) {
			list = BeanValidators.extractPropertyAndMessageAsList(ex);
			return false;
		}
		return true;
	}

	protected String message() {
		if (list.size() != 0 && list != null) {
			return list.get(0);
		} else {
			return "验证成功";
		}
	}

}
