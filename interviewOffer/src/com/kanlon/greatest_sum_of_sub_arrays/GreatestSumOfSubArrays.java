package com.kanlon.greatest_sum_of_sub_arrays;

/**
 * 面试题31：连续子数组的最大和。
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)
 *
 * @author zhangcanlong
 * @date 2019年1月27日
 */
public class GreatestSumOfSubArrays {

	public static void main(String[] args) {
		GreatestSumOfSubArrays test = new GreatestSumOfSubArrays();
		// 功能测试1 多个正数和负数，最大子数组大于0
		int[] ints1 = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println("功能测试1 多个数，最大子数组大于0：" + test.findGreatestSumOfSubArrays(ints1));
		System.out.println("功能测试1 多个数，最大子数组大于0：" + test.findGreatestSumOfSubArraysWithRecursive(ints1));

		// 功能测试2：全是负数
		int[] ints2 = { -3, -2, -3, -5 };
		System.out.println("功能测试2：全是负数：" + test.findGreatestSumOfSubArrays(ints2));
		System.out.println("功能测试2：全是负数：" + test.findGreatestSumOfSubArraysWithRecursive(ints2));
		// 功能测试3：全是正数
		int[] ints3 = { 1, 2, 4, 5 };
		System.out.println("功能测试3：全是正数：" + test.findGreatestSumOfSubArrays(ints3));
		System.out.println("功能测试3：全是正数：" + test.findGreatestSumOfSubArraysWithRecursive(ints3));

		// 功能测试4：只有一个数
		int[] ints4 = { 1 };
		System.out.println("功能测试4：只有一个数：" + test.findGreatestSumOfSubArrays(ints4));
		System.out.println("功能测试4：只有一个数：" + test.findGreatestSumOfSubArraysWithRecursive(ints4));

		// 特殊测试1：空
		System.out.println("特殊测试1：空，" + test.findGreatestSumOfSubArrays(null));
		System.out.println("特殊测试1：空，" + test.findGreatestSumOfSubArraysWithRecursive(null));

	}

	/**
	 * 找出子数组的和的最大值。
	 * <p>
	 * 解题思路1：(1)设置两个变量，一个保存当前遍历的子数组的和，一个保存最大值的子数组和。接着遍历数组。
	 * （2）当遍历到当前元素时，如果当前子数组和是小于等于0的，则将当前子数组和设置为当前元素，否则将当前元素加入到当前子数组和。
	 * （3）如果当前子数组和大于最大子数组和，则将最大子数组和设置为当前子数组和。
	 *
	 * @param ints
	 *            要查找的数组
	 * @return 返回最大值
	 */
	public Integer findGreatestSumOfSubArrays(int[] ints) {
		if (ints == null || ints.length <= 0) {
			throw new IllegalArgumentException("数组不能为空");
		}
		int currentSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < ints.length; i++) {
			if (currentSum <= 0) {
				currentSum = ints[i];
			} else {
				currentSum += ints[i];
			}
			if (currentSum > maxSum) {
				maxSum = currentSum;
			}
		}
		return maxSum;
	}

	/**
	 * 解题思路2:（使用动态规划，递归形式）(1)当以第i-1个数字结尾的子数组中所有数字的和小于0时，如果把这个负数与第i个数累加，得到的结果比第i个数字
	 * 本身还要小，所以这种情况下，以第i个数字结尾的子数组就是第i个数字本身。
	 * (2)如果第i-1个数字结尾的子数组中所有数字的和大于0，则与第i个数字累加就得到以第i数字结尾的子数组中所有数字的和
	 * （3）需要注意的是，每次返回前要先和最大子数组进行比较，如果大于最大子数组和，则将该值设置为最大子数组和
	 *
	 * @param ints
	 *            要查找的数组
	 * @return 返回最大的子数组和
	 */
	public Integer findGreatestSumOfSubArraysWithRecursive(int[] ints) {
		if (ints == null || ints.length <= 0) {
			throw new IllegalArgumentException("数组不能为空");
		}
		int[] maxSum = { Integer.MIN_VALUE };
		tempFind(ints, ints.length - 1, maxSum);
		return maxSum[0];
	}

	/**
	 * 辅助递归的方法
	 *
	 * @return
	 */
	private Integer tempFind(int[] ints, int lastIndex, int[] maxSum) {
		if (lastIndex == 0 || tempFind(ints, lastIndex - 1, maxSum) <= 0) {
			if (ints[lastIndex] > maxSum[0]) {
				maxSum[0] = ints[lastIndex];
			}
			return ints[lastIndex];
		} else {
			int tempMax = tempFind(ints, lastIndex - 1, maxSum) + ints[lastIndex];
			if (tempMax > maxSum[0]) {
				maxSum[0] = tempMax;
			}
			return tempMax;
		}
	}
}
