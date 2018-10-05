package com.kanlon.other;

import java.util.HashMap;

/**
 * 比较两个数组中的所有元素是否相等的最简单方法（时间复杂度最低）
 *
 * @author zhangcanlong
 * @date 2018年9月28日
 */
public class CompareEquals {
	public static void main(String[] args) {
		// 测试用例
		// 测试用例1
		Integer[] ints11 = null;
		Integer[] ints12 = { 3 };
		// 测试用例2
		Integer[] ints21 = {};
		Integer[] ints22 = null;
		// //测试用例3
		Integer[] ints31 = {};
		Integer[] ints32 = {};
		// //测试用例4
		Integer[] ints41 = { 1 };
		Integer[] ints42 = { 3, 1 };
		// //测试用例5
		Integer[] ints51 = { 4 };
		Integer[] ints52 = { 4 };
		// //测试用例6
		Integer[] ints61 = { 1, 2, 434, 56, 8 };
		Integer[] ints62 = { 2, 1, 434, 8, 56 };

		CompareEquals compareTest = new CompareEquals();
		System.out.println("测试1：" + compareTest.intIsEquals(ints11, ints12));
		System.out.println("测试2：" + compareTest.intIsEquals(ints21, ints22));
		System.out.println("测试3：" + compareTest.intIsEquals(ints31, ints32));
		System.out.println("测试4：" + compareTest.intIsEquals(ints41, ints42));
		System.out.println("测试5：" + compareTest.intIsEquals(ints51, ints52));
		System.out.println("测试6：" + compareTest.intIsEquals(ints61, ints62));

		// 测试方法2
		System.out.println("测试1：" + compareTest.isEquals(ints11, ints12));
		System.out.println("测试2：" + compareTest.isEquals(ints21, ints22));
		System.out.println("测试3：" + compareTest.isEquals(ints31, ints32));
		System.out.println("测试4：" + compareTest.isEquals(ints41, ints42));
		System.out.println("测试5：" + compareTest.isEquals(ints51, ints52));
		System.out.println("测试6：" + compareTest.isEquals(ints61, ints62));

	}

	/**
	 * 比较两个数组中的所有元素是否相等，思路：将数组1的元素的值作为key存入Hashmap中，如果HashMap中没有该元素key，则将其key所对应的value设置为1，如果Hashmap中有了该key，则将key中的值加1.
	 * 这是遍历第二个数组，如果在HashMap中没有数组2中元素的key，则返回false，如果有则将其key所对应的值减1。最后第三次遍历，遍历数组1，获取HashMap对应key所对应的值，如果值不为0，则返回false
	 *
	 * @param obj1
	 *            要比较的数组1
	 * @param obj2
	 *            要比较的数组2
	 * @return
	 */
	public boolean isEquals(Object[] obj1, Object[] obj2) {
		if (obj1 == null && obj2 == null) {
			return true;
		}
		if (obj1 == null && (obj2 != null && obj2.length == 0)) {
			return true;
		}
		if (obj2 == null && (obj1 != null && obj1.length == 0)) {
			return true;
		}
		if ((obj1 == null || obj2 == null) || obj1.length != obj2.length) {
			return false;
		}
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < obj1.length; i++) {
			if (map.containsKey(obj1[i].toString())) {
				Integer value = map.get(obj1[i]);
				map.put(obj1[i].toString(), ++value);
			} else {
				map.put(obj1[i].toString(), 1);
			}
		}

		for (int i = 0; i < obj2.length; i++) {
			// 如果在数组1中不包含该元素，则直接返回false
			if (!map.containsKey(obj2[i].toString())) {
				return false;
			}
			Integer value = map.get(obj2[i].toString());
			map.put(obj2[i].toString(), --value);
		}

		// 最后一次遍历，查看HashMap中所有的值是否为0
		for (int i = 0; i < obj1.length; i++) {
			Integer value = map.get(obj1[i].toString());
			if (value != 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 比较两个整数数组是否相等
	 *
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public boolean intIsEquals(Integer[] ints1, Integer[] ints2) {
		if (ints1 == null && ints2 == null) {
			return true;
		}
		if (ints1 == null && (ints2 != null && ints2.length == 0)) {
			return true;
		}
		if (ints2 == null && (ints1 != null && ints1.length == 0)) {
			return true;
		}
		if ((ints1 == null || ints2 == null) || ints1.length != ints2.length) {
			return false;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < ints1.length; i++) {
			if (map.containsKey(ints1[i])) {
				Integer value = map.get(ints1[i]);
				map.put(ints1[i], ++value);
			} else {
				map.put(ints1[i], 1);
			}
		}

		for (int i = 0; i < ints2.length; i++) {
			// 如果在数组2中不包含该元素，则直接返回false
			if (!map.containsKey(ints2[i])) {
				return false;
			}
			Integer value = map.get(ints2[i]);
			map.put(ints2[i], --value);
		}
		// 最后一次遍历，查看HashMap中所有的值是否为0
		for (int i = 0; i < ints1.length; i++) {
			Integer value = map.get(ints1[i]);
			if (value != 0) {
				return false;
			}
		}

		return true;
	}
}
