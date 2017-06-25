package com.core.http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 发送http工具
 * 
 * @author 傅文城 2017年4月27日 下午5:20:49
 */
public class HttpUtils {
	public static String post(String url, String body) {
		return http(HttpMethod.POST, url, body);
	}

	public static String get(String url, String body) {
		return http(HttpMethod.GET, url, body);
	}

	public static String http(HttpMethod method, String url, String body) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		// 这个对象有add()方法，可往请求头存入信息
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// 解决中文乱码的关键
		HttpEntity<String> entity = new HttpEntity<String>(body, headers);
		// 上面第一个参数是Http消息体例如json串
		ResponseEntity<String> resp = restTemplate.exchange(url, method, entity, String.class);
		return resp.getBody();
	}
}
