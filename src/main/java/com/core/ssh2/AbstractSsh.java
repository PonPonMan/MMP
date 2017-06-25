package com.core.ssh2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import ch.ethz.ssh2.Connection;

/**
 * ssh父类
 * 
 * @author 傅文城 2017年4月27日 上午9:35:55
 */
public abstract class AbstractSsh {
	protected Logger log4j = Logger.getLogger(getClass().getName());
	protected String t;
	protected String ip;
	protected String path;
	protected String sshUserName;
	protected File pubKey;
	protected Connection conn;

	public AbstractSsh(String ip, String sshUserName) {
		this.ip = ip;
		this.sshUserName = sshUserName;
		init();
	}

	protected void init() {
		// 获取src/main/resources路径下的文件resource
		Resource resource = new ClassPathResource("id_rsa");
		InputStream inputStream = null;
		try {
			inputStream = resource.getInputStream();
			// 创建临时文件
			this.pubKey = File.createTempFile("id_rsa", "");
			// 往临时文件写入流
			FileUtils.copyInputStreamToFile(resource.getInputStream(), pubKey);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
		if (this.pubKey.exists()) {
			System.out.println("公钥读取成功");
		}
	}

	protected String connect() {// 连接失败，重试5次
		boolean isconn = false;
		int connectNum = 5;
		String result = "";
		while (connectNum > 0 && !isconn) {
			try {
				this.conn = new Connection(this.ip);
				this.conn.connect();
				isconn = this.conn.authenticateWithPublicKey(this.sshUserName, this.pubKey, "");
				if (!isconn) {
					this.conn = null;
				}
			} catch (IOException e) {
				result = e.toString();
			}
			connectNum--;
		}
		return result;
	}

	protected void close() {
		this.conn.close();
	}
}
