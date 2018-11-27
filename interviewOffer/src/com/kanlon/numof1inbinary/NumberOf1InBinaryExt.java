package com.kanlon.numof1inbinary;

/**
 * 统计二进制1中的个数的拓展题目。
 * <p>
 * 把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于是把整数的二进制表示中的最右边一个1变成0.这样的二进制的问题都可以用这个思路解决。
 *
 * @author zhangcanlong
 * @date 2018年10月6日
 */
public class NumberOf1InBinaryExt {

	public static void main(String[] args) {

		NumberOf1InBinaryExt ext = new NumberOf1InBinaryExt();
		// 测试题目1
		int n0 = 0;
		int n1 = 1;
		int n2 = 8;
		System.out.println(ext.judgeIs2Power(n0));
		System.out.println(ext.judgeIs2Power(n1));
		System.out.println(ext.judgeIs2Power(n2));

		// 测试题目2
		int num1 = 10;
		int num2 = 13;
		System.out.println(ext.m2n(num1, num2));

	}

	/**
	 * 拓展题目1：用一条语句判断一个整数是不是2的整数次方。
	 * <p>
	 * 解题思路：一个整数如果是2的整数次方，那么它的二进制表示中有且只有一位是1，而其他所有位都是0.根据前面的分析，把这个整数减去1之后再和它自己做与运算，这个整数中唯一的1就会变成0.
	 *
	 * @param n
	 *            要判断的数
	 * @return
	 */
	public boolean judgeIs2Power(int n) {
		return (n & (n - 1)) == 0 && n > 0;
	}

	/**
	 * 拓展题目2：输入两个整数m和n，计算需要改变m的二进制表示中的
	 * 多少位才能得到n。比如：10的二进制表示为1010,13的二进制表示为1101，需要改变1010中的3位才能得到1101.
	 * <p>
	 * 解题思路：第一步求这两个数的异或，第二部统计异或结果中1的个数
	 *
	 * @param m
	 * @param n
	 * @return
	 */
	public int m2n(int m, int n) {
		int mn = m ^ n;
		int num = 0;
		while (mn != 0) {
			++num;
			mn = mn & (mn - 1);
		}
		return num;
	}

}