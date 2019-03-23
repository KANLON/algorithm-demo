package com.kanlon.algorithm.training.algo004;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * ALGO 004 算法训练 结点选择
 * 
 * @author zhangcanlong
 * @since 2019-3-21 上午09:17:43
 * @version: V1.0
 */
public class Main {

	// 存储树的结构，用邻接表存储树
	private static List<List<Integer>> v = new ArrayList<List<Integer>>();
	// 存储权值和
	private static int[][] dp = new int[100005][2];;
	// 表示结点是否被访问，100005为最大结点数
	private static boolean[] visit = new boolean[100005];

	public static void main(String[] args) {
		solution1();
	}

	/**
	 * 解题思路1: 参考：https://blog.csdn.net/richenyunqi/article/details/78834248
	 * 动态规划，从后面递归回来，一个结点可以分为两种情况，
	 * （1）一个是选中，然后就很肯定不能选子结点，加上不选子节点的情况权值和。
	 * （2）另一个是不选，然后就选择选或不选子节点  两种情况中，权值和大的情况。
	 * （3）当遍历到没有子结点的时候直接跳过，在上一步，会自动将其值加上的。
	 */
	public static void solution1() {
		Scanner scan = new Scanner(System.in);
		// 表示树结点数
		int n = scan.nextInt();

		for (int i = 1; i <= n; i++) {
			// 将第一行的存放其本身节点的值
			dp[i][0] = scan.nextInt();
			v.add(new ArrayList<Integer>());
		}
		// 让结点序号与实际下标序号相等
		v.add(new ArrayList<Integer>());

		// 存储边的情况，并将边连接到对应结上
		for (int i = 0; i < n - 1; i++) {
			// 用邻接表存储图的节点
			int a = scan.nextInt();
			int b = scan.nextInt();
			v.get(a).add(b);
			v.get(b).add(a);
		}
		// 深度遍历
		dfs(1);
		
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}

	/**
	 * 深度遍历
	 * 
	 * @param root
	 *            树的顶点在顶点数组中的位置
	 */
	private static void dfs(int root) {
		List<Integer> temp = v.get(root);
		// 已访问
		visit[root] = true;
		// 遍历某个root节点的所有子节点
		for (int i = 0; i <= temp.size() - 1; i++) {
			// 如果子节点没有访问过
			if (!visit[temp.get(i)]) {
				// 递归遍历
				dfs(temp.get(i));
				// 更新选中这个结点的整颗子树的最大权值和,即加上不选子结点的情况的权值和
				dp[root][0] += dp[temp.get(i)][1];
				// 更新没有选中这个结点的整棵子树的最大权值和，即加上不选子结点或选子结点的情况的权值和
				dp[root][1] += Math.max(dp[temp.get(i)][0], dp[temp.get(i)][1]);
			}
		}
	}
}
