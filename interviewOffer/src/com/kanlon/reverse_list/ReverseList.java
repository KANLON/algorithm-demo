package com.kanlon.reverse_list;

import java.util.Stack;

/**
 * ������16����ת����
 * <p>
 * ����һ������������һ�������ͷ��㣬��ת�����������ת�������ͷ��㡣
 *
 * @author zhangcanlong
 * @date 2018��10��24��
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
		// ����
		ReverseList test = new ReverseList();
		System.out.println(node1);
		// ���ܲ��ԣ�����������ж������
		// System.out.println("����һ��" + test.reverseList(node1));
		// System.out.println("��������" + test.reverseList2(node1));
		// ������ԣ�����������ֻ��һ����㣩
		// System.out.println("����һ��" + test.reverseList(node4));
		// System.out.println("��������" + test.reverseList2(node4));
		// ������ԣ�����õ�����ָ����null��
		// System.out.println("����һ��" + test.reverseList(null));
		// System.out.println("��������" + test.reverseList2(null));

	}

	/**
	 * ����˼·1����̫�ã������������η���ջ�У�Ȼ���ٽ��䵯�����������ӵ���һ�������Ľ��
	 *
	 * @param head
	 *            Ҫ��ת�������ͷ���
	 * @return ���ط��ط�ת�ĺ�������ͷ���
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
	 * ����˼·2���Ƽ�����ֱ�ӱ�������һ�飬����ǰ�����Ľ�㣬ָ����һ����㣨֮����Ҫָ����һ����㣬�����¸����ָ��ǰ��㣬����Ϊ�¸����Ҫ��������������ֱ����ǰ���Ϊnull����Ҫʹ��һ����ʱ���洢��һ����㣬��Ȼ��ٳ��������
	 *
	 * @param head
	 *            Ҫ��ת�������ͷ���
	 * @return ���ط�ת��������ͷ�Ľ��
	 */
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.m_pNext == null) {
			return head;
		}
		// �������淴ת��������ͷ���
		ListNode reverseHead = head;
		// ���ڱ���
		ListNode tempNode = head;
		// ���ڱ�����һ�����
		ListNode preNode = null;
		while (tempNode != null) {
			// �洢��һ�����
			ListNode pNext = tempNode.m_pNext;
			if (tempNode.m_pNext == null) {
				reverseHead = tempNode;
			}
			// ָ��ǰһ����㣬ʹ��������ѣ���������洢�Ľ�㣬�Ϳ��Լ�������
			tempNode.m_pNext = preNode;
			preNode = tempNode;
			tempNode = pNext;
		}
		return reverseHead;
	}
}

/**
 * �Զ����������
 *
 * @author zhangcanlong
 * @date 2018��10��15��
 */
class ListNode {
	int m_nvalue;
	ListNode m_pNext;

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("m_nvale:" + m_nvalue);
		ListNode tempNode = m_pNext;
		// ���toString��������ѭ������
		while (tempNode != null) {
			buffer.append("->" + tempNode.m_nvalue);
			tempNode = tempNode.m_pNext;
		}
		return buffer.toString();
	}
}
