package in.omkar.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.omkar.modal.BankAccount;
import in.omkar.util.HibernateUtil;

public class SelectAppUsingCriteriaApp {


	@SuppressWarnings({ "unused", "unchecked", "deprecation" })
	public static void main(String[] args) {
		 Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			///
			
			if (session != null) {
				Criteria criteria = session.createCriteria(BankAccount.class);
				 
				Filter filter = session.enableFilter("FILTER_ACCOUNTS_BY_STATUS");
				   filter.setParameter("status_type1", "blocked");
				   filter.setParameter("status_type2", "closed");
				   
				   List<BankAccount> list = criteria.list();
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

