package in.omkar.test;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.omkar.modal.BankAccount;
import in.omkar.util.HibernateUtil;


public class InsertRecordApp {
	public static void main(String[] args) {
		Session session =null;
		Transaction transaction = null;
		Long id = null;
		boolean flag = false;
		BankAccount bankAccount = null;
		try {
			if (session == null) {
				session = HibernateUtil.getSession();
			}
			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				 bankAccount = new BankAccount();
				bankAccount.setBalance(20000d);
				bankAccount.setHolderName("omkar");
				bankAccount.setType("savings");
				
				 id = (Long)session.save(bankAccount);
				
				
				flag = true;
			}
				
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				
				System.out.println("saved");
				System.out.println("opening date" + bankAccount.getCreationDateTime() ) ;
				System.out.println("last accessed " + bankAccount.getLastUpdatedDateTime());
				System.out.println("account version count" + bankAccount.getCount());
			}else {
				if (transaction != null) {
					transaction.rollback();
					
				}else {
					System.out.println("transaction object is null");
				}
				System.out.println("unsaved");
			}
			if (session != null) {
				HibernateUtil.closeSession();
			}
			HibernateUtil.closeSessionFactory();
		}
	}
}
