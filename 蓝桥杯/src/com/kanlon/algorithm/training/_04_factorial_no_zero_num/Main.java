package com.kanlon.algorithm.training._04_factorial_no_zero_num;

import java.util.Scanner;

/**
 * 算法训练 题目4
 * @author zhangcanlong
 * @data 2019-3-18 下午03:57:35
 * @version: V1.0
 */
public class Main {
	public static void main(String[] args) {
//		solution1();
		solution2();
	}
	
	/**
	 * 方法一：直接计算阶乘，同时判断是否有以0为结尾，如果是，则除以10，对于阶乘非0数来说，这种方式并不会改变其结果。（不能全部通过，通过率70%）
	 */
	public static void solution1(){
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		Long sum = 1L;
		for(int i=1;i<=n;++i){
			sum*=i;
			while(sum%10==0){
				sum/=10;
			}
		}
		System.out.println(sum%10);
	}
	
	
	/**
	 * 方法二：直接计算阶乘，同时判断是否有以0为结尾，如果是，则除以10，对于阶乘非0数来说，这种方式并不会改变其结果。加上只用后面三位数字相乘即可。参考：https://blog.csdn.net/kunzhoumei/article/details/86823990
	 */
	public static void solution2(){
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		Long sum = 1L;
		for(int i=1;i<=n;++i){
			sum*=i;
			while(sum%10==0){
				sum/=10;
			}
			//只用后面三位相乘即可
			sum=sum%1000;
		}
		System.out.println(sum%10);
	}
	
	
}
