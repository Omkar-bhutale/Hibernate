package in.omkar.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import in.omkar.modal.Student;

public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    private HibernateUtil() {
    }

    static {
        try {
            System.out.println("Initializing HibernateUtil...");
            sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}

