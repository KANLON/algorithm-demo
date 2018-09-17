package com.kanlon.singleton;

/**
 * Singleton模式的实现 题目：设计一个类，我们只能生成该类的一个实例。
 *
 * @author zhangcanlong
 * @date 2018年9月16日
 */
public class SingletonDemo {

}

/**
 * 方法一，只适合单线程环境
 *
 */
class Singleton1 {
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
 * 方法二：虽然在多线程环境中能工作，但工作效率不高（初步饿汉式）
 *
 */
class Singleton2 {
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
 */
class Singleton3 {
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
 * 方法四：饱汉式，一般开发使用这个
 *
 */
class Singleton4 {
	private Singleton4() {
	}

	private static Singleton4 singleton = new Singleton4();

	private static Singleton4 getInstance() {
		return singleton;
	}
}

/**
 * 方法五：使用了内部类创建实例(推荐)
 * 使用内部类可以避免这个问题，因为在多线程环境下，jvm对一个类的初始化会做限制，
 * 同一时间只会允许一个线程去初始化一个类，这样就从虚拟机层面避免了大部分单例实现的问题
 */
class Singleton5 {
	private Singleton5() {
	}

	private static  final Singleton5 getInstance() {
		return Nested.singleton;
	}

	static class Nested {
		private static final Singleton5 singleton = new Singleton5();
	}

}
