package com.kanlon.number_of_1;

/**
 * 面试题32：从1到n整数中1出现的次数。
 * <p>
 * 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 * 例如输入12，从1到12这些整数中包含1的数字有1，10，11和12，1一共出现了5次。
 *
 * @author zhangcanlong
 * @date 2019年2月5日
 */
public class NumberOf1 {

	public static void main(String[] args) {
		// 功能测试
		NumberOf1 test = new NumberOf1();
		System.out.println("方法一，功能测试1，5，：" + test.numberOf1Between1AndN1(5));
		System.out.println("方法二，功能测试1，5，：" + test.numberOf1Between1AndN2(5));
		System.out.println("方法一，功能测试2，10，：" + test.numberOf1Between1AndN1(10));
		System.out.println("方法二，功能测试2，10，：" + test.numberOf1Between1AndN2(10));
		System.out.println("方法一，功能测试3，55，：" + test.numberOf1Between1AndN1(55));
		System.out.println("方法二，功能测试3，55，：" + test.numberOf1Between1AndN2(55));
		System.out.println("方法一，功能测试4，99，：" + test.numberOf1Between1AndN1(99));
		System.out.println("方法二，功能测试4，99，：" + test.numberOf1Between1AndN2(99));

		// 边界值测试
		System.out.println("方法一，边界测试1，0，：" + test.numberOf1Between1AndN1(0));
		System.out.println("方法二，边界测试1，0，：" + test.numberOf1Between1AndN2(0));
		System.out.println("方法一，边界测试2，1，：" + test.numberOf1Between1AndN1(1));
		System.out.println("方法二，边界测试2，1，：" + test.numberOf1Between1AndN2(1));

		// 性能测试（输入比较大的数）
		System.out.println("方法一，性能测试1，10000，：" + test.numberOf1Between1AndN1(10000));
		System.out.println("方法二，性能测试1，10000，：" + test.numberOf1Between1AndN2(10000));
	}

	/**
	 * 解题思路1（粗暴解答,O（nlogn））:遍历1到n的每个数字，某个数字再除以10，判断其各位是否为1，如果是1，则将次数加1，知道遍历完成。
	 *
	 * @param n
	 *            要遍历的数字
	 * @return 返回1出现的次数
	 */
	public int numberOf1Between1AndN1(int n) {
		if (n <= 0) {
			return 0;
		}
		// 1出现的次数
		int count = 0;
		for (int i = 1; i <= n; ++i) {
			int currentNum = i;
			while (currentNum > 0) {
				if (currentNum % 10 == 1) {
					count++;
				}
				currentNum /= 10;
			}
		}
		return count;
	}

	/**
	 * 解题思路2（推荐，找规律，O（logn）,牛客网上的解法，剑指offer原书的太复杂）：设n=abcde,其中abcde分别为十进制中各位上的数字。如果要计算百位上出现的次数，它要受到3方面的影响：百位上d数字，百位以下（低位）的数字，百位以上（高位）的数字。
	 * ①如果百位上数字为0，百位上可能出现1的次数由更高位决定。比如：12013，则可以知道百位出现1的情况可能是：100~199，1100~1199,2100~2199，，...，11100~11199，一共1200个。可以看出是由更高位数字（12）决定，并且等于更高位数字（12）乘以
	 * 当前位数（100）。
	 * ②如果百位上数字为1，百位上可能出现1的次数不仅受更高位影响还受低位影响。比如：12113，则可以知道百位受高位影响出现的情况是：100~199，1100~1199,2100~2199，，....，11100~11199，一共1200个。和上面情况一样，并且等于更高位数字（12）乘以
	 * 当前位数（100）。但同时它还受低位影响，百位出现1的情况是：12100~12113,一共114个，等于低位数字（113）+1。
	 * ③如果百位上数字大于1（2~9），则百位上出现1的情况仅由更高位决定，比如12213，则百位出现1的情况是：100~199,1100~1199，2100~2199，...，11100~11199,12100~12199,一共有1300个，并且等于更高位数字+1（12+1）乘以当前位数（100）。
	 *
	 * @param n
	 *            要遍历的数字
	 * @return 返回1出现的次数
	 */
	public int numberOf1Between1AndN2(int n) {
		if (n <= 0) {
			return 0;
		}
		int count = 0;// 1的个数
		int i = 1;// 当前位
		int current = 0, after = 0, before = 0;
		while ((n / i) != 0) {
			current = (n / i) % 10; // 高位数字
			before = n / (i * 10); // 当前位数字
			after = n - (n / i) * i; // 低位数字
			// 如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
			if (current == 0) {
				count += before * i;
			} else if (current == 1) {
				count += before * i + after + 1;
			} else {
				count += (before + 1) * i;
			}
			// 前移一位
			i = i * 10;
		}
		return count;
	}

}
