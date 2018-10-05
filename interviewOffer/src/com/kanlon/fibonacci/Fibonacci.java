package com.kanlon.fibonacci;

import java.security.InvalidParameterException;

/**
 * 斐波那契数列的求解。题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
 * 题目2：一只青蛙一次可以跳上1个台阶，可以跳上2级。求该青蛙跳上一个n级的台阶共有多少种跳法。
 *
 * @author zhangcanlong
 * @date 2018年10月5日
 */
public class Fibonacci {

	public static void main(String[] args) {
		Fibonacci fi = new Fibonacci();
		int[] testInts = new int[9];
		// 测试例子（功能测试）
		testInts[0] = 3;
		testInts[1] = 5;
		testInts[2] = 10;
		// 边界值测试
		testInts[3] = 0;
		testInts[4] = 1;
		testInts[5] = 2;
		// 性能测试（输入较大的数字）
		testInts[6] = 40;
		// 下面两个由于时间太慢，所以暂时不测试
		// testInts[7] = 50;
		// testInts[8] = 100;
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < testInts.length; i++) {
			System.out.println("递归解决：" + fi.nFibonacci(testInts[i]));
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("时间为：" + (endTime1 - startTime));

		for (int i = 0; i < testInts.length; i++) {
			System.out.println("循环解决：" + fi.nFibonacciWithLoop(testInts[i]));
		}
		System.out.println("时间为：" + (System.currentTimeMillis() - endTime1));

	}

	/**
	 * 求解思路一：递归解决，不过效率低。以求解f(10)为例，如果想求得f(10)，需要先求得f(9)和f(8)。
	 * 同样，想求得f(9)，需要先求得f(8)和f(7),....,会存在多个重复值，而且重复的值会随着n的增大而急剧增加，这意味计算量会随着n的增大而急剧增大。
	 *
	 * @param n
	 * @return
	 */
	public long nFibonacci(long n) {
		if (n < 0) {
			throw new RuntimeException("输入的项不能小于0");
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
	 * 解题思路2（推荐使用）:用循环实现，利用前两项已经计算出来的结果，计算下一个，时间复杂度O(n)
	 *
	 * @param n
	 * @return
	 */
	public long nFibonacciWithLoop(long n) {
		if (n < 0) {
			throw new InvalidParameterException("输入的项不能小于0");
		}
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		// 第n-1项（初始值为n=1）
		long before1 = 1;
		// 第n-2项（初始值为n=0）
		long before2 = 0;
		// 第n项
		long fn = 0;
		for (int i = 2; i <= n; i++) {
			fn = before1 + before2;
			// 为下一次做好准备，都前进一项
			before2 = before1;
			before1 = fn;
		}
		return fn;
	}

	/**
	 * 解题思路3：利用数学公式计算，不过这个数学公式比较难记住。时间复杂度O(logn)（这个暂时还没有完成）
	 *
	 * @param n
	 * @return
	 */
	public long nFibonacciWithFormula(long n) {
		return 0;
	}

	/**
	 * 求矩阵的乘方（这个暂时还没有完成）
	 *
	 * @param matrix
	 *            矩阵，即二维数组
	 * @param power
	 *            乘方的数
	 */
	public int[][] matrixPower(int[][] matrix, int power) {
		if (power <= 0) {
			throw new InvalidParameterException("乘方数不能小于等于0！！");
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

		// 偶数时
		if (power % 2 == 0) {
			return matrixPower(matrixPower(matrix, power / 2), 2);
		}
		// 奇数时
		if (power % 2 != 0) {
			return matrixPower(matrixPower(matrix, power / 2), 2);
		}
		Math.max(1, 2);
		return matrix;
	}

}
