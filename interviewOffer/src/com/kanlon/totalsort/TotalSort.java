package com.kanlon.totalsort;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排序的方法的。题目：对{a,b,c}进行全排序，要求输出全排序的结果
 *
 * @author zhangcanlong
 * @date 2018年10月7日
 */
public class TotalSort {

	/**
	 * 用来存放全排序的结果集
	 */
	private static List<String> list = new ArrayList<>();

	public static void main(String[] args) {
		// 测试字符数组的全排序
		TotalSort test = new TotalSort();
		char[] arrays = "abc".toCharArray();
		test.totalSort(arrays, 0, arrays.length - 1);
		// 测试通用全排序
		Character[] chars = { '1', '2', '3' };
		test.totalSortObjects(chars, 0, arrays.length - 1);
		System.out.println("通用的全排序：" + list);
	}

	/**
	 * 解题思路：运用递归方法调用，将原数组要排序的第一个元素与每个元素进行交换，然后递归调用该方法排序除首元素的其他元素，当只要排序该数组
	 * 的一个元素时，只有一种排序方式，直接输出该数组。
	 *
	 * @param arrays
	 *            要排序的数组
	 * @param start
	 *            要排序的开始元素的下标
	 * @param end
	 *            要排序的结束元素的下标
	 */
	public void totalSortObjects(Object[] arrays, int start, int end) {
		if (start == end) {
			StringBuffer tempBuffer = new StringBuffer();
			for (int i = 0; i <= end; i++) {
				tempBuffer.append(arrays[i]);
			}
			list.add(tempBuffer.toString());
		} else {
			for (int i = start; i <= end; i++) {
				swap(arrays, start, i);
				totalSortObjects(arrays, start + 1, end);
				// 还原原数组，保证第一个元素能和排序的每个元素都交换
				swap(arrays, start, i);
			}
		}

	}

	/**
	 * 交换数组的两个元素（更通用）
	 *
	 * @param arrs
	 *            要交换的数组
	 * @param a
	 *            要交换的元素的下标1
	 * @param b
	 *            要交换的元素的下标2
	 */
	private void swap(Object[] arrs, int a, int b) {
		Object temp = arrs[a];
		arrs[a] = arrs[b];
		arrs[b] = temp;
	}

	/**
	 * 解题思路：运用递归方法调用，将原数组要排序的第一个元素与每个元素进行交换，然后递归调用该方法排序除首元素的其他元素，当只要排序该数组
	 * 的一个元素时，只有一种排序方式，直接输出该数组。
	 *
	 * @param arrays
	 *            要排序的数组
	 * @param start
	 *            要排序的开始元素的下标
	 * @param end
	 *            要排序的结束元素的下标
	 */
	public void totalSort(char[] arrays, int start, int end) {
		if (start == end) {
			for (int i = 0; i <= end; i++) {
				System.out.print(arrays[i]);
			}
			// 换行输出
			System.out.println();
		} else {
			for (int i = start; i <= end; i++) {
				swap(arrays, start, i);
				totalSort(arrays, start + 1, end);
				// 还原原数组，保证第一个元素能和排序的每个元素都交换
				swap(arrays, start, i);
			}
		}

	}

	/**
	 * 交换数组的两个元素
	 *
	 * @param arrays
	 *            要交换的数组
	 * @param start
	 *            要交换的元素下标1
	 * @param i
	 *            要交换的元素下标2
	 */
	private void swap(char[] arrays, int start, int i) {
		char temp = arrays[start];
		arrays[start] = arrays[i];
		arrays[i] = temp;
	}

}