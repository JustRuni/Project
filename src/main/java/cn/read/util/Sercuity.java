package cn.read.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Sercuity {
	private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	public static String encodePassword(String password) {
		return bCryptPasswordEncoder.encode(password);
	}
	public static void main(String[] args) {
		String password ="123";
		String codePassword = encodePassword(password);
		System.out.println(codePassword);
	}

}
