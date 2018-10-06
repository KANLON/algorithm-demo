package com.kanlon.power;

import java.security.InvalidParameterException;

/**
 * ��ֵ�������η� ��Ŀ��ʵ�ֺ���double Power(double base,int
 * exponent),��base��exponent�η�������ʹ�ÿ⺯����ͬʱ����Ҫ���Ǵ������⡣
 *
 * @author zhangcanlong
 * @date 2018��10��6��
 */
public class CulPower {
	public static void main(String[] args) {
		CulPower cul = new CulPower();
		// ������������������ָ���ֱ���Ϊ����������������
		double base1 = 2;
		int exponent1 = 3;
		double base2 = 2;
		int exponent2 = -3;
		double base3 = -2;
		int exponent3 = 3;
		double base4 = 0;
		int exponent4 = 3;
		double base5 = 2;
		int exponent5 = 0;
		double base6 = 0;
		int exponent6 = 0;
		double base7 = -2;
		int exponent7 = -3;
		System.out.println(cul.power(base1, exponent1));
		System.out.println(cul.power(base2, exponent2));
		System.out.println(cul.power(base3, exponent3));
		System.out.println(cul.power(base4, exponent4));
		System.out.println(cul.power(base5, exponent5));
		System.out.println(cul.power(base6, exponent6));
		System.out.println(cul.power(base7, exponent7));
	}

	/**
	 * ����˼·1�����ǵ�ָ���п����Ǹ�������exponent�Ǹ���ʱ��baseҲ��0ʱ���򷵻�0.�����base�ľ���ֵ�ĵ�����
	 * ע�⣺��doubleֵ���бȽ�ʱ������ֱ�ӱȽ�
	 *
	 * @param base
	 * @param exponent
	 * @return
	 */
	public double power(double base, int exponent) {
		// ���ﲻ��ֱ����base==0���жϣ���Ϊbase�Ǹ�������0�ǲ�׼ȷ��ֵ
		if (equal(base, 0) && exponent < 0) {
			// ���������0������ָ����С��0�ģ���0�������������׳��쳣
			throw new InvalidParameterException("0��ָ�����ܸ�����û�����壡��");
		}
		double result = bestPowerWithUnsignedException(base, Math.abs(exponent));
		if (exponent < 0) {
			result = 1.0d / result;
		}
		return result;
	}

	/**
	 * ����base��������exponent�η��Ľ��,ֱ�Ӷ��base���
	 *
	 * @param base
	 *            ����
	 * @param abs
	 *            �������η�
	 * @return
	 */
	private double powerWithUnsignedExponent(double base, int exponent) {
		double result = 1.0d;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}

	/**
	 * (�Ƽ�ʹ��)����base��������exponent�η��Ľ������õķ�������������a��n�η��Ĺ�ʽ��ʱ�临�Ӷ�ΪO(logn)
	 *
	 * @param base
	 *            ����
	 * @param exponect
	 *            �������η�
	 * @return
	 */
	private double bestPowerWithUnsignedException(double base, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}
		double result = bestPowerWithUnsignedException(base, exponent >> 1);
		result *= result;
		if ((exponent & 1) == 1) {
			result *= base;
		}
		return result;
	}

	/**
	 * �Ƚ�����doubleֵ�Ƿ����
	 *
	 * @param num1
	 * @param num2
	 * @return
	 */
	private boolean equal(double num1, double num2) {
		if (num1 - num2 < 0.000001 && num1 - num2 > 0.000001) {
			return true;
		}
		return false;
	}

}
