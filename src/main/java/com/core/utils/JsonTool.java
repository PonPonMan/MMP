package com.core.utils;

import com.alibaba.fastjson.JSONObject;

public class JsonTool {
	public static JSONObject genSuccessMsg(Object msg) {
		JSONObject json = new JSONObject();
		json.put("message", msg);
		json.put("error", false);
		return json;
	}

	public static JSONObject genErrorMsg(Object msg) {
		JSONObject json = new JSONObject();
		json.put("message", msg);
		json.put("error", true);
		return json;
	}
}
