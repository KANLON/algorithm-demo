package com.kanlon.sub_tree;

/**
 * 面试题18：树的子结构 题目：输入两颗二叉树A和B，判断B是不是A的子结构。
 *
 * @author zhangcanlong
 * @date 2018年12月23日
 */
public class DecideTreeNode {
	public static void main(String[] args) {
		// 测试
		DecideTreeNode subTree = new DecideTreeNode();
		// 功能测试，树A和树B都是普通二叉树，树B是或者不是树A的子结构
		BinaryTree tree11 = new BinaryTree(8);
		BinaryTree tree12 = new BinaryTree(8);
		BinaryTree tree13 = new BinaryTree(7);
		BinaryTree tree14 = new BinaryTree(9);
		BinaryTree tree15 = new BinaryTree(2);
		BinaryTree tree16 = new BinaryTree(4);
		BinaryTree tree17 = new BinaryTree(7);
		tree11.mPLeft = tree12;
		tree11.mPRight = tree13;
		tree12.mPLeft = tree14;
		tree12.mPRight = tree15;
		tree15.mPLeft = tree16;
		tree16.mPRight = tree17;

		BinaryTree tree21 = new BinaryTree(8);
		BinaryTree tree22 = new BinaryTree(9);
		BinaryTree tree23 = new BinaryTree(2);
		tree21.mPLeft = tree22;
		tree21.mPRight = tree23;
		System.out.println("功能测试：" + subTree.hasSubTree(tree11, tree21));
		// 特殊输入测试，两颗二叉树的一个或者两个根结点为null指针，二叉树的所有结点都没有左子树或者右子树
		System.out.println("两颗二叉树的一个为null指针" + subTree.hasSubTree(null, tree21));
		System.out.println("两颗二叉树的一个为null指针" + subTree.hasSubTree(tree11, null));
		System.out.println("两颗二叉树的都为null指针" + subTree.hasSubTree(null, null));

		BinaryTree tree31 = new BinaryTree(8);
		BinaryTree tree32 = new BinaryTree(8);
		BinaryTree tree33 = new BinaryTree(7);
		BinaryTree tree34 = new BinaryTree(9);
		BinaryTree tree35 = new BinaryTree(2);
		BinaryTree tree36 = new BinaryTree(4);
		BinaryTree tree37 = new BinaryTree(7);
		tree31.mPLeft = tree32;
		tree32.mPLeft = tree33;
		tree33.mPLeft = tree34;
		tree34.mPLeft = tree35;
		tree35.mPLeft = tree36;
		tree36.mPLeft = tree37;

		BinaryTree tree41 = new BinaryTree(7);
		BinaryTree tree42 = new BinaryTree(9);
		BinaryTree tree43 = new BinaryTree(3);
		tree41.mPLeft = tree42;
		tree42.mPLeft = tree43;

		System.out.println("二叉树所有结点都没有右子树：" + subTree.hasSubTree(tree31, tree41));
	}

	/**
	 * 解题思路：利用递归判断，先在判断树1是否还有结点，如果还有结点，则先判断该结点是否与子树2的当前结点值相同，如果相同则继续在另一个方法（专门递归判断所有结点是否相等）递归判断左右结点是否相同。
	 * 如果左右结点相同则继续递归判断。如果当前根结点与树2的当前根结点值不相同，则继续拿树2的根分别与树1的左结点和右结点做递归判断。
	 * 最后当树1或则树2为null时，则返回结果。
	 *
	 * @param tree1
	 *            树1
	 * @param tree2
	 *            树2
	 * @return 树1是否含有树2的子树的结果，true，则表示含有。false则表示不含有
	 */
	public boolean hasSubTree(BinaryTree tree1Root, BinaryTree tree2Root) {
		/**
		 * 标志是否含有子树的状态结果
		 */
		boolean result = false;
		if (tree1Root != null && tree2Root != null) {

			if (tree1Root.mNValue == tree2Root.mNValue) {
				result = DoesTree1HaveTree2(tree1Root, tree2Root);
			}
			if (!result) {
				result = hasSubTree(tree1Root.mPLeft, tree2Root);
			}
			if (!result) {
				result = hasSubTree(tree1Root.mPRight, tree2Root);
			}
		}
		return result;
	}

	/**
	 * 判断树1和树2是否一样，树1可以比树2多，但前面的结点必须和树2一样，否则返回false
	 *
	 * @param tree1Root
	 * @param tree2Root
	 * @return
	 */
	public boolean DoesTree1HaveTree2(BinaryTree tree1Root, BinaryTree tree2Root) {
		// 如果树2先为null，则表示树2与树1全部相同
		if (tree2Root == null) {
			return true;
		}
		// 如果树1先空，则表示还有树2有的，树1没有，所有返回false
		if (tree1Root == null) {
			return false;
		}

		if (tree1Root.mNValue != tree2Root.mNValue) {
			return false;
		}

		return DoesTree1HaveTree2(tree1Root.mPLeft, tree2Root.mPLeft)
				&& DoesTree1HaveTree2(tree1Root.mPRight, tree2Root.mPRight);
	}

}

/**
 * 二叉树的类
 *
 * @author zhangcanlong
 * @date 2018年12月23日
 */
class BinaryTree {
	public BinaryTree(int value) {
		mNValue = value;
	}

	int mNValue;
	BinaryTree mPLeft;
	BinaryTree mPRight;
}
