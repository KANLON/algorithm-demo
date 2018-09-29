package com.kanlon.rotate;

/**
 * 旋转数组的最小数字
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1.
 *
 *
 * @author zhangcanlong
 * @date 2018年9月28日
 */
public class MinNumberInRotatedArray {
	public static void main(String[] args) {
		// 测试
		int[] ints1 = { 1, 2, 3, 4, 5 };
		int[] ints2 = { 3, 4, 5, 1, 2 };
		int[] ints3 = { 1, 1, 1, 4, 1, 1 };
		int[] ints4 = { 1, 0, 1, 1, 1 };
		int[] ints5 = { 1 };
		int[] ints6 = null;

		MinNumberInRotatedArray rotatedArray = new MinNumberInRotatedArray();
		// System.out.println(rotatedArray.findMinNum(ints1));
		// System.out.println(rotatedArray.findMinNum(ints2));
		// System.out.println(rotatedArray.findMinNum(ints3));
		System.out.println(rotatedArray.findMinNum(ints4));
		System.out.println(rotatedArray.findMinNum(ints5));
		System.out.println(rotatedArray.findMinNum(ints6));

	}

	/**
	 * 找出旋转数组中最小的数字.解题思路：利用类似二分查找的方法，定义两个指针分别指向头和尾，接着取两个指针与中间的元素比较。
	 * 如果中间的元素大于头指针，则将头指针指向中间元素。如果中间元素小于尾指针，则将尾指针指向中间元素。知道两个指针之间相差1，则第二个指针为最小元素。
	 * 需要考虑两个例外情况：1.没有翻转时。2.中间值与它们都相等时
	 *
	 * @param ints
	 */
	public int findMinNum(int[] ints) {
		if (ints == null || ints.length == 0) {
			throw new RuntimeException("输入的数组为null");
		}

		int index1 = 0;
		int index2 = ints.length - 1;
		int minValue = ints[index1];
		// 当没有翻转时
		if (ints[index2] > ints[index1]) {
			return minValue;
		}

		while (index2 - index1 > 1) {
			// 当三个相等时，则使用顺序遍历
			if (ints[index1] == ints[index2] && ints[index1] == ints[(index1 + index2) >> 1]) {
				for (int i = 0; i < ints.length; i++) {
					minValue = Math.min(minValue, ints[i]);
				}

				return minValue;
			}

			if (ints[(index1 + index2) >> 1] > ints[index1]) {
				index1 = (index1 + index2) >> 1;
			}
			if (ints[(index1 + index2) >> 1] < ints[index2]) {
				index2 = (index1 + index2) >> 1;
			}

		}
		minValue = ints[index2];
		// 当 1114 11
		// 1 0 111
		return minValue;
	}
}