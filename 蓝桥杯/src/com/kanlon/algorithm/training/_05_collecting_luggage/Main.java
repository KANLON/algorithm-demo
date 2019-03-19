package com.kanlon.algorithm.training._05_collecting_luggage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 放弃了，由于时间紧迫，这道题很难，暂时没有时间做
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
		List<TestModel> list = new ArrayList<TestModel>();
		while(true){
			int tempVertexNum = scan.nextInt();
			
			if(tempVertexNum==0){break;}
			
			TestModel model = new TestModel();
			//多边性顶点数
			model.setVertexNum(tempVertexNum);
			
			//顶点坐标
			int[][] vertexPosition = new int[model.getVertexNum()][2];
			for(int i=0;i<vertexPosition.length;i++){
				for(int j=0;j<2;j++){
					vertexPosition[i][j]=scan.nextInt();
				}
			}
			model.setVertexPosition(vertexPosition);
			//乘客坐标
			int[] passengerPosition = new int[2];
			passengerPosition[0]=scan.nextInt();
			passengerPosition[1]=scan.nextInt();
			model.setPassengerPosition(passengerPosition);
			//行李速度
			model.setVl(scan.nextInt());
			//乘客速度
			model.setPl(scan.nextInt());

			list.add(model);
		}
		
		
		
	}
	
	
	
}

/**
 * 对象
 * @author zhangcanlong
 * @data 2019-3-19 上午09:46:50
 * @version: V1.0
 */
class TestModel{
	
	//多边性顶点数
	int vertexNum ;
	//顶点坐标
	int[][] vertexPosition = new int[vertexNum][2];

	//乘客坐标
	int[] passengerPosition = new int[2];

	//行李速度
	int vl;
	//乘客速度
	int pl ;
	public int getVertexNum() {
		return vertexNum;
	}
	public void setVertexNum(int vertexNum) {
		this.vertexNum = vertexNum;
	}
	public int[][] getVertexPosition() {
		return vertexPosition;
	}
	public void setVertexPosition(int[][] vertexPosition) {
		this.vertexPosition = vertexPosition;
	}
	public int[] getPassengerPosition() {
		return passengerPosition;
	}
	public void setPassengerPosition(int[] passengerPosition) {
		this.passengerPosition = passengerPosition;
	}
	public int getVl() {
		return vl;
	}
	public void setVl(int vl) {
		this.vl = vl;
	}
	public int getPl() {
		return pl;
	}
	public void setPl(int pl) {
		this.pl = pl;
	}
	
}
