package com.kanlon.sort_array_for_min_number;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 面试题33：把数组排成最小的数
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3,32,321},则打印出这三个数字能排成的最小数字321323。
 *
 *
 * @author zhangcanlong
 * @date 2019年2月6日
 */
public class SortArrayForMinNumber {
	public static void main(String[] args) {
		SortArrayForMinNumber test = new SortArrayForMinNumber();
		// 功能测试1:{21,23}
		int[] numbers1 = { 33, 32, 321 };
		System.out.println("功能测试1：" + test.printMinNumber1(numbers1));
		System.out.println("功能测试1：" + test.printMinNumber2(numbers1));
		// 功能测试2
		int[] numbers2 = { 1, 32, 321 };
		System.out.println("功能测试2：" + test.printMinNumber1(numbers2));
		System.out.println("功能测试2：" + test.printMinNumber2(numbers2));
		// 特殊测试1
		int[] numbers3 = { 12 };
		System.out.println("特殊测试1：" + test.printMinNumber1(numbers3));
		System.out.println("特殊测试1：" + test.printMinNumber2(numbers3));
		// 特殊测试2
		int[] numbers4 = null;
		System.out.println("特殊测试2：" + test.printMinNumber1(numbers4));
		System.out.println("特殊测试2：" + test.printMinNumber2(numbers4));
	}

	/**
	 * 解题思路1（暴力破解）：对数组进行全排序，然后比较每个元素的大小。n!
	 *
	 * @param numbers
	 *            数组
	 */
	String printMinNumber1(int[] numbers) {
		if (numbers == null || numbers.length <= 0) {
			return "";
		}
		List<String> list = new ArrayList<>();
		fullSort(numbers, 0, numbers.length - 1, list);
		// 找出最小的元素
		BigInteger minNumber = new BigInteger(list.get(0));
		for (int i = 0; i < list.size(); i++) {
			BigInteger temp = new BigInteger(list.get(i));
			if (minNumber.compareTo(temp) > 0) {
				minNumber = temp;
			}
		}
		return minNumber.toString();
	}

	/**
	 * 解题思路2（推荐，最好能了解其证明原理，O(nlogn)）：定义一种新的规则，有两个数m和n，比较他们的组合nm和mn是那个大。然后对数组进行排序，最后将其拼接起来，则形成了最小的数
	 *
	 * @param numbers
	 *            数组
	 */
	String printMinNumber2(int[] numbers) {
		if (numbers == null || numbers.length <= 0) {
			return "";
		}
		// 将基本类型转化为包装类型
		Integer[] tempInts = new Integer[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			tempInts[i] = numbers[i];
		}

		Arrays.sort(tempInts, new Comparator<Integer>() {
			// 组合后越小的，放前面，即组合小保持原顺序，小于组合大的
			@Override
			public int compare(Integer int1, Integer int2) {
				BigInteger temp1 = new BigInteger(int1 + "" + int2);
				BigInteger temp2 = new BigInteger(int2 + "" + int1);
				return temp1.compareTo(temp2);
			}
		});
		// 拼装成最小元素字符串
		StringBuilder minNumberStr = new StringBuilder();
		for (Integer temp : tempInts) {
			minNumberStr.append(temp.toString());
		}
		return minNumberStr.toString();
	}

	/**
	 * 对数组进行全排序，并将全排序的结果放入到list集合中
	 *
	 * @param numbers
	 *            要排序的数组
	 * @param start
	 *            开始排序的元素下标
	 * @param end
	 *            结束排序的元素的下标
	 * @param list
	 *            要存放排序结果的集合
	 */
	void fullSort(int[] numbers, int start, int end, List<String> list) {
		if (numbers == null || numbers.length <= 0) {
			return;
		}
		if (start > end) {
			StringBuilder build = new StringBuilder();
			for (int number : numbers) {
				build.append(number + "");
			}
			list.add(build.toString());
		}
		for (int i = start; i <= end; i++) {
			// 交换两个数
			int temp = numbers[start];
			numbers[start] = numbers[i];
			numbers[i] = temp;
			fullSort(numbers, start + 1, end, list);
			// 还原
			numbers[i] = numbers[start];
			numbers[start] = temp;
		}
	}

}
