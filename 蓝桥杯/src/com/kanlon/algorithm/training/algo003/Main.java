package com.kanlon.algorithm.training.algo003;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 算法训练 k好数，一开始是不理解k好数的，后来在网上查看了，就知道，原来“任意的相邻的两位都不是相邻的数字”指的是单个数内每个数字之间不超过1，如：11，1-1=0!=1
 * @author zhangcanlong
 * @data 2019-3-19 下午08:01:24
 * @version: V1.0
 */
public class Main {
	
    final static int MOD = 1000000007; 
	
	public static void main(String[] args) {
//		solution1();
		solution2();
		
	}
	
	/**
	 * 方法一，暴力破解，遍历每个数，并对每个数都进行判断,(只有20%)。参考：https://blog.csdn.net/lovely__RR/article/details/83242622
	 */
	public static void solution1(){
		Scanner scan = new Scanner(System.in);
		//存放结果有多少个这个k好数
		int result = 0 ;
		//进制
		long radix = scan.nextInt();
		//位数
		long digit = scan.nextInt();
		//最小的digit位数
		long min = (long)Math.pow(radix,digit-1);
		//最大的数
		long max = (long)(Math.pow(radix, digit)-1);
		
		for(long i=min;i<=max;i++){
			//判断radix进制的数，相邻之间的数的差是否等于1
			String radixNumStr = Long.toString(i, (int)radix);
			//是否符合k好数
			boolean flag = true;
			for(int j=1;j<radixNumStr.length();j++){
				if(Math.abs(radixNumStr.charAt(j)-radixNumStr.charAt(j-1))==1){
					flag=false;
					break;
				}
			}
			if(flag){
				result++;
			}
		}
		System.out.println(result%1000000007);
	}
	
	/**
	 * 方法2：动态规划
	 */
	public static void solution2(){
		 Scanner input = new Scanner(System.in);  

         while (input.hasNext())  
         {  
             //k为k进制
        	 int k = input.nextInt();
        	 //L为位数
             int L = input.nextInt();  
             //结果
             int num = 0;  
             //L位数行，k列
             int[][] nums = new int[L][k];  
             //将第一行所有值设置为1
             for (int j = 0; j < k; j++){
                 nums[0][j] = 1;  
             }
             
             for (int i = 1; i < L; i++){
            	 //从1开始;遍历数组，nums
                 for (int j = 0; j < k; j++)
                	 //二层指标
                     for (int x = 0; x < k; x++){
                    	 //x的不是j下标的相邻位，则
                         if (x != j - 1 && x != j + 1){
                        	 //将上一行的所有值，累加到当前行的每个数里，要删除掉周围的数
                             nums[i][j] += nums[i - 1][x];  
                             nums[i][j] %= MOD;  
                         }  
                     }  
             }
             //最后遍历最后一行，所有列的结果和即可
             for (int j = 1; j < k; j++){  
                 num += nums[L - 1][j];  
                 num %= MOD;  
             }  
             System.out.println(num);  
         }  
	}
}
