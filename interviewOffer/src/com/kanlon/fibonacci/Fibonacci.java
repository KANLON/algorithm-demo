package com.kanlon.fibonacci;

import java.security.InvalidParameterException;

/**
 * 쳲��������е���⡣��Ŀ��дһ������������n����쳲�������Fibonacci�����еĵ�n�
 * ��Ŀ2��һֻ����һ�ο�������1��̨�ף���������2���������������һ��n����̨�׹��ж�����������
 *
 * @author zhangcanlong
 * @date 2018��10��5��
 */
public class Fibonacci {

	public static void main(String[] args) {
		Fibonacci fi = new Fibonacci();
		int[] testInts = new int[9];
		// �������ӣ����ܲ��ԣ�
		testInts[0] = 3;
		testInts[1] = 5;
		testInts[2] = 10;
		// �߽�ֵ����
		testInts[3] = 0;
		testInts[4] = 1;
		testInts[5] = 2;
		// ���ܲ��ԣ�����ϴ�����֣�
		testInts[6] = 40;
		// ������������ʱ��̫����������ʱ������
		// testInts[7] = 50;
		// testInts[8] = 100;
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < testInts.length; i++) {
			System.out.println("�ݹ�����" + fi.nFibonacci(testInts[i]));
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("ʱ��Ϊ��" + (endTime1 - startTime));

		for (int i = 0; i < testInts.length; i++) {
			System.out.println("ѭ�������" + fi.nFibonacciWithLoop(testInts[i]));
		}
		System.out.println("ʱ��Ϊ��" + (System.currentTimeMillis() - endTime1));

	}

	/**
	 * ���˼·һ���ݹ���������Ч�ʵ͡������f(10)Ϊ������������f(10)����Ҫ�����f(9)��f(8)��
	 * ͬ���������f(9)����Ҫ�����f(8)��f(7),....,����ڶ���ظ�ֵ�������ظ���ֵ������n��������������ӣ�����ζ������������n���������������
	 *
	 * @param n
	 * @return
	 */
	public long nFibonacci(long n) {
		if (n < 0) {
			throw new RuntimeException("��������С��0");
		}
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return nFibonacci(n - 1) + nFibonacci(n - 2);
	}

	/**
	 * ����˼·2���Ƽ�ʹ�ã�:��ѭ��ʵ�֣�����ǰ�����Ѿ���������Ľ����������һ����ʱ�临�Ӷ�O(n)
	 *
	 * @param n
	 * @return
	 */
	public long nFibonacciWithLoop(long n) {
		if (n < 0) {
			throw new InvalidParameterException("��������С��0");
		}
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		// ��n-1���ʼֵΪn=1��
		long before1 = 1;
		// ��n-2���ʼֵΪn=0��
		long before2 = 0;
		// ��n��
		long fn = 0;
		for (int i = 2; i <= n; i++) {
			fn = before1 + before2;
			// Ϊ��һ������׼������ǰ��һ��
			before2 = before1;
			before1 = fn;
		}
		return fn;
	}

	/**
	 * ����˼·3��������ѧ��ʽ���㣬���������ѧ��ʽ�Ƚ��Ѽ�ס��ʱ�临�Ӷ�O(logn)�������ʱ��û����ɣ�
	 *
	 * @param n
	 * @return
	 */
	public long nFibonacciWithFormula(long n) {
		return 0;
	}

	/**
	 * �����ĳ˷��������ʱ��û����ɣ�
	 *
	 * @param matrix
	 *            ���󣬼���ά����
	 * @param power
	 *            �˷�����
	 */
	public int[][] matrixPower(int[][] matrix, int power) {
		if (power <= 0) {
			throw new InvalidParameterException("�˷�������С�ڵ���0����");
		}
		if (power == 1) {
			return matrix;
		}

		if (power == 2) {
			for (int i = 0; i < power; i++) {
				matrix[0][0] = matrix[0][0] * matrix[0][0] + matrix[0][1] * matrix[1][0];
				matrix[0][1] = matrix[0][0] * matrix[1][0] + matrix[0][1] * matrix[1][1];
				matrix[1][0] = matrix[1][0] * matrix[0][0] + matrix[1][1] * matrix[1][0];
				matrix[1][1] = matrix[1][0] * matrix[0][1] + matrix[1][1] * matrix[1][1];
			}
			return matrix;
		}

		// ż��ʱ
		if (power % 2 == 0) {
			return matrixPower(matrixPower(matrix, power / 2), 2);
		}
		// ����ʱ
		if (power % 2 != 0) {
			return matrixPower(matrixPower(matrix, power / 2), 2);
		}
		Math.max(1, 2);
		return matrix;
	}

}
