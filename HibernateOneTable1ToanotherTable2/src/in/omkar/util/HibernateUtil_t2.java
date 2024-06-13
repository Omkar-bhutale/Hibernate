package in.omkar.util;

import org.hibernate.Session;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.omkar.modal.Student;
public class HibernateUtil_t2 {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	private HibernateUtil_t2() {
	}

	static {
		System.out.println("HibernateUtil.enclosing_method()");
		sessionFactory = new Configuration().configure("/HibernateOneTable1ToanotherTable2/src/in/omkar/cfg/t2_hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
	}
	public static void main(String[] args) {
		Session session = getSession();
		System.out.println(session.hashCode());
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
