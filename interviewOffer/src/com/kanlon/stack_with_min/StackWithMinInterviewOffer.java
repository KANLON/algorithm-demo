package com.kanlon.stack_with_min;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题21：包含min函数的栈
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)
 * <p>
 * 解题思路（剑指offer中的解题思路）：利用辅助栈，每次进栈时，同时检查辅助栈的栈顶元素是否小于等于该元素，是则将其也放入辅助栈中。出栈时检查出栈元素是否小于等于辅助栈顶元素，是则也将辅助栈顶出栈。保持辅助栈栈顶为栈最小元素。
 *
 * @author zhangcanlong
 * @date 2018年12月27日
 */
public class StackWithMinInterviewOffer {

	public static void main(String[] args) {
		// 测试用例
		StackWithMinInterviewOffer test = new StackWithMinInterviewOffer();
		test.push(3);
		System.out.println("得到最小元素：" + test.getMin());
		test.push(1);
		System.out.println("得到最小元素：" + test.getMin());
		test.push(4);
		System.out.println("得到最小元素：" + test.getMin());
		System.out.println(test);
		System.out.println("出栈：" + test.pop());
		System.out.println(test.getMin());
		System.out.println("出栈：" + test.pop());
		System.out.println("得到最小元素：" + test.getMin());
		System.out.println(test);
		System.out.println("出栈：" + test.pop());
		System.out.println(test.getMin());
	}

	/**
	 * 存放数据的
	 */
	private List<Integer> data = new ArrayList<>();
	/**
	 * 存放最小元素值（辅助栈）
	 */
	private List<Integer> min = new ArrayList<>();

	/**
	 * 入栈
	 *
	 * @param Integer
	 */
	public void push(Integer value) {
		data.add(value);
		if (min.size() == 0 || min.get(min.size() - 1) >= value) {
			min.add(value);
		}
	}

	/**
	 * 出栈
	 *
	 * @return
	 */
	public Integer pop() {
		if (data.size() == 0) {
			throw new RuntimeException("栈为null不能执行出栈！");
		}
		int returnValue = data.get(data.size() - 1);
		if (min.size() != 0 && min.get(min.size() - 1) >= returnValue) {
			min.remove(min.size() - 1);
		}
		data.remove(data.size() - 1);
		return returnValue;
	}

	/**
	 * 得到最小元素值
	 *
	 * @return
	 */
	public Integer getMin() {
		if (min.size() == 0) {
			throw new RuntimeException("栈为null不能执行得到最小元素！");
		}
		int minValue = min.get(min.size() - 1);
		return minValue;
	}

	@Override
	public String toString() {
		return data.toString();
	}

}
