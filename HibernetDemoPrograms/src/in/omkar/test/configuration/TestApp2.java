package in.omkar.test.configuration;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.omkar.modal.Student;

public class TestApp2 {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			Configuration configuration = new Configuration();//by default hiberneat searches for hibernet.proprties which should be present in src folder
			configuration.addAnnotatedClass(Student.class);
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			
			Student student = session.get(Student.class, 1);
			if (student != null) {
				System.out.println(student);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
