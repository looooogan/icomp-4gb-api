package com.api.utils;

import com.api.utils.constants.Constants;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public class CookieKey {

	public static String getToken(HttpServletRequest request) {
		String token = "";
		Cookie[] cookies = request.getCookies();
		if (!ArrayUtils.isEmpty(cookies)) {
			try {
				token = CookieKey.getCookieValue(cookies, Constants.TOKEN);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if(StringUtils.isBlank(token)){
			token = request.getSession().getId();
		}
		return token;
	}

	public static String getCookieValue(Cookie[] cookies, String str)
			throws UnsupportedEncodingException {
		String result = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(str)) {
				result = cookie.getValue();
				break;
			}
		}
		return result;
	}

}
