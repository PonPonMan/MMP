package com.core.ssh2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
/**
 * ssh2
 * @author 傅文城
 * 2017年4月27日 上午9:37:04
 */
public class RemoteSsh2  extends AbstractSsh{
	
	
	public RemoteSsh2(String ip, String sshUserName) {
		super(ip, sshUserName);
	}
	/**
	 * 执行指令获取结果
	 * 
	 * @param command
	 *            命令行
	 * @return
	 */
	public String getResult(String command) {
		StringBuffer outString = new StringBuffer();
		String result = "连接失败";
		String connectResult = "";
		InputStream is = null;
		InputStreamReader ins = null;
		BufferedReader brs = null;
		Session session = null;
		try {
			connectResult = connect();
			if (StringUtils.isNoneBlank(connectResult)) {
				log4j.error("remotessh connect失败，:" + connectResult + ",ip:" + this.ip + ",command:" + command);
			} else {
				session = conn.openSession();
				session.execCommand(command);
				// 正常信息
				is = new StreamGobbler(session.getStdout());
				ins = new InputStreamReader(is, "UTF-8");
				brs = new BufferedReader(ins);
				while (true) {
					String line = brs.readLine();
					if (line == null) {
						break;
					}
					outString.append(line).append("<br>");
				}
				result = outString.toString();
			}
		} catch (IOException e) {
			log4j.error("remotessh IO异常:" + e.toString() + ",ip:" + this.ip + ",command:" + command);
		} finally {
			try {
				if (brs != null) {
					brs.close();
				}
				if (is != null) {
					is.close();
				}
				if (session != null) {
					session.close();
				}
			} catch (IOException e) {
				log4j.error("remotessh关闭流异常:" + e.toString() + ",ip:" + this.ip + ",command:" + command);
			}
			close();
		}
		return result;
	}

}