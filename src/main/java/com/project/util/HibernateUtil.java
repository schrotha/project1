package com.project.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private Session ses;
	
	public static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	
	public Session getSession() {
		
		if(this.ses == null) {
			
			this.ses = sf.openSession();
		}
		
		return this.ses;
	}
	
	public void closeSes() {
		this.ses.close();
		sf.close();
		this.ses = null;
	}
	
}
