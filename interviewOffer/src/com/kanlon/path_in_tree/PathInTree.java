package com.kanlon.path_in_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 面试题25：二叉树中和为某一值的路径(深度优先遍历)
 * <p>
 * 题目：输入一棵二叉树和为一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从树的根结点开始往下一直到叶子结点所经过的结点形成一条路径。
 *
 * @author zhangcanlong
 * @date 2019年1月3日
 */
public class PathInTree {
	public static void main(String[] args) {
		PathInTree test = new PathInTree();
		// 功能测试1（有多左右子树的二叉树，并且含有满足路径要求的）
		BinaryTree tree11 = new BinaryTree(10);
		BinaryTree tree12 = new BinaryTree(5);
		BinaryTree tree13 = new BinaryTree(12);
		BinaryTree tree14 = new BinaryTree(4);
		BinaryTree tree15 = new BinaryTree(7);
		tree11.mPLeft = tree12;
		tree11.mPRight = tree13;
		tree12.mPLeft = tree14;
		tree12.mPRight = tree15;
		System.out.println("功能测试1含有多个左右子结点：");
		tree11.outTree();
		test.findPath(tree11, 22);

		// 功能测试2，只有左结点二叉树
		BinaryTree tree21 = new BinaryTree(10);
		BinaryTree tree22 = new BinaryTree(5);
		BinaryTree tree23 = new BinaryTree(4);
		tree21.mPLeft = tree22;
		tree22.mPLeft = tree23;
		System.out.println("功能测试2只含有多个左子结点：");
		tree21.outTree();
		test.findPath(tree21, 22);

		// 功能测试3，只有右结点二叉树
		BinaryTree tree31 = new BinaryTree(10);
		BinaryTree tree32 = new BinaryTree(5);
		BinaryTree tree33 = new BinaryTree(7);
		tree31.mPRight = tree32;
		tree32.mPRight = tree33;
		System.out.println("功能测试3只含有多个右子结点：");
		tree31.outTree();
		test.findPath(tree31, 22);

		// 功能测试4，只有一个结点
		BinaryTree tree41 = new BinaryTree(8);
		System.out.println("功能测试4,只有一个结点：");
		test.findPath(tree41, 8);
		// 特殊测试1，空结点
		System.out.println("特殊测试1,空：");
		test.findPath(null, 0);

	}

	/**
	 * 寻找路径
	 * <p>
	 * 解题思路：遍历二叉树，使用栈来存储路径，将当前结点加入到路径栈中，如果当前结点到了叶子结点并且路径的值和等于给定值，则输出。否则，还没有到达叶子结点，递归遍历左右子结点，并且递归后返回要将当前结点的路径弹出栈。
	 *
	 * @param rootNode
	 *            二叉树的根结点
	 * @param expectedSum
	 *            路径的值和
	 */
	public void findPath(BinaryTree rootNode, int expectedSum) {
		if (rootNode == null) {
			return;
		}
		// 存放路径的栈
		Stack<Integer> pathStack = new Stack<>();
		// 当前路径的值和
		int currentSum = 0;
		findPath(rootNode, expectedSum, pathStack, currentSum);
	}

	/**
	 * 辅助递归的方法，核心
	 *
	 * @param rootNode
	 *            二叉树的根结点
	 * @param expectedSum
	 *            给定的路径的值和
	 * @param pathStack
	 *            存放路径的栈
	 * @param currentSum
	 *            当前路径的值和
	 */
	private void findPath(BinaryTree rootNode, int expectedSum, Stack<Integer> pathStack, int currentSum) {
		// 将当前遍历的结点加入到路径中去
		pathStack.push(rootNode.mNValue);
		currentSum += rootNode.mNValue;

		// 如果是叶子结点并且路径值和等于给定的值，则输出
		boolean isLeaf = rootNode.mPLeft == null && rootNode.mPRight == null;
		if (currentSum == expectedSum && isLeaf) {
			System.out.print("路径为：");
			for (int i = 0; i < pathStack.size(); i++) {
				System.out.print(pathStack.get(i) + "->");
			}
			System.out.println();
		}

		// 递归遍历左子树
		if (rootNode.mPLeft != null) {
			findPath(rootNode.mPLeft, expectedSum, pathStack, currentSum);
		}
		// 递归遍历右子树
		if (rootNode.mPRight != null) {
			findPath(rootNode.mPRight, expectedSum, pathStack, currentSum);
		}

		// 删除路径和减掉路径值和,相当于返回上一级父结点
		Integer parentNodeValue = pathStack.pop();
		currentSum -= parentNodeValue;
	}

}

/**
 * 二叉树的结构
 *
 * @author zhangcanlong
 * @date 2018年12月25日
 */
class BinaryTree {
	public BinaryTree() {
	}

	public BinaryTree(int value) {
		mNValue = value;
	}

	Integer mNValue = null;
	BinaryTree mPLeft;
	BinaryTree mPRight;

	// 层次遍历二叉树
	public void outTree() {
		// 存放上一层的结点
		List<BinaryTree> list = new ArrayList<>();
		// 存放当前层的结点
		List<BinaryTree> nowNodeList = new ArrayList<>();
		list.add(this);
		// 表示遍历当前层的第几个结点
		int count = 1;
		while (count <= list.size()) {
			System.out.print(list.get(count - 1).mNValue + " ");
			BinaryTree leftNodeTemp = list.get(count - 1).mPLeft;
			BinaryTree rightNodeTemp = list.get(count - 1).mPRight;
			count++;
			if (leftNodeTemp != null) {
				nowNodeList.add(leftNodeTemp);
				leftNodeTemp = leftNodeTemp.mPLeft;
			}
			if (rightNodeTemp != null) {
				nowNodeList.add(rightNodeTemp);
				rightNodeTemp = rightNodeTemp.mPRight;
			}
			// 如果遍历到了上一层的最后一个结点，则将上一层替换为当前层，并将当前层清空
			if (count == list.size() + 1) {
				list.clear();
				list.addAll(nowNodeList);
				nowNodeList.clear();
				count = 1;
			}
		}
		System.out.println();

	}
}
