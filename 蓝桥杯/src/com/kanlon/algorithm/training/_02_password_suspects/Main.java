package com.kanlon.algorithm.training._02_password_suspects;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 算法训练2
 * @author zhangcanlong
 * @data 2019-3-17 上午11:28:36
 * @version: V1.0
 */
public class Main {
	public static void main(String[] args) {
		solution1();
	}
	
	public static void solution1(){
		Scanner scan = new Scanner(System.in);
		int passwordLength = scan.nextInt();
		int subStrNumber = scan.nextInt();
		if(subStrNumber==0){
			System.out.println((long)Math.pow(26,passwordLength));
			return;
		}
		List<String> strs = new ArrayList<String>(subStrNumber);
		for(int i=0;i<subStrNumber;i++){
			strs.add(scan.nextLine());
		}
		
		
	}
}
