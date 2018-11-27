package com.kanlon.reverse_list;

import java.util.Stack;

/**
 * 面试题16：反转链表
 * <p>
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 *
 * @author zhangcanlong
 * @date 2018年10月24日
 */
public class ReverseList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode();
		ListNode node2 = new ListNode();
		ListNode node3 = new ListNode();
		ListNode node4 = new ListNode();
		node1.m_nvalue = 1;
		node2.m_nvalue = 2;
		node3.m_nvalue = 3;
		node4.m_nvalue = 4;
		node1.m_pNext = node2;
		node2.m_pNext = node3;
		node3.m_pNext = node4;
		// 测试
		ReverseList test = new ReverseList();
		System.out.println(node1);
		// 功能测试（输入的链表有多个链表）
		// System.out.println("方法一：" + test.reverseList(node1));
		// System.out.println("方法二：" + test.reverseList2(node1));
		// 特殊测试（输入的链表的只有一个结点）
		// System.out.println("方法一：" + test.reverseList(node4));
		// System.out.println("方法二：" + test.reverseList2(node4));
		// 特殊测试（输入得到链表指针是null）
		// System.out.println("方法一：" + test.reverseList(null));
		// System.out.println("方法二：" + test.reverseList2(null));

	}

	/**
	 * 解题思路1（不太好）：将链表依次放入栈中，然后再将其弹出，将其连接到下一个弹出的结点
	 *
	 * @param head
	 *            要反转的链表的头结点
	 * @return 返回返回反转的后的链表的头结点
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.m_pNext == null) {
			return head;
		}
		Stack<ListNode> stack = new Stack<>();
		ListNode tempNode = head;
		while (tempNode != null) {
			stack.push(tempNode);
			tempNode = tempNode.m_pNext;
		}
		tempNode = stack.pop();
		ListNode reverseHead = tempNode;
		while (!stack.isEmpty()) {
			ListNode node = stack.pop();
			tempNode.m_pNext = node;
			tempNode = node;
		}
		tempNode.m_pNext = null;
		return reverseHead;
	}

	/**
	 * 解题思路2（推荐）：直接遍历链表一遍，将当前遍历的结点，指向上一个结点（之所以要指向上一个结点，不是下个结点指向当前结点，是因为下个结点要留着做遍历），直到当前结点为null，需要使用一个临时结点存储上一个结点，不然会操成链表断裂
	 *
	 * @param head
	 *            要反转的链表的头结点
	 * @return 返回反转后的链表的头的结点
	 */
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.m_pNext == null) {
			return head;
		}
		// 用来保存反转后的链表的头结点
		ListNode reverseHead = head;
		// 用于遍历
		ListNode tempNode = head;
		// 用于保存上一个结点
		ListNode preNode = null;
		while (tempNode != null) {
			// 存储下一个结点
			ListNode pNext = tempNode.m_pNext;
			if (tempNode.m_pNext == null) {
				reverseHead = tempNode;
			}
			// 指向前一个结点，使得链表断裂，所以上面存储的结点，就可以继续遍历
			tempNode.m_pNext = preNode;
			preNode = tempNode;
			tempNode = pNext;
		}
		return reverseHead;
	}
}

/**
 * 自定义的链表类
 *
 * @author zhangcanlong
 * @date 2018年10月15日
 */
class ListNode {
	int m_nvalue;
	ListNode m_pNext;

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("m_nvale:" + m_nvalue);
		ListNode tempNode = m_pNext;
		// 这个toString不能用于循环链表
		while (tempNode != null) {
			buffer.append("->" + tempNode.m_nvalue);
			tempNode = tempNode.m_pNext;
		}
		return buffer.toString();
	}
}