package com.kanlon.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Singletonģʽ��ʵ�� ��Ŀ�����һ���࣬����ֻ�����ɸ����һ��ʵ����
 *
 * @author zhangcanlong
 * @date 2018��9��16��
 */
public class SingletonDemo {

}

/**
 * ����һ��ֻ�ʺϵ��̻߳����� ����final���η�����ֹ�û��̳и��࣬ʹ��clone�����������õ���ʵ������һ��ʵ����
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
 * ����������Ȼ�ڶ��̻߳������ܹ�����������Ч�ʲ��ߣ���������ʽ�� ������final���η�����ֹ�û��̳и��࣬ʹ��clone�����������õ���ʵ������һ��ʵ��
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
 * �����������еĽⷨ����ͬ����ǰ�������ж�ʵ���Ƿ��Ѵ��ڣ���������ʽ���������ϸ���
 * ����final���η�����ֹ�û��̳и��࣬ʹ��clone�����������õ���ʵ������һ��ʵ��
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
 * �����ģ�����ʽ��һ�㿪��ʹ������� ����final���η�����ֹ�û��̳и��࣬ʹ��clone�����������õ���ʵ������һ��ʵ��
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
 * �����壺ʹ�����ڲ��ഴ��ʵ���� ����final���η�����ֹ�û��̳и��࣬ʹ��clone�����������õ���ʵ������һ��ʵ��
 * ʹ���ڲ�����Ա���������⣬��Ϊ�ڶ��̻߳����£�jvm��һ����ĳ�ʼ���������ƣ�
 * ͬһʱ��ֻ������һ���߳�ȥ��ʼ��һ���࣬�����ʹ��������������˴󲿷ֵ���ʵ�ֵ�����.
 * �ο����ӣ� https://blog.csdn.net/gavin_dyson/article/details/70145374
 *
 * @author zhangcanlong
 * @date 2018��9��16��
 */
final class Singleton5 {
	private Singleton5() {
	}

	private static Singleton5 getInstance() {
		return Nested.INSTANCE;
	}

	static class Nested {
		// �����final��Ϊ�˷�ֹ�ڲ���������Ը��ǵ�
		private static final Singleton5 INSTANCE = new Singleton5();
	}

}

/**
 * ��������ö��ʽ���� �����ַ��������ܽ�����߳�ͬ�����⣬�����ܷ�ֹ�����л����´����µĶ��󣬲�������jdk1.5�вż���enum���ԣ����Բ�����
 *
 * @author zhangcanlong
 * @date 2018��9��18��
 */
enum Singleton6 {
	INSATANCE;

	public void getInstance() {
	}
}

/**
 * �Ǽ�ʽ��spring IOC ����ʹ�ø÷���ʵ��
 *
 * @author zhangcanlong
 * @date 2018��9��18��
 */
class RegSingleton {
	// �Ǽǲ�������������е�ʵ��
	private static Map<String, RegSingleton> regSingletonMap = new HashMap<>();

	// ������ص�ʱ�����һ��ʵ�����Ǽǲ���
	static {
		RegSingleton regSingleton = new RegSingleton();
		regSingletonMap.put(regSingleton.getClass().getName(), regSingleton);

	}

	//
	// ����Ĭ�ϵĹ��췽��
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
