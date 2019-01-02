package com.kanlon.squence_of_bst;

/**
 * 面试题24：二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。<br/>
 *
 * @author zhangcanlong
 * @date 2019年1月2日
 */
public class SquenceOfBST {
	public static void main(String[] args) {
		SquenceOfBST test = new SquenceOfBST();
		// 功能测试1（有多个元素，能构成二叉搜索树）
		int[] ints1 = { 5, 7, 6, 9, 11, 10, 8 };
		System.out.println(test.vertifySquenceOfBST(ints1, 0, ints1.length - 1));
		// 功能测试2（有多个元素，不能构成二叉搜索树）
		int[] ints2 = { 7, 4, 6, 5 };
		System.out.println(test.vertifySquenceOfBST(ints2, 0, ints2.length - 1));
		// 特殊测试1（只有一个元素）
		int[] ints3 = { 5 };
		System.out.println(test.vertifySquenceOfBST(ints3, 0, ints3.length - 1));
		// 特殊测试2（空）
		System.out.println(test.vertifySquenceOfBST(null, 0, 0));
	}

	/**
	 * 判断某序列是否能构成二叉搜索树
	 * <p>
	 * 解题思路：因为序列是后根遍历，所以序列的最后一个元素是树的根结点，且前面小于根节点的并列元素是左子树的，大于根节点的并列元素是右子树的。
	 * 判断不满足构成二叉搜索树的条件是，在一堆左子树中有大于树根节点的元素，或者在一堆右子树中有小于根结点的元素。
	 *
	 * @param ints
	 *            要判断的序列
	 * @param start
	 *            开始元素下标（用于递归）
	 * @param last
	 *            结束元素下标（用于递归）
	 * @return
	 */
	public Boolean vertifySquenceOfBST(int[] ints, int start, int last) {
		if (ints == null || ints.length <= 1 || start == last) {
			return true;
		}
		// 树的根结点
		int rootNode = ints[last];
		// 判断左子树
		int leftIndex = 0;
		for (; leftIndex < last; leftIndex++) {
			if (ints[leftIndex] > rootNode) {
				break;
			}
		}

		// 判断右子树
		int rightIndex = leftIndex;
		for (; rightIndex < last; rightIndex++) {
			if (ints[rightIndex] < rootNode) {
				return false;
			}
		}
		// 递归判断子左子树是否满足二叉搜索树
		boolean left = true;
		if (leftIndex > 0) {
			left = vertifySquenceOfBST(ints, start, leftIndex - 1);
		}
		// 递归判断子右子树是否满足二叉搜索树
		boolean right = true;
		if (rightIndex < last) {
			right = vertifySquenceOfBST(ints, leftIndex, last - 1);
		}

		return left && right;
	}
}
