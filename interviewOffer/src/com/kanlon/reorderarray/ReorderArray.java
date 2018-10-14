package com.kanlon.reorderarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ������14����������˳��ʹ����λ��ż��ǰ��
 * <p>
 * ��Ŀ������һ���������飬ʵ��һ�������������������е����ֵ�˳��ʹ����������λ�������ǰ�벿�֣�����ż��λ������ĺ�벿�֡�
 *
 * @author zhangcanlong
 * @date 2018��10��14��
 */
public class ReorderArray {

	public static void main(String[] args) {

		ReorderArray test = new ReorderArray();
		// ����
		// ����1 ������ż���������
		int[] ints1 = { 1, 2, 3, 4, 5, 6, 7 };
		// ����2 ��������ż��������������ǰ��
		int[] ints2 = { 6, 4, 2, 1, 3, 5, 7 };
		// ����3 ������������������ż��ǰ
		int[] ints3 = { 1, 3, 5, 7, 6, 4, 2 };
		// ����4 ����ֻ������
		int[] ints4 = { 1, 3, 5, 7 };
		// ����5 ����ֻ��ż��
		int[] ints5 = { 6, 4, 2 };
		// ����6 ����nullָ��
		int[] ints6 = null;
		// ����7 ����ֻ����һ������
		int[] ints7 = { 3 };

		List<int[]> list = new ArrayList<>();
		list.add(ints1);
		list.add(ints2);
		list.add(ints3);
		list.add(ints4);
		list.add(ints5);
		list.add(ints6);
		list.add(ints7);

		// test.reorderArray(ints1);
		for (int i = 0; i < list.size(); i++) {
			test.reorderArray(list.get(i));
			System.out.println(Arrays.toString(list.get(i)));
		}
	}

	/**
	 * ����˼·1:��������ָ�룬һ����0��ʼ++��һ����length-1��ǰ--������һ��ָ������ż�����뿪ʼ�ڶ���ָ��Ҳ��ʼ����ƶ���ֱ���ƶ�������������Ȼ�󽻻�����ָ������Ӧ��Ԫ�أ�����ѭ����ֱ����һ��ָ�벻��С�ڵڶ���ָ��
	 *
	 * @param datas
	 *            Ҫ�����������
	 */
	public void reorderArray(int[] datas) {
		if (datas == null || datas.length == 0) {
			return;
		}
		int index1 = 0;
		int index2 = datas.length - 1;
		int length = datas.length;
		while (index1 < index2) {
			// ��ָ��1����ż��
			if (datas[index1] % 2 == 0) {
				// ֱ��datas��index2����ż����index1С��index2��ֵ,�����
				while (datas[index2] % 2 == 0 && index1 < index2) {
					index2--;
				}
				// ��������ָ������Ӧ��Ԫ�ص�ֵ
				if (index1 < index2) {
					datas[index1] = datas[index1] ^ datas[index2];
					datas[index2] = datas[index1] ^ datas[index2];
					datas[index1] = datas[index1] ^ datas[index2];
					++index1;
					--index2;
				}
				// û������ż���������++
			} else {
				++index1;
			}
		}
	}

	/**
	 * ����˼·2���Ƽ�������չ�Եģ���ɱoffer���������Ŀ�ĳ����и������ڷǸ�����ǰ����ߣ��ܱ�3�����������ڲ��ܱ�3����������ǰ�档
	 * ��ʱ��������ڶ��ǽ������Ϊ�����֣����Խ��жϲ��ַ���������������ǰ������true������Ǻ��������false
	 *
	 * @param datas
	 *            Ҫ���������
	 */
	public void reorderArray2(int[] datas) {
		if (datas == null || datas.length == 0) {
			return;
		}
		int index1 = 0;
		int index2 = datas.length - 1;
		while (index1 < index2) {
			// ���������ǰ��ģ���index1++
			while (index1 < index2 && isBeginOrEnd(datas[index1])) {
				index1++;
			}
			// ��������Ǻ���ģ���index2--
			while (index1 < index2 && !isBeginOrEnd(datas[index2])) {
				index2--;
			}
			// ����������
			if (index1 < index2) {
				datas[index1] = datas[index1] ^ datas[index2];
				datas[index2] = datas[index1] ^ datas[index2];
				datas[index1] = datas[index1] ^ datas[index2];
			}
		}
	}

	/**
	 * �ж�ĳ������Ӧ�����������ǰ�滹�Ǻ���
	 *
	 * @param n
	 *            Ҫ�жϵ�����
	 * @return true�����ʾ����Ӧ������ǰ��ģ������false���ʾ����Ӧ�����ں����
	 */
	public boolean isBeginOrEnd(int n) {
		// ������������ǰ�棬ż���ں���Ϊ��
		return (n & 1) == 1;
	}
}
