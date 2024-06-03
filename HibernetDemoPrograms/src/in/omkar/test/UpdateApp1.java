package in.omkar.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.omkar.modal.Student;
import in.omkar.util.HibernateUtil;

public class UpdateApp1 {

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
					student.setId(1);
					student.setAge(23);
					student.setAddress("bhtan hipparga");
					student.setName("raju");
					
					session.update(student);
					flag = true;
				}
				
				
			}
		}catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("object saved success fully");
			}else {
				System.out.println("object saving unsucess full");
			}
			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}
			
		
	}
}
