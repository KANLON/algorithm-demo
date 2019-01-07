package com.kanlon.copy_complex_list;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * ### 面试题26：复杂链表的复制
 * <p>
 * 题目：请实现函数ComplexListNode clone(ComplexListNode
 * pHead),复制一个复杂的链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个结点外，还有一个m_pSibling指向链表中的任意结点或者null。
 *
 * @author zhangcanlong
 * @date 2019年1月6日
 */
public class CopyComplexList {
	public static void main(String[] args) {
		// 测试
		CopyComplexList test = new CopyComplexList();
		// 功能测试1（链表有多个值，任意指针指向两三个值）
		ComplexListNode node11 = new ComplexListNode(1);
		ComplexListNode node12 = new ComplexListNode(2);
		ComplexListNode node13 = new ComplexListNode(3);
		ComplexListNode node14 = new ComplexListNode(4);
		ComplexListNode node15 = new ComplexListNode(5);
		node11.m_pNext = node12;
		node12.m_pNext = node13;
		node13.m_pNext = node14;
		node14.m_pNext = node15;
		node11.m_pSibling = node13;
		node12.m_pSibling = node14;
		node13.m_pSibling = node12;
		System.out.println("功能测试1（链表有多个值，任意指针指向两三个值:");
		System.out.println("原链表：" + node11);
		System.out.println(test.copyListNodeWithMap(node11).toString());
		System.out.println("原链表：" + node11);
		System.out.println(test.copyListNodeWithNext(node11).toString());

		// 功能测试2（链表有多个值，任意指针都为null）
		ComplexListNode node21 = new ComplexListNode(1);
		ComplexListNode node22 = new ComplexListNode(2);
		ComplexListNode node23 = new ComplexListNode(3);
		ComplexListNode node24 = new ComplexListNode(4);
		ComplexListNode node25 = new ComplexListNode(5);
		node21.m_pNext = node22;
		node22.m_pNext = node23;
		node23.m_pNext = node24;
		node24.m_pNext = node25;
		System.out.println("功能测试2（链表有多个值，任意指针都为null）");
		System.out.println("原链表：" + node21);
		System.out.println(test.copyListNodeWithMap(node21).toString());
		System.out.println(test.copyListNodeWithNext(node21).toString());

		// 功能测试3（链表只有一个值，任意指针指向自己）
		ComplexListNode node31 = new ComplexListNode(1);
		node31.m_pSibling = node31;
		System.out.println("功能测试3（链表只有一个值，任意指针指向自己）:");
		System.out.println(test.copyListNodeWithMap(node31).toString());
		System.out.println(test.copyListNodeWithNext(node31).toString());
		// 功能测试4 （链表只有一个值，任意指针为null）
		ComplexListNode node41 = new ComplexListNode(1);
		System.out.println("功能测试4 （链表只有一个值，任意指针为null）:");
		System.out.println(test.copyListNodeWithMap(node41).toString());
		System.out.println(test.copyListNodeWithNext(node41).toString());
		// 特殊测试1（链表为null）
		System.out.println("特殊测试1（链表为null）:");
		System.out.println(test.copyListNodeWithMap(null));
		System.out.println(test.copyListNodeWithNext(null));

	}

