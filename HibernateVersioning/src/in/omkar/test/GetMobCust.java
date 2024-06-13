package in.omkar.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.omkar.modal.MobileCustomer;
import in.omkar.util.HibernateUtil;

public class GetMobCust {
	public static void main(String[] args) {
		Session session =null;
		//Transaction transaction = null;
		boolean flag = false;
		try {
			if (session == null) {
				session = HibernateUtil.getSession();
			}
			
				MobileCustomer mobileCustomer = session.get(MobileCustomer.class, 1);
				
				System.out.println(mobileCustomer);
				session.evict(mobileCustomer);
				 mobileCustomer = session.get(MobileCustomer.class, 1);

				System.out.println(mobileCustomer);
				
				//session.save(mobileCustomer);
				flag = true;
				
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			}
			if (session != null) {
				HibernateUtil.closeSession();
			}
			HibernateUtil.closeSessionFactory();
		}

	

}
