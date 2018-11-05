package com.kanlon.merge_sorted_lists;

/**
 *
 * ������17���ϲ��������������
 * <p>
 * ��Ŀ������������������������ϲ�����������ʹ�������еĽ����Ȼ���յ�������ġ�
 *
 * @author zhangcanlong
 * @date 2018��10��29��
 */
public class MergeSortedLists {

	public static void main(String[] args) {
		MergeSortedLists test = new MergeSortedLists();
		// ���ܲ��ԣ����������ж����㣬����ֵ������ͬ
		ListNode node11 = new ListNode();
		ListNode node12 = new ListNode();
		ListNode node13 = new ListNode();
		ListNode node14 = new ListNode();
		ListNode node21 = new ListNode();
		ListNode node22 = new ListNode();
		ListNode node23 = new ListNode();
		ListNode node24 = new ListNode();
		node11.m_nvalue = 1;
		node12.m_nvalue = 3;
		node13.m_nvalue = 5;
		node14.m_nvalue = 7;
		node21.m_nvalue = 2;
		node22.m_nvalue = 4;
		node23.m_nvalue = 6;
		node24.m_nvalue = 8;
		node11.m_pNext = node12;
		node12.m_pNext = node13;
		node13.m_pNext = node14;

		node21.m_pNext = node22;
		node22.m_pNext = node23;
		node23.m_pNext = node24;
		System.out.println("����1��" + node11);
		System.out.println("����2��" + node21);
		// Ҫ������һ���������ӣ���Ҫע����������в��Դ��롣��Ϊ�������������д���󣬻�ı�ԭ������1������2 �Ľṹ
		System.out.println("���ܲ��ԣ����������ж����㣬����ֵ������ͬ ���õݹ飩" + test.mergeSortedLists(node11, node21));
		System.out.println("���ܲ��ԣ����������ж����㣬����ֵ������ͬ(��ѭ��) " + test.mergeSortedListsWithFor(node11, node21));
		// ���ܲ���: ���������ж����㣬����ֵ��ͬ�Ľ��
		node12.m_nvalue = 4;
		node13.m_nvalue = 4;
		node23.m_nvalue = 5;
		System.out.println("����1��" + node11);
		System.out.println("����2��" + node21);
		// System.out.println("���ܲ��ԣ����������ж����㣬����ֵ������ͬ���õݹ飩 " +
		// test.mergeSortedLists(node11, node21));
		System.out.println("���ܲ��ԣ����������ж����㣬����ֵ������ͬ  ����ѭ����" + test.mergeSortedListsWithFor(node11, node21));

		// ������ԣ����������һ��������ͷ���Ϊnullָ��
		// System.out.println("������ԣ����������һ��������ͷ���Ϊnullָ�� ���õݹ飩" +
		// test.mergeSortedLists(null, null));
		System.out.println("������ԣ����������һ��������ͷ���Ϊnullָ�� ����ѭ����" + test.mergeSortedListsWithFor(null, null));

		// ����������ֻ��һ�����
		ListNode node1 = new ListNode();
		node1.m_nvalue = 1;
		ListNode node2 = new ListNode();
		node2.m_nvalue = 2;
		// System.out.println("����������ֻ��һ����� (�õݹ�) " +
		// test.mergeSortedLists(node1, node2));
		System.out.println("����������ֻ��һ�����  ����ѭ����" + test.mergeSortedListsWithFor(node1, node2));
	}

	/**
	 * ����˼·���ݹ�ⷨ�������ȼ�����������ĳ�ʼͷ����У�����1��ͷ���С������2ֵ���������1��ͷ��㽫�Ǻϲ���������ͷ��㣬����ͼ��ʾ��
	 * Ȼ�������ǽ��źϲ���������ʣ��Ľ�㣬������������ʣ�µĽ����Ȼ������ģ���˺ϲ���������Ĳ����ǰ��Ĳ����ǰ��Ĳ�����һ���ġ�
	 * ���ν�����ȥ��������һ���ݹ�Ĺ��̡��ݹ麯�������������������ǵõ����������еĽ�С��ͷ��㲢�������ӵ��Ѿ��ϲ�������֮����������ʣ��Ľ����Ȼ������ģ���˺ϲ��Ĳ����֮ǰ�Ĳ���һ����
	 *
	 * @param head1
	 *            ��������1��ͷ���
	 * @param head2
	 *            ��������2��ͷ���
	 * @return �ϲ���������ͷ���
	 */
	public ListNode mergeSortedLists(ListNode head1, ListNode head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		ListNode pMergedHead = null;
		if (head1.m_nvalue < head2.m_nvalue) {
			pMergedHead = head1;
			pMergedHead.m_pNext = mergeSortedLists(head1.m_pNext, head2);
		} else {
			pMergedHead = head2;
			pMergedHead.m_pNext = mergeSortedLists(head1, head2.m_pNext);
		}
		return pMergedHead;
	}

	/**
	 * ����˼·���ǵݹ�ⷨ��������ȷ���ϲ�����׽�㣬Ȼ�����һ����ѭ����������һ�������Ѿ��Ƚ���ʱ���˳���ѭ����ѭ���ڽ���������ݴ�С���μӵ��ϲ����������ص㣩�����ѭ�������󣬽�����ʣ�µĽ��ӵ��ϲ���Ľ�����
	 *
	 * @param head1
	 *            ��������1��ͷ���
	 * @param head2
	 *            ��������2��ͷ���
	 * @return �ϲ���������ͷ���
	 */
	public ListNode mergeSortedListsWithFor(ListNode head1, ListNode head2) {
		// �ϲ���������ͷ��㣬
		ListNode head = new ListNode(0);
		// ���������е�ǰ��ָ�룬ָ������������һ��Ԫ��
		ListNode tempNode = null;
		// �ж��Ƿ�Ϊnull
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		// �ҵ�ͷ���
		if (head.m_nvalue <= head2.m_nvalue) {
			head.m_pNext = head1;
			head1 = head1.m_pNext;
		} else {
			head.m_pNext = head2;
			head2 = head2.m_pNext;
		}
		tempNode = head.m_pNext;
		// ��while ���ѭ��һֱִ�е�ǰ�ᣬ������������û��ѭ�������Ե�null
		while (true) {
			// ����1��Ϊnull����ֵ������list2��ֵ
			while (head1 != null && head1.m_nvalue <= head2.m_nvalue) {
				tempNode.m_pNext = head1;
				tempNode = head1;
				head1 = head1.m_pNext;
			}
			// �������1ѭ�����ˣ��Ǿ�ֱ���˳�
			if (head1 == null) {
				break;
			}
			// ����2��Ϊnull ����ֵ����������1��ֵ
			while (head2 != null && head2.m_nvalue <= head1.m_nvalue) {
				tempNode.m_pNext = head2;
				tempNode = head2;
				head2 = head2.m_pNext;
			}
			if (head2 == null) {
				break;
			}
		}
		// ��ʣ����ǲ���ͳһƴ�ӵ����
		if (head1 == null) {
			tempNode.m_pNext = head2;
		} else {
			tempNode.m_pNext = head1;
		}
		return head.m_pNext;
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

	public ListNode() {
	}

	public ListNode(int value) {
		m_nvalue = value;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer(String.valueOf(m_nvalue));
		ListNode temp = m_pNext;
		while (temp != null) {
			buffer.append("->" + temp.m_nvalue);
			temp = temp.m_pNext;
		}
		return buffer.toString();
	}
}