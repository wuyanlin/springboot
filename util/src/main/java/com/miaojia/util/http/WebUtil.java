package com.miaojia.util.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class WebUtil {
	public static String ObjectToString(Map<String, Object> param) {
		StringBuffer paramstr = new StringBuffer();
		int i = 0;
		for (String key : param.keySet()) {
			if (i == 0)
				paramstr.append("");
			else
				paramstr.append("&");
			paramstr.append(key).append("=").append(param.get(key));
			i++;
		}
		return paramstr.toString();
	}
	
}