	/**
	 * 解题思路1（借助HashMap数组）：先将原来链表的结点某个copy到hashmap中，形式为N-N'
	 * ,然后依次复制链表每个结点，并将复制后的结点的指针指向复制前的下一个结点所在的key值对应的value值。
	 * 将任意指针m_pSibling指向原来结点指向的hashmap中key对应的value结点。这样是空间换时间时间复杂度为O（n）
	 *
	 * @param listNode
	 *            要复制链表的头结点
	 * @return 复制后的链表的头结点
	 */
	public ComplexListNode copyListNodeWithMap(ComplexListNode listNode) {
		if (listNode == null) {
			return null;
		}
		ComplexListNode tempOldListNode = listNode;
		// 复制后的链表的头结点
		ComplexListNode copyListNodeHead = new ComplexListNode();
		ComplexListNode copyListNodeNext = new ComplexListNode();
		copyListNodeHead = copyListNodeNext;
		Map<ComplexListNode, ComplexListNode> map = new HashMap<>();
		// 设置链表的头结点
		copyListNodeHead.m_nValue = tempOldListNode.m_nValue;
		map.put(listNode, copyListNodeHead);
		// 单单复制链表的结点值和下一个指针值
		while (tempOldListNode.m_pNext != null) {
			// 如果有下一个结点，则将创建一个结点，并将其链接到next链表中，和放入的map中
			ComplexListNode tempNode = new ComplexListNode();
			tempNode.m_nValue = tempOldListNode.m_pNext.m_nValue;
			copyListNodeNext.m_pNext = tempNode;
			copyListNodeNext = copyListNodeNext.m_pNext;
			map.put(tempOldListNode.m_pNext, tempNode);
			// 将链表迭代到下一个结点
			tempOldListNode = tempOldListNode.m_pNext;
		}
		// 同时遍历新旧链表，当遇到旧链表的任意指针m_pSibling指针指向不为null，则将其新链表的任意指针m_pSibling指向旧链表的那个指针指向的key，对应的value
		// 存储旧链表的头结点，用于遍历
		ComplexListNode tempOldListNode2 = listNode;
		// 存储新链表的头结点，用于遍历
		ComplexListNode copyListNodeHead2 = copyListNodeHead;
		while (tempOldListNode2 != null) {
			if (tempOldListNode2.m_pSibling != null) {
				copyListNodeHead2.m_pSibling = map.get(tempOldListNode2.m_pSibling);
			}
			tempOldListNode2 = tempOldListNode2.m_pNext;
			copyListNodeHead2 = copyListNodeHead2.m_pNext;
		}
		return copyListNodeHead;
	}

	/**
	 * 解题思路2（在原结点下链接新结点）：（1）新增结点：在原链表所有结点上都新增加一个结点，使得链表结构由N1->N2->N3变成N1->N1'->N2->N2'->N3->N3'
	 * (2)重新定位：遍历该链表如果原来结点的任意指针m_pSibling不为null，则将其原结点的下一个结点（即新的对应结点）的任意指针m_pSibling指向原来结点任意指针指向的结点的下一个结点
	 * (3)拆分连接：将偶数的结点顺序连接起立，将奇数的结点顺序连接起来。返回偶数的结点的头结点点
	 *
	 * @param listNode
	 *            要复制链表的头结点
	 * @return 复制后的链表的头结点
	 */
	public ComplexListNode copyListNodeWithNext(ComplexListNode listNode) {

		if (listNode == null) {
			return null;
		}
		// (1)新增结点
		// 用来进行新增结点时链表遍历的临时结点
		ComplexListNode createNodeTempNode = listNode;
		while (createNodeTempNode != null) {
			ComplexListNode nextNode = new ComplexListNode();
			nextNode.m_nValue = createNodeTempNode.m_nValue;
			nextNode.m_pNext = createNodeTempNode.m_pNext;
			createNodeTempNode.m_pNext = nextNode;
			// 将结点替代为下一个要新增的结点出
			createNodeTempNode = nextNode.m_pNext;
		}

		// （2）重新定位
		// 用来进行重新定位时链表遍历的临时结点
		ComplexListNode newLocateTempNode = listNode;
		// 统计当前遍历的结点数
		int newLocateCount = 1;
		while (newLocateTempNode != null) {
			// 当奇数时才需要重新定位
			if (newLocateCount % 2 != 0 && newLocateTempNode.m_pSibling != null && newLocateTempNode.m_pNext != null) {
				newLocateTempNode.m_pNext.m_pSibling = newLocateTempNode.m_pSibling.m_pNext;
			}
			newLocateTempNode = newLocateTempNode.m_pNext;
			newLocateCount++;
		}

		// （3）拆分连接
		// 用来拆分连接时链表遍历的临时结点(从第三个结点开始遍历)
		ComplexListNode splitConnectTempNode = listNode.m_pNext.m_pNext;
		// 统计当前遍历的结点数
		int count = 3;
		// 用来链接复制后的链表结点
		ComplexListNode copyListNodeTemp = listNode.m_pNext;
		// 存储偶数的结点
		ComplexListNode copyListNodeHead = listNode.m_pNext;
		// 存储遍历的上一个结点位置用于删除偶数结点
		ComplexListNode lastNode = listNode.m_pNext;
		while (splitConnectTempNode != null) {
			// 偶数
			if (count % 2 == 0) {
				// 将偶数结点链接到copy链表上
				copyListNodeTemp.m_pNext = splitConnectTempNode;
				copyListNodeTemp = copyListNodeTemp.m_pNext;
				// （这种删除方法不可以）然后将结点删除（不是最后一个，则先将后面的结点值复制到当前结点来，然后将当前结点的下一个修改为后面结点的下一个，如果是最后一个，则不用处理）
				// if (splitConnectTempNode.m_pNext != null) {
				// splitConnectTempNode.m_nValue =
				// splitConnectTempNode.m_pNext.m_nValue;
				// splitConnectTempNode.m_pNext =
				// splitConnectTempNode.m_pNext.m_pNext;
				// }
				// 要跳过偶数点删除
				if (splitConnectTempNode.m_pNext != null) {
					lastNode.m_pNext = splitConnectTempNode.m_pNext;
				}
			} else {
				lastNode = splitConnectTempNode;
				splitConnectTempNode = splitConnectTempNode.m_pNext;
			}
			count++;
		}
		return copyListNodeHead;
	}

}

