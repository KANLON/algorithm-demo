package com.kanlon.first_not_repeating_char;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题35：第一个只出现一次的字符。 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff",则输出'b'
 *
 * @author zhangcanlong
 * @date 2019年2月11日
 */
public class FirstNotRepeatingChar {
	public static void main(String[] args) {
		FirstNotRepeatingChar test = new FirstNotRepeatingChar();
		// 功能测试1（abaccdeff，有唯一出现）
		String str1 = "abaccdeff";
		System.out.println("功能测试1（abaccdeff，有唯一出现），方法一:" + test.findFirstNotRepeatingChar1(str1));
		System.out.println("功能测试1（abaccdeff，有唯一出现），方法二:" + test.findFirstNotRepeatingChar2(str1));
		// 功能测试2（abaccdbd，没有唯一出现的）
		String str2 = "abaccdbd";
		System.out.println("功能测试2（abaccdbd，没有唯一出现的），方法一:" + test.findFirstNotRepeatingChar1(str2));
		System.out.println("功能测试2（abaccdbd，没有唯一出现的），方法二:" + test.findFirstNotRepeatingChar2(str2));
		// 功能测试2（a，只有一个字符）
		String str3 = "a";
		System.out.println("功能测试2（a，只有一个字符），方法一:" + test.findFirstNotRepeatingChar1(str3));
		System.out.println("功能测试2（a，只有一个字符），方法二:" + test.findFirstNotRepeatingChar2(str3));
		// 特殊测试1（null）
		System.out.println("特殊测试1（null），方法一:" + test.findFirstNotRepeatingChar1(null));
		System.out.println("特殊测试1（null），方法二:" + test.findFirstNotRepeatingChar2(null));

	}

	/**
	 * 解题思路1（利用自带的hashmap，推荐）：遍历字符，将字符作为key存储在hashmap中，将其出现的次数作为value。第一次遍历字符串时，遇到value为1的，则将其输出或返回，即的第一次出现的字符
	 *
	 * @param str
	 *            要查找的字符串
	 * @return 返回第一次出现的并且只出现一次的字符串，没有，则返回null
	 */
	public Character findFirstNotRepeatingChar1(String str) {
		if (str == null || str.length() <= 0) {
			throw new IllegalArgumentException("字符不能为null");
		}
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i) + "")) {
				map.put(str.charAt(i) + "", map.get(str.charAt(i) + "") + 1);
			} else {
				map.put(str.charAt(i) + "", 1);
			}
		}
		// 第二次遍历
		for (int i = 0; i < str.length(); i++) {
			if (map.get(str.charAt(i) + "") == 1) {
				return str.charAt(i);
			}
		}

		return null;
	}

	/**
	 * 解题思路2(自己构造简易hash表):自己构造hash表，使用字符的ascii码，作为下标，构造256大小的数组，数组的值存放对应元素出现的次数
	 *
	 * @param str
	 *            要查找的字符
	 * @return 返回第一次出现，并且出现第一次的字符，如果不存在，则返回null
	 */
	public Character findFirstNotRepeatingChar2(String str) {
		if (str == null || str.length() <= 0) {
			throw new IllegalArgumentException("字符不能为null");
		}
		int[] ints = new int[256];
		for (int i = 0; i < str.length(); i++) {
			ints[str.charAt(i)]++;
		}
		for (int i = 0; i < str.length(); i++) {
			if (ints[str.charAt(i)] == 1) {
				return str.charAt(i);
			}
		}
		return null;
	}
}
