package in.omkar.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.omkar.modal.AddressInfo;
import in.omkar.modal.StudentInfo;
import in.omkar.util.HibernateUtil;

public class InsetApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction =null;
		boolean flag = false;
		try {
			if (session == null) {
				session=HibernateUtil.getSession();
				System.out.println("Session object is" + session);
				
			}
			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				AddressInfo addressInfo = new AddressInfo("india","maharastra","deglur");
				
				StudentInfo studentInfo = new  StudentInfo(11, "Omkar", 22, addressInfo);
				
				session.save(studentInfo);
				
				flag = true;
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("object saved to database");
			}else {
				transaction.rollback();
				System.out.println("failed to save object");
			}
			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}

	}

}