/**
 * 定义的复杂链表
 *
 * @author zhangcanlong
 * @date 2019年1月6日
 */
class ComplexListNode {
	public ComplexListNode() {
	};

	public ComplexListNode(int value) {
		m_nValue = value;
	}

	int m_nValue;
	ComplexListNode m_pNext;
	ComplexListNode m_pSibling;

	// 使用该类作为key，需要重写hashCode和equals方法
	// 重写hashCode的意义：我们重写hashCode()的目的在于，在A.equals(B)返回true的情况下，A,
	// B的hashCode()要返回相同的值．
	@Override
	public int hashCode() {
		// 这里的hashCode方法参考了jdk中链表的hashCode方法
		int hashCode = 1;
		ComplexListNode temp = this;
		while (temp != null) {
			int value = temp.m_nValue;
			hashCode = 31 * hashCode + value;
			if (temp.m_pSibling != null) {
				hashCode += temp.m_pSibling.m_nValue;
			}
			temp = temp.m_pNext;
		}
		return hashCode;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ComplexListNode)) {
			return false;
		}
		ComplexListNode e1 = this;
		ComplexListNode e2 = (ComplexListNode) o;
		while (e1 != null && e2 != null) {
			// 比较值
			boolean flag = e1.m_nValue == e2.m_nValue;
			if (flag == false) {
				return false;
			}
			// 比较任意指针
			if (e1.m_pSibling != null && e2.m_pSibling != null) {
				if (e1.m_pSibling.m_nValue != e2.m_pSibling.m_nValue) {
					return false;
				}
			} else {
				if (!(e1.m_pSibling == null && e2.m_pSibling == null)) {
					return false;
				}
			}
			e1 = e1.m_pNext;
			e2 = e2.m_pNext;
		}
		return (e1 == null && e2 == null);
	}

	@Override
	public String toString() {
		// 遍历链表。
		ComplexListNode temp = this;
		System.out.println("链表结构为：");
		StringBuffer totalBuffer = new StringBuffer();
		StringBuffer randomIndexBuffer = new StringBuffer();
		while (temp != null) {
			totalBuffer.append(temp.m_nValue + "->");
			if (temp.m_pSibling != null) {
				randomIndexBuffer.append(temp.m_nValue + "的任意指针为：" + temp.m_pSibling.m_nValue + ",");
			}
			temp = temp.m_pNext;
		}
		return totalBuffer.toString() + "\n" + randomIndexBuffer.toString();
	}
}