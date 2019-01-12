package com.kanlon.string_permutation;

import java.util.Stack;

/**
 * 字符串全排序的拓展题目1.
 * <p>
 * 求n个字符的长度为m(1<=m<=n)的组合.
 *
 * @author zhangcanlong
 * @date 2019年1月11日
 */
public class StringPermutationExt1 {
	public static void main(String[] args) {
		// 测试
		StringPermutationExt1 test = new StringPermutationExt1();
		// 功能测试1 （多个字符串）
		System.out.println("功能测试1 （多个字符串）");
		System.out.println(test.stringCombination("abc"));
		// 功能测试2（1个字符串）
		System.out.println("功能测试2（1个字符串）");
		System.out.println(test.stringCombination("a"));
		// 特殊测试1 （空字符串）
		System.out.println("特殊测试1 （空字符串）");
		System.out.println(test.stringCombination(""));
		// 特殊测试2（空）
		System.out.println("特殊测试2（空）");
		System.out.println(test.stringCombination(null));
	}

	/**
	 * 求字符串的所有的m位组合，m<=str.length()
	 *
	 * @param str
	 *            要组合的字符串
	 * @return 组合的次数
	 */
	public Integer stringCombination(String str) {
		Stack<Character> stack = new Stack<>();
		// 如果要组合的字符串为null，或者长度小于等于1，或者要组合的位数，大于等于字符串长度，则直接返回
		if (str == null || str.length() <= 1) {
			System.out.println(str);
			return 1;
		}
		int combinateSum = 0;
		for (int i = 1; i <= str.length(); i++) {
			combinateSum += stringCombination(str.toCharArray(), 0, str.length() - 1, i, stack);
		}
		return combinateSum;
	}

	/**
	 * 核心递归方法。
	 * <p>
	 * 解题思路：将字符串组合分为两部分：第一个字符和其余的所有字符。如果组合里包含第一个字符，则下一步在所剩余的n-1个字符里选取m个字符。
	 * 如果组合里不包含第一个字符，则下一步在剩余的n-1个字符里选取m个字符。也就是说，我们可以把n个字符组成长度为m的组合问题分解为两个子问题，分别求n-1个字符串中长度为m-1的组合，
	 * 以及求n-1个字符的长度为m的组合。这两个子问题都可以用递归的方式解决。
	 *
	 * @param chars
	 *            要组合的字符数组
	 * @param start
	 *            要开始组合的字符数组
	 * @param end
	 *            要结束组合的字符数组
	 * @param combinationDigit
	 *            要组合的位数
	 * @param stack
	 *            存放组合的字符
	 * @return 总组合数
	 */
	public Integer stringCombination(char[] chars, int start, int end, int combinationDigit, Stack<Character> stack) {
		// 组合的位数<=0，则直接返回1，表示一种组合方案的结束,结束递归
		if (combinationDigit <= 0) {
			System.out.println(stack.toString());
			return 1;
		}
		// 如果到了最后一位，应该组合位数小于等于0了的，因为在该递归方法内，已经把剩下最后一位和组合位数为1的方案执行了，所以如果组合数不为0，并且已经到了最后一位这种情况下直接返回，该情况不构成组合数
		if (start > end) {
			return 0;
		}
		stack.push(chars[start]);
		int combinate1 = stringCombination(chars, start + 1, end, combinationDigit - 1, stack);
		stack.pop();
		int combinate2 = stringCombination(chars, start + 1, end, combinationDigit, stack);
		return combinate1 + combinate2;
	}
}
