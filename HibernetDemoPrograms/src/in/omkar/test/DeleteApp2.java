package in.omkar.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.omkar.modal.Student;
import in.omkar.util.HibernateUtil;

public class DeleteApp2 {
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
					Student student = session.get(Student.class, 2);
					session.delete(student);
					flag = true;
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("record deleted succes fully");
				
			}else {
				System.out.println("Deletion failed");
			}
			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}
	}

}
