package com.kanlon.algorithm.training.algo003;

import java.util.Scanner;

/**
 * 算法训练 k好数，一开始是不理解k好数的，后来在网上查看了，就知道，原来“任意的相邻的两位都不是相邻的数字”指的是单个数内每个数字之间不超过1，如：11，1-1=0!=1
 * @author zhangcanlong
 * @data 2019-3-19 下午08:01:24
 * @version: V1.0
 */
public class Main {
	public static void main(String[] args) {
		
	}
	
	/**
	 * 方法一，暴力破解，遍历每个数，并对每个数都进行判断。参考：https://blog.csdn.net/lovely__RR/article/details/83242622
	 */
	public static void solution1(){
		Scanner scan = new Scanner(System.in);
		//进制
		long radix = scan.nextInt();
		//位数
		long digit = scan.nextInt();
		//最小的digit位数
		long min = radix*(digit-1);
		
	}
}
