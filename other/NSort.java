package other.nsort;

import java.util.Arrays;

/**
 * 题目：实现一个排序算法，要求时间效率O(n).对公司所有员工的年龄排序，公司总共有几万名员工。可以用辅助空间，只允许使用常量大小辅助空间，不得超过O(n)。
 *
 * @author zhangcanlong
 * @date 2019年2月11日
 */
public class NSort {
	public static void main(String[] args) {
		NSort test = new NSort();
		// 功能测试1（多个年龄，有相同，有不同）
		int[] ints1 = { 12, 42, 23, 12, 23, 12 };
		test.nsort(ints1);
		System.out.println("功能测试1（多个年龄，有相同，有不同）：" + Arrays.toString(ints1));
		// 功能测试2（多个年龄，全部相同）
		int[] ints2 = { 12, 12, 12, 12, 12, 12 };
		test.nsort(ints2);
		System.out.println("功能测试2（多个年龄，全部相同）：" + Arrays.toString(ints2));
		// 功能测试3（只有一个年龄）
		int[] ints3 = { 12 };
		test.nsort(ints3);
		System.out.println("功能测试3（只有一个年龄）：" + Arrays.toString(ints3));
		// 特殊测试1（null）
		test.nsort(null);
	}

	/**
	 * 解题思路（空间换时间）：由于是要对员工年龄排序，因此数字的大小限制在0~100之间，所以使用大小为100的数组来辅助排序，下标表示年龄，值表示该年龄出现的次数，最后遍历该数组元素，值是多少，打印多少次就可以了
	 *
	 * @param ints
	 */
	public void nsort(int[] ints) {
		if (ints == null || ints.length <= 0) {
			return;
		}
		// 辅助数组
		int[] temp = new int[100];
		for (int i = 0; i < ints.length; i++) {
			temp[ints[i]]++;
		}

		int index = 0;
		for (int i = 0; i < temp.length; i++) {
			while (temp[i] != 0) {
				ints[index++] = i;
				temp[i]--;
			}
		}
	}
}
