package com.kanlon.stack_push_pop_order;

import java.util.Stack;

/**
 * 面试题22:栈的压入、弹出序列。题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如：1、2、3、4、5是某栈的压栈序列。
 * 序列4、5、3、2、1是某栈的弹出序列，但4、3、5、1、2就不可能是该压栈序列的弹出序列。
 *
 * @author zhangcanlong
 * @date 2018年12月31日
 */
public class StackPushPopOrder {
	public static void main(String[] args) {
		// 测试
		StackPushPopOrder test = new StackPushPopOrder();
		// 功能测试1，弹出序列是入栈序列
		int[] pushOrder1 = { 1, 2, 3, 4, 5 };
		int[] popOrder1 = { 4, 5, 3, 2, 1 };
		System.out.println("功能测试1，弹出序列是入栈序列" + test.isPopOrder(pushOrder1, popOrder1));
		// 功能测试2，弹出序列不是入栈序列
		int[] pushOrder2 = { 1, 2, 3, 4, 5 };
		int[] popOrder2 = { 4, 3, 5, 1, 2 };
		System.out.println("功能测试2，弹出序列不是入栈序列" + test.isPopOrder(pushOrder2, popOrder2));
		// 特殊测试1，都只有一个元素,并且不等
		int[] pushOrder3 = { 1 };
		int[] popOrder3 = { 4 };
		System.out.println("特殊测试1，都只有一个元素,并且不等" + test.isPopOrder(pushOrder3, popOrder3));
		// 特殊测试1，都只有一个元素,相等
		int[] pushOrder4 = { 1 };
		int[] popOrder4 = { 1 };
		System.out.println("特殊测试1，都只有一个元素,相等" + test.isPopOrder(pushOrder4, popOrder4));
		// 特殊测试2，其中之一为null
		System.out.println("特殊测试2，其中之一为null" + test.isPopOrder(null, popOrder1));
	}

	/**
	 * 判断某个出栈序列是否是入栈序列的对应的出栈序列。
	 * <p>
	 * 解题思路(与原书解法不一样)：(1)将入栈序列依次入栈，直到遇到要入栈的元素等于出栈序列的第一个元素。如果相等则直接跳过该元素，入栈序列和出栈序列都到下一个指针。直到入栈序列指针到最后一个元素。
	 * (2)接着检查下一个出栈元素是否等于入栈的栈顶元素，如果等于则继续出栈，否则继续入栈，重复第一步操作。
	 * (3)遍历完所有入栈序列后，从当前出栈序列所指下标的元素，依次和栈中元素依次出栈对比，一旦发现有不相同的，则返回false,否则返回true
	 * <p>
	 * 解题思路：
	 *
	 * @param pushOrder
	 *            入栈序列
	 * @param popOrder
	 *            出栈序列
	 * @return
	 */
	public Boolean isPopOrder(int[] pushOrder, int[] popOrder) {
		// 存放入栈序列的栈
		Stack<Integer> stack = new Stack<>();
		if (pushOrder == null || popOrder == null || pushOrder.length == 0 || popOrder.length == 0) {
			return false;
		}
		// 入栈序列长度
		int pushLength = pushOrder.length;
		// 出栈序列长度
		int popLength = popOrder.length;
		if (pushLength != popLength) {
			return false;
		}
		// 指向入栈序列的下标
		int pushIndex = 0;
		// 指向出栈序列的下标
		int popIndex = 0;
		while (pushIndex < pushLength) {
			if (pushOrder[pushIndex] == popOrder[popIndex]) {
				popIndex++;
			} else {
				stack.push(pushOrder[pushIndex]);
			}
			pushIndex++;
		}
		// 剩下的出栈依次和出栈序列比较,有不相等则返回false
		while (stack.size() != 0 || popIndex <= popLength - 1) {
			if (stack.pop() != popOrder[popIndex++]) {
				return false;
			}
		}
		// 入栈完之后,依次出栈对比
		if (stack.size() == 0 && popIndex == popLength) {
			return true;
		} else {
			return false;
		}

	}
}
