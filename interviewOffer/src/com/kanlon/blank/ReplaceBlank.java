package com.kanlon.blank;

/**
 * ��Ŀ����ʵ��һ�����������ַ�����ÿ���ո��滻��"%20"���������롰We are happy.�����������We%20are%20happy.����
 * ��ʵ����Ӧ�ñ����ɣ����ַ������еĿո��滻Ϊ%20�������������ֳ������Ŀ����ı��ʡ�
 *
 * @author zhangcanlong
 * @date 2018��9��22��
 */
public class ReplaceBlank {

	public static void main(String[] args) {
		// ����
		String url1 = " We are happy.";
		String url2 = " We are happy.  ";
		String url3 = "Wearehappy.";
		String url4 = " ";
		String url5 = "";
		String url6 = "  ";
		ReplaceBlank replace = new ReplaceBlank();
		System.out.println(new String(replace.replaceBlank(url1.toCharArray())));
		System.out.println(new String(replace.replaceBlank(url2.toCharArray())));
		System.out.println(new String(replace.replaceBlank(url3.toCharArray())));
		System.out.println(new String(replace.replaceBlank(url4.toCharArray())));
		System.out.println(new String(replace.replaceBlank(url5.toCharArray())));
		System.out.println(new String(replace.replaceBlank(url6.toCharArray())));

	}

	/**
	 * ����˼·���ȱ�������һ�飬ͳ�ƿո�ĸ�����Ȼ�����滻����������Ĵ�С�����Ŷ���P1��P2����ָ�룬�ֱ�ָ��ԭʼ�ַ���ĩβ���滻֮����ַ�����ĩβ��
	 * ������ǰ�ƶ�ָ��P1���������ָ����ַ����Ƶ�P2ָ���λ�ã�ֱ��������һ���ո�Ϊֹ��������һ���ո�֮�󣬰�P1��ǰ�ƶ�1����P2֮ǰ�����ַ���"%20"������"%20"�ĳ���Ϊ3��ͬʱҲҪ��P2��ǰ�ƶ�3��ֱ��P1==P2��
	 *
	 * @param urls
	 * @return
	 */
	public char[] replaceBlank(char[] urls) {

		int blankNum = 0;
		int oldLength = urls.length;
		int newLength = 0;
		// ͳ�ƿո�����
		for (int i = 0; i < urls.length; i++) {
			if (Character.isWhitespace(urls[i])) {
				blankNum++;
			}
		}
		if (urls == null || urls.length == 0 || blankNum == 0) {
			return urls;
		}
		newLength = oldLength + blankNum * 2;

		// �滻���µ�����
		char[] newUrls = new char[newLength];
		System.arraycopy(urls, 0, newUrls, 0, urls.length);
		urls = newUrls;

		int p1 = oldLength - 1;
		int p2 = newLength - 1;
		// �滻�ո�
		while (p1 != p2) {
			if (!Character.isWhitespace(urls[p1])) {
				urls[p2] = urls[p1];
				p2--;
			} else {
				urls[p2] = '0';
				urls[--p2] = '2';
				urls[--p2] = '%';
				p2--;
			}
			p1--;
		}

		return urls;
	}
}
