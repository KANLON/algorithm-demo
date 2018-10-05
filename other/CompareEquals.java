package com.kanlon.other;

import java.util.HashMap;

/**
 * �Ƚ����������е�����Ԫ���Ƿ���ȵ���򵥷�����ʱ�临�Ӷ���ͣ�
 *
 * @author zhangcanlong
 * @date 2018��9��28��
 */
public class CompareEquals {
	public static void main(String[] args) {
		// ��������
		// ��������1
		Integer[] ints11 = null;
		Integer[] ints12 = { 3 };
		// ��������2
		Integer[] ints21 = {};
		Integer[] ints22 = null;
		// //��������3
		Integer[] ints31 = {};
		Integer[] ints32 = {};
		// //��������4
		Integer[] ints41 = { 1 };
		Integer[] ints42 = { 3, 1 };
		// //��������5
		Integer[] ints51 = { 4 };
		Integer[] ints52 = { 4 };
		// //��������6
		Integer[] ints61 = { 1, 2, 434, 56, 8 };
		Integer[] ints62 = { 2, 1, 434, 8, 56 };

		CompareEquals compareTest = new CompareEquals();
		System.out.println("����1��" + compareTest.intIsEquals(ints11, ints12));
		System.out.println("����2��" + compareTest.intIsEquals(ints21, ints22));
		System.out.println("����3��" + compareTest.intIsEquals(ints31, ints32));
		System.out.println("����4��" + compareTest.intIsEquals(ints41, ints42));
		System.out.println("����5��" + compareTest.intIsEquals(ints51, ints52));
		System.out.println("����6��" + compareTest.intIsEquals(ints61, ints62));

		// ���Է���2
		System.out.println("����1��" + compareTest.isEquals(ints11, ints12));
		System.out.println("����2��" + compareTest.isEquals(ints21, ints22));
		System.out.println("����3��" + compareTest.isEquals(ints31, ints32));
		System.out.println("����4��" + compareTest.isEquals(ints41, ints42));
		System.out.println("����5��" + compareTest.isEquals(ints51, ints52));
		System.out.println("����6��" + compareTest.isEquals(ints61, ints62));

	}

	/**
	 * �Ƚ����������е�����Ԫ���Ƿ���ȣ�˼·��������1��Ԫ�ص�ֵ��Ϊkey����Hashmap�У����HashMap��û�и�Ԫ��key������key����Ӧ��value����Ϊ1�����Hashmap�����˸�key����key�е�ֵ��1.
	 * ���Ǳ����ڶ������飬�����HashMap��û������2��Ԫ�ص�key���򷵻�false�����������key����Ӧ��ֵ��1���������α�������������1����ȡHashMap��Ӧkey����Ӧ��ֵ�����ֵ��Ϊ0���򷵻�false
	 *
	 * @param obj1
	 *            Ҫ�Ƚϵ�����1
	 * @param obj2
	 *            Ҫ�Ƚϵ�����2
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
			// ���������1�в�������Ԫ�أ���ֱ�ӷ���false
			if (!map.containsKey(obj2[i].toString())) {
				return false;
			}
			Integer value = map.get(obj2[i].toString());
			map.put(obj2[i].toString(), --value);
		}

		// ���һ�α������鿴HashMap�����е�ֵ�Ƿ�Ϊ0
		for (int i = 0; i < obj1.length; i++) {
			Integer value = map.get(obj1[i].toString());
			if (value != 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * �Ƚ��������������Ƿ����
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
			// ���������2�в�������Ԫ�أ���ֱ�ӷ���false
			if (!map.containsKey(ints2[i])) {
				return false;
			}
			Integer value = map.get(ints2[i]);
			map.put(ints2[i], --value);
		}
		// ���һ�α������鿴HashMap�����е�ֵ�Ƿ�Ϊ0
		for (int i = 0; i < ints1.length; i++) {
			Integer value = map.get(ints1[i]);
			if (value != 0) {
				return false;
			}
		}

		return true;
	}
}
