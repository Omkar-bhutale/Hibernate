package in.omkar.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.omkar.util.HibernateUtil;

public class InsertApp {

	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			if (session != null && transaction!=null) {
				
				flag = true;
			}
			
		} catch (HibernateException  e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (flag) {
				transaction.commit();
			}else {
			}
			session.close();
			HibernateUtil.closeSessionFactory();
		}
	}

}

