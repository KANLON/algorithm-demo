package com.kanlon.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * ����ģʽʵ�ֵ���չ���⣬����һ�����࣬ʹ��ʵ�ָû�����������Ͷ�ֻ�ܲ���һ��ʵ��
 *
 * @author zhangcanlong
 * @date 2018��9��18��
 */
public class SingletonDemoExt {

}

/**
 * �Ǽ�ʽ��spring IOC ����ʹ�ø÷���ʵ��
 *
 * @author zhangcanlong
 * @date 2018��9��18��
 */
class President {
	// �Ǽǲ�������������е�ʵ��
	private static Map<String, President> regSingletonMap = new HashMap<>();

	// ������ص�ʱ�����һ��ʵ�����Ǽǲ���
	static {
		President president = new President();
		regSingletonMap.put(president.getClass().getName(), president);

	}

	//
	// ����Ĭ�ϵĹ��췽��
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
