package in.omkar.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.query.Query;

import in.omkar.modal.BankAccount;
import in.omkar.util.HibernateUtil;

public class SoftDeletionUsingHQL {


	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {
		 Transaction transaction = null;
		Session session = null;
		boolean flag = true;
		try {
			session = HibernateUtil.getSession();
			///
			
			if (session != null) {
				transaction = session.beginTransaction();
				Query query = session.createQuery("UPDATE in.omkar.modal.BankAccount set status = 'closed' where accNo = :acc_no" );
				query.setParameter("acc_no", 1008);
				int executeUpdate = query.executeUpdate();
				  flag = true;
				  
				}
			
		
		
		
			
		} catch (HibernateException  e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (flag) {
				System.out.println("soft deletion success full");
			}else {
				System.out.println("soft deletion failed");
			}
			session.close();
			HibernateUtil.closeSessionFactory();
		}
	}

}

