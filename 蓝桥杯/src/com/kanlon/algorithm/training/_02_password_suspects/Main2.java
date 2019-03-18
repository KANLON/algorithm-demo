package com.kanlon.algorithm.training._02_password_suspects;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 算法训练2(暂时做不出来，网上有个参考的)
 * @author zhangcanlong
 * @data 2019-3-17 上午11:28:36
 * @version: V1.0
 */
public class Main2 {
	public static void main(String[] args) {
		solution1();
	}
	
	public static void solution1(){
		Scanner scan = new Scanner(System.in);
		int passwordLength = scan.nextInt();
		int subStrNumber = scan.nextInt();
		if(subStrNumber==0){
			long result = (long)Math.pow(26,passwordLength);
			if(result>42){
			System.out.println((long)Math.pow(26,passwordLength));
			}else{
				for(int i='a';i<'z';i++){
					System.out.println((char)i);
				}
			}
			return;
		}
		List<String> strs = new ArrayList<String>(subStrNumber);
		//子字符串总长度
		int sumLength = 0;
		for(int i=0;i<subStrNumber;i++){
			String temp = scan.next();
			sumLength+=temp.length();
			strs.add(temp);
		}
		//存放结果
		List<String> results = new ArrayList<String>();
		
			//如果组合数大于42，则不用输出
			int resultNum = 1;
			for(int i=1;i<=strs.size();i++){
				resultNum*=i;
			}
			if(resultNum<=42){
				results = fullSort(strs,0,strs.size()-1,results,passwordLength);
				Collections.sort(results);
				System.out.println(resultNum);
				for(String str:results){
					System.out.println(str);
				}
			}else{
				System.out.println(resultNum);
			}
		
		
	}
	/**
	 * 全排序实现方法
	 * @param strs 要全排序的集合
	 * @param start 开始元素下标
	 * @param last 结束元素下标
	 * @return 返回全排序的结果
	 */
	private static List<String> fullSort(List<String> strs,int start,int last,List<String> results,int targetLength){
		if(last==start){
			results.addAll(append(strs,strs.size()));
		}
		//第一个数依次与后面的数交换
		for(int i=start;i<=last;i++){
			String temp = strs.get(start);
			strs.set(start, strs.get(i));
			strs.set(i, temp);
			
			fullSort(strs,start+1,last,results,targetLength);
			
			//还原
			strs.set(i, strs.get(start));
			strs.set(start, temp);
		}
		
		return results;
	}
	
	/**
	 * 根据指定长度拼接字符串
	 * @param strs
	 * @param targetLength
	 * @return
	 */
	private static Set<String> append(List<String> strs,int targetLength){
		Set<String> returnStr = new HashSet<String>();
		//遍历strs获取长度
		int strsSumLength = 0;
		for(String str :strs){
			strsSumLength+=str.length();
		}
		//如果总长度与要求的长度相同
		if(strsSumLength==targetLength){
			StringBuffer result = new StringBuffer();
			for(String str:strs){
				result.append(str);
			}
			returnStr.add(result.toString());
			return returnStr;
		}
		int diff = strsSumLength-targetLength;
		//相同
		int sameIndex = 1;
		//在遍历拼接的时候，看看有没有相同的，有相同的，则合并，同时减少diff的值
		int temp=diff;
		for(int i=sameIndex;i<strs.size();i++){
			StringBuffer tempResult = new StringBuffer(); 
			for(int j=0;j<strs.size()-1;j++){
				String nowStr = strs.get(j);
				String nextStr = j+1>=strs.size()-1?" ":strs.get(j+1);
				if(nowStr.charAt(nowStr.length()-1)==nextStr.charAt(0)){
					--temp;
					if(diff==0){
						tempResult.append(nowStr.substring(0,nowStr.length()-1));
						temp=diff;
						break;
					}
				}else{
					tempResult.append(strs.get(j));
				}
			}
			returnStr.add(tempResult.toString());
		}
		
		return returnStr;
	}
}
