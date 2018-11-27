package com.kanlon.treenode;

import java.util.Arrays;

/**
 * 面试题6：根据给出的先序遍历和中序遍历，构造二叉树，输入二叉树的根节点
 *
 * @author zhangcanlong
 * @date 2018年9月26日
 */
public class ConstructBinaryTree {
	public static void main(String[] args) {
		// 1、测试用例（普通二叉树）
		int[] preOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inOrder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		// 2、测试用例（特殊二叉树 所有结点都没有右子结点的二叉树）
		// int[] preOrder = { 1, 2, 4 };
		// int[] inOrder = { 4, 2, 1 };
		// 3、测试用例（特殊二叉树 所有结点都没有左子结点的二叉树）
		// int[] preOrder = { 1, 3, 6 };
		// int[] inOrder = { 1, 3, 6 };
		// 4、测试用例（只有一个结点的二叉树）
		// int[] preOrder = { 1 };
		// int[] inOrder = { 1 };
		// 5、测试用例（二叉树的跟结点指针为null）
		// int[] preOrder = {};
		// int[] inOrder = {};
		// 6、测试用例（输入的前序遍历序列和中序遍历序列不匹配）
		// int[] preOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		// int[] inOrder = { 5, 3, 6, 8, 1, 4, 7, 2, };

		if (preOrder == null || inOrder == null || preOrder.length <= 0) {
			System.exit(0);
		}
		ConstructBinaryTree tree = new ConstructBinaryTree();
		BinaryTreeNode root = tree.constructCore(preOrder, inOrder, inOrder.length);
		// 在此处debug就可以看到root的结构
		System.out.println(root);
	}

	/**
	 * 解题思路：在函数ConstructCore中，我们先根据前序遍历的第一个数字创建跟节点，接下来在中序遍历序列中找到根节点的位置，
	 * 这样就能确定左、右子树结点的数量。在前序遍历和中序遍历的序列中划分了左、右子数结点的值之后，我们就可以递归地调用函数ConstructCore去分别构建他它的左右子树
	 *
	 * @return
	 */
	public BinaryTreeNode constructCore(int[] preOrder, int[] inOrder, int length) {

		// 判断输入的先序与中序遍历是否含有相同的元素
		if (!arrayEquals(preOrder, inOrder)) {
			throw new RuntimeException("输入的先序遍历和后序遍历不一致！！！");
		}
		// 如果没有元素时，递归结束
		if (preOrder == null || inOrder == null || length == 0) {
			return null;
		}
		BinaryTreeNode root = new BinaryTreeNode();
		root.m_nValue = preOrder[0];

		int leftNum = 0;
		int rightNum = 0;

		// 在中序遍历中找到根节点的值，确定左右子树的结点的数量
		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == preOrder[0]) {
				break;
			}
			leftNum++;
		}
		rightNum = inOrder.length - leftNum - 1;

		// 构建左子树
		if (leftNum > 0) {
			// 这里的copyOfRange方法是算前不算后
			int[] preOrderChild = Arrays.copyOfRange(preOrder, 1, leftNum + 1);
			int[] inOrderChild = Arrays.copyOfRange(inOrder, 0, leftNum);
			root.m_pLeft = constructCore(preOrderChild, inOrderChild, length);
		}
		// 构建右子树
		if (rightNum > 0) {
			// 这里的copyOfRange方法是算前不算后
			int[] preOrderChild = Arrays.copyOfRange(preOrder, leftNum + 1, preOrder.length);
			int[] inOrderChild = Arrays.copyOfRange(inOrder, leftNum + 1, inOrder.length);
			root.m_pRight = constructCore(preOrderChild, inOrderChild, length);
		}

		return root;
	}

	/**
	 * 判断两个数组中的所有元素是否相等，相等则返回true，不等则返回false
	 *
	 * @param firstInts
	 * @param secondInts
	 * @return
	 */
	public boolean arrayEquals(int[] firstInts, int[] secondInts) {
		if (firstInts == null && secondInts == null) {
			return true;
		}
		if (firstInts == null && (secondInts != null && secondInts.length > 0)) {
			return false;
		}
		if (secondInts == null && (firstInts != null && firstInts.length > 0)) {
			return false;
		}
		if (firstInts.length != secondInts.length) {
			return false;
		}
		int num = 0;
		// 首先对两个数组所有元素进行异或运算，不等于0，则返回，如果等于则进行排序后再比较
		for (int i = 0; i < firstInts.length; i++) {
			num ^= firstInts[i] ^ secondInts[i];
		}
		if (num != 0) {
			return false;
		}
		// 为了防止改变原来的数组
		int[] ints1 = Arrays.copyOf(firstInts, firstInts.length);
		int[] ints2 = Arrays.copyOf(secondInts, secondInts.length);
		Arrays.sort(ints1);
		Arrays.sort(ints2);
		for (int i = 0; i < ints1.length; i++) {
			if (ints1[i] != ints2[i]) {
				return false;
			}
		}
		return true;
	}

}

/**
 * 二叉树类
 *
 * @author zhangcanlong
 * @date 2018年9月27日
 */
class BinaryTreeNode {
	int m_nValue;
	BinaryTreeNode m_pLeft;
	BinaryTreeNode m_pRight;
}