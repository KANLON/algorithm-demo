package com.kanlon.power;

import java.security.InvalidParameterException;

/**
 * 数值的整数次方 题目：实现函数double Power(double base,int
 * exponent),求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * @author zhangcanlong
 * @date 2018年10月6日
 */
public class CulPower {
	public static void main(String[] args) {
		CulPower cul = new CulPower();
		// 测试用例，将底数和指数分别设为正数，负数，和零
		double base1 = 2;
		int exponent1 = 3;
		double base2 = 2;
		int exponent2 = -3;
		double base3 = -2;
		int exponent3 = 3;
		double base4 = 0;
		int exponent4 = 3;
		double base5 = 2;
		int exponent5 = 0;
		double base6 = 0;
		int exponent6 = 0;
		double base7 = -2;
		int exponent7 = -3;
		System.out.println(cul.power(base1, exponent1));
		System.out.println(cul.power(base2, exponent2));
		System.out.println(cul.power(base3, exponent3));
		System.out.println(cul.power(base4, exponent4));
		System.out.println(cul.power(base5, exponent5));
		System.out.println(cul.power(base6, exponent6));
		System.out.println(cul.power(base7, exponent7));
	}

	/**
	 * 解题思路1：考虑到指数有可能是负数，当exponent是负数时，base也是0时，则返回0.结果是base的绝对值的倒数。
	 * 注意：在double值进行比较时，不能直接比较
	 *
	 * @param base
	 * @param exponent
	 * @return
	 */
	public double power(double base, int exponent) {
		// 这里不能直接用base==0来判断，因为base是浮点数，0是不准确的值
		if (equal(base, 0) && exponent < 0) {
			// 如果底数是0，而且指数是小于0的，则0不能做除数，抛出异常
			throw new InvalidParameterException("0的指数不能负数，没有意义！！");
		}
		double result = bestPowerWithUnsignedException(base, Math.abs(exponent));
		if (exponent < 0) {
			result = 1.0d / result;
		}
		return result;
	}

	/**
	 * 计算base的正整数exponent次方的结果,直接多次base相乘
	 *
	 * @param base
	 *            底数
	 * @param abs
	 *            正整数次方
	 * @return
	 */
	private double powerWithUnsignedExponent(double base, int exponent) {
		double result = 1.0d;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}

	/**
	 * (推荐使用)计算base的正整数exponent次方的结果，最好的方法，利用了求a的n次方的公式。时间复杂度为O(logn)
	 *
	 * @param base
	 *            底数
	 * @param exponect
	 *            正整数次方
	 * @return
	 */
	private double bestPowerWithUnsignedException(double base, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}
		double result = bestPowerWithUnsignedException(base, exponent >> 1);
		result *= result;
		if ((exponent & 1) == 1) {
			result *= base;
		}
		return result;
	}

	/**
	 * 比较两个double值是否相等
	 *
	 * @param num1
	 * @param num2
	 * @return
	 */
	private boolean equal(double num1, double num2) {
		if (num1 - num2 < 0.000001 && num1 - num2 > 0.000001) {
			return true;
		}
		return false;
	}

}
