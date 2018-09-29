package com.kanlon.rotate;

/**
 * ��ת�������С����
 * ��Ŀ����һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת������һ����������������һ����ת�������ת�������СԪ�ء���������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1.
 *
 *
 * @author zhangcanlong
 * @date 2018��9��28��
 */
public class MinNumberInRotatedArray {
	public static void main(String[] args) {
		// ����
		int[] ints1 = { 1, 2, 3, 4, 5 };
		int[] ints2 = { 3, 4, 5, 1, 2 };
		int[] ints3 = { 1, 1, 1, 4, 1, 1 };
		int[] ints4 = { 1, 0, 1, 1, 1 };
		int[] ints5 = { 1 };
		int[] ints6 = null;

		MinNumberInRotatedArray rotatedArray = new MinNumberInRotatedArray();
		// System.out.println(rotatedArray.findMinNum(ints1));
		// System.out.println(rotatedArray.findMinNum(ints2));
		// System.out.println(rotatedArray.findMinNum(ints3));
		System.out.println(rotatedArray.findMinNum(ints4));
		System.out.println(rotatedArray.findMinNum(ints5));
		System.out.println(rotatedArray.findMinNum(ints6));

	}

	/**
	 * �ҳ���ת��������С������.����˼·���������ƶ��ֲ��ҵķ�������������ָ��ֱ�ָ��ͷ��β������ȡ����ָ�����м��Ԫ�رȽϡ�
	 * ����м��Ԫ�ش���ͷָ�룬��ͷָ��ָ���м�Ԫ�ء�����м�Ԫ��С��βָ�룬��βָ��ָ���м�Ԫ�ء�֪������ָ��֮�����1����ڶ���ָ��Ϊ��СԪ�ء�
	 * ��Ҫ�����������������1.û�з�תʱ��2.�м�ֵ�����Ƕ����ʱ
	 *
	 * @param ints
	 */
	public int findMinNum(int[] ints) {
		if (ints == null || ints.length == 0) {
			throw new RuntimeException("���������Ϊnull");
		}

		int index1 = 0;
		int index2 = ints.length - 1;
		int minValue = ints[index1];
		// ��û�з�תʱ
		if (ints[index2] > ints[index1]) {
			return minValue;
		}

		while (index2 - index1 > 1) {
			// ���������ʱ����ʹ��˳�����
			if (ints[index1] == ints[index2] && ints[index1] == ints[(index1 + index2) >> 1]) {
				for (int i = 0; i < ints.length; i++) {
					minValue = Math.min(minValue, ints[i]);
				}

				return minValue;
			}

			if (ints[(index1 + index2) >> 1] > ints[index1]) {
				index1 = (index1 + index2) >> 1;
			}
			if (ints[(index1 + index2) >> 1] < ints[index2]) {
				index2 = (index1 + index2) >> 1;
			}

		}
		minValue = ints[index2];
		// �� 1114 11
		// 1 0 111
		return minValue;
	}
}