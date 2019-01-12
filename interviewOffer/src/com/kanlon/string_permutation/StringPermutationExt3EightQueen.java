package com.kanlon.string_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 拓展题目3(8皇后问题)：在8X8的国际象棋上摆放8个皇后，使其不能相互攻击，即任意两个皇后不得处在同一行、同一列或者同一对角线上。
 * 下图中的每个黑色格子表示一个皇后，这就是一种符合条件的摆放方法。请问总共有多少种符合条件的摆法？
 *
 *
 * @author zhangcanlong
 * @date 2019年1月12日
 */
public class StringPermutationExt3EightQueen {
	public static void main(String[] args) {
		StringPermutationExt3EightQueen test = new StringPermutationExt3EightQueen();
		System.out.println("摆法有：" + test.eightQueenSort() + "种");
	}

	/**
	 * 求8皇后的摆法种数。
	 * <p>
	 * 解题思路：用含有8个数字的数组{1,2,3,4,5,6,7,8}表示摆法，数组的索引值表示所在列数，数组中的数字值表示所在行数，则这样的摆法保证了不同行不同列了。
	 * 然后只要对数组进行全排序验证摆法是否在同一对角线上即可。即对于数组的两个下标i和j，是不是i-j=ColumnIndex[i]-columnIndex[j]或者j-i=columnIndex[i]-columnIndex[j]
	 *
	 * @return 返回符合条件的摆法数
	 */
	public Integer eightQueenSort() {
		// 表示摆法,从0开始更好判断
		// int[] columnIndex = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] columnIndex = { 0, 1, 2, 3, 4, 5, 6, 7 };
		List<int[]> list = new ArrayList<>();
		fullSort(columnIndex, 0, columnIndex.length - 1, list);
		System.out.println(Arrays.toString(list.get(0)));
		return list.size();
	}

	/**
	 * 数组的全排序
	 *
	 * @param ints
	 * @param start
	 * @param end
	 * @param list
	 *            存放数组全排序的结果
	 */
	public void fullSort(int[] ints, int start, int end, List<int[]> list) {
		if (ints == null || ints.length <= 0) {
			return;
		}
		if (start >= end) {
			// 判断是否符合在同一对角线，不是才添加
			if (!isRight(ints)) {
				int[] tempInts = Arrays.copyOf(ints, ints.length);
				list.add(tempInts);
			}
			return;
		}

		for (int i = start; i <= end; i++) {
			int temp = ints[i];
			ints[i] = ints[start];
			ints[start] = temp;

			fullSort(ints, start + 1, end, list);

			// 还原
			ints[start] = ints[i];
			ints[i] = temp;
		}

	}

	/**
	 * 判断数组的摆法是否在同一对角线
	 *
	 * @param ints
	 *            需要判断的数组
	 * @return
	 */
	public Boolean isRight(int[] ints) {
		boolean flag = false;
		for (int i = 0; i < ints.length - 1; i++) {
			for (int j = i + 1; j < ints.length; j++) {
				if (i - j == ints[i] - ints[j] || j - i == ints[i] - ints[j]) {
					flag = true;
				}
			}
		}
		return flag;
	}
}
