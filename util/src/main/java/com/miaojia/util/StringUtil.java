package com.miaojia.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StringUtil {
	/**
	 * 根据切分大小进行换行
	 * @param str
	 * @param size 要切分的大小
	 * @return String 换行结果
	 */
	public static String getWrapString(String str, int size) {
		int hzCount = 0;// 汉字的个数
		int ywCount = 0;// 字母节数
		String result = "";
		try {
			if (str.getBytes("GBK").length < size) {
				return str;
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		char[] cStr = str.toCharArray();
		for (int i = 0; i < cStr.length; i++) {
			try {
				if ((cStr[i] + "").getBytes("GBK").length == 2) {
					hzCount++;
				} else if ((cStr[i] + "").getBytes("GBK").length == 1) {
					ywCount++;
				}
				result = result + cStr[i];
				if ((hzCount * 2 + ywCount) % size == 0) {
					result = result + "\n";
				} else if ((hzCount * 2 + ywCount) % size == 1) {
					if ((cStr[i] + "").getBytes("GBK").length == 2) {
						result = result + "\n";
					}
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 返回指定格式的字符型日期
	 * 
	 * @param date
	 *            要转换的日期对象
	 * @param formatString
	 *            结果字符串如：yyyyMMddHHmmss
	 * @return String 日期转换结果
	 */
	public static String Date2String(Date date, String formatString) {
		if (CommUtil.isEmpty(date)) {
			return null;
		}
		SimpleDateFormat simpledateformat = new SimpleDateFormat(formatString);
		String strDate = simpledateformat.format(date);
		return strDate;
	}

	/**
	 * list 转字符串
	 * @param list	传入的list
	 * @return String lisy转换结果
	 * @author wuyanlin
	 */
	public static String List2String(List<String> list) {
		StringBuffer sb = new StringBuffer();

		if (CommUtil.isNotEmpty(list)) {
			for (Object s : list) {// 遍历lis逗号隔开
				sb.append(s);
				sb.append(",");
			}
		} else {

			return null;
		}
		// 删除最后一个逗号
		if (sb.length() > 0) {
			sb.delete(sb.length() - 1, sb.length());
		} else {

			return null;
		}

		return sb.toString();
	}
}
