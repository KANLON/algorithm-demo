package com.kanlon.merge_sorted_lists;

/**
 *
 * 面试题17：合并两个排序的链表
 * <p>
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然按照递增排序的。
 *
 * @author zhangcanlong
 * @date 2018年10月29日
 */
public class MergeSortedLists {

	public static void main(String[] args) {
		MergeSortedLists test = new MergeSortedLists();
		// 功能测试：两个链表有多个结点，结点的值互不相同
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
		System.out.println("链表1：" + node11);
		System.out.println("链表2：" + node21);
		// 要运行下一个测试例子，需要注解下面的两行测试代码。因为，运行完下面行代码后，会改变原来链表1和链表2 的结构
		System.out.println("功能测试：两个链表有多个结点，结点的值互不相同 （用递归）" + test.mergeSortedLists(node11, node21));
		System.out.println("功能测试：两个链表有多个结点，结点的值互不相同(用循环) " + test.mergeSortedListsWithFor(node11, node21));
		// 功能测试: 两个链表有多个结点，存在值相同的结点
		node12.m_nvalue = 4;
		node13.m_nvalue = 4;
		node23.m_nvalue = 5;
		System.out.println("链表1：" + node11);
		System.out.println("链表2：" + node21);
		// System.out.println("功能测试：两个链表有多个结点，结点的值互不相同（用递归） " +
		// test.mergeSortedLists(node11, node21));
		System.out.println("功能测试：两个链表有多个结点，结点的值互不相同  （用循环）" + test.mergeSortedListsWithFor(node11, node21));

		// 特殊测试：两个链表的一个或两个头结点为null指针
		// System.out.println("特殊测试：两个链表的一个或两个头结点为null指针 （用递归）" +
		// test.mergeSortedLists(null, null));
		System.out.println("特殊测试：两个链表的一个或两个头结点为null指针 （用循环）" + test.mergeSortedListsWithFor(null, null));

		// 两个链表中只有一个结点
		ListNode node1 = new ListNode();
		node1.m_nvalue = 1;
		ListNode node2 = new ListNode();
		node2.m_nvalue = 2;
		// System.out.println("两个链表中只有一个结点 (用递归) " +
		// test.mergeSortedLists(node1, node2));
		System.out.println("两个链表中只有一个结点  （用循环）" + test.mergeSortedListsWithFor(node1, node2));
	}

	/**
	 * 解题思路（递归解法）：首先假设两个链表的初始头结点中，链表1的头结点小于链表2值，因此链表1的头结点将是合并后的链表的头结点，如下图所示。
	 * 然后我我们接着合并两个链表剩余的结点，在两个链表中剩下的结点依然是排序的，因此合并两个链表的步骤和前面的步骤和前面的步骤是一样的。
	 * 依次进行下去，明显是一个递归的过程。递归函数可以是这样，当我们得到两个链表中的较小的头结点并把它连接到已经合并的链表之后，两个链表剩余的结点依然是排序的，因此合并的步骤和之前的步骤一样。
	 *
	 * @param head1
	 *            排序链表1的头结点
	 * @param head2
	 *            排序链表2的头结点
	 * @return 合并后的链表的头结点
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
	 * 解题思路（非递归解法）：首先确定合并后的首结点，然后进行一个死循环，当其中一个链表已经比较完时就退出该循环，循环内将链表结点根据大小依次加到合并后的链表后（重点），最后循环结束后，将链表剩下的结点加到合并后的结点后面
	 *
	 * @param head1
	 *            排序链表1的头结点
	 * @param head2
	 *            排序链表2的头结点
	 * @return 合并后的链表的头结点
	 */
	public ListNode mergeSortedListsWithFor(ListNode head1, ListNode head2) {
		// 合并后的链表的头结点，
		ListNode head = new ListNode(0);
		// 排序链表中的前锋指针，指向新链表的最后一个元素
		ListNode tempNode = null;
		// 判断是否为null
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		// 找到头结点
		if (head.m_nvalue <= head2.m_nvalue) {
			head.m_pNext = head1;
			head1 = head1.m_pNext;
		} else {
			head.m_pNext = head2;
			head2 = head2.m_pNext;
		}
		tempNode = head.m_pNext;
		// 该while 外层循环一直执行的前提，在于两个链表都没有循环到各自的null
		while (true) {
			// 链表1不为null，且值不大于list2的值
			while (head1 != null && head1.m_nvalue <= head2.m_nvalue) {
				tempNode.m_pNext = head1;
				tempNode = head1;
				head1 = head1.m_pNext;
			}
			// 如果链表1循环完了，那就直接退出
			if (head1 == null) {
				break;
			}
			// 链表2不为null ，且值不大于链表1的值
			while (head2 != null && head2.m_nvalue <= head1.m_nvalue) {
				tempNode.m_pNext = head2;
				tempNode = head2;
				head2 = head2.m_pNext;
			}
			if (head2 == null) {
				break;
			}
		}
		// 把剩余的那部分统一拼接到最后
		if (head1 == null) {
			tempNode.m_pNext = head2;
		} else {
			tempNode.m_pNext = head1;
		}
		return head.m_pNext;
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