package com.kanlon.treenode;

import java.util.Arrays;

/**
 * ������6�����ݸ��������������������������������������������ĸ��ڵ�
 *
 * @author zhangcanlong
 * @date 2018��9��26��
 */
public class ConstructBinaryTree {
	public static void main(String[] args) {
		// 1��������������ͨ��������
		int[] preOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inOrder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		// 2��������������������� ���н�㶼û�����ӽ��Ķ�������
		// int[] preOrder = { 1, 2, 4 };
		// int[] inOrder = { 4, 2, 1 };
		// 3��������������������� ���н�㶼û�����ӽ��Ķ�������
		// int[] preOrder = { 1, 3, 6 };
		// int[] inOrder = { 1, 3, 6 };
		// 4������������ֻ��һ�����Ķ�������
		// int[] preOrder = { 1 };
		// int[] inOrder = { 1 };
		// 5�������������������ĸ����ָ��Ϊnull��
		// int[] preOrder = {};
		// int[] inOrder = {};
		// 6�����������������ǰ��������к�����������в�ƥ�䣩
		// int[] preOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		// int[] inOrder = { 5, 3, 6, 8, 1, 4, 7, 2, };

		if (preOrder == null || inOrder == null || preOrder.length <= 0) {
			System.exit(0);
		}
		ConstructBinaryTree tree = new ConstructBinaryTree();
		BinaryTreeNode root = tree.constructCore(preOrder, inOrder, inOrder.length);
		// �ڴ˴�debug�Ϳ��Կ���root�Ľṹ
		System.out.println(root);
	}

	/**
	 * ����˼·���ں���ConstructCore�У������ȸ���ǰ������ĵ�һ�����ִ������ڵ㣬����������������������ҵ����ڵ��λ�ã�
	 * ��������ȷ����������������������ǰ���������������������л�����������������ֵ֮�����ǾͿ��Եݹ�ص��ú���ConstructCoreȥ�ֱ𹹽���������������
	 *
	 * @return
	 */
	public BinaryTreeNode constructCore(int[] preOrder, int[] inOrder, int length) {

		// �ж��������������������Ƿ�����ͬ��Ԫ��
		if (!arrayEquals(preOrder, inOrder)) {
			throw new RuntimeException("�������������ͺ��������һ�£�����");
		}
		// ���û��Ԫ��ʱ���ݹ����
		if (preOrder == null || inOrder == null || length == 0) {
			return null;
		}
		BinaryTreeNode root = new BinaryTreeNode();
		root.m_nValue = preOrder[0];

		int leftNum = 0;
		int rightNum = 0;

		// ������������ҵ����ڵ��ֵ��ȷ�����������Ľ�������
		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == preOrder[0]) {
				break;
			}
			leftNum++;
		}
		rightNum = inOrder.length - leftNum - 1;

		// ����������
		if (leftNum > 0) {
			// �����copyOfRange��������ǰ�����
			int[] preOrderChild = Arrays.copyOfRange(preOrder, 1, leftNum + 1);
			int[] inOrderChild = Arrays.copyOfRange(inOrder, 0, leftNum);
			root.m_pLeft = constructCore(preOrderChild, inOrderChild, length);
		}
		// ����������
		if (rightNum > 0) {
			// �����copyOfRange��������ǰ�����
			int[] preOrderChild = Arrays.copyOfRange(preOrder, leftNum + 1, preOrder.length);
			int[] inOrderChild = Arrays.copyOfRange(inOrder, leftNum + 1, inOrder.length);
			root.m_pRight = constructCore(preOrderChild, inOrderChild, length);
		}

		return root;
	}

	/**
	 * �ж����������е�����Ԫ���Ƿ���ȣ�����򷵻�true�������򷵻�false
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
		// ���ȶ�������������Ԫ�ؽ���������㣬������0���򷵻أ�������������������ٱȽ�
		for (int i = 0; i < firstInts.length; i++) {
			num ^= firstInts[i] ^ secondInts[i];
		}
		if (num != 0) {
			return false;
		}
		// Ϊ�˷�ֹ�ı�ԭ��������
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
 * ��������
 *
 * @author zhangcanlong
 * @date 2018��9��27��
 */
class BinaryTreeNode {
	int m_nValue;
	BinaryTreeNode m_pLeft;
	BinaryTreeNode m_pRight;
}
