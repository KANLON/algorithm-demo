package com.kanlon.string_permutation;

import java.util.Arrays;

/**
 * 面试题28：字符串的排序
 * <p>
 * 题目：输入一个字符串，打印出该字符串中字符的所有排序。例如输入字符串abc，则打印出由字符a、b、c所能排序出来的所有字符串abc、acb、bac、bca、cab和cba
 *
 * @author zhangcanlong
 * @date 2019年1月8日
 */
public class StringPermutation {
	public static void main(String[] args) {
		StringPermutation test = new StringPermutation();
		// 功能测试1（含有多个字符串）
		System.out.println("功能测试1（含有多个字符串）:");
		test.permutation("abc");
		// 功能测试2（含有1个字符串）
		System.out.println("功能测试2（含有1个字符串）");
		test.permutation("a");
		// 功能测试特殊（空）
		System.out.println("特殊测试（空）");
		test.permutation(null);

	}

	/**
	 * 将字符串中所有字符全排序
	 * <p>
	 * 解题思路：求整个字符串的排序可以看成两步：（1）首先求所有可能出现在第一个位置的字符，即把第一个字符和后面所有字符交换。
	 * （2）然后这时我们将后面的字符分为两部分，后面字符的第一个字符以及这个字符之后的所有字符。然后把第一个字符逐一和后面的字符交换。
	 * （3）明显上面的步骤可以使用递归来解决。
	 *
	 * @param str
	 *            要排序的所有字符
	 */
	public void permutation(String str) {
		if (str == null || str.length() <= 1) {
			System.out.println(str);
			return;
		}
		char[] chars = str.toCharArray();
		permutation(chars, 0, chars.length - 1);
	}

	/**
	 * 辅助递归方法，核心部分
	 *
	 * @param chars
	 *            要排序的字符数组
	 * @param begin
	 *            要排序的第一元素下标
	 * @param end
	 *            要排序的最后一个元素下标
	 */
	public void permutation(char[] chars, int begin, int end) {
		if (begin >= end) {
			System.out.println(Arrays.toString(chars));
			return;
		}
		char firstNum = chars[begin];
		for (int i = begin; i <= end; i++) {
			chars[begin] = chars[i];
			chars[i] = firstNum;
			permutation(chars, begin + 1, end);

			// 还原
			chars[i] = chars[begin];
			chars[begin] = firstNum;
		}
	}
}
