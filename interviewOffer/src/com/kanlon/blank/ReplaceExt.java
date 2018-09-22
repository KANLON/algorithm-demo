package com.kanlon.blank;

/**
 * ��չ�����������������A1��A2���ڴ���A1��ĩβ���㹻��Ŀ���ռ�����A2����ʵ��һ����������A2�е��������ֲ��뵽A1�в����������ֶ�������ġ�
 *
 * @author zhangcanlong
 * @date 2018��9��22��
 */
public class ReplaceExt {

	public static void main(String[] args) {
		// ����
		int[] ints1 = { 1, 3, 5, 7, 9, 0, 0, 0, 0, 0 };
		int[] ints2 = {};
		ReplaceExt replace = new ReplaceExt();
		ints1 = replace.mergeArray(ints1, 5, ints2, 0);

		for (int i = 0; i < ints1.length; i++) {
			System.out.print(ints1[i] + " ");
		}
	}

	/**
	 * ˼·����ĩβ��ʼ�Ƚ����������Ԫ�صĴ�С������ķŵ����һ��Ԫ���У�������1������2��Ԫ���Ѿ��Ƚ��꣬������һ������Ԫ��ȫ�����Ƶ�����1ǰ��
	 *
	 * @param arr1
	 *            Ҫ�ϲ�������1
	 * @param arr2
	 *            Ҫ�ϲ�������2
	 * @param num1
	 *            ����1 �ڵ�Ԫ�ظ���
	 * @param num2
	 *            ����2�ڵ�Ԫ�ظ���
	 * @return
	 */
	public int[] mergeArray(int[] arr1, int num1, int[] arr2, int num2) {
		if (arr1 == null || arr2 == null || arr2.length == 0) {
			return arr1;
		}
		// �������1�������㹻���Ԫ�أ�������һ���µ��㹻�������飬�������1
		if (arr1.length < num1 + num2) {
			int[] newInts = new int[num1 + num2];
			System.arraycopy(arr1, 0, newInts, 0, num1);
			arr1 = newInts;
		}
		int index1 = num1 - 1;
		int index2 = num2 - 1;
		// �ϲ���������
		while (index1 >= 0 && index2 >= 0) {
			if (arr1[index1] > arr2[index2]) {
				arr1[index1 + index2 + 1] = arr1[index1];
				index1--;
			} else {
				arr1[index1 + index2 + 1] = arr2[index2];
				index2--;
			}
		}
		// ���arr2����Ԫ��
		if (index1 < 0 && index2 >= 0) {
			System.arraycopy(arr2, 0, arr1, 0, index2 + 1);
		}
		return arr1;
	}

}
