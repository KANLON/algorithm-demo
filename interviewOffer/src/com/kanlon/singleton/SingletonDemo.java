package com.kanlon.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton模式的实现 题目：设计一个类，我们只能生成该类的一个实例。
 *
 * @author zhangcanlong
 * @date 2018年9月16日
 */
public class SingletonDemo {

}

/**
 * 方法一，只适合单线程环境。 加上final修饰符，防止用户继承该类，使用clone方法创建出该单例实例的另一个实例。
 */
final class Singleton1 {
	private Singleton1() {
	}

	private static Singleton1 singleton = null;

	public static Singleton1 getInstance() {
		if (singleton == null) {
			singleton = new Singleton1();
		}
		return singleton;
	}
}

/**
 * 方法二：虽然在多线程环境中能工作，但工作效率不高（初步饿汉式） 。加上final修饰符，防止用户继承该类，使用clone方法创建出该单例实例的另一个实例
 */
final class Singleton2 {
	private Singleton2() {
	}

	private static Object synObj = new Object();
	private static Singleton2 singleton = null;

	public static Singleton2 getInstance() {
		synchronized (synObj) {
			if (singleton == null) {
				singleton = new Singleton2();
			}
		}
		return singleton;
	}
}

/**
 * 方法三：可行的解法，加同步锁前后两次判断实例是否已存在（完整饿汉式），不过较复杂
 * 加上final修饰符，防止用户继承该类，使用clone方法创建出该单例实例的另一个实例
 */
final class Singleton3 {
	private Singleton3() {
	}

	private static Object synObj = new Object();
	private static Singleton3 singleton = null;

	public static Singleton3 getInstance() {
		if (singleton == null) {
			synchronized (synObj) {
				if (singleton == null) {
					singleton = new Singleton3();
				}
			}
		}
		return singleton;
	}
}

/**
 * 方法四：饱汉式，一般开发使用这个。 加上final修饰符，防止用户继承该类，使用clone方法创建出该单例实例的另一个实例
 */
final class Singleton4 {
	private Singleton4() {
	}

	private static Singleton4 singleton = new Singleton4();

	private static Singleton4 getInstance() {
		return singleton;
	}
}

/**
 * 方法五：使用了内部类创建实例。 加上final修饰符，防止用户继承该类，使用clone方法创建出该单例实例的另一个实例
 * 使用内部类可以避免这个问题，因为在多线程环境下，jvm对一个类的初始化会做限制，
 * 同一时间只会允许一个线程去初始化一个类，这样就从虚拟机层面避免了大部分单例实现的问题.
 * 参考链接： https://blog.csdn.net/gavin_dyson/article/details/70145374
 *
 * @author zhangcanlong
 * @date 2018年9月16日
 */
final class Singleton5 {
	private Singleton5() {
	}

	private static Singleton5 getInstance() {
		return Nested.INSTANCE;
	}

	static class Nested {
		// 这里加final是为了防止内部将这个属性覆盖掉
		private static final Singleton5 INSTANCE = new Singleton5();
	}

}

/**
 * 方法六：枚举式单例 。这种方法不仅能解决多线程同步问题，而且能防止反序列化重新创建新的对象，不过由于jdk1.5中才加入enum特性，所以不常用
 *
 * @author zhangcanlong
 * @date 2018年9月18日
 */
enum Singleton6 {
	INSATANCE;

	public void getInstance() {
	}
}

/**
 * 登记式，spring IOC 就是使用该方法实现
 *
 * @author zhangcanlong
 * @date 2018年9月18日
 */
class RegSingleton {
	// 登记簿，用来存放所有的实例
	private static Map<String, RegSingleton> regSingletonMap = new HashMap<>();

	// 在类加载的时候添加一个实例到登记簿中
	static {
		RegSingleton regSingleton = new RegSingleton();
		regSingletonMap.put(regSingleton.getClass().getName(), regSingleton);

	}

	//
	// 保护默认的构造方法
	protected RegSingleton() {
	}

	public static RegSingleton getInstance(String name) {

		if (name == null) {
			name = "RegSingleton";
		}
		if (regSingletonMap.get(name) == null) {
			try {
				regSingletonMap.put(name, (RegSingleton) Class.forName(name).newInstance());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return regSingletonMap.get(name);
	}

}
