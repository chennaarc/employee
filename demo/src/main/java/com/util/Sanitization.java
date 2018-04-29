package com.util;

import org.springframework.web.util.HtmlUtils;

public class Sanitization {
	
	public static String processSantizeData(String requestStr) {
		return HtmlUtils.htmlEscape(requestStr);
	}
}
