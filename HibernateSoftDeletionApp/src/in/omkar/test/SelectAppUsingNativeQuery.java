package in.omkar.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.omkar.modal.BankAccount;
import in.omkar.util.HibernateUtil;

public class SelectAppUsingNativeQuery {


	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String[] args) {
		 Transaction transaction = null;
		Session session = null;
		boolean flag = true;
		try {
			session = HibernateUtil.getSession();
			///
			
			if (session != null) {
				NativeQuery sqlQuery = session.createSQLQuery("select * from bankaccount");
				sqlQuery.addEntity(BankAccount.class);
				
				List<BankAccount> list = sqlQuery.list();
				
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

