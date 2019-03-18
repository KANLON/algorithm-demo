package com.kanlon.algorithm.training._05_collecting_luggage;

import java.util.Scanner;

/**
 * 算法训练5：Collecting Luggage  
 * @author zhangcanlong
 * @data 2019-3-18 下午04:21:49
 * @version: V1.0
 */
public class Main {
	public static void main(String[] args) {
		
	}
	
	public static void solution1(){
		Scanner scan = new Scanner(System.in);
		//多边性顶点数
		int vertexNum = scan.nextInt();
		//顶点坐标
		int[][] vertexPosition = new int[vertexNum][2];
		for(int i=0;i<vertexPosition.length;i++){
			for(int j=0;j<2;j++){
				vertexPosition[i][j]=scan.nextInt();
			}
		}
		//乘客坐标
		int[] passengerPosition = new int[2];
		passengerPosition[0]=scan.nextInt();
		passengerPosition[1]=scan.nextInt();
		//
		
	}
}
