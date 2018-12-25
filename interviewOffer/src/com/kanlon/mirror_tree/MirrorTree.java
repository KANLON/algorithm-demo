package com.kanlon.mirror_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题19：请完成一个函数，输入一个二叉树，该函数输出它的镜像
 *
 * @author zhangcanlong
 * @date 2018年12月24日
 */
public class MirrorTree {
	public static void main(String[] args) {
		// 测试
		MirrorTree testTree = new MirrorTree();
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
		// testTree.mirrorRecursively(tree11);
		testTree.mirrorCircular(tree11);
		tree11.outTree();

		// 功能测试（只含有左结点）
		BinaryTree tree21 = new BinaryTree(8);
		BinaryTree tree22 = new BinaryTree(6);
		BinaryTree tree23 = new BinaryTree(10);
		BinaryTree tree24 = new BinaryTree(5);
		tree21.mPLeft = tree22;
		tree22.mPLeft = tree23;
		tree23.mPLeft = tree24;
		// testTree.mirrorRecursively(tree21);
		testTree.mirrorCircular(tree21);
		tree21.outTree();
		// 功能测试（只含有右结点）
		BinaryTree tree31 = new BinaryTree(8);
		BinaryTree tree32 = new BinaryTree(6);
		BinaryTree tree33 = new BinaryTree(10);
		BinaryTree tree34 = new BinaryTree(5);
		tree31.mPLeft = tree32;
		tree32.mPLeft = tree33;
		tree33.mPLeft = tree34;
		// testTree.mirrorRecursively(tree31);
		testTree.mirrorCircular(tree31);
		tree31.outTree();
		// 功能测试（只含有1个结点）
		BinaryTree tree41 = new BinaryTree(8);
		testTree.mirrorRecursively(tree41);
		tree41.outTree();
		// 特殊测试（null树）
		BinaryTree tree51 = null;
		// testTree.mirrorRecursively(tree51);
		testTree.mirrorCircular(tree51);
		// tree51.outTree();
	}

	/**
	 * 解题思路1（递归解法）：仔细观察和自己手动将一个二叉树转变成镜像二叉树时，我们会发现只要如果二叉树某结点下有左右结点，将其左右结点将交换就可以了。然后在其左右结点递归该方法就完成镜像转换了
	 *
	 * @param treeRoot
	 *            要交换树的根结点
	 */
	public void mirrorRecursively(BinaryTree treeRoot) {
		if (treeRoot == null) {
			return;
		}

		if (treeRoot.mPLeft != null || treeRoot.mPRight != null) {
			// 交换左右结点
			BinaryTree temp = new BinaryTree();
			temp = treeRoot.mPLeft;
			treeRoot.mPLeft = treeRoot.mPRight;
			treeRoot.mPRight = temp;
			// 递归交换左右结点
			if (treeRoot.mPLeft != null) {
				mirrorRecursively(treeRoot.mPLeft);
			}
			if (treeRoot.mPRight != null) {
				mirrorRecursively(treeRoot.mPRight);
			}
		}
	}

	/**
	 * 解题思路2（循环解法）：可以直接利用层次遍历中的方法，层次遍历方法有挺多，这个就不一一介绍了或者直接使用一种遍历二叉树的方法就可以了。具体看代码，在层次遍历中得到每个结点后，将他们的左右结点交换就可以了。
	 *
	 * @param treeRoot
	 *            要转化成镜像的二叉树跟结点
	 */
	public void mirrorCircular(BinaryTree treeRoot) {
		if (treeRoot == null) {
			return;
		}
		// 存放上一层的结点
		List<BinaryTree> list = new ArrayList<>();
		// 存放当前层的结点
		List<BinaryTree> nowNodeList = new ArrayList<>();
		list.add(treeRoot);
		// 表示遍历当前层的第几个结点
		int count = 1;
		while (count <= list.size()) {
			BinaryTree leftNodeTemp = list.get(count - 1).mPLeft;
			BinaryTree rightNodeTemp = list.get(count - 1).mPRight;
			if (leftNodeTemp != null || rightNodeTemp != null) {
				// 交换左右结点
				BinaryTree temp = new BinaryTree();
				temp = list.get(count - 1).mPLeft;
				list.get(count - 1).mPLeft = list.get(count - 1).mPRight;
				list.get(count - 1).mPRight = temp;
			}
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
			System.out.print(list.get(count - 1).mNValue);
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
