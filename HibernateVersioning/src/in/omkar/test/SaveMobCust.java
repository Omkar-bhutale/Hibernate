package in.omkar.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.internal.BasicPathUsageException;

import in.omkar.modal.MobileCustomer;
import in.omkar.util.HibernateUtil;

public class SaveMobCust {
	public static void main(String[] args) {
		Session session =null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			if (session == null) {
				session = HibernateUtil.getSession();
			}
			if (session != null) {
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				MobileCustomer mobileCustomer = session.get(MobileCustomer.class, 1);
				mobileCustomer.setCallerTune("nana karde pyar");
				
				//session.save(mobileCustomer);
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
			}else {
				transaction.rollback();
				System.out.println("unsaved");
			}
			if (session != null) {
				HibernateUtil.closeSession();
			}
			HibernateUtil.closeSessionFactory();
		}
	}
}
