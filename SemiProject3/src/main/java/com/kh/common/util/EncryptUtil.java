package com.kh.common.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptUtil {
	
	public static String oneWayEnc(String message, String algorithm) {
		String encMessage = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			
			md.update(message.getBytes(Charset.forName("UTF-8")));
			
			byte[] digest = md.digest();
			encMessage = Base64.getEncoder().encodeToString(digest);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return encMessage;
	}
}