package com.kanlon.listnode;

import java.util.Stack;

/**
 * ��Ŀ������һ�������ͷ��㣬��β��ͷ��������ӡ��ÿ������ֵ��<br/>
 * ����Ľ�㶨�����£� class ListNode { int mNKey; ListNode mPNext; }
 *
 * @author zhangcanlong
 * @date 2018��9��24��
 */
public class PrintListNode {
	public static void main(String[] args) {
		PrintListNode node = new PrintListNode();
		// �����������
		ListNode listNode1 = new ListNode();
		listNode1.mNKey = 1;
		ListNode listNode2 = new ListNode();
		listNode2.mNKey = 2;
		ListNode listNode3 = new ListNode();
		listNode3.mNKey = 3;
		ListNode listNode4 = new ListNode();
		listNode4.mNKey = 4;

		listNode1.mPNext = listNode2;
		listNode2.mPNext = listNode3;
		listNode3.mPNext = listNode4;
		// ���������ж�����
		node.PrintListNodeReversinglyStack(listNode1);
		node.PrintListNodeReversinglyRecursion(listNode1);
		// ��������ֻ��һ�����
		node.PrintListNodeReversinglyStack(listNode4);
		node.PrintListNodeReversinglyRecursion(listNode4);
		// ��������ͷ���Ϊ��
		node.PrintListNodeReversinglyStack(null);
		node.PrintListNodeReversinglyRecursion(null);
	}

	/**
	 * ��ת��ӡ����ջ��ʽʵ�֣�
	 *
	 * @param listNode
	 */
	public void PrintListNodeReversinglyStack(ListNode listNode) {
		if (listNode == null) {
			System.out.println("������Ϊ�գ�");
			return;
		}

		Stack<ListNode> stack = new Stack<>();
		stack.push(listNode);
		while (listNode.mPNext != null) {
			listNode = listNode.mPNext;
			stack.push(listNode);
		}
		System.out.println("��ת�������Ϊ��ջ��ʽ����");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().mNKey + "\n");
		}
	}

	/**
	 * ��ת��ӡ�����ݹ鷽ʽ��
	 *
	 * @param listNode
	 */
	public void PrintListNodeReversinglyRecursion(ListNode listNode) {
		if (listNode == null) {
			System.out.println("�ݹ鷽ʽʵ�ַ�ת��ӡ������");
			return;
		}
		PrintListNodeReversinglyRecursion(listNode.mPNext);
		System.out.print(listNode.mNKey + "\n");
	}
}

// �����
class ListNode {
	int mNKey;
	ListNode mPNext;

}