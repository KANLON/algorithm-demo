package deletenode;

/**
 * ������13����O(1)ʱ��ɾ��������
 * <p>
 * ��Ŀ���������������ͷָ���һ�����ָ�룬����һ��������O(1)ʱ��ɾ���ý�㡣�������뺯���Ķ������£�
 *
 * @author zhangcanlong
 * @date 2018��10��8��
 */
public class DeleteNodeInList {
	public static void main(String[] args) {
		DeleteNodeInList test = new DeleteNodeInList();
		// ��������������
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

		// ����ֻ��һ����������
		ListNode listNode5 = new ListNode();
		listNode5.m_nValue = 5;

		// �����￪ʼdebug
		// ���ܲ��ԣ��Ӷ������������м�ɾ��һ����㣩
		test.deleteNode(listNode1, listNode2);
		test.outNode(listNode1);

		// ���ж������������ɾ��ͷ���
		test.deleteNode(listNode1, listNode1);
		test.outNode(listNode1);

		// ���ж�һ�������е�ɾ��β���
		test.deleteNode(listNode1, listNode4);
		test.outNode(listNode1);

		// ��ֻ��һ������������ɾ��Ψһ�Ľ��
		listNode5 = test.deleteNode(listNode5, listNode5);
		test.outNode(listNode5);

		// ����������ԣ�ָ�������ͷ���ָ��Ϊnullָ�룬ָ��Ҫɾ���Ľ��Ϊnullָ�룩
		test.deleteNode(null, null);

	}

	/**
	 * ����˼·�������ҪO(1)������ͨ�������ҵ��ýڵ��ǰ�ڵ����ɾ���ý�㣬��Ϊ������ʱ�临�ӶȻ���O(n)��
	 * ���еķ���Ӧ���ǽ�Ҫɾ���Ľڵ����һ������ֵ��ֵΪҪɾ���Ľڵ㣬Ȼ�󽫸���һ�����ָ�����¸���㣬�Ӷ��ﵽɾ����Ч����
	 * <p>
	 * ע�⣺1.���ǵ�Ҫɾ���Ľ�����λ�������β�������������ֻ��һ���������������
	 * 2.�������������ʱ�临�Ӷ�����£����Ҫ��һ��Ҫɾ���Ľ���Ƿ����������
	 *
	 * @param pListHead
	 *            Ҫɾ����������ͷ
	 * @param pToBeDeleted
	 *            Ҫɾ���Ľڵ�
	 */
	public ListNode deleteNode(ListNode pListHead, ListNode pToBeDeleted) {
		// �������֮һΪnull����ֱ�ӷ���
		if (pListHead == null || pToBeDeleted == null) {
			return null;
		}
		// ���Ҫɾ���Ľ�㲻��β���
		if (pToBeDeleted.m_pNext != null) {
			pToBeDeleted.m_nValue = pToBeDeleted.m_pNext.m_nValue;
			pToBeDeleted.m_pNext = pToBeDeleted.m_pNext.m_pNext;
			// �������ֻ��һ�����
		} else if (pListHead == pToBeDeleted) {
			// ��Ϊjava��ֵ���ݣ�ֱ�Ӹ���pListHead=null�ǲ�������
			pListHead.m_nValue = null;
		}
		// �������ж����㣬����ɾ������β��㣨����Ҫ˳�������ǰһ�����ɾ����
		else {
			ListNode node = pListHead;
			while (node.m_pNext != pToBeDeleted) {
				node = node.m_pNext;
			}
			node.m_pNext = null;
		}
		// ��Ҫ���ӷ�������ͷ��㣬��Ȼ������ֻ��һ�����ʱ���޷�����null��ֵ
		return pListHead;
	}

	/**
	 * ���������ֵ
	 *
	 * @param node
	 *            �����ͷ���
	 */
	public void outNode(ListNode node) {
		if (node == null) {
			System.out.println("����Ϊnull");
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