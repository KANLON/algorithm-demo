package com.kanlon.singleton;

/**
 * Singletonģʽ��ʵ�� ��Ŀ�����һ���࣬����ֻ�����ɸ����һ��ʵ����
 *
 * @author zhangcanlong
 * @date 2018��9��16��
 */
public class SingletonDemo {

}

/**
 * ����һ��ֻ�ʺϵ��̻߳���
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
 * ����������Ȼ�ڶ��̻߳������ܹ�����������Ч�ʲ��ߣ���������ʽ��
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
 * �����������еĽⷨ����ͬ����ǰ�������ж�ʵ���Ƿ��Ѵ��ڣ���������ʽ���������ϸ���
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
 * �����ģ�����ʽ��һ�㿪��ʹ�����
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
 * �����壺ʹ�����ڲ��ഴ��ʵ��
 *
 * @author zhangcanlong
 * @date 2018��9��16��
 */
class Singleton5 {
	private Singleton5() {
	}

	private static Singleton5 getInstance() {
		return Nested.singleton;
	}

	static class Nested {
		private static Singleton5 singleton = new Singleton5();
	}

}
