package com.kanlon.printnumber;

/**
 * 打印出1到最大的n位数。 题目：输入数字n，按顺序打印出1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999
 *
 * @author zhangcanlong
 * @date 2018年10月7日
 */
public class PrintNumber {
	public static void main(String[] args) {
		PrintNumber print = new PrintNumber();
		int n = 3;
		// 测试方法1
		// print.PrintToMaxOfNDigitsMethod1(n);
		// 测试方法2
		print.printToMaxOfDigitsMethod2(n);
	}

	/**
	 * 解题思路1：因为要考虑大数问题，将数字化为字符串，每次在字符串的基础上加1，然后在判断是否是最大数的时候，通过最左边的位有没有进位来判断
	 *
	 * @param n
	 */
	public void PrintToMaxOfNDigitsMethod1(int n) {
		if (n <= 0) {
			return;
		}
		// 初始化数字字符数组
		char[] chars = new char[n];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = '0';
		}
		while (!increment(chars)) {
			printN(chars);
		}

	}

	/**
	 * 打印出数字n
	 *
	 * @param chars
	 *            用来表示数字的字符数组
	 */
	private void printN(char[] chars) {
		// 用来表示前n项是否存在0的，如果一旦不存在为0的了，则其设置为false
		boolean isBegining0 = true;
		for (int i = 0; i < chars.length; i++) {
			if (isBegining0 && chars[i] != '0') {
				isBegining0 = false;
			}
			if (!isBegining0) {
				System.out.print(chars[i]);
			}
		}
		System.out.println();
	}

	/**
	 * 字符数组自增1,实现了用O(1)时间判断是不是已经到了最大的n位数
	 *
	 * @param chars
	 *            用来表示数字的字符数组
	 */
	private boolean increment(char[] number) {
		// 是否已经是最大的那个数
		boolean isOverflow = false;
		// 用来表示进位
		int nTakeOver = 0;
		int nLength = number.length;
		for (int i = nLength - 1; i >= 0; i--) {
			// 看有没有进位，没有进位，就直接加
			int nSum = number[i] - '0' + nTakeOver;
			// 如果是最后一位，则将当前数自增
			if (i == nLength - 1) {
				nSum++;
			}
			// 如果大于10，表示要进位
			if (nSum >= 10) {
				if (i == 0) {
					isOverflow = true;
				} else {
					nSum -= 10;
					// 用来表示进位加1
					nTakeOver = 1;
					number[i] = (char) ('0' + nSum);
				}
			} else {
				// 如果相加没有大于10，即没有进位，则直接自增该数
				number[i] = (char) ('0' + nSum);
				break;
			}
		}
		return isOverflow;
	}

	/**
	 * 解题思路2：利把数字的每一位都从0到9排序一遍，就可以得到所有的十进制数。全排序利用递归很容易表达
	 *
	 * @param n
	 */
	public void printToMaxOfDigitsMethod2(int n) {
		if (n <= 0) {
			return;
		}
		char[] number = new char[n];
		for (int i = 0; i < n; i++) {
			number[i] = '0';
		}
		for (int i = 0; i < 10; ++i) {
			number[0] = (char) (i + '0');
			printToMaxOfNDigitsRecursively(number, 0, n);
		}
	}

	/**
	 * 全排序的方法（当前该方法还没看懂）
	 *
	 * @param number
	 *            要排序的字符数组
	 * @param index
	 *            在数组中要开始的全排序的字符的角标
	 * @param length
	 *            数组的长度
	 */
	private void printToMaxOfNDigitsRecursively(char[] number, int index, int length) {
		if (index == length - 1) {
			printN(number);
			return;
		}
		for (int i = 0; i < 10; i++) {
			number[index + 1] = (char) (i + '0');
			printToMaxOfNDigitsRecursively(number, index + 1, length);
		}
	}

}
