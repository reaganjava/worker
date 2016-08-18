package com.umbrella.worker.util;

public class StringUtil {
	public static boolean isEmpty(String s) {
		/*if (s == null || s.trim().length() < 1)
			return true;
		return false;*/
		
		return s == null || s.trim().isEmpty();
	}
	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}

	public static boolean isGreatOne(Integer value) {
		if (value != null && value >= 1) {
			return true;
		}
		return false;
	}
	public static boolean isGreatOne(Long value) {
		if (value != null && value >= 1) {
			return true;
		}
		return false;
	}
	
	public static String getReferer(String referer) {
		referer = referer.replace("http://", "");
		int start = referer.indexOf("/");
		referer = referer.substring(start + 1);
		return referer.replace(".html", "");
	}
	
}
