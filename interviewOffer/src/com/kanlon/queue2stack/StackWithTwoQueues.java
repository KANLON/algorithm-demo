package com.kanlon.queue2stack;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ����������ʵ��һ��ջ
 *
 * @author zhangcanlong
 * @date 2018��9��28��
 */
public class StackWithTwoQueues {
	public static void main(String[] args) {
		// ����
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
 * ����������ʵ�ֵ�һ��ջ������˼·����ջʱ�������1���Ԫ�أ���ջʱ�����ж϶���1��Ԫ���Ƿ�Ϊnull�������Ϊnull�򽫶���1Ԫ�س��ӵ�����2��֪������1��ʣ��1��ʱ�������ջ��
 * �������1��Ԫ��Ϊnull���������2�е�Ԫ���Ƿ�Ϊnull�������Ϊnull�򽫶���2�е�Ԫ�س��ӵ�����1�У�ֱ��ʣ��һ��ʱ�������ջ���������2ҲΪnull����ʾջû��Ԫ����
 *
 * @author zhangcanlong
 * @date 2018��9��28��
 */
class Cstack<T> {
	private Queue<T> queue1 = new LinkedBlockingQueue<>();
	private Queue<T> queue2 = new LinkedBlockingQueue<>();

	/**
	 * ��ջ
	 *
	 * @param element
	 */
	public void push(T element) {
		queue1.offer(element);
	}

	/**
	 * ��ջ
	 *
	 * @return ���س�ջ��Ԫ��
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
		throw new RuntimeException("��ջ�����Ѿ�û��Ԫ����");

	}

}
