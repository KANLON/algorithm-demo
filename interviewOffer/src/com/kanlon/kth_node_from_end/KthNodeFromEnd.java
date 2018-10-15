package com.kanlon.kth_node_from_end;

/**
 * ������15�������е�����k�����
 * ��Ŀ������һ����������������е�����k����㡣Ϊ�˷��ϴ�����˵�ϰ�ߣ������1��ʼ�������������β���ʱ������1����㡣
 * ����һ��������6����㣬��ͷ��㿪ʼ���ǵ�ֵ������1��2��3��4��5��6�������ĵ�����3�������ֵΪ4�Ľ�㡣
 *
 * @author zhangcanlong
 * @date 2018��10��15��
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
	 * ����˼·1����ͳ�Ƴ���������ĳ��ȣ�Ȼ���øó��ȼ�ȥk+1���õ�������k����㣬˳���λ�ã�Ȼ����˳�����
	 *
	 * @param head
	 * @param k
	 */
	public ListNode printKthToTail(ListNode head, int k) {
		if (head == null || head.m_pNext == null) {
			return head;
		}
		if (k <= 0) {
			throw new RuntimeException("k����С�ڵ���0");
		}
		// �����õ�����
		int length = 1;
		ListNode temp1 = head;
		while (temp1.m_pNext != null) {
			length++;
			temp1 = temp1.m_pNext;
		}
		// ��k��lengthȡ��
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
 * �Զ����������
 *
 * @author zhangcanlong
 * @date 2018��10��15��
 */
class ListNode {
	int m_nvalue;
	ListNode m_pNext;
}
