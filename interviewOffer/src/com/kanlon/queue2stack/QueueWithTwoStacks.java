package com.kanlon.queue2stack;

import java.util.Stack;

/**
 * ��Ŀ��������ջʵ��һ�����С����е��������£�����ʵ��������������appendTail��deleteHead���ֱ�����ڶ���β����������ڶ���ͷ��ɾ�����Ĺ��ܡ�
 *
 * @author zhangcanlong
 * @date 2018��9��28��
 */
public class QueueWithTwoStacks {

	public static void main(String[] args) {
		// ��������
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
 * ������ջʵ��һ�����С�ʵ��˼·������Ӷ���Ԫ�ص�ʱ����ջ1��ӣ���ɾ������Ԫ�ص�ʱ���ȼ��ջ2�Ƿ�Ϊnull�����Ϊnull���ջ1��ջԪ�ؼ��뵽ջ2�У�֪��ʣ��һ��Ԫ��ʱ�����Ԫ��ʱ����Ҫɾ����Ԫ��,���ջ1ҲΪ�գ���ɾ��ʧ�ܣ��Ѿ�û��Ԫ�ء�
 * �����ջ2��Ϊnullʱ�����ջ2��ջ��
 *
 * @author zhangcanlong
 * @date 2018��9��28��
 */
class CQueue<T> {
	private Stack<T> stack1 = new Stack<>();
	private Stack<T> stack2 = new Stack<>();

	/**
	 * ���Ԫ�أ�
	 *
	 * @param node
	 *            Ҫ��ӵ�Ԫ��
	 */
	public void appendTail(T node) {
		stack1.push(node);
	}

	/**
	 * ɾ��Ԫ��
	 *
	 * @return ����ɾ����Ԫ��
	 */
	public T deleteHead() {
		if (stack2.isEmpty()) {
			if (stack1.isEmpty()) {
				throw new RuntimeException("ɾ��ʧ�ܣ��Ѿ�û��Ԫ����");
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