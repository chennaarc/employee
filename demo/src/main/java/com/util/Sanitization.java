package com.util;

import org.springframework.web.util.HtmlUtils;
import com.domain.Employee;

public class Sanitization {
	
	public static String processSantizeData(String requestStr) {
		return HtmlUtils.htmlEscape(requestStr);
	}
	
	public static void processSantizeData(Employee emp) {
		emp.setFirstName(HtmlUtils.htmlEscape(emp.getFirstName()));
		emp.setLastName(HtmlUtils.htmlEscape(emp.getLastName()));
		emp.setEmpId(HtmlUtils.htmlEscape(emp.getEmpId()));
	}	
}
