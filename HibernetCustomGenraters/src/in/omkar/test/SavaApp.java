package in.omkar.test;



import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.omkar.modal.Employee;
import in.omkar.util.HibernateUtil;



public class SavaApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = null; 
		try {
			
			System.out.println("hii");
			if (session == null) 
				session =HibernateUtil.getSession();
				
			if (transaction == null) {
				transaction = session.beginTransaction();				
			}
			System.out.println("hii");
			Employee employee = new Employee();
			employee.setEname("raju bhai");
			employee.setEsalary(12000);
			System.out.println("hello");
			id = (Integer)session.save(employee);
			System.out.println("saving into the seession with id" + id);
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
