package com.miaojia.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CommUtil {
	/**
	 * 判断对象是否Empty(null或元素为0)<br>
	 * 实用于对如下对象做判断:String Collection及其子类 Map及其子类
	 *
	 * @param pObj
	 *            待检查对象
	 * @return boolean 返回的布尔值
	 */
	public static boolean isEmpty(Object pObj) {
		if (pObj == null)
			return true;
		if (pObj == "")
			return true;
		if (pObj instanceof String) {
			if (((String) pObj).length() == 0) {
				return true;
			}
		} else if (pObj instanceof Collection) {
			if (((Collection<?>) pObj).size() == 0) {
				return true;
			}
		} else if (pObj instanceof Map) {
			if (((Map<?, ?>) pObj).size() == 0) {
				return true;
			}
		} else if (pObj.getClass().isArray()) {
			if (((Object[]) pObj).length == 0) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 判断对象是否为NotEmpty(!null或元素&gt;0)<br>
	 * 实用于对如下对象做判断:String Collection及其子类 Map及其子类
	 *
	 * @param pObj
	 *            待检查对象
	 * @return boolean 返回的布尔值
	 */
	public static boolean isNotEmpty(Object pObj) {
		if (pObj == null)
			return false;
		if (pObj == "")
			return false;
		if (pObj instanceof String) {
			if (((String) pObj).length() == 0) {
				return false;
			}
		} else if (pObj instanceof Collection) {
			if (((Collection<?>) pObj).size() == 0) {
				return false;
			}
		} else if (pObj instanceof Map) {
			if (((Map<?, ?>) pObj).size() == 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 根据字符串和分割规则分割字符串为list
	 * @param s
	 *            字符串
	 * @param splitregex
	 *            分割规则
	 * @return List	返回list
	 */
	public static List<String> stringToList(String s, String splitregex) {
		List<String> asList = new ArrayList<String>();
		if (isNotEmpty(s) && isNotEmpty(splitregex)) {

			String[] split = s.split(splitregex);

			asList = Arrays.asList(split);

		}
		return asList;
	}
}
