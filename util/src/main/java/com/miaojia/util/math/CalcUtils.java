package com.miaojia.util.math;

import java.math.BigDecimal;

public class CalcUtils {
	/**
	 * 加法
	 *
	 * @param var1 被加数
	 * @param var2 加数
	 * @return double 结果
	 */
	public static double add(double var1, double var2) {
		BigDecimal b1 = new BigDecimal(Double.toString(var1));
		BigDecimal b2 = new BigDecimal(Double.toString(var2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 减法
	 *
	 * @param var1 被减数
	 * @param var2 减数
	 * @return double 结果
	 */

	public static double sub(double var1, double var2) {
		BigDecimal b1 = new BigDecimal(Double.toString(var1));
		BigDecimal b2 = new BigDecimal(Double.toString(var2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 乘法
	 *
	 * @param var1 被乘数
	 * @param var2 乘数
	 * @return double 结果
	 */
	public static double mul(double var1, double var2) {
		BigDecimal b1 = new BigDecimal(Double.toString(var1));
		BigDecimal b2 = new BigDecimal(Double.toString(var2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 除法
	 *
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 精度，到小数点后几位
	 * @return double 结果
	 */

	public static double div(double v1, double v2, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException("The scale must be a positive integer or ");

		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

	/**
	 * 四舍五入
	 * @param v 要被四舍五入的数字
	 * @param scale 精确位数
	 * @return double 结果
	 */
	public static double round(double v, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException("The scale must be a positive integer or zero");

		}

		BigDecimal b = new BigDecimal(Double.toString(v));

		BigDecimal one = new BigDecimal("1");

		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

}
