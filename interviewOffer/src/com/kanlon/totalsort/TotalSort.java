package com.kanlon.totalsort;

import java.util.ArrayList;
import java.util.List;

/**
 * ȫ����ķ����ġ���Ŀ����{a,b,c}����ȫ����Ҫ�����ȫ����Ľ��
 *
 * @author zhangcanlong
 * @date 2018��10��7��
 */
public class TotalSort {

	/**
	 * �������ȫ����Ľ����
	 */
	private static List<String> list = new ArrayList<>();

	public static void main(String[] args) {
		// �����ַ������ȫ����
		TotalSort test = new TotalSort();
		char[] arrays = "abc".toCharArray();
		test.totalSort(arrays, 0, arrays.length - 1);
		// ����ͨ��ȫ����
		Character[] chars = { '1', '2', '3' };
		test.totalSortObjects(chars, 0, arrays.length - 1);
		System.out.println("ͨ�õ�ȫ����" + list);
	}

	/**
	 * ����˼·�����õݹ鷽�����ã���ԭ����Ҫ����ĵ�һ��Ԫ����ÿ��Ԫ�ؽ��н�����Ȼ��ݹ���ø÷����������Ԫ�ص�����Ԫ�أ���ֻҪ���������
	 * ��һ��Ԫ��ʱ��ֻ��һ������ʽ��ֱ����������顣
	 *
	 * @param arrays
	 *            Ҫ���������
	 * @param start
	 *            Ҫ����Ŀ�ʼԪ�ص��±�
	 * @param end
	 *            Ҫ����Ľ���Ԫ�ص��±�
	 */
	public void totalSortObjects(Object[] arrays, int start, int end) {
		if (start == end) {
			StringBuffer tempBuffer = new StringBuffer();
			for (int i = 0; i <= end; i++) {
				tempBuffer.append(arrays[i]);
			}
			list.add(tempBuffer.toString());
		} else {
			for (int i = start; i <= end; i++) {
				swap(arrays, start, i);
				totalSortObjects(arrays, start + 1, end);
				// ��ԭԭ���飬��֤��һ��Ԫ���ܺ������ÿ��Ԫ�ض�����
				swap(arrays, start, i);
			}
		}

	}

	/**
	 * �������������Ԫ�أ���ͨ�ã�
	 *
	 * @param arrs
	 *            Ҫ����������
	 * @param a
	 *            Ҫ������Ԫ�ص��±�1
	 * @param b
	 *            Ҫ������Ԫ�ص��±�2
	 */
	private void swap(Object[] arrs, int a, int b) {
		Object temp = arrs[a];
		arrs[a] = arrs[b];
		arrs[b] = temp;
	}

	/**
	 * ����˼·�����õݹ鷽�����ã���ԭ����Ҫ����ĵ�һ��Ԫ����ÿ��Ԫ�ؽ��н�����Ȼ��ݹ���ø÷����������Ԫ�ص�����Ԫ�أ���ֻҪ���������
	 * ��һ��Ԫ��ʱ��ֻ��һ������ʽ��ֱ����������顣
	 *
	 * @param arrays
	 *            Ҫ���������
	 * @param start
	 *            Ҫ����Ŀ�ʼԪ�ص��±�
	 * @param end
	 *            Ҫ����Ľ���Ԫ�ص��±�
	 */
	public void totalSort(char[] arrays, int start, int end) {
		if (start == end) {
			for (int i = 0; i <= end; i++) {
				System.out.print(arrays[i]);
			}
			// �������
			System.out.println();
		} else {
			for (int i = start; i <= end; i++) {
				swap(arrays, start, i);
				totalSort(arrays, start + 1, end);
				// ��ԭԭ���飬��֤��һ��Ԫ���ܺ������ÿ��Ԫ�ض�����
				swap(arrays, start, i);
			}
		}

	}

	/**
	 * �������������Ԫ��
	 *
	 * @param arrays
	 *            Ҫ����������
	 * @param start
	 *            Ҫ������Ԫ���±�1
	 * @param i
	 *            Ҫ������Ԫ���±�2
	 */
	private void swap(char[] arrays, int start, int i) {
		char temp = arrays[start];
		arrays[start] = arrays[i];
		arrays[i] = temp;
	}

}
