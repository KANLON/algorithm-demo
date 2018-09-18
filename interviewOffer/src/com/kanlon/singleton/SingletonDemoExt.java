package com.kanlon.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例模式实现的扩展问题，定义一个基类，使得实现该基类的派生类型都只能产生一个实例
 *
 * @author zhangcanlong
 * @date 2018年9月18日
 */
public class SingletonDemoExt {

}

/**
 * 登记式，spring IOC 就是使用该方法实现
 *
 * @author zhangcanlong
 * @date 2018年9月18日
 */
class President {
	// 登记簿，用来存放所有的实例
	private static Map<String, President> regSingletonMap = new HashMap<>();

	// 在类加载的时候添加一个实例到登记簿中
	static {
		President president = new President();
		regSingletonMap.put(president.getClass().getName(), president);

	}

	//
	// 保护默认的构造方法
	protected President() {
	}

	public static President getInstance(String name) {

		if (name == null) {
			name = "RegSingleton";
		}
		if (regSingletonMap.get(name) == null) {
			try {
				regSingletonMap.put(name, (President) Class.forName(name).newInstance());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return regSingletonMap.get(name);
	}

}
