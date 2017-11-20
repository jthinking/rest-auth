package com.jthinking.util.auth;

import java.util.Calendar;

import org.apache.commons.codec.digest.DigestUtils;

public class SecretKeyClient {
	
	public static String get() {
		Calendar calendar = Calendar.getInstance();
		StringBuilder builder = new StringBuilder();
		String password = "password";
		builder.append(password);
		builder.append(calendar.get(Calendar.YEAR));
		builder.append(calendar.get(Calendar.MONTH));
		builder.append(calendar.get(Calendar.DATE));
		builder.append(calendar.get(Calendar.HOUR));
		builder.append(calendar.get(Calendar.MINUTE));
		builder.append(calendar.get(Calendar.DAY_OF_WEEK));
		builder.append(calendar.get(Calendar.DAY_OF_MONTH));
		builder.append(calendar.get(Calendar.DAY_OF_YEAR));
		builder.append(calendar.get(Calendar.WEEK_OF_YEAR));
		builder.append(calendar.get(Calendar.WEEK_OF_MONTH));
		String md5Hex = DigestUtils.md5Hex(builder.toString());
		return md5Hex;
	}

}
