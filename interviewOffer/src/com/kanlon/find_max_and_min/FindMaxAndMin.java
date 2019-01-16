package com.kanlon.find_max_and_min;

/**
 * 不用比较找出两个数中的较大值和较小值
 *
 * @author zhangcanlong
 * @date 2019年1月16日
 */
public class FindMaxAndMin {

	public static void main(String[] args) {
		FindMaxAndMin test = new FindMaxAndMin();
		// 测试1
		System.out.println("测试1都是正数");
		test.findTwoNumMinAndMax1(1, 100);
		test.findTwoNumMinAndMax2(1, 100);
		// 测试2
		System.out.println("测试2，a负，b正");
		test.findTwoNumMinAndMax1(-13, 100);
		test.findTwoNumMinAndMax2(-13, 100);
		// 测试3
		System.out.println("测试3");
		test.findTwoNumMinAndMax1(-13, -48);
		test.findTwoNumMinAndMax2(-13, -48);
		// 测试4（溢出情况）
		System.out.println("测试4（溢出情况）");
		test.findTwoNumMinAndMax1(-2147483647, 2000000);
		test.findTwoNumMinAndMax2(-2147483647, 2000000);

	}

	/**
	 * 不用比较，找出两个数中最大的和最小的（不考虑溢出情况）
	 */
	public void findTwoNumMinAndMax1(int a, int b) {
		int signA = sign(a - b);
		int signB = flip(signA);
		System.out.println("较大的数为：" + (signA * a + signB * b));
		System.out.println("较小的数为：" + (signB * a + signA * b));
	}

	/**
	 * 不用比较，找出两个数中最大的和最小的（考虑溢出情况）
	 */
	public void findTwoNumMinAndMax2(int a, int b) {
		System.out.println("较大的数为：" + (a + b + Math.abs(a - b)) / 2);
		System.out.println("较小的数为：" + (a + b - Math.abs(a - b)) / 2);
	}

	/**
	 * 取相反的数，如果是1，则返回0，如果是0，则返回1
	 */
	private int flip(int n) {
		return n ^ 1;
	}

	/**
	 * 判断某个数的符号
	 *
	 * @param n
	 *            要判断的数
	 * @return 如果是正数，返回1，如果是负数返回0
	 */
	private int sign(int n) {
		return (n >>> 31) ^ 1;
	}

}
