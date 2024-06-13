package in.omkar.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.omkar.modal.BankAccount;
import in.omkar.util.HibernateUtil;

public class SelectAppUsingHQL {


	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {
		 Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			///
			{
			if (session != null) {
				@SuppressWarnings("unchecked")
				Query<BankAccount> query = session.createQuery("FROM in.omkar.modal.BankAccount");
				  Filter filter = session.enableFilter("FILTER_ACCOUNTS_BY_STATUS");
				  filter.setParameter("status_type1", "blocked" );
				  filter.setParameter("status_type2", "closed" );
				  
				  List<BankAccount> list = query.list();
				  
				  list.forEach(System.out::println);
				  
				}
			}
			{
				if (session != null) {
					@SuppressWarnings("unchecked")
					Query<BankAccount> query = session.createQuery("FROM in.omkar.modal.BankAccount");
					  session.disableFilter("FILTER_ACCOUNTS_BY_STATUS");
					  
					  List<BankAccount> list = query.list();
					  
					  list.forEach(System.out::println);
					  
					}
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

