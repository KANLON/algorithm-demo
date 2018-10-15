package com.kanlon.kth_node_from_end;

/**
 * 面试题15：链表中倒数第k个结点
 * 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点时倒数第1个结点。
 * 例如一个链表有6个结点，从头结点开始它们的值依次是1、2、3、4、5、6这个链表的倒数第3个结点是值为4的结点。
 *
 * @author zhangcanlong
 * @date 2018年10月15日
 */
public class KthNodeFromEnd {

	public static void main(String[] args) {
		KthNodeFromEnd test = new KthNodeFromEnd();
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
		ListNode node = test.printKthToTail(node1, 2);
		System.out.println(node.m_nvalue);

	}

	/**
	 * 解题思路1：先统计出所有链表的长度，然后用该长度减去k+1，得到倒数第k个结点，顺序的位置，然后再顺序遍历
	 *
	 * @param head
	 * @param k
	 */
	public ListNode printKthToTail(ListNode head, int k) {
		if (head == null || head.m_pNext == null) {
			return head;
		}
		if (k <= 0) {
			throw new RuntimeException("k不能小于等于0");
		}
		// 遍历得到长度
		int length = 1;
		ListNode temp1 = head;
		while (temp1.m_pNext != null) {
			length++;
			temp1 = temp1.m_pNext;
		}
		// 将k对length取余
		k = k % length;
		// 23 323 434 43
		int num = length - k + 1;
		ListNode temp2 = head;
		while (temp2.m_pNext != null && num > 1) {
			num--;
			temp2 = temp2.m_pNext;
		}
		return temp2;
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
}
