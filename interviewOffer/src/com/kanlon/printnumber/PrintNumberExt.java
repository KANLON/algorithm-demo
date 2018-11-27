package com.kanlon.printnumber;

import java.math.BigInteger;
import java.security.InvalidParameterException;

/**
 * 拓展题目：定义一个函数，在该函数中可以实现任意两个整数的加法。
 *
 * @author zhangcanlong
 * @date 2018年10月7日
 */
public class PrintNumberExt {
	public static void main(String[] args) {
		PrintNumberExt print = new PrintNumberExt();
		System.out.println(print.addTwoNumber("1234", "1234"));
	}

	/**
	 * 解题思路：首先两个整数相加的和不会超过他们之中最大的长度+1，因此，先定义一个字符数组，定义为两个整数最长长度+1，
	 * 接着以其中一个整数的数值处开始for循环计算相加，（先不考虑负数），大于10，则进1。负数 (该题还没实现)
	 *
	 * @param num1
	 *            整数1 的字符串
	 * @param num2
	 *            整数2 的字符串
	 * @return 返回相加的结果的字符串
	 */
	public String addTwoNumber(String num1, String num2) {
		if (!num1.matches("([-\\+])?\\d+") && !num2.matches("([-\\+])?\\d+")) {
			throw new InvalidParameterException("输入的不是一个整数，请重新输入！！！");
		}
		BigInteger int1 = new BigInteger(num1);
		BigInteger int2 = new BigInteger(num2);
		return int1.add(int2).toString();
	}

}