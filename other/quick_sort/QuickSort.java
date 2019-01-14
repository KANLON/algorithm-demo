package com.kanlon.quick_sort;

import java.util.Arrays;

/**
 * 快速排序的实现的，还可查找第k大的数
 *
 * @author zhangcanlong
 * @date 2019年1月13日
 */
public class QuickSort {

	public static void main(String[] args) {
		QuickSort test = new QuickSort();
		int[] datas = { 1, 3, 12, 1, 1, 45, 4 };
		test.quickSort(datas, datas.length, 0, datas.length - 1);
		System.out.println(Arrays.toString(datas));
	}

	/**
	 * 快速排序算法的实现
	 *
	 * @param data
	 *            要排序的算法
	 * @param length
	 *            数组的长度
	 * @param start
	 *            数组的第一个元素下标
	 * @param end
	 *            数组的最后一个元素下标
	 */
	void quickSort(int data[], int length, int start, int end) {
		if (start == end) {
			return;
		}

		int index = partition(data, length, start, end);
		if (index > start) {
			quickSort(data, length, start, index - 1);
		}
		if (index < end) {
			quickSort(data, length, index + 1, end);
		}
	}

	/**
	 * 实现快速排序算法的关键在于先在数组中选择一个数字，接下来把数组中的数字分为两部分，比选择的数字小的数字移到数组的左边，比选择的数字大的数字移到数组的右边。
	 *
	 * @param data
	 * @param length
	 * @param start
	 * @param end
	 * @return
	 */
	public int partition(int data[], int length, int start, int end) {
		if (data == null || length <= 0 || start < 0 || end >= length) {
			throw new IllegalArgumentException("无效的参数！");
		}
		// 第一个元素作为
		int index = start;
		swap(data, index, end);

		int small = start - 1;
		for (index = start; index < end; ++index) {
			if (data[index] < data[end]) {
				++small;
				if (small != index) {
					swap(data, index, small);
				}
			}
		}
		++small;
		swap(data, small, end);

		return small;
	}

	/**
	 * 根据索引根据数组中两个的元素
	 *
	 * @param data
	 * @param a
	 *            第一个元素的索引
	 * @param b
	 *            第二个元素的索引
	 */
	void swap(int[] data, int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;

	};
}
