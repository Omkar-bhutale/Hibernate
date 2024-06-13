package in.omkar.util;

import org.hibernate.Session;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.jandex.Main;

import in.omkar.modal.BankAccount;
public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	public HibernateUtil() {
	}

	public static void main(String[] args) {
		Session session = getSession();
		System.out.println(session.hashCode());
	}
	static {
		System.out.println("HibernateUtil.enclosing_method()");
		sessionFactory = new Configuration().configure().addAnnotatedClass(BankAccount.class)
				.buildSessionFactory();
		System.out.println("HibernateUtil.enclosing_method()");

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
