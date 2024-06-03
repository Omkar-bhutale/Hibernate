package in.omkar.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.omkar.modal.Student;
import in.omkar.util.HibernateUtil;

public class UpdateApp4 {

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
				Student student = session.get(in.omkar.modal.Student.class, 1);
				student.setName("omkar");
				flag = true;
			}
		}catch (HibernateException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}finally {
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
