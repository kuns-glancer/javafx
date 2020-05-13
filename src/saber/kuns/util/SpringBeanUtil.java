package saber.kuns.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanUtil {

	private static ApplicationContext applicationContext;

	static {
		if (applicationContext == null) {
			applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
		}
	}

	public static <T> T getBean(Class<T> clz) {
		return applicationContext.getBean(clz);
	}

}
