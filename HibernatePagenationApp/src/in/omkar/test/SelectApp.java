package in.omkar.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.query.Query;

import in.omkar.modal.BankAccount;
import in.omkar.util.HibernateUtil;

public class SelectApp {


	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {
		 Transaction transaction = null;
		Session session = null;
		boolean flag = true;
		try {
			session = HibernateUtil.getSession();
			///
			
			if (session != null) {
				Query<BankAccount> query = session.createQuery("From in.omkar.modal.BankAccount");
			
				query.setFirstResult(0);
				query.setMaxResults(3);
				List<BankAccount> list = query.list();
				list.forEach(System.out::println);
				
				  
				}
			
		
		
		
			
		} catch (HibernateException  e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			
			session.close();
			HibernateUtil.closeSessionFactory();
		}
	}

}

