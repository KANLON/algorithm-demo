package com.kanlon.kth_node_from_end;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题15：链表中倒数第k个结点的拓展题目
 * 拓展题目1：求链表的中间结点。如果链表中结点总数为奇数，则返回中间结点，如果结点总数是偶数，则返回中间两个结点的任意一个。
 * 拓展题目2：判断一个单项链表是否形成了环形结构。
 *
 *
 * @author zhangcanlong
 * @date 2018年10月15日
 */
public class KthNodeFromEndExt {

	public static void main(String[] args) {
		// 测试
		KthNodeFromEndExt test = new KthNodeFromEndExt();
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
		// 题目1
		List<ListNode> midNodeList = new ArrayList<>();
		// 功能测试 链表为偶数多个结点，1>2>3>4
		midNodeList.add(test.getMidNode(node1));
		// 功能测试 链表为奇数多个结点 2>3>4
		midNodeList.add(test.getMidNode(node2));
		// 特殊测试 链表为1个结点 4
		midNodeList.add(test.getMidNode(node4));
		// 特殊测试 链表为2个结点 3>4
		midNodeList.add(test.getMidNode(node3));
		// 测试测试 链表头结点为null
		midNodeList.add(test.getMidNode(null));
		for (ListNode midNode : midNodeList) {
			System.out.println(midNode);
		}
		System.out.println("===================");
		// 题目2
		// 功能测试 链表为有多个结点的非环
		System.out.println(test.isCircleList(node1));
		// 功能测试 链表为有多个结点的环
		node4.m_pNext = node1;
		System.out.println(test.isCircleList(node1));
		// 特殊测试 链表只有一个结点的非环
		ListNode circleNode1 = new ListNode();
		circleNode1.m_nvalue = 1;
		System.out.println(test.isCircleList(circleNode1));
		// 特殊测试 链表只有一个结点的环
		circleNode1.m_pNext = circleNode1;
		System.out.println(test.isCircleList(circleNode1));
		// 测试测试 链表为null
		System.out.println(test.isCircleList(null));

	}

	/**
	 * 求链表的中间结点的解题思路：定义两个指针，同时从链表的头结点出发，一个指针一次走一步，另一个指针一次走两步。当走得快的指针走到了链表末尾，则慢指针指向了中间元素
	 *
	 * @param head
	 *            要求的链表的头结点
	 * @return 返回该链表中间结点
	 */
	public ListNode getMidNode(ListNode head) {
		if (head == null || head.m_pNext == null) {
			return head;
		}
		ListNode fastNode = head;
		ListNode slowNode = head;
		while (fastNode.m_pNext != null) {
			fastNode = fastNode.m_pNext;
			if (fastNode.m_pNext != null) {
				fastNode = fastNode.m_pNext;
				slowNode = slowNode.m_pNext;
			}
		}
		return slowNode;
	}

	/**
	 * 判断单向链表是否形成环形结构的解题思路：定义两个指针，同时从链表的头结点出发，一个指针一次走一步，一个指针一次走两步，如果走得快的指针追上了走得慢的指针，那么这个链表就是环形链表。
	 * 如果走得快的指针到了链表的末尾（m_pNext指向null）都没有追上第一个指针，那么链表就不是环形链表.
	 * 注意：这里我选择了如果是null，也返回false
	 *
	 * @param head
	 *            要判断的单向链表的头结点
	 * @return 如果是环形，返回true，否则返回false
	 */
	public boolean isCircleList(ListNode head) {
		if (head == null || head.m_pNext == null) {
			return false;
		}
		ListNode fastNode = head;
		ListNode slowNode = head;
		while (fastNode.m_pNext != null) {
			fastNode = fastNode.m_pNext;
			if (fastNode.m_pNext != null) {
				fastNode = fastNode.m_pNext;
				slowNode = slowNode.m_pNext;
			}
			if (fastNode == slowNode) {
				return true;
			}
		}
		return false;
	}

}
