package com.kanlon.numof1inbinary;

/**
 * 题目：二进制中1的个数。
 * 请实现一个函数，输入一个整数，输出该数二进制中1的个数。例如把9表示成二进制是1001，有2位是1。因此，如果输入9，该函数输出2。
 *
 * @author zhangcanlong
 * @date 2018年10月5日
 */
public class NumberOf1InBinary {

	public static void main(String[] args) {
		NumberOf1InBinary binary = new NumberOf1InBinary();
		// 测试
		// 正数
		int n1 = 1;
		int n2 = 0x7FFFFFFF;
		// 负数（包含边界值）
		int n3 = 0x80000000;
		int n4 = 0xFFFFFFF;
		// 0
		int n5 = 0;

		System.out.println("n1=" + n1 + "  " + Integer.toBinaryString(n1));
		System.out.println(binary.countNumOf1Method1(n1));
		System.out.println(binary.countNumOf1LeftMove(n1));
		System.out.println(binary.countNumOf1AndSelf(n1));

		System.out.println("n2=" + n2 + "  " + Integer.toBinaryString(n2));
		System.out.println(binary.countNumOf1Method1(n2));
		System.out.println(binary.countNumOf1LeftMove(n2));
		System.out.println(binary.countNumOf1AndSelf(n2));

		System.out.println("n3=" + n3 + "  " + Integer.toBinaryString(n3));
		System.out.println(binary.countNumOf1Method1(n3));
		System.out.println(binary.countNumOf1LeftMove(n3));
		System.out.println(binary.countNumOf1AndSelf(n3));

		System.out.println("n4=" + n4 + "  " + Integer.toBinaryString(n4));
		System.out.println(binary.countNumOf1Method1(n4));
		System.out.println(binary.countNumOf1LeftMove(n4));
		System.out.println(binary.countNumOf1AndSelf(n4));

		System.out.println("n5=" + n5 + "  " + Integer.toBinaryString(n5));
		System.out.println(binary.countNumOf1Method1(n5));
		System.out.println(binary.countNumOf1LeftMove(n5));
		System.out.println(binary.countNumOf1AndSelf(n5));
	}

	/**
	 * 解题思路1：先判断n是否等于0了，不等则，先将n与1作与运算（整数1的二进制为除了最右边一位为1，其他位为0），判断n二进制的最后一位是不是1，如果运算结果为1，则1的个数++，则表示最右边一位为1，否则为0.
	 * 然后将n右移一位，接着上面的判断。
	 * <p>
	 * 注意：在右移的时候，使用的是java中的无符号位右移,不然会陷入死循环
	 *
	 * @param n
	 *            需要判断的数
	 * @return 返回二进制形式中的1的个数
	 */
	public int countNumOf1Method1(int n) {
		int num = 0;
		while (n != 0) {
			int value = n & 1;
			if (value == 1) {
				++num;
			}
			// 这里需要使用无符号右移(才不会陷入到死循环，而且这里算的话会连符号位也算进去)
			n = n >>> 1;
		}
		return num;
	}

	/**
	 * 解题思路2：通过左移计算。首先把i和1做与运算，判断i的最低位是不是1。接着把1左移一位得到2，再和i做与运算，就能判断i的次低位是不是1，
	 * 这样反复左移，每次判断i的其中一位是不是1。(这种方法是不计算上符号位，要自己加上)
	 *
	 * @param n
	 * @return
	 */
	public int countNumOf1LeftMove(int n) {
		// 需要加上符号位才是正确的
		int num = 0;
		if (n < 0) {
			num = 1;
		}
		int flag = 1;
		// 当flag大于0时，都要一直循环
		while (flag > 0) {
			int value = n & flag;
			if (value > 0) {
				++num;
			}
			flag = flag << 1;
		}
		return num;
	}

	/**
	 * 解题思路3（推荐）:
	 * 把一个整数减去1，再和原整数做与运算，会把该整数的最右边一个1变成0，那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作
	 *
	 * @param n
	 *            要计算的整数
	 * @return
	 */
	public int countNumOf1AndSelf(int n) {
		int num = 0;
		while (n != 0) {
			++num;
			n = (n - 1) & n;
		}
		return num;
	}

}