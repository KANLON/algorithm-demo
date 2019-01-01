package com.kanlon.binary_tree_top_to_bottom;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 面试题23：从上往下打印二叉树（二叉树的层次遍历）
 * 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。例如输入如下图中的二叉树，则依次打印出8、6、10、5、7、9、11
 *
 * @author zhangcanlong
 * @date 2019年1月1日
 */
public class BinaryTreeTopToBottom {
	public static void main(String[] args) {
		BinaryTreeTopToBottom test = new BinaryTreeTopToBottom();
		// 功能测试1,有多左右结点二叉树
		// 功能测试（含有多个左右结点的树）
		BinaryTree tree11 = new BinaryTree(8);
		BinaryTree tree12 = new BinaryTree(6);
		BinaryTree tree13 = new BinaryTree(10);
		BinaryTree tree14 = new BinaryTree(5);
		BinaryTree tree15 = new BinaryTree(7);
		BinaryTree tree16 = new BinaryTree(9);
		BinaryTree tree17 = new BinaryTree(11);
		tree11.mPLeft = tree12;
		tree11.mPRight = tree13;
		tree12.mPLeft = tree14;
		tree12.mPRight = tree15;
		tree13.mPLeft = tree16;
		tree13.mPRight = tree17;
		System.out.println("功能测试1含有多个左右子结点：");
		tree11.outTree();
		test.printTreeFromToBottom(tree11);

		// 功能测试2，只有左结点二叉树
		BinaryTree tree21 = new BinaryTree(8);
		BinaryTree tree22 = new BinaryTree(6);
		BinaryTree tree23 = new BinaryTree(10);
		BinaryTree tree24 = new BinaryTree(5);
		tree21.mPLeft = tree22;
		tree22.mPLeft = tree23;
		tree23.mPLeft = tree24;
		System.out.println("功能测试2只含有多个左子结点：");
		tree21.outTree();
		test.printTreeFromToBottom(tree21);

		// 功能测试3，只有右结点二叉树
		BinaryTree tree31 = new BinaryTree(8);
		BinaryTree tree32 = new BinaryTree(6);
		BinaryTree tree33 = new BinaryTree(10);
		BinaryTree tree34 = new BinaryTree(5);
		tree31.mPLeft = tree32;
		tree32.mPLeft = tree33;
		tree33.mPLeft = tree34;
		System.out.println("功能测试3只含有多个右子结点：");
		tree31.outTree();
		test.printTreeFromToBottom(tree31);

		// 功能测试4，只有一个结点
		BinaryTree tree41 = new BinaryTree(8);
		test.printTreeFromToBottom(tree41);
		// 特殊测试1，空结点
		test.printTreeFromToBottom(null);

	}

	/**
	 * 二叉树的层次遍历
	 * <p>
	 * 解题思路：用队列存储二叉树的结点，并打印出结点值，直到该队列为null，当结点有左右子结点的时候将其放入到队列中。
	 *
	 * @param rootNode
	 *            要遍历二叉树的根结点
	 */
	public void printTreeFromToBottom(BinaryTree rootNode) {
		if (rootNode == null) {
			return;
		}
		// 存放树所有结点的队列
		Queue<BinaryTree> queue = new LinkedBlockingQueue<>();
		queue.offer(rootNode);
		while (!queue.isEmpty()) {
			BinaryTree tempNode = queue.poll();
			System.out.print(tempNode.mNValue + " ");
			if (tempNode.mPLeft != null) {
				queue.offer(tempNode.mPLeft);
			}
			if (tempNode.mPRight != null) {
				queue.offer(tempNode.mPRight);
			}
		}
		System.out.println();
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
