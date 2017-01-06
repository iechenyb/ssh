package com.chenyb.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	static SessionFactory sf;

	public static SessionFactory getSf() {
		return sf;
	}

	static {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}

}
