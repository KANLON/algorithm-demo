package com.kanlon.printnumber;

/**
 * ��ӡ��1������nλ���� ��Ŀ����������n����˳���ӡ��1����nλʮ����������������3�����ӡ��1��2��3һֱ������3λ����999
 *
 * @author zhangcanlong
 * @date 2018��10��7��
 */
public class PrintNumber {
	public static void main(String[] args) {
		PrintNumber print = new PrintNumber();
		int n = 3;
		// ���Է���1
		// print.PrintToMaxOfNDigitsMethod1(n);
		// ���Է���2
		print.printToMaxOfDigitsMethod2(n);
	}

	/**
	 * ����˼·1����ΪҪ���Ǵ������⣬�����ֻ�Ϊ�ַ�����ÿ�����ַ����Ļ����ϼ�1��Ȼ�����ж��Ƿ����������ʱ��ͨ������ߵ�λ��û�н�λ���ж�
	 *
	 * @param n
	 */
	public void PrintToMaxOfNDigitsMethod1(int n) {
		if (n <= 0) {
			return;
		}
		// ��ʼ�������ַ�����
		char[] chars = new char[n];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = '0';
		}
		while (!increment(chars)) {
			printN(chars);
		}

	}

	/**
	 * ��ӡ������n
	 *
	 * @param chars
	 *            ������ʾ���ֵ��ַ�����
	 */
	private void printN(char[] chars) {
		// ������ʾǰn���Ƿ����0�ģ����һ��������Ϊ0���ˣ���������Ϊfalse
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
	 * �ַ���������1,ʵ������O(1)ʱ���ж��ǲ����Ѿ���������nλ��
	 *
	 * @param chars
	 *            ������ʾ���ֵ��ַ�����
	 */
	private boolean increment(char[] number) {
		// �Ƿ��Ѿ��������Ǹ���
		boolean isOverflow = false;
		// ������ʾ��λ
		int nTakeOver = 0;
		int nLength = number.length;
		for (int i = nLength - 1; i >= 0; i--) {
			// ����û�н�λ��û�н�λ����ֱ�Ӽ�
			int nSum = number[i] - '0' + nTakeOver;
			// ��������һλ���򽫵�ǰ������
			if (i == nLength - 1) {
				nSum++;
			}
			// �������10����ʾҪ��λ
			if (nSum >= 10) {
				if (i == 0) {
					isOverflow = true;
				} else {
					nSum -= 10;
					// ������ʾ��λ��1
					nTakeOver = 1;
					number[i] = (char) ('0' + nSum);
				}
			} else {
				// ������û�д���10����û�н�λ����ֱ����������
				number[i] = (char) ('0' + nSum);
				break;
			}
		}
		return isOverflow;
	}

	/**
	 * ����˼·2���������ֵ�ÿһλ����0��9����һ�飬�Ϳ��Եõ����е�ʮ��������ȫ�������õݹ�����ױ��
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
	 * ȫ����ķ�������ǰ�÷�����û������
	 *
	 * @param number
	 *            Ҫ������ַ�����
	 * @param index
	 *            ��������Ҫ��ʼ��ȫ������ַ��ĽǱ�
	 * @param length
	 *            ����ĳ���
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
