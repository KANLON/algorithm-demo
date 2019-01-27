package com.kanlon.more_than_half_number;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题29：数组中出现次数超过一半的数字
 *
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字，例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过了数组长度的一半，因此输出2.
 *
 *
 * @author zhangcanlong
 * @date 2019年1月16日
 */
public class MoreThanHalfNumber {
	public static void main(String[] args) {
		MoreThanHalfNumber test = new MoreThanHalfNumber();
		// 功能测试1（有多个元素，且有一个元素次数超过半数）
		int[] numbers1 = { 1, 2, 4, 43, 2, 2, 2 };
		System.out.println(test.findMoreThanHalfNum1(numbers1, numbers1.length));
		System.out.println(test.findMoreThanHalfNum2(numbers1));
		System.out.println(test.findMoreThanHalfNum3(numbers1));
		// 功能测试2（有多个元素，且有一个元素次数等于半数）
		int[] numbers2 = { 1, 2, 4, 43, 2, 3, 2 };
		System.out.println(test.findMoreThanHalfNum1(numbers2, numbers2.length));
		System.out.println(test.findMoreThanHalfNum2(numbers2));
		System.out.println(test.findMoreThanHalfNum3(numbers2));
		// 功能测试3（有多个元素，且有一个元素次数小于半数）
		int[] numbers3 = { 1, 2, 4, 43, 2, 4, 5 };
		System.out.println(test.findMoreThanHalfNum1(numbers3, numbers3.length));
		System.out.println(test.findMoreThanHalfNum2(numbers3));
		System.out.println(test.findMoreThanHalfNum3(numbers3));

		// 功能测试4（只有1个元素）
		int[] numbers4 = { 1 };
		System.out.println(test.findMoreThanHalfNum1(numbers4, numbers4.length));
		System.out.println(test.findMoreThanHalfNum2(numbers4));
		System.out.println(test.findMoreThanHalfNum3(numbers4));
		// 功能测试5（null）
		System.out.println(test.findMoreThanHalfNum1(null, 0));
		System.out.println(test.findMoreThanHalfNum2(null));
		System.out.println(test.findMoreThanHalfNum3(null));
	}

	/**
	 * 解题思路1（快速排序的思路）：(1)在随机快速排序的算法中，我们先在数组中随机选择一个数字，然后调整数组中数字的顺序，使得比选中的数字小于数字都排在它的左边，比选中的数字大的数字都排在它的右边。
	 * <p>
	 * (2)如果这个选中的数字的下标刚好是n/2,那么这个数字就是数组的中位数。如果他的下标大于n/2，那么中位数应该位于它的左边，我们可以接着在它的左边部分的数组中查找。
	 * <p>
	 * (3)如果它的下标小于n/2,那么中位数应该位于它的右边部分的数组中查找。这是一个典型的递归过程。
	 *
	 * @return 如果有则返回该数下标，没有则返回null
	 */
	public Integer findMoreThanHalfNum1(int[] numbers, int length) {
		// 检查参数
		if (numbers == null || length <= 0) {
			return null;
		}

		int middle = length >> 1;
		int start = 0;
		int end = length - 1;
		int index = partition(numbers, length, start, end);
		while (index != middle) {
			if (index > middle) {
				end = index - 1;
				index = partition(numbers, length, start, end);
			} else {
				start = index + 1;
				index = partition(numbers, length, start, end);
			}
		}
		int result = numbers[middle];
		// 检查结果是否符合
		int times = 0;
		for (int i = 0; i < length; ++i) {
			if (numbers[i] == result) {
				times++;
			}
		}
		if (times * 2 <= length) {
			return null;
		}

		return result;
	}

	/**
	 * 解题思路2（数字自增自减）：（1）数组中有一个数字出现的次数超过数组长度的一半，说明它是数组中出现次数最多的数字。我们可以使用一个变量来保存当前数字，一个变量来保存次数。
	 * (2)当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，次数+1，如果不同，则次数减一。如果次数为0，我们需要保存下一个数字，并把次数设为1。
	 * (3)由于我们要找的数字出现次数比其他所有数字之和还要多的，那么要找的数字肯定是最后一次把次数设为1时对应的数字。
	 *
	 * @return
	 */
	public Integer findMoreThanHalfNum2(int[] numbers) {
		if (numbers == null || numbers.length <= 0) {
			return null;
		}
		int currentNum = numbers[0];
		int times = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (times == 0) {
				times = 1;
				currentNum = numbers[i];
				continue;
			}
			if (currentNum == numbers[i]) {
				times++;
			} else {
				times--;
			}

		}
		if (times <= 0) {
			return null;
		}
		// 检查结果是否符合
		int count = 0;
		for (int i = 0; i < numbers.length; ++i) {
			if (numbers[i] == currentNum) {
				count++;
			}
		}
		if (count * 2 <= numbers.length) {
			return null;
		}

		return currentNum;
	}

	/**
	 * 解题思路3（使用HashMap(推荐，较通用),时间复杂度O(n)）：（1）使用HashMap中的key存储出现的数字，value存储该数字出现的次数。
	 * （2）遍历数组，如果不存在该key则，存入key，value设置为1，如果存在该key，则value++；
	 * （3）最后将获取所有key，遍历value，找出最大的value值，对应的key则是出现次数的最多的数字。
	 *
	 * @return
	 */
	public Integer findMoreThanHalfNum3(int[] numbers) {
		if (numbers == null || numbers.length <= 0) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				map.put(numbers[i], map.get(numbers[i]) + 1);
			} else {
				map.put(numbers[i], 1);
			}
		}
		// 遍历所有key
		Integer maxValueKey = null;
		int maxValue = 0;
		for (Integer key : map.keySet()) {
			if (map.get(key) > maxValue) {
				maxValueKey = key;
				maxValue = map.get(key);
			}
		}
		// 检查出现次数是否大于数组长度的一半
		if (maxValue * 2 <= numbers.length) {
			maxValueKey = null;
		}
		return maxValueKey;
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
