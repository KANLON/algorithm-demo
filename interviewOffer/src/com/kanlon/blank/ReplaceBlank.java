package com.kanlon.blank;

/**
 * 题目：请实现一个函数，把字符串中每个空格替换成"%20"。例如输入“We are happy.”，则输出“We%20are%20happy.”。
 * 其实这里应该表述成，把字符数组中的空格替换为%20。这样才能体现出这个题目问题的本质。
 *
 * @author zhangcanlong
 * @date 2018年9月22日
 */
public class ReplaceBlank {

	public static void main(String[] args) {
		// 测试
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
	 * 解题思路，先遍历数组一遍，统计空格的个数，然后定义替换掉的新数组的大小，接着定义P1，P2两个指针，分别指向原始字符的末尾和替换之后的字符串的末尾。
	 * 接着向前移动指针P1，逐个把它指向的字符复制到P2指向的位置，直到碰到第一个空格为止。遇到第一个空格之后，把P1向前移动1格，在P2之前插入字符串"%20"。由于"%20"的长度为3，同时也要把P2向前移动3格。直到P1==P2。
	 *
	 * @param urls
	 * @return
	 */
	public char[] replaceBlank(char[] urls) {

		int blankNum = 0;
		int oldLength = urls.length;
		int newLength = 0;
		// 统计空格数量
		for (int i = 0; i < urls.length; i++) {
			if (Character.isWhitespace(urls[i])) {
				blankNum++;
			}
		}
		if (urls == null || urls.length == 0 || blankNum == 0) {
			return urls;
		}
		newLength = oldLength + blankNum * 2;

		// 替换后新的数组
		char[] newUrls = new char[newLength];
		System.arraycopy(urls, 0, newUrls, 0, urls.length);
		urls = newUrls;

		int p1 = oldLength - 1;
		int p2 = newLength - 1;
		// 替换空格
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