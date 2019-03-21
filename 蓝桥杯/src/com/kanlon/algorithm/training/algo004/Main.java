package com.kanlon.algorithm.training.algo004;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * ALGO 004   算法训练 结点选择  
 * @author zhangcanlong
 * @since 2019-3-21 上午09:17:43
 * @version: V1.0
 */
public class Main {
	public static void main(String[] args) {
		solution1();
	}
	
	/**
	 * 解题思路1：
	 */
	public static void solution1(){
		Scanner scan = new Scanner(System.in);
		//表示树结点数
		int n = scan.nextInt();
		//表示结点对应的权重，即值
		DefaultMutableTreeNode[] nodes = new DefaultMutableTreeNode[n];
		for(int i=0;i<nodes.length;i++){
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(scan.nextInt());
			nodes[i]=node;
		}
		
		//存储边的情况，并将边连接到对应结上
		List<int[]> sideList = new ArrayList<int[]>();
		for(int i=0;i<n-1;i++){
			int[] temp = new int[2];
			temp[0]=scan.nextInt();
			temp[1]=scan.nextInt();
			sideList.add(temp);
			//连接节点
			nodes[temp[0]-1].add(nodes[temp[1]-1]);
		}
		
		if(n==1){
			System.out.println(nodes[0]);
			return;
		}
		
		//树的根节点
		DefaultMutableTreeNode root = nodes[0];
			
		
	}
}
