package com.zwj.util;

import java.util.Random;
/**
 * 随机数
 * @author xu116
 *
 */
public class Tool {
	public static int getRandomString(int length) {
		// StringBuffer buffer=new
		// StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		StringBuffer buffer = new StringBuffer("123456789");
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int range = buffer.length();
		for (int i = 0; i < length; i++) {
			sb.append(buffer.charAt(r.nextInt(range)));
		}
		return Integer.parseInt(sb.toString());
	}
}
