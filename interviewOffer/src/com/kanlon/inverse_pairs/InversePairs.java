package com.kanlon.inverse_pairs;

import java.util.Arrays;

/**
 * 面试题36：数组中的逆序对
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * @author zhangcanlong
 * @date 2019年2月12日
 */
public class InversePairs {
	public static void main(String[] args) {
		InversePairs test = new InversePairs();
		// 功能测试1，有多个逆序对
		int[] ints1 = { 7, 5, 6, 4 };
		System.out.println("功能测试1，有多个逆序对:" + test.inversePairs(ints1));
		// 功能测试2，多个元素，0个逆序对
		int[] ints2 = { 2, 3, 4, 5, 6 };
		System.out.println("功能测试2，多个元素，0个逆序对:" + test.inversePairs(ints2));
		// 功能测试3，1个元素
		int[] ints3 = { 2 };
		System.out.println("功能测试3，1个元素:" + test.inversePairs(ints3));
		System.out.println("特殊测试1，0个元素：" + test.inversePairs(new int[] {}));
	}

	/**
	 * 解题思路（归并排序的改进）：
	 * 把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；则前面数组array[i]~array[mid]都是大于array[j]的，
	 * count += mid+1 - i 参考剑指Offer，但是感觉剑指Offer归并过程少了一步拷贝过程。
	 * 还有就是测试用例输出结果比较大，对每次返回的count mod(1000000007)求余
	 * <p>
	 * 参考：https://www.nowcoder.com/questionTerminal/96bd6684e04a44eb80e6a68efc0ec6c5
	 *
	 * @param array
	 * @return
	 */
	public long inversePairs(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int[] copy = new int[array.length];
		long count = inversePairsCore(array, copy, 0, array.length - 1);
		System.out.println(Arrays.toString(copy));
		return count;
	}

	private long inversePairsCore(int[] array, int[] copy, int low, int high) {
		if (low >= high) {
			copy[low] = array[low];
			return 0;
		}
		int mid = (low + high) >> 1;
		long leftCount = inversePairsCore(array, copy, low, mid);
		long rightCount = inversePairsCore(array, copy, mid + 1, high);
		long count = 0;
		// i初始化为前半段最后一个元素的下标
		int i = mid;
		// j初始化为后半段最后一个数字的下标
		int j = high;
		// 辅助数组的下标
		int indexCopy = high;
		// 归并两个数组时，统计逆序对
		while (i >= low && j >= mid + 1) {
			if (array[i] > array[j]) {
				count += j - mid;
				copy[indexCopy--] = array[i--];
				// 打印出逆序对
				// int temp = j;
				// for (; temp >= mid + 1; temp--) {
				// System.out.print(array[i + 1] + ">" + array[temp] + ",");
				// }
			} else {
				copy[indexCopy--] = array[j--];
			}
		}

		// 将左边的所有数归并到新数组
		for (; i >= low; i--) {
			copy[indexCopy--] = array[i];
		}
		// 将右边所有数归并到新数组
		for (; j >= mid + 1; j--) {
			copy[indexCopy--] = array[j];
		}
		// 将已经排好的copy数组的元素，复制会原数组，以便下次归并是，不混乱
		for (int s = low; s <= high; s++) {
			array[s] = copy[s];
		}
		return (leftCount + rightCount + count);
	}
}
