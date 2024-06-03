package in.omkar.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.omkar.modal.Student;
import in.omkar.util.HibernateUtil;

public class SaveORUpdateApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			if (session == null) {
				session = HibernateUtil.getSession();
			}
			if (session != null) {
				transaction = session.beginTransaction();
				if (transaction != null) {
					Student student = new Student();
					student.setId(2);
					student.setName("Sanskruti");
					student.setAddress("bhuttan hipparga");
					student.setAge(22);
					session.saveOrUpdate(student);
					
					Student student1 = new Student();
					student1.setId(3);
					student1.setName("supri");
					student1.setAddress("bhuttan hipparga2");
					student1.setAge(23);
					session.saveOrUpdate(student1);
				
					flag = true;

				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("student updated");
			} else {
				System.out.println("updation failed");
			}
			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();

		}

	}
}
