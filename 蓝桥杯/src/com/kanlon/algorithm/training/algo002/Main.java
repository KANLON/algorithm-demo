package com.kanlon.algorithm.training.algo002;

import java.util.Scanner;

/**
 * ALGO 002 算法训练 最大最小公倍数  
 * @author zhangcanlong
 * @data 2019-3-19 下午06:09:56
 * @version: V1.0
 */
public class Main {
	public static void main(String[] args) {
		solution1();
	}
	
	/**
	 * 方法一：多写几个数，找规律，首先要最大的数开始算起，最好取前几大，然后，n，n-1，n-2是之间最大不超过3，所以它们之间有只可能有公因子2，（暴力，只能对60%，还许需要考虑(n-1)开始的状态）
	 */
	public static void solution1(){
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		//偶数
		if(n%2==0){
			long lastNum = n-3;
			if(n%3==0){
				while(lastNum%3==0 || lastNum%2==0){
					lastNum--;
				}
			}
			System.out.println(Math.max(n*(n-1)*lastNum,(n-3)*(n-1)*(n-2)));
			
		}else{
			System.out.println(n*(n-1)*(n-2));
		}
	}
}



