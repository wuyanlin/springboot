package com.miaojia.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SqlUtil {

	/**
	 * 将特定分隔的字符串转换为SQL语句的'',分隔 例如 "1,2,3"分隔为"'1','2','3'"
	 *
	 * @param str
	 *            要分隔的字符串
	 * @param falg
	 *            原字符串分隔标志
	 * @return String 返回转换的结果
	 */
	public static String formatStrToSQLCondition(String str, String falg) {
		String[] re = str.split(falg);
		str = "";
		for (int i = 0; i < re.length; i++) {
			if (CommUtil.isNotEmpty(re[i])) {
				if (i < re.length - 1)
					str += "'" + re[i] + "',";
				else
					str += "'" + re[i] + "'";
			}
		}
		return str;
	}
	/**
	 * 构建where条件,
	 * @param parame	参数形式如:id_eq:123,name_like:%123%
	 * @return	Map 构建结果
	 */
	public static Map<String, Object> buildWhere(Map<String, Object> parame) {

		Map<String, Object> result = new HashMap<String, Object>();

		String where = "";

		List<Object> parames = new ArrayList<Object>();

		for (Entry<String, Object> keys : parame.entrySet()) {
			String key = keys.getKey();
			String value = keys.getValue().toString();

			if (CommUtil.isNotEmpty(key) && CommUtil.isNotEmpty(value)) {
				if (key.indexOf("_") != -1) { // 存在下划线，才需要添加条件
					String name = key.substring(0, key.lastIndexOf("_"));
					String condition = key.substring(key.lastIndexOf("_") + 1);
					switch (condition.toUpperCase()) {
					case "EQ":
						where += " AND " + name + " = ? ";
						parames.add(value);
						break;

					case "NE":
						where += " AND " + name + " <> ? ";
						parames.add(value);
						break;
					case "LIKE":
						where += " AND " + name + " LIKE ? ";
						parames.add(value);
						break;
					case "LT":
						where += " AND " + name + " < ? ";
						parames.add(value);
						break;
					case "GT":
						where += " AND " + name + " > ? ";
						parames.add(value);
						break;
					case "IN":
						where += " AND " + name + " IN (?) ";
						parames.add(value);
						break;
					case "LTE":
						where += " AND " + name + " <= ? ";
						parames.add(value);
						break;
					case "GTE":
						where += " AND " + name + " >= ? ";
						parames.add(value);
						break;
					case "EX":
						where += " AND " + name + " REGEXP ? ";
						parames.add(value);
						break;
					case "BETWEEN":
						if (value.indexOf("-") != -1) {
							where += " AND " + name + " BETWEEN ? and ? ";
							String[] split = value.split("-");
							parames.add(split[0]);
							parames.add(split[1]);
						}
						break;
					}
				}
			}

		}
		if (where.length() >= 4) {
			where = where.substring(4);
		}
		result.put("where", where);
		result.put("parames", parames);

		return result;
	}
}
