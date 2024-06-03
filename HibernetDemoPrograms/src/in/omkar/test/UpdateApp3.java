package in.omkar.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.omkar.modal.Student;
import in.omkar.util.HibernateUtil;

public class UpdateApp3 {

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
					Student student = session.get(Student.class, 1);
					student.setName("Sanskruti");
					session.update(student);
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
