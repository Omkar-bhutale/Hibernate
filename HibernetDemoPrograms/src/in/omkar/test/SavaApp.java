package in.omkar.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.omkar.modal.Student;
import in.omkar.util.HibernateUtil;

public class SavaApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = null; 
		try {
			if (session == null) {
				session = HibernateUtil.getSession();				
			}
			if (transaction == null) {
				transaction = session.beginTransaction();				
			}
			Student student = new Student();
			//student.setId(2);
			student.setName("raj");
			student.setAddress(" hipparga");
			student.setAge(22);
			session.persist(student);
	//		id = (Integer)session.save(student);
			flag = true;
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
//				System.out.println("id is ::" + id);
				System.out.println("saved");
				
			}
			else {
				transaction.rollback();
				System.out.println("not saved");
			}

			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}
	
		
	}

}
