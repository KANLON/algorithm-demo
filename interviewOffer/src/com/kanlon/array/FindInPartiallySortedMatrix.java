package com.kanlon.array;

/**
 * ��Ŀ����һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * <p>
 * ��������Ķ�ά�������ÿ�С�ÿ�ж����������������������в�������7���򷵻�true�������������5���������鲻���и����֣��򷵻�false��
 * <p>
 * 1 2 8 9
 * <p>
 * 2 4 9 12
 * <p>
 * 4 7 10 13
 * <p>
 * 6 8 11 15
 * <p>
 * ����˼·���ӽ��俪ʼ���ң�����ѡȡ���������Ͻǵ����֡���������ֵ���Ҫ���ҵ����֣����ҹ��̽�������������ִ���Ҫ���ҵ����֣��޳�����������ڵ��У����������С��Ҫ���ҵ����֣��޳�����������ڵ��С�
 *
 * @author zhangcanlong
 * @date 2018��9��21��
 */
public class FindInPartiallySortedMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		FindInPartiallySortedMatrix findDemo = new FindInPartiallySortedMatrix();
		boolean flag = findDemo.find(matrix, 4, 4, 12);
		System.out.println(flag);
	}

	/**
	 * ���ҵĶ�ά�����е�ĳԪ ��
	 *
	 * @param matrix
	 *            ��ά����
	 * @param rows
	 *            ��ά���������
	 * @param columns
	 *            ��ά���������
	 * @param number
	 *            Ҫ���ҵ�Ԫ��
	 * @return
	 */
	public Boolean find(int[][] matrix, int rows, int columns, int number) {
		// �����ʼ�Ƿ��ҵ���ע
		Boolean found = false;

		// �����������
		if (matrix != null && rows > 0 && columns > 0) {
			int row = 0;
			int column = columns - 1;
			// ����û�в�����
			while (row < rows && column >= 0) {
				// ������и��е����ֵ���Ҫ���ҵ�Ԫ�أ�����
				if (matrix[row][column] == number) {
					found = true;
					break;
				} else if (matrix[row][column] > number) {
					// �����Ԫ�ش���Ҫ���ҵ�Ԫ�أ�����ٸ���
					column--;
				} else if (matrix[row][column] < number) {
					// �����Ԫ��С��Ҫ���ҵ�Ԫ�أ�����ٸ��У������Ӹ��к�
					row++;
				}
			}
		}
		return found;
	}
}
