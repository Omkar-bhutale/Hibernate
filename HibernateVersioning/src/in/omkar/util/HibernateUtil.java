package in.omkar.util;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.omkar.modal.MobileCustomer;
public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	private HibernateUtil() {
	}

	static {
		System.out.println("HibernateUtil.enclosing_method()");
		sessionFactory = new Configuration().configure().addAnnotatedClass(MobileCustomer.class)
				.buildSessionFactory();
	}

	public static Session getSession() {
		if (session == null) {
			System.out.println("HibernateUtil.getSession()");
			session = sessionFactory.openSession();
		}
		return session;
	}

	public static void closeSession() {
		if (session != null) {
			session.close();
		}
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

}
