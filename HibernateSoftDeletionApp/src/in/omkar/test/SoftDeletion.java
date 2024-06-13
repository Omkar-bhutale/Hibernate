package in.omkar.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.omkar.modal.BankAccount;
import in.omkar.util.HibernateUtil;

public class SoftDeletion {


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
				BankAccount account = new BankAccount();
				account.setAccno(1007);
				session.delete(account);
				flag = true;
				
				
				
				  
				}
			
		
		
		
			
		} catch (HibernateException  e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("account updated");
			}else {
				transaction.rollback();
				System.out.println("updation failed");
			}
			session.close();
			HibernateUtil.closeSessionFactory();
		}
	}

}

