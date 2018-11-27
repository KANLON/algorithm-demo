package com.kanlon.queue2stack;

import java.util.Stack;

/**
 * 题目：用两个栈实现一个队列。队列的声明如下，，请实现它的两个函数appendTail和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 *
 * @author zhangcanlong
 * @date 2018年9月28日
 */
public class QueueWithTwoStacks {

	public static void main(String[] args) {
		// 测试用例
		CQueue<Integer> queue = new CQueue<>();
		queue.appendTail(1);
		queue.appendTail(2);
		queue.appendTail(3);
		System.out.println(queue.deleteHead());
		queue.appendTail(4);
		System.out.println(queue.deleteHead());
		System.out.println(queue.deleteHead());
		System.out.println(queue.deleteHead());
		System.out.println(queue.deleteHead());

	}

}

/**
 * 用两个栈实现一个队列。实现思路：当添加队列元素的时候，往栈1添加，当删除队列元素的时候，先检查栈2是否为null，如果为null则从栈1出栈元素加入到栈2中，知道剩下一个元素时，则该元素时队列要删除的元素,如果栈1也为空，则删除失败，已经没有元素。
 * 当检查栈2不为null时，则从栈2出栈。
 *
 * @author zhangcanlong
 * @date 2018年9月28日
 */
class CQueue<T> {
	private Stack<T> stack1 = new Stack<>();
	private Stack<T> stack2 = new Stack<>();

	/**
	 * 添加元素，
	 *
	 * @param node
	 *            要添加的元素
	 */
	public void appendTail(T node) {
		stack1.push(node);
	}

	/**
	 * 删除元素
	 *
	 * @return 返回删除的元素
	 */
	public T deleteHead() {
		if (stack2.isEmpty()) {
			if (stack1.isEmpty()) {
				throw new RuntimeException("删除失败！已经没有元素了");
			} else {
				while (stack1.size() != 1) {
					stack2.push(stack1.pop());
				}
				return stack1.pop();
			}
		}
		return stack2.pop();
	}

}