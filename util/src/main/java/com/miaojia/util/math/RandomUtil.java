package com.miaojia.util.math;

import java.math.BigDecimal;

public class RandomUtil {
	/**
	 * 获取start到end区间的随机数,不包含start+end
	 * @param start
	 *            开始数字
	 * @param end
	 *            结束数字
	 * @return BigDecimal 随机结果，包含小数，请根据实际情况进行操作
	 */
	public static BigDecimal getRandom(int start, int end) {
		return new BigDecimal(start + Math.random() * end);
	}
}
