package com.jthinking.util.auth;

import java.util.Calendar;

import org.apache.commons.codec.digest.DigestUtils;

public class SecretKeyServer {
	
	private static String[] get() {
		String[] keys = new String[2];
		
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
		String password = "password";
		
		StringBuilder builder1 = new StringBuilder();
		builder1.append(password);
		builder1.append(year);
		builder1.append(month);
		builder1.append(date);
		builder1.append(hour);
		builder1.append(minute);
		builder1.append(dayOfWeek);
		builder1.append(dayOfMonth);
		builder1.append(dayOfYear);
		builder1.append(weekOfYear);
		builder1.append(weekOfMonth);

		StringBuilder builder2 = new StringBuilder();
		builder2.append(password);
		builder2.append(year);
		builder2.append(month);
		builder2.append(date);
		builder2.append(hour);
		builder2.append(minute - 1);
		builder2.append(dayOfWeek);
		builder2.append(dayOfMonth);
		builder2.append(dayOfYear);
		builder2.append(weekOfYear);
		builder2.append(weekOfMonth);
        
		String md5Hex1 = DigestUtils.md5Hex(builder1.toString());
		String md5Hex2 = DigestUtils.md5Hex(builder2.toString());
		keys[0] = md5Hex1;
		keys[1] = md5Hex2;
		return keys;
	}
	
	public static boolean auth(String key) {
		String[] keys = get();
		
		for (String k : keys) {
			if (k.equalsIgnoreCase(key)) {
				return true;
			}
		}
		
		return false;
	}

}
