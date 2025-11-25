package com.aadiandjava.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernetConfig {
	
	public static Session getHibernateSession() {
		Configuration cfg =new Configuration();
		cfg.configure(); 
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		return session;
		
	}

}
