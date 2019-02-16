package com.kanlon.first_common_nodes_in_lists;

import java.util.Stack;

/**
 * 面试题37：两个链表的第一个公共结点
 *
 * 题目：输入两个链表，找出它们的第一个公共结点（这里假设两个链表都是单链表和第一个公共结点之后的结点都一样,如果还要混合其他形式，则只有暴力两次遍历）。链表结点定义如下：
 *
 * @author zhangcanlong
 * @since 2019年2月14日
 */
public class FirstCommonNodesInLists {
	public static void main(String[] args) {
		FirstCommonNodesInLists test = new FirstCommonNodesInLists();
		// 功能测试1（两个链表长度不同且有多个结点，多个重复结点）
		ListNode node7 = new ListNode(7, null);
		ListNode node6 = new ListNode(6, node7);
		ListNode node5 = new ListNode(5, node6);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node6);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);
		System.out.println("功能测试一（方法一）：" + test.findFirstCommonNodeInListsBySkipBefore(node1, node4));
		System.out.println("功能测试一（方法二）：" + test.findFirstCommonNodeInListsByStack(node1, node4));
		// 功能测试2（两个链表长度相同，且有多个结点，多个重复结点）
		System.out.println(
				"功能测试2（两个链表长度相同，且有多个结点，多个重复结点）（方法一）：" + test.findFirstCommonNodeInListsBySkipBefore(node2, node4));
		System.out
				.println("功能测试2（两个链表长度相同，且有多个结点，多个重复结点）（方法二）：" + test.findFirstCommonNodeInListsByStack(node2, node4));

		// 功能测试3（都是相同的链表）
		System.out.println("功能测试3（都是相同的链表）（方法一）：" + test.findFirstCommonNodeInListsBySkipBefore(node6, node6));
		System.out.println("功能测试3（都是相同的链表）（方法二）：" + test.findFirstCommonNodeInListsByStack(node6, node6));

		// 功能测试4（只有一个结点，不同结点）
		ListNode node8 = new ListNode(8, null);
		System.out.println("功能测试4（只有一个结点，不同结点）（方法一）：" + test.findFirstCommonNodeInListsBySkipBefore(node7, node8));
		System.out.println("功能测试4（只有一个结点，不同结点）（方法二）：" + test.findFirstCommonNodeInListsByStack(node7, node8));

		// 特殊测试1（null）
		System.out.println("特殊测试1（null）（方法一）：" + test.findFirstCommonNodeInListsBySkipBefore(node6, null));
		System.out.println("特殊测试1（null）（方法二）：" + test.findFirstCommonNodeInListsByStack(null, node6));

	}

	/**
	 * 找出两个链表公共的结点，解题思路1（推荐）：由于两个链表不一定同长度，而他们第一个公共结点后，都是相连的，长度相同，因此可以先让长的链表先走几步，然后两个链表一起遍历，直到结点相同，则是第一个公共结点
	 *
	 * @param head1
	 *            要查找的链表1
	 * @param head2
	 *            要查找的链表2
	 * @return 返回两个链表的公共结点
	 */
	public ListNode findFirstCommonNodeInListsBySkipBefore(ListNode head1, ListNode head2) {
		// 只要有一方为空，则返回null
		if (head1 == null || head2 == null) {
			return null;
		}
		// 遍历两个链表得到它们的长度
		int list1Length = 0;
		int list2Length = 0;
		ListNode tempList1 = head1;
		ListNode tempList2 = head2;
		while (tempList1 != null) {
			list1Length++;
			tempList1 = tempList1.mPNext;
		}
		while (tempList2 != null) {
			list2Length++;
			tempList2 = tempList2.mPNext;
		}

		// 让长的链表走到和短的链表一样长
		tempList1 = head1;
		tempList2 = head2;
		int beforeLength = Math.abs(list1Length - list2Length);
		if (list1Length > list2Length) {
			while (beforeLength > 0) {
				tempList1 = tempList1.mPNext;
				beforeLength--;
			}
		} else {
			while (beforeLength > 0) {
				tempList2 = tempList2.mPNext;
				beforeLength--;
			}
		}

		// 同时遍历知道结点相同
		while (tempList1 != tempList2 && tempList1 != null) {
			tempList1 = tempList1.mPNext;
			tempList2 = tempList2.mPNext;
		}
		return tempList1 == null ? null : tempList1;
	}

	/**
	 * 找出两个链表公共的结点，解题思路2：可以通过利用栈将两个链表从后面开始倒序遍历，遍历出栈到不相等的结点的前一个就是第一个公共结点
	 *
	 * @param head1
	 *            要查找的链表1
	 * @param head2
	 *            要查找的链表2
	 * @return 返回两个链表的公共结点
	 */
	public ListNode findFirstCommonNodeInListsByStack(ListNode head1, ListNode head2) {
		// 只要有一方为空，则返回null
		if (head1 == null || head2 == null) {
			return null;
		}
		Stack<ListNode> stack1 = new Stack<>();
		Stack<ListNode> stack2 = new Stack<>();
		// 遍历结点到最后,并存放在栈中
		ListNode tempNode1 = head1;
		ListNode tempNode2 = head2;
		stack1.push(tempNode1);
		stack2.push(tempNode2);
		while (tempNode1.mPNext != null) {
			tempNode1 = tempNode1.mPNext;
			stack1.push(tempNode1);
		}
		while (tempNode2.mPNext != null) {
			tempNode2 = tempNode2.mPNext;
			stack2.push(tempNode2);
		}

		// 从结尾开始往回遍历，相当于出栈
		ListNode beforeNode = null;
		while (stack1.size() > 0 && stack2.size() > 0) {
			if (stack1.peek() != stack2.peek()) {
				return beforeNode;
			} else {
				beforeNode = stack1.pop();
				stack2.pop();
			}
		}

		return beforeNode;
	}

}

/**
 * 定义的链表
 *
 * @author zhangcanlong
 * @since 2019年2月15日
 */
class ListNode {
	int mNKey;
	ListNode mPNext;

	public ListNode() {
	}

	public ListNode(int mNKey, ListNode mPNext) {
		this.mNKey = mNKey;
		this.mPNext = mPNext;
	}

	@Override
	public String toString() {

		return (mNKey + "");
	}
}
