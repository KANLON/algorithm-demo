package com.kanlon.convert_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题27：二叉搜索树和双向链表
 * <p>
 * 题目：输入一颗二叉搜索树，将二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。比如输入如下图中左边的二叉搜索树，则输出转换之后的排序双向链表。
 *
 * @author zhangcanlong
 * @date 2019年1月7日
 */
public class ConvertBinarySearchTree {
	public static void main(String[] args) {
		ConvertBinarySearchTree test = new ConvertBinarySearchTree();
		// 功能测试1,有多左右结点二叉树
		// 功能测试（含有多个左右结点的树）
		BinaryTree tree11 = new BinaryTree(10);
		BinaryTree tree12 = new BinaryTree(6);
		BinaryTree tree13 = new BinaryTree(14);
		BinaryTree tree14 = new BinaryTree(4);
		BinaryTree tree15 = new BinaryTree(8);
		BinaryTree tree16 = new BinaryTree(12);
		BinaryTree tree17 = new BinaryTree(16);
		tree11.mPLeft = tree12;
		tree11.mPRight = tree13;
		tree12.mPLeft = tree14;
		tree12.mPRight = tree15;
		tree13.mPLeft = tree16;
		tree13.mPRight = tree17;
		System.out.println("功能测试1含有多个左右子结点：");
		tree11.outTree();
		BinaryTree listNode1 = test.convert(tree11);
		listNode1.outListTree();

		// 功能测试2，只有左结点二叉树
		BinaryTree tree21 = new BinaryTree(8);
		BinaryTree tree22 = new BinaryTree(6);
		BinaryTree tree23 = new BinaryTree(4);
		BinaryTree tree24 = new BinaryTree(2);
		tree21.mPLeft = tree22;
		tree22.mPLeft = tree23;
		tree23.mPLeft = tree24;
		System.out.println("功能测试2只含有多个左子结点：");
		tree21.outTree();
		test.convert(tree21).outListTree();

		// 功能测试3，只有右结点二叉树
		BinaryTree tree31 = new BinaryTree(8);
		BinaryTree tree32 = new BinaryTree(10);
		BinaryTree tree33 = new BinaryTree(12);
		BinaryTree tree34 = new BinaryTree(14);
		tree31.mPRight = tree32;
		tree32.mPRight = tree33;
		tree33.mPRight = tree34;
		System.out.println("功能测试3只含有多个右子结点：");
		tree31.outTree();
		test.convert(tree31).outListTree();

		// 功能测试4，只有一个结点
		BinaryTree tree41 = new BinaryTree(8);
		test.convert(tree41).outListTree();
		// 特殊测试1，空结点
		test.convert(null);

	}

	/**
	 * 解题思路：(1)利用中序遍历，因为中序遍历的顺序刚好是二叉搜索树的从小到大的遍历顺序。
	 * (2)当遍历到根结点的时候，【将根结点左子树结点，指向左子树中最大的元素，即双向链表中最后的一个元素】。（这时候已经转化后左子树了）和将最后的元素的右子树指向根结点。这样此时遍历的根结点也是双向链表了，并将最后一个元素替换为该结点。
	 * （3）然后如果右子树不是空的话，将右子树和链表的最后一个元素结点传到递归方法中转换。左右子树 都是这样递归转换。
	 *
	 * @return
	 */
	public BinaryTree convert(BinaryTree treeNode) {
		if (treeNode == null) {
			return null;
		}
		// 双向链表最后一个元素结点
		BinaryTree listLastNode = null;
		BinaryTree[] listNodes = { listLastNode };
		convertNode(treeNode, listNodes);

		// 返回双向链表的头结点
		BinaryTree listHeadNode = listNodes[0];
		while (listHeadNode != null && listHeadNode.mPLeft != null) {
			listHeadNode = listHeadNode.mPLeft;
		}
		return listHeadNode;
	}

	/**
	 * 将二叉搜索树转化为排序的双向链表
	 *
	 * @param pNode
	 *            二叉搜索树的根结点
	 * @param listLastNode
	 *            双向链表的最后一个元素
	 */
	void convertNode(BinaryTree pNode, BinaryTree[] listLastNode) {
		if (pNode == null) {
			return;
		}
		BinaryTree currentNode = pNode;
		if (currentNode.mPLeft != null) {
			convertNode(currentNode.mPLeft, listLastNode);
		}
		currentNode.mPLeft = listLastNode[0];
		if (listLastNode[0] != null) {
			listLastNode[0].mPRight = currentNode;
		}
		listLastNode[0] = currentNode;
		if (currentNode.mPRight != null) {
			convertNode(currentNode.mPRight, listLastNode);
		}
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

	/**
	 * 输出排序双向链表的值
	 */
	public void outListTree() {
		BinaryTree temp = this;
		System.out.print(temp.mNValue + "->");
		while (temp != null && temp.mPRight != null) {
			temp = temp.mPRight;
			System.out.print(temp.mNValue + "->");
		}
		while (temp != null) {
			System.out.print("<-" + temp.mNValue);
			temp = temp.mPLeft;
		}
		System.out.println();
	}

}
