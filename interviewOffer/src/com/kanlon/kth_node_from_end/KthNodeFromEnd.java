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
		// ���ܲ��ԣ���k������������м䣩
		ListNode nodeMethod11 = test.printKthToTail(node1, 2);
		ListNode nodeMethod21 = test.printKthToTail2(node1, 2);
		// ���ܲ��ԣ���k�����������ͷ��㣩
		ListNode nodeMethod12 = test.printKthToTail(node1, 4);
		ListNode nodeMethod22 = test.printKthToTail2(node1, 4);
		// ���ܲ��ԣ���k�����������β��㣩
		ListNode nodeMethod13 = test.printKthToTail(node1, 1);
		ListNode nodeMethod23 = test.printKthToTail2(node1, 1);

		// ����������ԣ�������������k��
		ListNode nodeMethod15 = test.printKthToTail(node1, 6);
		ListNode nodeMethod25 = test.printKthToTail2(node1, 6);

		System.out.println("��k������������м�--" + nodeMethod11.m_nvalue);
		System.out.println("��k������������м�--" + nodeMethod21.m_nvalue);
		System.out.println("��k�����������ͷ���--" + nodeMethod12.m_nvalue);
		System.out.println("��k�����������ͷ���--" + nodeMethod22.m_nvalue);
		System.out.println("��k�����������β���--" + nodeMethod13.m_nvalue);
		System.out.println("��k�����������β���--" + nodeMethod23.m_nvalue);
		System.out.println("������������k--" + nodeMethod15.m_nvalue);
		System.out.println("������������k--" + nodeMethod25.m_nvalue);
		// ����������������Իᱨ�쳣�����Է������ﵥ��ִ��
		// ����������ԣ�����ͷ���Ϊnullָ�룩
		ListNode nodeMethod14 = test.printKthToTail(null, 6);
		ListNode nodeMethod24 = test.printKthToTail2(null, 6);
		// ����������ԣ�kС�ڵ���0��
		ListNode nodeMethod16 = test.printKthToTail(node1, 0);
		ListNode nodeMethod26 = test.printKthToTail2(node1, 0);
		System.out.println("����ͷ���Ϊnullָ��--" + nodeMethod14.m_nvalue);
		System.out.println("����ͷ���Ϊnullָ��--" + nodeMethod24.m_nvalue);
		System.out.println("kС�ڵ���0--" + nodeMethod16.m_nvalue);
		System.out.println("kС�ڵ���0--" + nodeMethod26.m_nvalue);

	}

	/**
	 * ����˼·1����ͳ�Ƴ���������ĳ��ȣ�Ȼ���øó��ȼ�ȥk+1���õ�������k����㣬˳���λ�ã�Ȼ����˳�����
	 * ע�⣺���k����length�����k����k mod length���������ȡģ���ֵ����0����k=length
	 *
	 * @param head
	 *            Ҫ��ӡ������
	 * @param k
	 *            �����ڼ������
	 * @return �����ĸý��
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
	 * ����˼·2����������ָ�붼ָ���׽�㣬�ڶ���ָ������ǰ�ƶ�k-1λ��Ȼ���һ��ָ��͵ڶ���ָ��ͬʱ��ʼ��ǰ�ƶ���֪���ڶ���ָ���ƶ���β��㣬���һ��ָ����ָ���Ԫ�ؾ��ǵ�����k�����
	 * ע�⣺�������������ڿ���ֻ����һ�������������k����length���򷵻��׽��
	 *
	 * @param head
	 *            Ҫ��ӡ������
	 * @param k
	 *            �����ڼ������
	 * @return �����ĸý��
	 */
	public ListNode printKthToTail2(ListNode head, int k) {
		if (head == null || head.m_pNext == null) {
			return head;
		}
		if (k <= 0) {
			throw new RuntimeException("k����С�ڵ���0");
		}

		ListNode node1 = head;
		ListNode node2 = head;
		// ��ʾ��ǰ�Ľ����
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
 * �Զ����������
 *
 * @author zhangcanlong
 * @date 2018��10��15��
 */
class ListNode {
	int m_nvalue;
	ListNode m_pNext;
}
