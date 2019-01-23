package com.kanlon.k_least_numbers;

/**
 * 面试题30：最小的k个数
 * <p>
 * 题目：输入 n个整数，找出其中最小的k个数，例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1、2、3、4
 *
 * @author zhangcanlong
 * @date 2019年1月22日
 */
public class KLeastNumbers {
	public static void main(String[] args) {

	}

	/**
	 * 解题思路1(使用快速排序的思路)：（1）因为快速排序是选定一个基准元素，将比基准元素小的放在左边，比基准元素大的放在右边。
	 * （2）因此只要往k为下标那边进行快速排序的递归算法，当基准元素的下标等于k时，则在数组左边的k个元素就是数组中最小的k个数字
	 * <p>
	 * 这种方法的时间复杂度O(n)，不过需要更改数组的原来的元素位置，另一方面对数组进行了部分排序
	 *
	 * @param datas
	 *            要寻找的数组
	 * @param n
	 *            数组的长度
	 * @param output
	 *            最小的k个数的数组
	 * @param k
	 *            最小的k个数
	 */
	public void getLeastNumbersWithQuickSort(int[] datas, int n, int[] output, int k) {
		if (datas == null || n <= 0 || k > n || k <= 0) {
			return;
		}
		int start = 0;
		int end = n - 1;
		int index = partition(datas, n, start, end);
		while (index != k) {
			// 往左边继续递归
			if (index > k) {
				end = index - 1;
				index = partition(datas, n, start, end);
			} else {
				// 往右边继续递归
				start = index + 1;
				index = partition(datas, n, start, end);
			}
		}
		// 遍历左边k个元素，即最小的k个数
		for (int i = 0; i <= index; ++i) {
			output[i] = datas[i];
		}
	}

	public void getLeastNumbersWithStack(int[] datas, int n, int[] output, int k) {

	}

	/**
	 * 快速排序的关键步骤，一个过程。关键是在于先在数组中选择一个数字，接下来把数组中的数字分为两部分，比选择的数字小的数字移动数组的左边，比选择数字大的数字移到数组的右边。
	 *
	 * @param data
	 *            要排序的数组
	 * @param length
	 *            要排序的数组的长度
	 * @param start
	 *            要排序的数组的开始下标
	 * @param end
	 *            要排序的数组的结束下标
	 * @return 返回中间元素的下标
	 */
	private int partition(int[] data, int length, int start, int end) {
		if (data == null || length < 0 || start < 0 || end >= length) {
			throw new IllegalArgumentException("参数错误");
		}
		// 基准元素的下标
		int index = start;
		// 将基准元素移动到最后，和首元素交换
		swap(data, index, end);
		// 用来表示第几个比基准元素小的数组中的下标
		int small = start - 1;
		// 遍历数组
		for (index = start; index < end; ++index) {
			// 如果当前元素小于基准元素，则将其换到前面去
			if (data[index] < data[end]) {
				++small;
				if (small != index) {
					swap(data, index, small);
				}
			}
		}
		++small;
		// 将基准元素交换回中间
		swap(data, small, end);
		return small;
	}

	/**
	 * 交换两个数
	 *
	 * @param data
	 * @param a
	 * @param b
	 */
	private void swap(int[] data, int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}

}
