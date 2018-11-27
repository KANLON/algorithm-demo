package com.kanlon.deletenode;

/**
 * 面试题13：在O(1)时间删除链表结点
 * <p>
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。链表结点与函数的定义如下：
 *
 * @author zhangcanlong
 * @date 2018年10月8日
 */
public class DeleteNodeInList {
	public static void main(String[] args) {
		DeleteNodeInList test = new DeleteNodeInList();
		// 定义多个结点的链表
		ListNode listNode1 = new ListNode();
		ListNode listNode2 = new ListNode();
		ListNode listNode3 = new ListNode();
		ListNode listNode4 = new ListNode();
		listNode1.m_nValue = 1;
		listNode2.m_nValue = 2;
		listNode3.m_nValue = 3;
		listNode4.m_nValue = 4;
		listNode1.m_pNext = listNode2;
		listNode2.m_pNext = listNode3;
		listNode3.m_pNext = listNode4;

		// 定义只有一个结点的链表
		ListNode listNode5 = new ListNode();
		listNode5.m_nValue = 5;

		// 在这里开始debug
		// 功能测试（从多个结点的链表的中间删除一个结点）
		test.deleteNode(listNode1, listNode2);
		test.outNode(listNode1);

		// 从有多个结点的链表中删除头结点
		test.deleteNode(listNode1, listNode1);
		test.outNode(listNode1);

		// 从有多一个链表中的删除尾结点
		test.deleteNode(listNode1, listNode4);
		test.outNode(listNode1);

		// 从只有一个结点的链表中删除唯一的结点
		listNode5 = test.deleteNode(listNode5, listNode5);
		test.outNode(listNode5);

		// 特殊输入测试（指定链表的头结点指针为null指针，指向要删除的结点为null指针）
		test.deleteNode(null, null);

	}

	/**
	 * 解题思路：如果需要O(1)，则不能通过遍历找到该节点的前节点后，再删除该结点，因为这样的时间复杂度会是O(n)。
	 * 可行的方法应该是将要删除的节点的下一个结点的值赋值为要删除的节点，然后将该下一个结点指向下下个结点，从而达到删除的效果。
	 * <p>
	 * 注意：1.考虑到要删除的结点可能位于链表的尾部或输入的链表只有一个结点的特殊情况。
	 * 2.还有如果不考虑时间复杂度情况下，最好要考一下要删除的结点是否存在链表中
	 *
	 * @param pListHead
	 *            要删除结点的链表头
	 * @param pToBeDeleted
	 *            要删除的节点
	 */
	public ListNode deleteNode(ListNode pListHead, ListNode pToBeDeleted) {
		// 如果两者之一为null，则直接返回
		if (pListHead == null || pToBeDeleted == null) {
			return null;
		}
		// 如果要删除的结点不是尾结点
		if (pToBeDeleted.m_pNext != null) {
			pToBeDeleted.m_nValue = pToBeDeleted.m_pNext.m_nValue;
			pToBeDeleted.m_pNext = pToBeDeleted.m_pNext.m_pNext;
			// 如果链表只有一个结点
		} else if (pListHead == pToBeDeleted) {
			// 因为java是值传递，直接复制pListHead=null是不起作用
			pListHead.m_nValue = null;
		}
		// 链表中有多个结点，并且删除的是尾结点（则需要顺序查找其前一个结点删除）
		else {
			ListNode node = pListHead;
			while (node.m_pNext != pToBeDeleted) {
				node = node.m_pNext;
			}
			node.m_pNext = null;
		}
		// 需要增加返回链表头结点，不然在链表只有一个结点时，无法返回null的值
		return pListHead;
	}

	/**
	 * 输入链表的值
	 *
	 * @param node
	 *            链表的头结点
	 */
	public void outNode(ListNode node) {
		if (node == null) {
			System.out.println("链表为null");
			return;
		}
		ListNode tempNode = node;
		while (tempNode != null) {
			System.out.print(tempNode.m_nValue + " ");
			tempNode = tempNode.m_pNext;
		}
		System.out.println();
	}
}

class ListNode {
	Integer m_nValue;
	ListNode m_pNext;
}