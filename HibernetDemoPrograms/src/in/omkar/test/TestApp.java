package in.omkar.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.omkar.modal.Student;



public class TestApp {

	public static void main(String[] args) throws Exception {
		//inform JVM to actve Hibernate
		Configuration configuration = new Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		//create a persistance object
		Student student = new Student();
		student.setId(11);
		student.setName("omkar");
		student.setAddress("butan hipparga");
		student.setAge(22);
		
		//3.perform persistance operation using entity/modal/pojo object
		session.save(student);
		
		System.in.read();
		
		transaction.commit();
		System.out.println("student obj saved to db sucess");
		System.out.println("hi");
		
		
	}

}
