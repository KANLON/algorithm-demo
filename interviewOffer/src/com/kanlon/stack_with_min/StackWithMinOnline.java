package com.kanlon.stack_with_min;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题21：包含min函数的栈
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)
 * <p>https://mp.weixin.qq.com/s/SFbGNAEGnqZMib9VMC26Ew
 * 解题思路（网上较优解题思路）：利用辅助栈（存放最小元素在数据数组中的下标），每次进栈时，辅助栈顶下标对应的元素是否小于该元素，是则将其下辅助栈中。出栈时检查出栈元素的下标是否等于辅助栈顶值，是则也将辅助栈顶出栈。保持辅助栈栈顶为栈最小元素的下标。
 *
 * @author zhangcanlong
 * @date 2018年12月27日
 */
public class StackWithMinOnline {

	public static void main(String[] args) {

		// 测试用例
		StackWithMinOnline test = new StackWithMinOnline();
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

	private List<Integer> data = new ArrayList<>();
	private List<Integer> min = new ArrayList<>();

	public void push(Integer value) {
		data.add(value);
		if (min.size() == 0 || data.get(min.get(min.size() - 1)) > value) {
			min.add(data.size() - 1);
		}
	}

	public Integer pop() {
		if (data.size() == 0) {
			throw new RuntimeException("栈为空，不能出栈！");
		}
		int returnValue = data.get(data.size() - 1);
		if (min.get(min.size() - 1) == data.size() - 1) {
			min.remove(min.size() - 1);
		}
		data.remove(data.size() - 1);
		return returnValue;
	}

	public Integer getMin() {
		if (data.size() == 0) {
			throw new RuntimeException("栈为空，不能出栈！");
		}
		return data.get(min.get(min.size() - 1));
	}

	@Override
	public String toString() {
		return data.toString();
	}

}
