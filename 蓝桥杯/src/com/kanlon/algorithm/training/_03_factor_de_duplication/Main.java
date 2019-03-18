package com.kanlon.algorithm.training._03_factor_de_duplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 训练3 素因子去重。题目大意：要求的素因子去重，则是把某数进行因式分解，得到其所有素因数，然后将素因数相乘。
 * @author zhangcanlong
 * @data 2019-3-18 下午02:53:12
 * @version: V1.0
 */
public class Main {
	public static void main(String[] args) {
		solution();
	}
	
	/**
	 * 解题思路：1.从2开始遍历，每次除尽该数，从而达到去重和只包含素数的因数。参考：https://blog.csdn.net/kunzhoumei/article/details/86821146
	 */
	public static void solution(){
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		if(n<=1){
			System.out.println(n);
		}
		//存放所有素数因子
		List<Integer> list = new ArrayList<Integer>();
		for(int i=2;i<=n;i++){
			if(n%i==0){
				list.add(i);
				n=n/i;
				while(n%i==0){
					n=n/i;
				}
			}
		}
		int result = 1;
		for(Integer i:list){
			result*=i;
		}
		System.out.println(result);
	}
}
