package com.kanlon.k_least_numbers;

import java.util.Arrays;

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
		// 测试
		KLeastNumbers test = new KLeastNumbers();

		// 功能测试1（多个元素，有多个相同，寻找最小的多个元素）
		int[] ints1 = { 4, 5, 1, 6, 2, 7, 3, 8 };
		int[] output = new int[ints1.length];
		test.getLeastNumbersWithHead(ints1, ints1.length, output, 4);
		System.out.println("功能测试1：" + Arrays.toString(ints1));
		test.getLeastNumbersWithQuickSort(ints1, ints1.length, output, 4);
		System.out.println("功能测试1：" + Arrays.toString(ints1));
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

	/**
	 * 解题思路2（利用最大堆）：（1）要寻找最小的k个数，先使用最大堆存储数组的前k个数，接着从k+1个元素开始遍历数组，如果元素比最大堆堆顶元素小，则删除堆顶元素，并将该元素添加到堆中。最后遍历堆可以得到最小的k个元素了。
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
	public void getLeastNumbersWithHead(int[] datas, int n, int[] output, int k) {
		if (datas == null || n <= 0 || k > n || k <= 0) {
			return;
		}
		TopN topn = new TopN();
		topn.findTopN(k, datas);
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

class TopN {
	// 父节点
	private int parent(int n) {
		return (n - 1) / 2;
	}

	// 左孩子
	private int left(int n) {
		return 2 * n + 1;
	}

	// 右孩子
	private int right(int n) {
		return 2 * n + 2;
	}

	// 构造堆
	private void buildHeap(int n, int[] data) {
		for (int i = 1; i < n; i++) {
			int t = i;
			// 调整堆
			while (t != 0 && data[parent(t)] > data[t]) {
				// 交换data[t]和data[parent(t)]的值
				int temp = data[t];
				data[t] = data[parent(t)];
				data[parent(t)] = temp;

				t = parent(t);
			}
		}
	}

	// 调整data[i]
	private void adjust(int i, int n, int[] data) {
		if (data[i] <= data[0]) {
			return;
		}
		// 置换堆顶
		int temp = data[i];
		data[i] = data[0];
		data[0] = temp;
		// 调整堆顶
		int t = 0;
		while ((left(t) < n && data[t] > data[left(t)]) || (right(t) < n && data[t] > data[right(t)])) {
			if (right(t) < n && data[right(t)] < data[left(t)]) {
				// 右孩子更小，置换右孩子
				temp = data[t];
				data[t] = data[right(t)];
				data[right(t)] = temp;
				t = right(t);
			} else {
				// 否则置换左孩子
				temp = data[t];
				data[t] = data[left(t)];
				data[left(t)] = temp;
				t = left(t);
			}
		}
	}

	// 寻找topN，该方法改变data，将topN排到最前面
	public void findTopN(int n, int[] data) {
		// 先构建n个数的小顶堆
		buildHeap(n, data);
		// n往后的数进行调整
		for (int i = n; i < data.length; i++) {
			adjust(i, n, data);
		}
	}

	// 打印数组
	public void print(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

}