package com.aadiandjavadao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class UserDao implements InitializingBean,DisposableBean{
	//After been creation this  method will be invoke by  IOC
//	public void init() {
//		System.out.println("Get DB Connection ...");
//	}
    public void getData() {
    	System.out.println("Getting data ");
    }
	//After been destroyed this  method will be invoke by  IOC
    @Override
    public void destroy() {
    	System.out.println("closing theDB connection ");
    }
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Get DB Connection ...");

		
	}
}
