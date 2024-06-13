package in.omkar.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.omkar.modal.CardPayment;
import in.omkar.modal.ChequePayment;
import in.omkar.modal.Payment;

public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    static {
        try {
            sessionFactory = new Configuration().configure()
                    .addAnnotatedClass(Payment.class)
                    .addAnnotatedClass(CardPayment.class)
                    .addAnnotatedClass(ChequePayment.class)
                    .buildSessionFactory();
            System.out.println("HibernateUtil --> SessionFactory object is created");
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void closeSession(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        System.out.println("Session opened: " + session);
        HibernateUtil.closeSession(session);
        System.out.println("Session closed.");
    }
}
