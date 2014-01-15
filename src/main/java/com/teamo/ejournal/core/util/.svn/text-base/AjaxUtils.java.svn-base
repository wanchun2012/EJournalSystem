package com.teamo.ejournal.core.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.WebRequest;

public class AjaxUtils {

	public final static String ajaxHeader = "X-Requested-With";
	
	public static boolean isAjaxRequest(WebRequest webRequest) {
		String requestedWith = webRequest.getHeader(ajaxHeader);
		return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
	}
	
	public static boolean isAjaxRequest(HttpServletRequest request) {
		String requestedWith = request.getHeader(ajaxHeader);
		return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
	}

	public static boolean isAjaxUploadRequest(WebRequest webRequest) {
		return webRequest.getParameter("ajaxUpload") != null;
	}
	
	private AjaxUtils() {}

}
