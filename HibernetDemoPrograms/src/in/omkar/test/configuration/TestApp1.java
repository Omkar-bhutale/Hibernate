package in.omkar.test.configuration;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.omkar.modal.Student;

public class TestApp1 {

	public static void main(String[] args) {
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		// configuration using pure java method
		try {

			configuration = new Configuration();
			configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			configuration.setProperty("hibernate.connection.url", "jdbc:mysql:///college");
			configuration.setProperty("hibernate.connection.user", "root");
			configuration.setProperty("hibernate.connection.password", "Sanskruti");
			configuration.setProperty("hibernate.dilect", "org.hibernate.dialect.MySQL5Dialect");
			configuration.setProperty("hibernate.format_sql", "true");
			configuration.setProperty("hibernate.hbm2ddl.auto", "update");

			configuration.addAnnotatedClass(Student.class);

			sessionFactory = configuration.buildSessionFactory();

			if (session == null) {
				session = sessionFactory.openSession();
			}
			if (session != null) {
				transaction = session.beginTransaction();
				Student student = new Student();
				student.setId(1);
				student.setAddress("bhuttan hipparga");
				student.setName("omkar");
				student.setAge(22);
				session.save(student);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("object is saved to db");
			}else {
				System.out.println("studnet is not saved");
			}
			
			session.close();
			sessionFactory.close();
		}

	}

}
