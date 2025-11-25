package com.aadiandjavadao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
		UserDao bean = context.getBean(UserDao.class);
	    bean.getData();
	    //context.close()
	    ConfigurableApplicationContext cc=(ConfigurableApplicationContext)context;
	    cc.close();
	}

}
