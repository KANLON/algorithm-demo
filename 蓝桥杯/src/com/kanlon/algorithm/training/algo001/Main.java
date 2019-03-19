package com.kanlon.algorithm.training.algo001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ALGO 001 算法训练  区间k大数查询
 * @author zhangcanlong
 * @data 2019-3-19 下午05:26:50
 * @version: V1.0
 */
public class Main {
	public static void main(String[] args) {
		solution1();
	}
	
	/**
	 * 解答1（完全暴力），应该还有O(n)的解法，但是蓝桥杯的系统通过了，就先这样了，有空再来补充。
	 */
	public static void solution1(){
		Scanner scan = new Scanner(System.in);
		int serNum = scan.nextInt();
		int[] ints = new int[serNum];
		for(int i=0;i<ints.length;i++){
			ints[i]=(scan.nextInt());
		}
		int findTime = scan.nextInt();
		List<int[]> findList = new ArrayList<int[]>(findTime);
		for(int i=0;i<findTime;i++){
			int[] tempInts = new int[3];
			for(int j=0;j<tempInts.length;j++){
				tempInts[j]=scan.nextInt();
			}
			findList.add(tempInts);
		}
		
		
		for(int i=0;i<findList.size();i++){
			int[] temp = findList.get(i);
			int[] newInts = Arrays.copyOfRange(ints, temp[0]-1,temp[1]);
			Arrays.sort(newInts);
			int resultIndex= newInts.length-temp[2];
			System.out.println(newInts[resultIndex]);
		}
		
	}
}
