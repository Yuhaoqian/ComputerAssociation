package com.ca.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UnCode {
	public static String stringUncode(String param) {
		if (param != null && !param.trim().equals("")) {
			try {
				//                param = param.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
				//  //测试%转义
				// 因为getParameter会自动解一次码，所以要先转再解码
				param = URLEncoder.encode(param, "utf-8");// 转码
				param = URLDecoder.decode(param, "UTF-8");// 解码
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return param;
	}

}
