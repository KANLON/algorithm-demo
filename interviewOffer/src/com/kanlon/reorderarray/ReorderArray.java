package com.kanlon.reorderarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题14：调整数组顺序使奇数位于偶数前面
 * <p>
 * 题目：输入一个整数数组，实现一个函数来调整该数组中的数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * @author zhangcanlong
 * @date 2018年10月14日
 */
public class ReorderArray {

	public static void main(String[] args) {

		ReorderArray test = new ReorderArray();
		// 测试
		// 测试1 数组奇偶数交替出现
		int[] ints1 = { 1, 2, 3, 4, 5, 6, 7 };
		// 测试2 数组所有偶数都出现在奇数前面
		int[] ints2 = { 6, 4, 2, 1, 3, 5, 7 };
		// 测试3 数组所有奇数都出现偶数前
		int[] ints3 = { 1, 3, 5, 7, 6, 4, 2 };
		// 测试4 数组只有奇数
		int[] ints4 = { 1, 3, 5, 7 };
		// 测试5 数组只有偶数
		int[] ints5 = { 6, 4, 2 };
		// 测试6 输入null指针
		int[] ints6 = null;
		// 测试7 输入只含有一个数字
		int[] ints7 = { 3 };

		List<int[]> list = new ArrayList<>();
		list.add(ints1);
		list.add(ints2);
		list.add(ints3);
		list.add(ints4);
		list.add(ints5);
		list.add(ints6);
		list.add(ints7);

		// test.reorderArray(ints1);
		for (int i = 0; i < list.size(); i++) {
			test.reorderArray(list.get(i));
			System.out.println(Arrays.toString(list.get(i)));
		}
	}

	/**
	 * 解题思路1:定义两个指针，一个从0开始++，一个从length-1向前--。当第一个指针遇到偶数就与开始第二个指针也开始向后移动，直到移动到遇到奇数。然后交换两个指针所对应的元素，继续循环，直到第一个指针不再小于第二个指针
	 *
	 * @param datas
	 *            要重排序的数组
	 */
	public void reorderArray(int[] datas) {
		if (datas == null || datas.length == 0) {
			return;
		}
		int index1 = 0;
		int index2 = datas.length - 1;
		int length = datas.length;
		while (index1 < index2) {
			// 当指针1遇到偶数
			if (datas[index1] % 2 == 0) {
				// 直到datas中index2等于偶数和index1小于index2的值,则向后
				while (datas[index2] % 2 == 0 && index1 < index2) {
					index2--;
				}
				// 交换两个指针所对应的元素的值
				if (index1 < index2) {
					datas[index1] = datas[index1] ^ datas[index2];
					datas[index2] = datas[index1] ^ datas[index2];
					datas[index1] = datas[index1] ^ datas[index2];
					++index1;
					--index2;
				}
				// 没有遇到偶数，则继续++
			} else {
				++index1;
			}
		}
	}

	/**
	 * 解题思路2（推荐，可拓展性的，秒杀offer）：如果题目改成所有负数都在非负数的前面或者，能被3整除的数都在不能被3整数的数的前面。
	 * 这时候可以由于都是将数组分为两部分，可以将判断部分分离出来，如果是在前面则是true，如果是后面的则是false
	 *
	 * @param datas
	 *            要排序的数组
	 */
	public void reorderArray2(int[] datas) {
		if (datas == null || datas.length == 0) {
			return;
		}
		int index1 = 0;
		int index2 = datas.length - 1;
		while (index1 < index2) {
			// 如果该数是前面的，则index1++
			while (index1 < index2 && isBeginOrEnd(datas[index1])) {
				index1++;
			}
			// 如果该数是后面的，则index2--
			while (index1 < index2 && !isBeginOrEnd(datas[index2])) {
				index2--;
			}
			// 交换两个数
			if (index1 < index2) {
				datas[index1] = datas[index1] ^ datas[index2];
				datas[index2] = datas[index1] ^ datas[index2];
				datas[index1] = datas[index1] ^ datas[index2];
			}
		}
	}

	/**
	 * 判断某个整数应该是在数组的前面还是后面
	 *
	 * @param n
	 *            要判断的整数
	 * @return true，则表示该数应该是在前面的，如果是false则表示该数应该是在后面的
	 */
	public boolean isBeginOrEnd(int n) {
		// 这里以奇数在前面，偶数在后面为例
		return (n & 1) == 1;
	}
}
