package com.kanlon.ugly_number;

/**
 * 面试题34：丑数。题目：我们把只包含因子2、3、5的数称作为丑数（Ugly
 * Number）。求按从小到大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7.习惯上我们把1当做第一个丑数。
 *
 * @author zhangcanlong
 * @date 2019年2月11日
 */
public class UglyNumber {
	public static void main(String[] args) {
		// 功能测试1
		UglyNumber test = new UglyNumber();
		long time1 = System.currentTimeMillis();
		System.out.println("功能测试1，方法一：" + test.getUglyNumberCount1(1500));
		long time2 = System.currentTimeMillis();
		System.out.println("花费时间为：" + (time2 - time1) + "毫秒");
		System.out.println("功能测试1，方法二：" + test.getUglyNumberCount2(1500));
		long time3 = System.currentTimeMillis();
		System.out.println("花费时间为：" + (time3 - time2) + "毫秒");
		System.out.println("功能测试2，方法一：" + test.getUglyNumberCount1(1));
		System.out.println("功能测试2，方法二：" + test.getUglyNumberCount2(1));
		System.out.println("特殊测试1，方法一：" + test.getUglyNumberCount1(0));
		System.out.println("特殊测试1，方法二：" + test.getUglyNumberCount2(0));
	}

	/**
	 * 解题思路1（暴力破解）：对于顺序遍历自然数，如果该数分别是2、3、5的倍数，则除以2、3、5，最后判断其是否等于1，即判断其是否除了2、3、5之外还有没有其他因子。
	 *
	 * @param n
	 *            要得到的第几个丑数
	 * @return 返回该第n个丑数
	 */
	public long getUglyNumberCount1(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("要得到的丑数不能小于等于0");
		}
		if (n == 1) {
			return 1;
		}
		// 当前的丑数序号
		int count = 1;
		// 自然数
		int number = 2;
		// 存储丑数
		int uglyNumber = 1;
		// 判断是否是丑数
		while (count < n) {
			// 临时
			int temp = number;
			while (temp % 2 == 0) {
				temp /= 2;
			}
			while (temp % 3 == 0) {
				temp /= 3;
			}
			while (temp % 5 == 0) {
				temp /= 5;
			}
			if (temp == 1) {
				uglyNumber = number;
				count++;
			}
			number++;
		}
		return uglyNumber;
	}

	/**
	 * 解题思路2（空间换时间，推荐）：（1）使用一个数组将之前已经求出来的丑数保存起来，然后依次用2,3,4,5乘上数组中已经求出来的
	 * 丑数，选出其中最小的一个保存到数组中。假设数组中存的最大丑数是Max，那么只要求出2,3，5乘以数组中的某一个数刚好比Max大，然后选出三者间最小的就可以。
	 * （2）例如：当前数组中的丑数为1，此时2*1,3*1,5*1中最小的是2，将2存到数组中，此时数组中的数为1,2.Max=2。有因为2*1==Max，所以第二次乘的丑数应该为2*2,3*1>2,5*1>2，在新的4,3,5中最小的为3，将3存到数组中，依次循环。
	 * (3)这种方法只计算丑数，如果是计算1500，时间快过方法一，2万多倍
	 * <p>
	 * 参考：https://blog.csdn.net/u013309870/article/details/67012369
	 *
	 * @param n
	 *            要得到的第几个丑数
	 * @return 返回的第n个丑数
	 */
	public long getUglyNumberCount2(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("要得到的丑数不能小于等于0");
		}
		// 存储丑数的数组
		int[] uglyNumbers = new int[n];
		uglyNumbers[0] = 1;

		int uglyNumberIndex = 1, min;
		int nextIndex2 = 0, nextIndex3 = 0, nextIndex5 = 0;
		while (uglyNumberIndex < n) {
			// 找出三个数中的最小的
			min = uglyNumbers[nextIndex2] * 2 < uglyNumbers[nextIndex3] * 3 ? uglyNumbers[nextIndex2] * 2
					: uglyNumbers[nextIndex3] * 3;
			min = min < uglyNumbers[nextIndex5] * 5 ? min : uglyNumbers[nextIndex5] * 5;

			uglyNumbers[uglyNumberIndex] = min;
			// 如果乘以的数小于数组中最大的数，则将其下标++
			while (uglyNumbers[nextIndex2] * 2 <= min) {
				nextIndex2++;
			}
			while (uglyNumbers[nextIndex3] * 3 <= min) {
				nextIndex3++;
			}
			while (uglyNumbers[nextIndex5] * 5 <= min) {
				nextIndex5++;
			}

			uglyNumberIndex++;
		}

		return uglyNumbers[uglyNumberIndex - 1];
	}
}
