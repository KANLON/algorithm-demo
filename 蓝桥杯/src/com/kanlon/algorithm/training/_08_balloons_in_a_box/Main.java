package com.kanlon.algorithm.training._08_balloons_in_a_box;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 训练8：目前只有55%的准确率，
 * @author zhangcanlong
 * @data 2019-3-19 下午02:49:17
 * @version: V1.0
 */
public class Main {
	
	static int indexNum = 1;
	
	//s，e是关于长方体的两个对点
	static Point s = new Point();
	static Point e= new Point();
	//关于长方体内的气球位置
	static Point[] a = new Point[10];
	
	public static void main(String[] args) {
		solution1();
	}
	
	/**
	 * 解决1：参考：https://blog.csdn.net/weixin_38391092/article/details/79351337
	 */
	public static void solution1(){
		//读取数据
		Scanner scan = new Scanner(System.in);
		int pointNum = scan.nextInt();
		s.x=scan.nextInt();
		s.y=scan.nextInt();
		s.z = scan.nextInt();
		e.x = scan.nextInt();
		e.y = scan.nextInt();
		e.z =scan.nextInt();
		for(int i=0;i<pointNum;i++){
			a[i] = new Point();
			a[i].x=scan.nextInt();
			a[i].y=scan.nextInt();
			a[i].z = scan.nextInt();
		}
		//长方体盒子的体积
		double total = Math.abs((s.x-e.x)*(s.y-e.y)*(s.z-e.z));
		
		//答案
		double ans = 0;
		
		int vis[] = new int[pointNum];
		for(int i=0;i<pointNum;i++){
			vis[i]=i;
		}
		
		//求出关于各个圆心位置的全排序，并计算气球总体积
		do{
			for(int i=0;i<pointNum;i++){
				a[i].r=0;
			}
			double temp =0;
			for(int i=0;i<pointNum;i++){
				a[vis[i]].r = solve(vis[i]);
				for(int j=0;j<pointNum;j++){
					if(i==j || a[vis[j]].r==0){
						continue;
					}
					double tt = dis(a[vis[j]],a[vis[i]])-a[vis[j]].r;
					tt = Math.max(tt,0.0);
					a[vis[i]].r = Math.min(a[vis[i]].r,tt);
				}
				
				temp +=area(a[vis[i]].r);
			}
			ans = Math.max(ans, temp);
		}while(newNextPermutation(vis));
		System.out.println(Math.round(Math.abs(total-ans)));
	}
	
	/**
	 * 计算球 的面积
	 * @param r 球的半径
	 * @return 球的面积
	 */
	private static double area(double r){
		return 4.0*r*r*r*Math.PI/3.0;
	}
	
	/**
	 * 球心位置到长方形侧面的最短距离
	 * @param i 球中点的下标
	 * @return 最短距离
	 */
	private static double solve(int i){
		double t1 = Math.min(Math.abs(a[i].x-e.x), Math.abs(a[i].x-s.x));
		double t2 = Math.min(Math.abs(a[i].y-e.y), Math.abs(a[i].y-s.y));
		double t3 = Math.min(Math.abs(a[i].z-e.z), Math.abs(a[i].z-s.z));
		return Math.min(t1, Math.min(t2,t3));
	}
	
	/**
	 * 计算 两点之间的距离
	 * @param p1 点1
	 * @param p2 点2 
	 * @return 点1 和点2之间的距离
	 */
	private static double dis(Point p1,Point p2){
		double temp1 = (p1.x-p2.x)*(p1.x-p2.x);
		double temp2 = (p1.y-p2.y)*(p1.y-p2.y);
		double temp3 = (p1.z-p2.z)*(p1.z-p2.z);
		return Math.pow(temp1+temp2+temp3,0.5);
	}
	
	/**
	 * 将数组从1，到数组大小位数进行排序
	 * @param nums
	 * @return
	 */
	private static boolean newNextPermutation(int[] nums){
		if(indexNum<=nums.length){
			boolean flag= nextPermutation(nums, indexNum);
			 if(!flag){
				 indexNum++;
			 }
		}else{
			return false;
		}
		return true;
	}
	
	/**
	 * 求数组的全排序的下一个顺序
	 * @param nums 要排序的数组
	 * @param endLength 需要排序的前几位
	 * @return
	 */
    private static boolean nextPermutation(int[] nums,int endLength) {
        for (int i = endLength - 2; i >= 0; i--)
            if (nums[i] < nums[i + 1])
                for (int j = endLength - 1; j > i; j--)
                    if (nums[i] < nums[j]) {
                        swap(nums, i, j);
                        reverse(nums, i + 1, endLength - 1);
                        return true;
                    }
        //到最后的了，还原最开始状态
        reverse(nums, 0, endLength - 1);
        return false;
    }
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    private static  void reverse(int[] nums, int left, int right) {
        while (left < right)
            swap(nums, left++, right--);
    }

	
}
/**
 * 坐标值
 * @author zhangcanlong
 * @data 2019-3-19 下午03:18:21
 * @version: V1.0
 */
class Point{
	//坐标值
	double x;
	double y;
	double z;
	//如果是圆心，则表示圆心半径
	double r;
}
