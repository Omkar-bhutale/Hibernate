package in.omkar.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	private HibernateUtil() {
	}

	static {
		sessionFactory = new Configuration().configure().addAnnotatedClass(in.omkar.modal.Student.class)
				.buildSessionFactory();
	}

	public static Session getSession() {
		if (session == null) {
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
