package com.kanlon.queue2stack;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 用两个队列实现一个栈
 *
 * @author zhangcanlong
 * @date 2018年9月28日
 */
public class StackWithTwoQueues {
	public static void main(String[] args) {
		// 测试
		Cstack<Integer> stack = new Cstack<>();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop());
		stack.push(3);
		System.out.println(stack.pop());
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}
}

/**
 * 用两个队列实现的一个栈，解题思路：入栈时，向队列1添加元素，出栈时，先判断队列1的元素是否为null，如果不为null则将队列1元素出队到队列2中知道队列1中剩下1个时，则将其出栈。
 * 如果队列1的元素为null，则检查队列2中的元素是否为null，如果不为null则将队列2中的元素出队到队列1中，直到剩下一个时，将其出栈，如果队列2也为null，表示栈没有元素了
 *
 * @author zhangcanlong
 * @date 2018年9月28日
 */
class Cstack<T> {
	private Queue<T> queue1 = new LinkedBlockingQueue<>();
	private Queue<T> queue2 = new LinkedBlockingQueue<>();

	/**
	 * 入栈
	 *
	 * @param element
	 */
	public void push(T element) {
		queue1.offer(element);
	}

	/**
	 * 出栈
	 *
	 * @return 返回出栈的元素
	 */
	public T pop() {
		if (queue1.size() > 0) {
			while (queue1.size() > 1) {
				queue2.offer(queue1.poll());
			}
			return queue1.poll();
		}
		if (queue2.size() > 0) {
			while (queue2.size() > 1) {
				queue1.offer(queue2.poll());
			}
			return queue2.poll();
		}
		throw new RuntimeException("出栈错误，已经没有元素了");

	}

}