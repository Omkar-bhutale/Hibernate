package in.omkar.test;

import java.io.NotActiveException;
import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.omkar.modal.BankAccount;
import in.omkar.util.HibernateUtil;

public class SelectAppUsingNativeSQL {


	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) {
		 Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			///
			
			if (session != null) {
				
				  NativeQuery sqlQuery = session.createSQLQuery("Select * from bankAccount ");
				  //filter dont work for native SQl
				  Filter filter = session.enableFilter("FILTER_ACCOUNTS_BY_STATUS");
				   filter.setParameter("status_type1", "blocked");
				   filter.setParameter("status_type2", "closed");
				   
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

