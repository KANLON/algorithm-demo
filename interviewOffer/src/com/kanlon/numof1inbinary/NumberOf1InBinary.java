package com.kanlon.numof1inbinary;

/**
 * ��Ŀ����������1�ĸ�����
 * ��ʵ��һ������������һ�����������������������1�ĸ����������9��ʾ�ɶ�������1001����2λ��1����ˣ��������9���ú������2��
 *
 * @author zhangcanlong
 * @date 2018��10��5��
 */
public class NumberOf1InBinary {

	public static void main(String[] args) {
		NumberOf1InBinary binary = new NumberOf1InBinary();
		// ����
		// ����
		int n1 = 1;
		int n2 = 0x7FFFFFFF;
		// �����������߽�ֵ��
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
	 * ����˼·1�����ж�n�Ƿ����0�ˣ��������Ƚ�n��1�������㣨����1�Ķ�����Ϊ�������ұ�һλΪ1������λΪ0�����ж�n�����Ƶ����һλ�ǲ���1�����������Ϊ1����1�ĸ���++�����ʾ���ұ�һλΪ1������Ϊ0.
	 * Ȼ��n����һλ������������жϡ�
	 * <p>
	 * ע�⣺�����Ƶ�ʱ��ʹ�õ���java�е��޷���λ����,��Ȼ��������ѭ��
	 *
	 * @param n
	 *            ��Ҫ�жϵ���
	 * @return ���ض�������ʽ�е�1�ĸ���
	 */
	public int countNumOf1Method1(int n) {
		int num = 0;
		while (n != 0) {
			int value = n & 1;
			if (value == 1) {
				++num;
			}
			// ������Ҫʹ���޷�������(�Ų������뵽��ѭ��������������Ļ���������λҲ���ȥ)
			n = n >>> 1;
		}
		return num;
	}

	/**
	 * ����˼·2��ͨ�����Ƽ��㡣���Ȱ�i��1�������㣬�ж�i�����λ�ǲ���1�����Ű�1����һλ�õ�2���ٺ�i�������㣬�����ж�i�Ĵε�λ�ǲ���1��
	 * �����������ƣ�ÿ���ж�i������һλ�ǲ���1��(���ַ����ǲ������Ϸ���λ��Ҫ�Լ�����)
	 *
	 * @param n
	 * @return
	 */
	public int countNumOf1LeftMove(int n) {
		// ��Ҫ���Ϸ���λ������ȷ��
		int num = 0;
		if (n < 0) {
			num = 1;
		}
		int flag = 1;
		// ��flag����0ʱ����Ҫһֱѭ��
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
	 * ����˼·3���Ƽ���:
	 * ��һ��������ȥ1���ٺ�ԭ�����������㣬��Ѹ����������ұ�һ��1���0����ôһ�������Ķ����Ʊ�ʾ���ж��ٸ�1���Ϳ��Խ��ж��ٴ������Ĳ���
	 *
	 * @param n
	 *            Ҫ���������
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
