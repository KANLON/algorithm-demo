package com.kanlon.listnode;

import java.util.Stack;

/**
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。<br/>
 * 链表的结点定义如下： class ListNode { int mNKey; ListNode mPNext; }
 *
 * @author zhangcanlong
 * @date 2018年9月24日
 */
public class PrintListNode {
	public static void main(String[] args) {
		PrintListNode node = new PrintListNode();
		// 定义测试链表
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
		// 输入链表有多个结点
		node.PrintListNodeReversinglyStack(listNode1);
		node.PrintListNodeReversinglyRecursion(listNode1);
		// 输入链表只有一个结点
		node.PrintListNodeReversinglyStack(listNode4);
		node.PrintListNodeReversinglyRecursion(listNode4);
		// 输入链表头结点为空
		node.PrintListNodeReversinglyStack(null);
		node.PrintListNodeReversinglyRecursion(null);
	}

	/**
	 * 翻转打印链表（栈方式实现）
	 *
	 * @param listNode
	 */
	public void PrintListNodeReversinglyStack(ListNode listNode) {
		if (listNode == null) {
			System.out.println("该链表为空！");
			return;
		}

		Stack<ListNode> stack = new Stack<>();
		stack.push(listNode);
		while (listNode.mPNext != null) {
			listNode = listNode.mPNext;
			stack.push(listNode);
		}
		System.out.println("翻转后的链表为（栈方式）：");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().mNKey + "\n");
		}
	}

	/**
	 * 翻转打印链表（递归方式）
	 *
	 * @param listNode
	 */
	public void PrintListNodeReversinglyRecursion(ListNode listNode) {
		if (listNode == null) {
			System.out.println("递归方式实现翻转打印出链表：");
			return;
		}
		PrintListNodeReversinglyRecursion(listNode.mPNext);
		System.out.print(listNode.mNKey + "\n");
	}
}

// 结点类
class ListNode {
	int mNKey;
	ListNode mPNext;

}