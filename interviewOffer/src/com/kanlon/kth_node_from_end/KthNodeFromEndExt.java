package com.kanlon.kth_node_from_end;

import java.util.ArrayList;
import java.util.List;

/**
 * ������15�������е�����k��������չ��Ŀ
 * ��չ��Ŀ1����������м��㡣��������н������Ϊ�������򷵻��м��㣬������������ż�����򷵻��м�������������һ����
 * ��չ��Ŀ2���ж�һ�����������Ƿ��γ��˻��νṹ��
 *
 *
 * @author zhangcanlong
 * @date 2018��10��15��
 */
public class KthNodeFromEndExt {

	public static void main(String[] args) {
		// ����
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
		// ��Ŀ1
		List<ListNode> midNodeList = new ArrayList<>();
		// ���ܲ��� ����Ϊż�������㣬1>2>3>4
		midNodeList.add(test.getMidNode(node1));
		// ���ܲ��� ����Ϊ���������� 2>3>4
		midNodeList.add(test.getMidNode(node2));
		// ������� ����Ϊ1����� 4
		midNodeList.add(test.getMidNode(node4));
		// ������� ����Ϊ2����� 3>4
		midNodeList.add(test.getMidNode(node3));
		// ���Բ��� ����ͷ���Ϊnull
		midNodeList.add(test.getMidNode(null));
		for (ListNode midNode : midNodeList) {
			System.out.println(midNode);
		}
		System.out.println("===================");
		// ��Ŀ2
		// ���ܲ��� ����Ϊ�ж�����ķǻ�
		System.out.println(test.isCircleList(node1));
		// ���ܲ��� ����Ϊ�ж�����Ļ�
		node4.m_pNext = node1;
		System.out.println(test.isCircleList(node1));
		// ������� ����ֻ��һ�����ķǻ�
		ListNode circleNode1 = new ListNode();
		circleNode1.m_nvalue = 1;
		System.out.println(test.isCircleList(circleNode1));
		// ������� ����ֻ��һ�����Ļ�
		circleNode1.m_pNext = circleNode1;
		System.out.println(test.isCircleList(circleNode1));
		// ���Բ��� ����Ϊnull
		System.out.println(test.isCircleList(null));

	}

	/**
	 * ��������м���Ľ���˼·����������ָ�룬ͬʱ�������ͷ��������һ��ָ��һ����һ������һ��ָ��һ�������������ߵÿ��ָ���ߵ�������ĩβ������ָ��ָ�����м�Ԫ��
	 *
	 * @param head
	 *            Ҫ��������ͷ���
	 * @return ���ظ������м���
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
	 * �жϵ��������Ƿ��γɻ��νṹ�Ľ���˼·����������ָ�룬ͬʱ�������ͷ��������һ��ָ��һ����һ����һ��ָ��һ��������������ߵÿ��ָ��׷�����ߵ�����ָ�룬��ô���������ǻ�������
	 * ����ߵÿ��ָ�뵽�������ĩβ��m_pNextָ��null����û��׷�ϵ�һ��ָ�룬��ô����Ͳ��ǻ�������.
	 * ע�⣺������ѡ���������null��Ҳ����false
	 *
	 * @param head
	 *            Ҫ�жϵĵ��������ͷ���
	 * @return ����ǻ��Σ�����true�����򷵻�false
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
