package com.core.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5 {
//	@Resource
//	PasswordService PasswordService;
//	public String ss (String password){
//		PasswordService.encryptPassword(password);
//	}
// public static void main(String[] args) {
//	 String algorithmName = "md5";  
//	 String username = "admin";  
//	 String password = "123456";  
//	 String salt1 = username;  
//	 String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();  
//	 System.out.println("salt2:" + salt2);
//	 int hashIterations = 2;  
//	   
//	 SimpleHash hash = new SimpleHash(algorithmName, password, salt1 + salt2, hashIterations);  
//	 String encodedPassword = hash.toHex();
//	 System.out.println("encodedPassword:"+encodedPassword);
//}
}
