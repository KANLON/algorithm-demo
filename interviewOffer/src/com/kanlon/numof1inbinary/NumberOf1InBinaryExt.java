package com.kanlon.numof1inbinary;

/**
 * ͳ�ƶ�����1�еĸ�������չ��Ŀ��
 * <p>
 * ��һ��������ȥ1֮���ٺ�ԭ����������λ�����㣬�õ��Ľ���൱���ǰ������Ķ����Ʊ�ʾ�е����ұ�һ��1���0.�����Ķ����Ƶ����ⶼ���������˼·�����
 *
 * @author zhangcanlong
 * @date 2018��10��6��
 */
public class NumberOf1InBinaryExt {

	public static void main(String[] args) {

		NumberOf1InBinaryExt ext = new NumberOf1InBinaryExt();
		// ������Ŀ1
		int n0 = 0;
		int n1 = 1;
		int n2 = 8;
		System.out.println(ext.judgeIs2Power(n0));
		System.out.println(ext.judgeIs2Power(n1));
		System.out.println(ext.judgeIs2Power(n2));

		// ������Ŀ2
		int num1 = 10;
		int num2 = 13;
		System.out.println(ext.m2n(num1, num2));

	}

	/**
	 * ��չ��Ŀ1����һ������ж�һ�������ǲ���2�������η���
	 * <p>
	 * ����˼·��һ�����������2�������η�����ô���Ķ����Ʊ�ʾ������ֻ��һλ��1������������λ����0.����ǰ��ķ����������������ȥ1֮���ٺ����Լ��������㣬���������Ψһ��1�ͻ���0.
	 *
	 * @param n
	 *            Ҫ�жϵ���
	 * @return
	 */
	public boolean judgeIs2Power(int n) {
		return (n & (n - 1)) == 0 && n > 0;
	}

	/**
	 * ��չ��Ŀ2��������������m��n��������Ҫ�ı�m�Ķ����Ʊ�ʾ�е�
	 * ����λ���ܵõ�n�����磺10�Ķ����Ʊ�ʾΪ1010,13�Ķ����Ʊ�ʾΪ1101����Ҫ�ı�1010�е�3λ���ܵõ�1101.
	 * <p>
	 * ����˼·����һ����������������򣬵ڶ���ͳ���������1�ĸ���
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
