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
		// 功能测试（第k个结点在链表中间）
		ListNode nodeMethod11 = test.printKthToTail(node1, 2);
		ListNode nodeMethod21 = test.printKthToTail2(node1, 2);
		// 功能测试（第k个结点是链表头结点）
		ListNode nodeMethod12 = test.printKthToTail(node1, 4);
		ListNode nodeMethod22 = test.printKthToTail2(node1, 4);
		// 功能测试（第k个结点是链表尾结点）
		ListNode nodeMethod13 = test.printKthToTail(node1, 1);
		ListNode nodeMethod23 = test.printKthToTail2(node1, 1);

		// 特殊输入测试（链表总数少于k）
		ListNode nodeMethod15 = test.printKthToTail(node1, 6);
		ListNode nodeMethod25 = test.printKthToTail2(node1, 6);

		System.out.println("第k个结点在链表中间--" + nodeMethod11.m_nvalue);
		System.out.println("第k个结点在链表中间--" + nodeMethod21.m_nvalue);
		System.out.println("第k个结点是链表头结点--" + nodeMethod12.m_nvalue);
		System.out.println("第k个结点是链表头结点--" + nodeMethod22.m_nvalue);
		System.out.println("第k个结点是链表尾结点--" + nodeMethod13.m_nvalue);
		System.out.println("第k个结点是链表尾结点--" + nodeMethod23.m_nvalue);
		System.out.println("链表总数少于k--" + nodeMethod15.m_nvalue);
		System.out.println("链表总数少于k--" + nodeMethod25.m_nvalue);
		// 由于这两个特殊测试会报异常，所以放在这里单独执行
		// 特殊输入测试（链表头结点为null指针）
		ListNode nodeMethod14 = test.printKthToTail(null, 6);
		ListNode nodeMethod24 = test.printKthToTail2(null, 6);
		// 特殊输入测试（k小于等于0）
		ListNode nodeMethod16 = test.printKthToTail(node1, 0);
		ListNode nodeMethod26 = test.printKthToTail2(node1, 0);
		System.out.println("链表头结点为null指针--" + nodeMethod14.m_nvalue);
		System.out.println("链表头结点为null指针--" + nodeMethod24.m_nvalue);
		System.out.println("k小于等于0--" + nodeMethod16.m_nvalue);
		System.out.println("k小于等于0--" + nodeMethod26.m_nvalue);

	}

	/**
	 * 解题思路1：先统计出所有链表的长度，然后用该长度减去k+1，得到倒数第k个结点，顺序的位置，然后再顺序遍历
	 * 注意：如果k大于length，则对k等于k mod length，另外如果取模后的值等于0，则k=length
	 *
	 * @param head
	 *            要打印的链表
	 * @param k
	 *            倒数第几个结点
	 * @return 倒数的该结点
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
		if (k == 0) {
			k = length;
		}
		// 23 323 434 43
		int num = length - k + 1;
		ListNode temp2 = head;
		while (temp2.m_pNext != null && num > 1) {
			num--;
			temp2 = temp2.m_pNext;
		}
		return temp2;
	}

	/**
	 * 解题思路2：定义两个指针都指向首结点，第二个指针先向前移动k-1位，然后第一个指针和第二个指针同时开始向前移动，知道第二个指针移动到尾结点，则第一个指针所指向的元素就是倒数第k个结点
	 * 注意：这里由于着重于考虑只遍历一次链表，所以如果k大于length，则返回首结点
	 *
	 * @param head
	 *            要打印的链表
	 * @param k
	 *            倒数第几个结点
	 * @return 倒数的该结点
	 */
	public ListNode printKthToTail2(ListNode head, int k) {
		if (head == null || head.m_pNext == null) {
			return head;
		}
		if (k <= 0) {
			throw new RuntimeException("k不能小于等于0");
		}

		ListNode node1 = head;
		ListNode node2 = head;
		// 表示当前的结点数
		int index = 0;
		while (node2.m_pNext != null) {
			if (index < k - 1) {
				node2 = node2.m_pNext;
				index++;
			} else {
				node1 = node1.m_pNext;
				node2 = node2.m_pNext;
			}
		}
		return node1;
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
		return "m_nvale:" + m_nvalue;
	}
}