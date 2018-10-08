package com.kanlon.printnumber;

import java.math.BigInteger;
import java.security.InvalidParameterException;

/**
 * ��չ��Ŀ������һ���������ڸú����п���ʵ���������������ļӷ���
 *
 * @author zhangcanlong
 * @date 2018��10��7��
 */
public class PrintNumberExt {
	public static void main(String[] args) {
		PrintNumberExt print = new PrintNumberExt();
		System.out.println(print.addTwoNumber("1234", "1234"));
	}

	/**
	 * ����˼·����������������ӵĺͲ��ᳬ������֮�����ĳ���+1����ˣ��ȶ���һ���ַ����飬����Ϊ�������������+1��
	 * ����������һ����������ֵ����ʼforѭ��������ӣ����Ȳ����Ǹ�����������10�����1������ (���⻹ûʵ��)
	 *
	 * @param num1
	 *            ����1 ���ַ���
	 * @param num2
	 *            ����2 ���ַ���
	 * @return ������ӵĽ�����ַ���
	 */
	public String addTwoNumber(String num1, String num2) {
		if (!num1.matches("([-\\+])?\\d+") && !num2.matches("([-\\+])?\\d+")) {
			throw new InvalidParameterException("����Ĳ���һ�����������������룡����");
		}
		BigInteger int1 = new BigInteger(num1);
		BigInteger int2 = new BigInteger(num2);
		return int1.add(int2).toString();
	}

}
