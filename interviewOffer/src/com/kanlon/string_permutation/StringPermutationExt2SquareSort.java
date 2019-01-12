package com.kanlon.string_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 拓展题目2：输入一个含有8个数字的数组，判断有没有可能把这8个数字分别放到正方体的8个顶点上（如下图所示），使得正方体上三组相对的面上的4个顶点的和都相等。
 *
 * @author zhangcanlong
 * @date 2019年1月12日
 */
public class StringPermutationExt2SquareSort {
	public static void main(String[] args) {
		// 测试
		StringPermutationExt2SquareSort test = new StringPermutationExt2SquareSort();
		// 功能测试1（数组满足）
		int[] ints1 = { 1, 1, 9, 10, 9, 10, 1, 1 };
		test.sortSquare(ints1);
		// 功能测试2 （数组不满足）
		int[] ints2 = { 1, 1, 1, 1, 1, 1, 1, 2 };
		test.sortSquare(ints2);

		// 测试全排序方法
		int[] test1 = { 1, 2, 3 };
		List<int[]> list = new ArrayList<>();
		// test.fullSortNum(test1, 0, 2, list);
		System.out.println("测试全排序");
		if (list != null) {
			for (int[] ints : list) {
				System.out.println(Arrays.toString(ints));
			}
		}
	}

	/**
	 * 判断含8个数字的数组是否满足正方体，上三组相对的面上的4个顶点的和都相等
	 * <p>
	 * 解题思路：求8个数字的全排序，满足a1+a2+a3+a4=a5+a6+a7+a8,a2+a3+a6+a7=a1+a4+a5+a8,a1+a2+a5+a6=a4+a3+a7+a8
	 *
	 * @param ints
	 *            要判断的数组
	 * @return 满足返回true，不满足返回false
	 */
	public Boolean sortSquare(int[] ints) {
		boolean flag = false;
		if (ints == null || ints.length != 8) {
			return false;
		}
		// 存放全排序的结果
		List<int[]> list = new ArrayList<>();
		fullSortNum(ints, 0, ints.length - 1, list);
		for (int i = 0; i < list.size(); i++) {
			// 判断是否满足对面和相等
			int[] sInts = list.get(i);
			boolean equalsFlag1 = sInts[0] + sInts[1] + sInts[2] + sInts[3] == sInts[4] + sInts[5] + sInts[6]
					+ sInts[7];
			boolean equalsFlag2 = sInts[1] + sInts[2] + sInts[5] + sInts[6] == sInts[0] + sInts[3] + sInts[4]
					+ sInts[7];
			boolean equalsFlag3 = sInts[0] + sInts[1] + sInts[4] + sInts[5] == sInts[3] + sInts[2] + sInts[6]
					+ sInts[7];
			if (equalsFlag1 && equalsFlag2 && equalsFlag3) {
				flag = true;
				System.out.println(Arrays.toString(sInts));
				break;
			}
		}
		return flag;
	}

	/**
	 * 数组的全排序的方法
	 *
	 * @param ints
	 * @param start
	 * @param end
	 * @param list
	 */
	public void fullSortNum(int[] ints, int start, int end, List<int[]> list) {
		if (ints == null || ints.length <= 0) {
			return;
		}
		if (start >= end) {
			// 在这里创建一个新的数组去复制是为了顺序加入到list中，因为java是值传递，如果不创建一个新的数组传进入的话，则list都保留原来数组的引用地址，则存放的数组的值没有变化
			// 以后需要详细研究一下
			// TODO
			int[] tempInts = Arrays.copyOf(ints, ints.length);
			list.add(tempInts);
			return;
		}
		// 交换首位元素
		for (int i = start; i <= end; i++) {
			int temp = ints[i];
			ints[i] = ints[start];
			ints[start] = temp;

			fullSortNum(ints, start + 1, end, list);
			// 还原
			ints[start] = ints[i];
			ints[i] = temp;
		}
	}

}
