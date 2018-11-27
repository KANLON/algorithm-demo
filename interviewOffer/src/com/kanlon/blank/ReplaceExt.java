package com.kanlon.blank;

/**
 * 扩展：有两个排序的数组A1和A2，内存在A1的末尾有足够多的空余空间容纳A2。请实现一个函数，把A2中的所有数字插入到A1中并且所有数字都是排序的。
 *
 * @author zhangcanlong
 * @date 2018年9月22日
 */
public class ReplaceExt {

	public static void main(String[] args) {
		// 测试
		int[] ints1 = { 1, 3, 5, 7, 9, 0, 0, 0, 0, 0 };
		int[] ints2 = {};
		ReplaceExt replace = new ReplaceExt();
		ints1 = replace.mergeArray(ints1, 5, ints2, 0);

		for (int i = 0; i < ints1.length; i++) {
			System.out.print(ints1[i] + " ");
		}
	}

	/**
	 * 思路：从末尾开始比较两个数组的元素的大小，将大的放到最后一个元素中，当数组1或数组2的元素已经比较完，将另外一个数组元素全部复制到数组1前。
	 *
	 * @param arr1
	 *            要合并的数组1
	 * @param arr2
	 *            要合并的数组2
	 * @param num1
	 *            数组1 内的元素个数
	 * @param num2
	 *            数组2内的元素个数
	 * @return
	 */
	public int[] mergeArray(int[] arr1, int num1, int[] arr2, int num2) {
		if (arr1 == null || arr2 == null || arr2.length == 0) {
			return arr1;
		}
		// 如果数组1不包含足够多的元素，将创建一个新的足够长的数组，替代数组1
		if (arr1.length < num1 + num2) {
			int[] newInts = new int[num1 + num2];
			System.arraycopy(arr1, 0, newInts, 0, num1);
			arr1 = newInts;
		}
		int index1 = num1 - 1;
		int index2 = num2 - 1;
		// 合并两个数组
		while (index1 >= 0 && index2 >= 0) {
			if (arr1[index1] > arr2[index2]) {
				arr1[index1 + index2 + 1] = arr1[index1];
				index1--;
			} else {
				arr1[index1 + index2 + 1] = arr2[index2];
				index2--;
			}
		}
		// 如果arr2还有元素
		if (index1 < 0 && index2 >= 0) {
			System.arraycopy(arr2, 0, arr1, 0, index2 + 1);
		}
		return arr1;
	}

}